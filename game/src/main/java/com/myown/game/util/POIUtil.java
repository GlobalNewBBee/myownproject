package com.myown.game.util;

import com.myown.game.model.tableColumn.TableColumns;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class POIUtil {

    private static String[] rows = {"序号","字段","字段类型","长度","注释"};

    public static void getWorkBook(List<TableColumns> list){
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表sheet
        XSSFSheet sheet = workbook.createSheet();
        //创建第一行
        XSSFRow firstRow = sheet.createRow(0);

        //插入表头数据
        for(int i=0;i<rows.length;i++){
            XSSFCell cell = firstRow.createCell(i);
            cell.setCellValue(rows[i]);
        }


        int rowNum = 1;
        for(int j=0;j<list.size();j++){
            //创建行
            XSSFRow row = sheet.createRow(rowNum);

            int fieldNum = 0;
            //创建单元格
            for(int i=0;i<rows.length;i++){
                if(i==0){
                    XSSFCell cell = row.createCell(0);
                    cell.setCellValue(rowNum);
                }else{
                    try{
                        TableColumns columns = list.get(j);
                        //获取字段
                        Field[] fields = columns.getClass().getDeclaredFields();
                        //for(Field field:fields){
                        Field field = fields[fieldNum];
                        String fieldName = field.getName();
                        PropertyDescriptor descriptor = new PropertyDescriptor(fieldName,columns.getClass());
                        Method readMethod = descriptor.getReadMethod();
                        String result = (String)readMethod.invoke(columns);

                        //创建单元格
                        XSSFCell cell = row.createCell(i);
                        cell.setCellValue(result);
                        fieldNum++;
                        //}
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
            rowNum++;
        }


        try {
            FileOutputStream file = new FileOutputStream("d://test.xls");
            workbook.write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void getValues(Object obj){

        /*HashMap hashmap = new HashMap<>();
        hashmap.put("字段",new HashMap<>().put("columnName",null));
        hashmap.put("字段类型",new HashMap<>().put("dataType",null));
        hashmap.put("长度",new HashMap<>().put("characterMaximumLength",null));
        hashmap.put("注释",new HashMap<>().put("columnComment",null));*/

        try{
            //获取对象的属性
            Field[] fields = obj.getClass().getDeclaredFields();

            for(int i=0;i<fields.length;i++){

                String fieldName = fields[i].getName();
                PropertyDescriptor descriptor = new PropertyDescriptor(fieldName,obj.getClass());
                Method readMethod = descriptor.getReadMethod();
                String value = (String)readMethod.invoke(obj);
                System.out.println(fieldName+":"+value);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TableColumns columns = new TableColumns();
        columns.setColumnName("id");
        columns.setDataType("varchar");
        columns.setCharacterMaximumLength("110");
        columns.setColumnComment("id");
        getValues(columns);
    }
}
