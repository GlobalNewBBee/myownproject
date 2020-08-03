package com.myown.game.model.tableColumn;

public class TableColumns {

    private String columnName;

    //private String columnType;

    private String dataType;

    private String characterMaximumLength;

    //private String isNullable;

    //private String columnDefault;

    private String columnComment;


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(String characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    /*public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }*/

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    /*public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }*/
}
