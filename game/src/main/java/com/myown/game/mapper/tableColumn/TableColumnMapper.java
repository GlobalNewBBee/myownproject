package com.myown.game.mapper.tableColumn;

import com.myown.game.model.tableColumn.TableColumnDTO;
import com.myown.game.model.tableColumn.TableColumns;

import java.util.List;

public interface TableColumnMapper {

    Integer countField(TableColumnDTO tableColumnDTO);

    List<TableColumns> getTableColumn(TableColumnDTO tableColumnDTO);
}
