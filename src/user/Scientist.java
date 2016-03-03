package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sql.Database4Sql;
import conf.Conf;

public class Scientist {
	
			 
	static String sqlSelectScientist="select uid,password,name,title,lid from Scientist where uid=? and password =?";
	static String sqlsearchLab="select lid,name,affiliation,bbpoint from Lab where name=?";
	/*
	static String sqlInsertScientist="insert into Scientist(uid,password,sname ) values(?,?,?)";
	static String sqlDeleteScientist="delete from scientist where uid =?";
	static String sqlbrowseScientist="select * from merchant";
	*/
	static String sqlviewComment="select name,content from comment where mid=?";
	static String sqlsubmitComment="insert into comment(mid,name,content) values(?,?,?)";
	
	public String uid;
	public String password;
	public String name;
	public String title;
	public String lid;
	
	public Scientist(String uid,String password,String name,String title,String lid){
		this.uid=uid;
		this.password=password;
		this.name=name;
		this.title=title;
		this.lid=lid;
	}
		

//Update user information, update password, sname, etc. based on uid.
	public String updateUser(String key,String value){
		return null;
	}

	public static Scientist getUser(String u,String p){
		Scientist ret=null;
		Database4Sql dSql = null;
		PreparedStatement pStmt = null;
		String sql=sqlSelectScientist;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1, u);
			pStmt.setString(2, p);
			ResultSet rs=dSql.queryPrepare(pStmt);
			if ( rs !=null && rs.next()) {
				ret=new Scientist(rs.getString(1).trim(),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5));
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;	
	}	
	
	public Lab searchLab(String name){
		Lab lab=null;
		Database4Sql dSql = null;
		PreparedStatement pStmt = null;
		String sql=sqlsearchLab;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1, name);
			ResultSet rs=dSql.queryPrepare(pStmt);
			if ( rs !=null && rs.next()) {
				lab=new Lab(rs.getString(1).trim(),rs.getString(2),rs.getString(3),
						Integer.valueOf(rs.getString(4)));
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lab;	
	}
	
	
	public Comment[] viewComment(String mid){
		Comment ret[]=new Comment[50];
		Database4Sql dSql = null;
		PreparedStatement pStmt = null;
		String sql=sqlviewComment;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1,mid);
			ResultSet rs=dSql.queryPrepare(pStmt);
			int i=1;
			while ( rs !=null && rs.next()) {
				ret[i]=new Comment(mid,rs.getString(1),rs.getString(2));
				i++;
			}
			rs.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;	
	}	
	public void submitComment(String mid,String name,String content)
	{
	  Database4Sql dSql = null;
	  PreparedStatement pStmt = null;
	  String sql=sqlsubmitComment;
	  try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1,mid);
			pStmt.setString(2, name);
			pStmt.setString(3,content);
			dSql.executePrepare(pStmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void changeInformation(String uid,String attribute,String value)
	{
	  Database4Sql dSql = null;
	  PreparedStatement pStmt = null;
	  String sql="update Scientist set "+attribute+"=? where uid=?";
	  try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1,value);
			pStmt.setString(2,uid);
			dSql.executePrepare(pStmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void changePassword(String password)
	{
		Database4Sql dSql = null;
		  PreparedStatement pStmt = null;
		  String sql="update Scientist set password=? where uid=?";
		  try {
				dSql=new Database4Sql();
				pStmt=dSql.getPreparedStatement(sql);
				pStmt.setString(1,password);
				pStmt.setString(2,this.uid);
				dSql.executePrepare(pStmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
}
