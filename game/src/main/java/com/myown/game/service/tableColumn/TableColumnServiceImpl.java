package com.myown.game.service.tableColumn;

import com.myown.game.constant.CommonResponse;
import com.myown.game.mapper.tableColumn.TableColumnMapper;
import com.myown.game.model.tableColumn.TableColumnDTO;
import com.myown.game.model.tableColumn.TableColumns;
import com.myown.game.util.POIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TableColumnServiceImpl implements TableColumnService{

    @Autowired
    private TableColumnMapper tableColumnMapper;


    @Override
    public CommonResponse exportExcel(TableColumnDTO dto) {

        CommonResponse response = new CommonResponse();

        try{

            if(dto==null){
                response.fail("参数不能为空！");
                return response;
            }
            List<TableColumns> list = tableColumnMapper.getTableColumn(dto);
            if(!CollectionUtils.isEmpty(list)){
                System.out.println("总共有："+list.size()+" 个字段");
                POIUtil.getWorkBook(list);
                response.success("导出成功!");
            }else{
                response.fail("数据查询失败！");
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("异常接口：exportExcel");
        }finally {
            return response;
        }
    }
}
