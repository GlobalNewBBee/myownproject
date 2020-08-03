package com.myown.game.service.tableColumn;

import com.myown.game.constant.CommonResponse;
import com.myown.game.model.tableColumn.TableColumnDTO;

public interface TableColumnService {

    CommonResponse exportExcel(TableColumnDTO dto);
}
