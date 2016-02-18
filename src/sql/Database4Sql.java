package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conf.Conf;

public class Database4Sql {
	 static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	 static String URL = "jdbc:sqlserver://%s; DatabaseName=%s";  
	 static String dbURL;
	 public Connection connection;
	 
	 
	 public Database4Sql()throws SQLException{
		try{
			Class.forName(driverName);
			dbURL=String.format(URL, Conf.dbServer,Conf.dbName);
			connection = DriverManager.getConnection(dbURL, Conf.dbUser, Conf.dbPassword);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}		
	 }
	 
	 public ResultSet querySql(String sql){
		 Statement stmt;				 
		 try {
			stmt = connection.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	 
	public boolean updateSql(String sql) throws SQLException{
		 Statement stmt;
			try {
				stmt = connection.createStatement();  
				stmt.executeQuery(sql);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public PreparedStatement getPreparedStatement(String sql) throws SQLException{
		return connection.prepareStatement(sql);
	}
	
	public boolean executePrepare(PreparedStatement pStmt) throws SQLException{
		return pStmt.execute();
	}
	
	public ResultSet queryPrepare(PreparedStatement pStmt) throws SQLException{
		return pStmt.executeQuery();
	}
	public void close() throws SQLException{
		if( connection !=null && !connection.isClosed())
			connection.close();
	}

}
