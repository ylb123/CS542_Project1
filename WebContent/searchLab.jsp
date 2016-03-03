<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="conf.Conf" %>
<%@ page import="user.Lab" %>
<%@ page import="user.Scientist" %>
<%@ page import="java.io.PrintWriter" %>
<%
   String name=request.getParameter("attr");
   Scientist scientist=(Scientist)session.getAttribute("user");
   if(name==null){
	  response.sendRedirect(Conf.url_login_error);
   }
   System.out.println(name);
   Lab lab=scientist.searchLab(name);
   out.println("Lab id:"+lab.getLid()+"<br/>"+
               "Name:"+lab.getName()+"<br/>"+
		       "Affiliation:"+lab.getAffiliation());
   
%>