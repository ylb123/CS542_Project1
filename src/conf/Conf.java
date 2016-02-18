package conf;


import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Conf {
	public static String dbServer="localhost:1433";
	public static String dbUser="sa";
	public static String dbPassword="920108";
	public static String dbName="bio";
	
	
	public static String login_userid="userid";
	public static String login_pwd="password";
	public static String login_type="usertype";
	public static String login_username="username";
	public static String login = "login";
	
	
	public static String url_login_error="./error.html";
	public static String url_main ="./main.html";
	public static String url_error ="./error.html";
	public static String url_nologin ="./nologin.html";

	
	public static String current(){
		
		return String.valueOf(new Date().getTime());
	}
	
	
}
