//package nl.han.dea.marc.config;
//
//import java.sql.*;
//
//public class JdbcMsSql {
//
//    public static Connection connObj;
//    public static String JDBC_URL = "jdbc:sqlserver://LAPTOPMARC\\MSSQLSERVER2016;databaseName=Spotitube;integratedSecurity=true";
//
//    public static void getDbConnection() {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connObj = DriverManager.getConnection(JDBC_URL);
//            if(connObj != null) {
//                DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
//                System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
//            }
//        } catch(Exception sqlException) {
//            sqlException.printStackTrace();
//        }
//    }
//
//}
