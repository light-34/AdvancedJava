package org.adv.heredity;

public enum Joins {
    INNER_JOIN ("inner join"),
    OUTER_JOIN ("outer join"),
    LEFT_JOIN ("left join"),
    RIGHT_JOIN ("right join");

    private final String joinType;

    Joins(String joinType) {
        this.joinType = joinType;
    }

    public String getJoinType() {
        return joinType;
    }
}
