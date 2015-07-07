package com.qubitproducts.hive.storage.jdbc.dao;

public class DB2ZDatabaseAccessor extends GenericJdbcDatabaseAccessor {

    @Override
    protected String addLimitAndOffsetToQuery(String sql, int limit, int offset) {
        if (offset == 0) {
            return addLimitToQuery(sql, limit);
        }
        else {
            return sql; //TODO: maybe try to rewrite using ROW_NUMBER() if we really need this
        }
    }


    @Override
    protected String addLimitToQuery(String sql, int limit) {
        return sql + " FETCH FIRST " + limit + " ROWS ONLY";
    }
    
    // alternative: just define the value for CURRENT QUERY ACCELERATION via qubit.sql.jdbc.url
    // e.g. jdbc:db2://9.10.11.12:9999/MYDB2:user=username;password=password;specialRegisters=CURRENT QUERY ACCELERATION=ALL;
    // see http://www-01.ibm.com/support/docview.wss?uid=swg27038078
    @Override
    protected String modifyQueryBeforeExecution(String query) {
    	//return "SET CURRENT QUERY ACCELERATION = ALL; " + query;
    	return query;
    }
    
}
