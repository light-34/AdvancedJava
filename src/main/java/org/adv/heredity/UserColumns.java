package org.adv.heredity;

import java.sql.Types;

public enum UserColumns implements ITableColumns {
    USER_NAME ("user_name", "USER_NAME", Types.VARCHAR, "USERS_TABLE", "UT")
    ;

    private final String columnName;
    private final String columnSqlName;
    private final Integer columnType;
    private final String columnTableName;
    private final String columnTableAlias;

    UserColumns(String columnName, String columnSqlName, Integer columnType, String columnTableName, String columnTableAlias) {
        this.columnName = columnName;
        this.columnSqlName = columnSqlName;
        this.columnType = columnType;
        this.columnTableName = columnTableName;
        this.columnTableAlias = columnTableAlias;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public String getColumnSqlName() {
        return columnSqlName;
    }

    @Override
    public Integer getColumnType() {
        return columnType;
    }

    @Override
    public String getColumnTableName() {
        return columnTableName;
    }

    @Override
    public String getColumnTableAlias() {
        return columnTableAlias;
    }
}
