package org.adv.heredity;

public class QueryGenerator extends BaseQueryGenerator{
    @Override
    public StringBuffer buildFromClause() {
        return null;
    }

    @Override
    public StringBuffer buildWhereClause() {
        return null;
    }

    @Override
    public StringBuffer buildGroupByClause() {
        Joins.INNER_JOIN.getJoinType();
        return (new StringBuffer(" GROUP BY "));
    }

    @Override
    public StringBuffer buildHavingClause() {
        return null;
    }

    @Override
    public StringBuffer buildOrderByClause() {
        return null;
    }

    @Override
    public StringBuffer buildSelectClause() {
        return null;
    }

    @Override
    public StringBuffer buildLimitClause() {
        return null;
    }

    @Override
    public StringBuffer buildOffsetClause() {
        return null;
    }

    @Override
    public StringBuffer getMainTable(String schema, String tableName) {
        return (new StringBuffer()).append(schema).append(DOT).append(tableName);
    }
}
