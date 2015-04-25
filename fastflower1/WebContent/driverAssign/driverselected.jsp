<%@page import="java.sql.Statement"%>
<%@page import="fastflower1.connection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String driver=request.getParameter("driverid");
try{
Connection c=connection.getcon();
Statement st=c.createStatement();
st.executeUpdate("UPDATE driverassign SET jobCondition=TRUE WHERE orderID=1 AND driverMail='"+driver+"'");
response.sendRedirect("../Shop/shop.jsp");
}catch(Exception e){
	System.out.print(e);
}
%>
</body>
</html>