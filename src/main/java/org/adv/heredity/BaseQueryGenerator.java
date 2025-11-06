package org.adv.heredity;

public abstract class BaseQueryGenerator implements IBaseQuery {
    protected static final String DOT = ".";
    protected static final String WS = " ";

    StringBuffer buildJoinClause() {
        StringBuffer joinClause = new StringBuffer();

        return joinClause;
    }

}
