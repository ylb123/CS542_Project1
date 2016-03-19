<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="conf.Conf" %>
<%@ page import="user.Lab" %>
<%@ page import="user.Scientist" %>
<%@ page import="user.Reagent" %>
<%@ page import="java.util.Date" %>

<%
   boolean success=false;
   String rname=request.getParameter("name");
   String lid=request.getParameter("lid");
   int quantity=Integer.valueOf(request.getParameter("quantity"));
   java.util.Date date=new java.util.Date();
   java.sql.Date date2=new java.sql.Date(date.getTime());
   Scientist scientist=(Scientist)session.getAttribute("user");
   if(rname==null){
	  response.sendRedirect(Conf.url_login_error);
   }
   success=scientist.requestReagent(rname,scientist.uid,lid,quantity,date2,scientist.name);
   if(success==true){
	    out.println("<script>alert('request succeed');</script>");
	    out.println("<script language='javascript' type='text/javascript'>window.location.href='main.html'; </script>");
	}
	else{
		out.println("<script>alert('request fails');</script>");
		out.println("<script language='javascript' type='text/javascript'>window.location.href='main.html'; </script>");
	}
%>