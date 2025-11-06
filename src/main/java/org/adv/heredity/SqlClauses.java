package org.adv.heredity;

public enum SqlClauses {
    CL_SELECT("SELECT"),
    CL_FROM("FROM"),
    CL_WHERE("WHERE"),
    CL_GROUPBY("GROUP BY"),
    CL_HAVING("HAVING"),
    CL_ORDERBY("ORDER BY"),
    CL_LIMIT("LIMIT"),
    CL_OFFSET("OFFSET"),
    CL_FETCH("FETCH");

    private final String clauseType;

    SqlClauses(String clauseType) {
        this.clauseType = clauseType;
    }

    public String getClauseType() {
        return clauseType;
    }
}
