package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import sql.Database4Sql;
import conf.Conf;

public class Scientist {
	
			 
	static String sqlSelectScientist="select uid,password,name,title,lid from Scientist where uid=? and password =?";
	static String sqlsearchLab="select lid,name,affiliation,bbpoint from Lab where name=?";
	static String sqlsearchProfile="select uid,s.name,title,l.name,bbpoint,image from Scientist s,Lab l "+
			                                                          "where ?=l.lid";
	static String sqlsearchReagent="select name,lid,source,type,expDate,scoreNum,averageScore,sqty,askp,image "
			                                           +"from Reagent where name=?";
	static String sqlsearchReagent2="select name,lid,source,type,expDate,scoreNum,averageScore,sqty,askp,image "
            +"from Reagent where averageScore>?";
	static String sqlrequestReagent="insert into Requests values(?,?,?,?,?,?)";
	static String sqlupdatePoint="update Lab set bbpoint=? where lid=?";
	static String sqlupdateQuantity="update Reagent set sqty=? where lid=? and name=?";
	static String sqlsearchPrice="select askp from Reagent where name=? and lid=?";
	static String sqlsearchQuantity="select sqty from Reagent where name=? and lid=?";
	static String sqlsearchRequests="select rname,uid,lid,rqty,rqdate,sname from Requests where lid=?";
	
	
	/*
	static String sqlInsertScientist="insert into Scientist(uid,password,sname ) values(?,?,?)";
	static String sqlDeleteScientist="delete from scientist where uid =?";
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
						rs.getInt(4));
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lab;	
	}
	
	public String[] searchProfile(){
		Database4Sql dSql = null;
		PreparedStatement pStmt = null;
		String sql=sqlsearchProfile;
		String[] s=new String[6];
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1, this.lid);
			ResultSet rs=dSql.queryPrepare(pStmt);
			if ( rs !=null && rs.next()) {
				s[0]=rs.getString(1).trim();
				s[1]=rs.getString(2);
				s[2]=rs.getString(3);
				s[3]=rs.getString(4);
				s[4]=rs.getString(5);
				s[5]=rs.getString(6);
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;	
	}
	
	public Reagent[] searchReagent(String name){
		Reagent[] ret=new Reagent[3];
		Reagent reagent=null;
		Database4Sql dSql = null;
		PreparedStatement pStmt = null;
		String sql=sqlsearchReagent;
		int i=0;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1, name);
			ResultSet rs=dSql.queryPrepare(pStmt);
			while( rs !=null && rs.next()) {
				reagent=new Reagent(rs.getString(1).trim(),rs.getString(2)
						,rs.getString(3),rs.getString(4),rs.getString(5)
						,rs.getInt(6),rs.getDouble(7)
						,rs.getDouble(9),rs.getString(10));
				ret[i]=reagent;
				i++;
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;	
	}
	
	public Reagent[] searchReagent(double score){

		Reagent[] ret=new Reagent[3];
		Reagent reagent=null;
		Database4Sql dSql = null;
		PreparedStatement pStmt = null;
		String sql=sqlsearchReagent2;
		int i=0;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setDouble(1, score);
			ResultSet rs=dSql.queryPrepare(pStmt);
			while( rs !=null && rs.next()) {
				reagent=new Reagent(rs.getString(1).trim(),rs.getString(2)
						,rs.getString(3),rs.getString(4),rs.getString(5)
						,rs.getInt(6),rs.getDouble(7)
						,rs.getDouble(9),rs.getString(10));
				ret[i]=reagent;
				i++;
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;	
	}
	
	public boolean requestReagent(String rname,String lid,int quantity,Timestamp date,String uid,String sname){
		
		Database4Sql dSql = null;
		PreparedStatement pStmt = null;
		String sql=sqlrequestReagent;
		boolean success=false;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1, rname);
			pStmt.setString(2, lid);
			pStmt.setInt(3, quantity);
			pStmt.setTimestamp(4, date);
			pStmt.setString(5, uid);
			pStmt.setString(6, sname);
			dSql.executePrepare(pStmt);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql=sqlsearchPrice;
		double price=0;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1,rname);
			pStmt.setString(2,lid);
			ResultSet rs=dSql.queryPrepare(pStmt);
			if( rs !=null && rs.next()) {
				price=rs.getDouble(1);
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//obtain the current bbpoint of the lab which the scientist belongs to, 
		//and subtract the required points 
		String[] s=searchProfile();
		double currentPoint=Double.parseDouble(s[4]);
		sql=sqlupdatePoint;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setDouble(1,currentPoint-price*quantity);
			pStmt.setString(2,this.lid);
			dSql.executePrepare(pStmt);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//add required points the receiving lab
		sql=sqlupdatePoint;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setDouble(1,currentPoint+price*quantity);
			pStmt.setString(2,lid);
			dSql.executePrepare(pStmt);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//obtain the current quantity of the reagent
		sql=sqlsearchQuantity;
		int remainQuantity=0;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1,rname);
			pStmt.setString(2,lid);
			ResultSet rs=dSql.queryPrepare(pStmt);
			if( rs !=null && rs.next()) {
				remainQuantity=rs.getInt(1);
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//subtract quantity from the receiving lab
		sql=sqlupdateQuantity;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setDouble(1,remainQuantity-quantity);
			pStmt.setString(2,lid);
			pStmt.setString(3,rname);
			dSql.executePrepare(pStmt);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		success=true;
		return success;	
	}
	
	public ArrayList<Requests> searchRequests(String lid)
	{
		ArrayList<Requests> a=new ArrayList<Requests>();
		Requests request=null;
		Database4Sql dSql = null;
		PreparedStatement pStmt = null;
		String sql=sqlsearchRequests;
		try {
			dSql=new Database4Sql();
			pStmt=dSql.getPreparedStatement(sql);
			pStmt.setString(1, lid);
			ResultSet rs=dSql.queryPrepare(pStmt);
			while( rs !=null && rs.next()) {
				request=new Requests(rs.getString(1),rs.getString(2)
						,rs.getString(3),rs.getInt(4),rs.getTimestamp(5)
						,rs.getString(6));
				a.add(request);
			}
			rs.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;	
	}
	
	/*public Comment[] viewComment(String mid){
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
	}*/	
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
