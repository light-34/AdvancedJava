package org.adv.workprojects;

public class WorkProjCopy {

    /*@Override
    public boolean checkDuplicateAttributeValue(String attributeNameId, String attributeValue, String attributeValueId, String customerCode,
            DAORunnerBean daoRunnerBean) throws DataAccessException {

        String custLib = DAOHelper.getCustomerSchema(daoRunnerBean, customerCode);

        List<String> params = new ArrayList<>();
        params.add(attributeNameId);
        params.add(attributeValue.toUpperCase());

        String attrValueIdConstraint = "";
        if (!attributeValueId.isEmpty()) {
            attrValueIdConstraint = " and ATTR_VALUE_RECORD_ID != ?";
            params.add(attributeValueId);
        }

        StringBuilder sqlSB = new StringBuilder()
            .append("select ATTR_VALUE_RECORD_ID ATTR_VALUE_ID from ")
            .append(custLib).append(".SVAATRVALT ")
            .append("where ATTR_NAME_RECORD_ID = ? and upper(VALUE) = ? ")
            .append(attrValueIdConstraint)
            .append("fetch first row only");

        String sql = sqlSB.toString();

        DAOHelper.logFullSQL(sql, params);
        List<AttributeValueTOV1> attributeValueTO = getJdbcTemplate().query(sql, new AttributeValueTOV1RowMapper(true), params.toArray());
        LOG.debug("FINISHED QUERY");

        return  attributeValueTO.isEmpty() ? false : true;
    }*/

}
