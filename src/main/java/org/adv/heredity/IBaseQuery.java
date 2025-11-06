package org.adv.heredity;

public interface IBaseQuery {
    StringBuffer buildFromClause();
    StringBuffer buildWhereClause();
    StringBuffer buildGroupByClause();
    StringBuffer buildHavingClause();
    StringBuffer buildOrderByClause();
    StringBuffer buildSelectClause();
    StringBuffer buildLimitClause();
    StringBuffer buildOffsetClause();
    StringBuffer getMainTable(String schema, String tableName);
}
