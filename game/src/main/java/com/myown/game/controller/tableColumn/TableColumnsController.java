package com.myown.game.controller.tableColumn;

import com.myown.game.constant.CommonResponse;
import com.myown.game.model.tableColumn.TableColumnDTO;
import com.myown.game.service.tableColumn.TableColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/excel")
@Api(value = "将表结构导出到Excel中",tags = {"将表结构导出到Excel中"})
public class TableColumnsController {

    @Autowired
    private TableColumnService tableColumnService;

    @RequestMapping(value = "/getWorkBook",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ApiOperation(value = "将表结构导出到Excel中",notes = "将表结构导出到Excel中")
    public CommonResponse getWorkBook(@ApiParam(name="TableColumnDTO对象",value="传入json格式",required=true) @RequestBody TableColumnDTO dto){
        return tableColumnService.exportExcel(dto);
    }
}
