<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    

<%@ page import="conf.Conf" %>
<%@ page import="user.Scientist" %>
<%
String uid=request.getParameter(Conf.login_userid);
String pwd=request.getParameter(Conf.login_pwd);

if(uid==null || pwd==null){
	response.sendRedirect(Conf.url_login_error);
}
Scientist scientist =Scientist.getUser(uid,pwd);


session.setAttribute("user", scientist);

if(scientist!=null){
	
	session.setAttribute(Conf.login_username, scientist.name);
	session.setAttribute(Conf.login_userid, scientist.uid);
	session.setAttribute(Conf.login, "yes"); 
	response.sendRedirect(Conf.url_main);
}
else{
	session.setAttribute(Conf.login,"no");
	out.println("<script>alert('wrong password');</script>");
	out.println("<script language='javascript' type='text/javascript'>window.location.href='index.html'; </script>");
}
%>