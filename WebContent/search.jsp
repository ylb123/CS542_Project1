<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
   int choose=Integer.valueOf(request.getParameter("choo"));
   System.out.println(choose);
   if(choose==1){%>
	  <jsp:forward page="searchLab.jsp"/>
   <%}
   else if(choose==2){%>
	   <jsp:forward page="searchReagent.jsp"/>
   <%}   
   else{%>
	   <jsp:forward page="searchAverageScore.jsp"/>
   <%}
%>
