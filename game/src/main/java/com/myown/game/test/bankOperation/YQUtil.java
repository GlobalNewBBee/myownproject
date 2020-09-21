package com.myown.game.test.bankOperation;

import org.apache.commons.lang3.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class YQUtil {

    /*
    * 报文体开头公共部分
    * */
    private static final String  XML_BODY_HEAD = "<?xml version=\"1.0\" encoding=\"GBK\"?><Result>";

    /*
    *报文体结尾部分
    * */
    private static final String XML_BOYD_TAIL = "</Result>";

    /*
    * 使用字符串拼接的方式来组装xml报文体
    * */
    public static String exchange2xmlbody(Object object){

        StringBuffer xmlBody = new StringBuffer(XML_BODY_HEAD);
        try{
            if(object!=null){
                Field[] fields = object.getClass().getDeclaredFields();
                for(Field field:fields){
                    String fieldName = field.getName();
                    PropertyDescriptor pd = new PropertyDescriptor(fieldName,object.getClass());
                    Method writeMethod = pd.getReadMethod();
                    Object value = writeMethod.invoke(object);
                    if(value!=null){
                        xmlBody.append("<");
                        xmlBody.append(fieldName);
                        xmlBody.append("/>");
                        xmlBody.append(value);
                        xmlBody.append("</");
                        xmlBody.append(fieldName);
                        xmlBody.append(">");
                    }
                }
            }else{
                System.out.println("参数不能为空！");
                return null;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            xmlBody.append(XML_BOYD_TAIL);
            return xmlBody.toString();
        }
    }

    /*
    * 使用DOM拼接xml报文
    * */
    public static String exchange2xmlBodyByDOM(Object object){

        try{
            if(object!=null){

            }else{
                System.out.println("参数不能为空！");
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            return null;
        }
    }
}
