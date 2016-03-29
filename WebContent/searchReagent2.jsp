<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="conf.Conf" %>
<%@ page import="user.Lab" %>
<%@ page import="user.Scientist" %>
<%@ page import="user.Reagent" %>
<%
   
   double score=-1;
   score=Double.valueOf(request.getParameter("attr"));
   Scientist scientist=(Scientist)session.getAttribute("user");
   if(score==-1){
	  response.sendRedirect(Conf.url_login_error);
   }
   Reagent[] ret=scientist.searchReagent(score);
   for(int i=0;i<ret.length;i++){
   if(ret[i]==null)
	 break;
   out.print("<div style='float:left;margin-left:30px;margin-top:20px'>"+
		       "<img src=\""+ret[i].getImage()+"\" style=\"height:30px;width:50px\"/><br/>"+
		       "Name:"+ret[i].getName()+"<br/>"+
               "Lid:"+ret[i].getLid()+"<br/>"+
		       "Source:"+ret[i].getSource()+"<br/>"+
               "Type:"+ret[i].getType()+"<br/>"+
		       "Expire Date:"+ret[i].getExpdate()+"<br/>"+
		       "Average Score:"+ret[i].getAveragescore()+"<br/>"+
		       "point:"+ret[i].getAskp()+
               "</div>"
		      );   
   //System.out.println("here");
   }
%>