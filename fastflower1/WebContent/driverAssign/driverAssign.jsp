<%@page import="java.sql.ResultSet"%>
<%@page import="fastflower1.connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<!--
	Strata by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Select a Driver</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.poptrox.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-xlarge.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body id="top">

		<!-- Header -->
			<header id="header">
			<%
			//int order1=Integer.parseInt(request.getParameter("orderid"));
			int order1=10;
			String user="dilshani@gmail.com";
			try{
				Connection c=connection.getcon();
				Statement st= c.createStatement();
				//String user=request.getParameter("user");
				ResultSet rs=st.executeQuery("SELECT * FROM request WHERE storeMail='"+user+"' AND orderID="+order1+"");
				while(rs.next()){
					String cusMail=rs.getString("customerMail");
					Connection c1=connection.getcon();
					Statement st1= c1.createStatement();
					ResultSet rs1=st1.executeQuery("SELECT fname,mname,lname FROM customer WHERE customerMail='"+cusMail+"'");
					rs1.next();
					int productid=Integer.parseInt(rs.getString("productID"));
					Connection c2=connection.getcon();
					Statement st2= c2.createStatement();
					ResultSet rs2=st2.executeQuery("SELECT description FROM product WHERE itemID="+productid+"");
					rs2.next();
					%>
					 <p><li>Order ID : <%= rs.getString("orderID")%> </li>
					<li>Customer Mail :<%= rs.getString("customerMail")%> </li>
					 <li>Customer Name :<%=rs1.getString("fname")+" "+rs1.getString("mname")+" "+rs1.getString("lname") %> </li>
					<li>Product ID :<%= rs.getString("productID") %></li>
					<li>Product Description :<%= rs2.getString("description")%></li>
					 <li>Delivery Address :<%= rs.getString("deliveryAddress")%></li>
					 <li>Qty :<%= rs.getString("qty") %></li>
					 <li>Due Date :<%=  rs.getString("dueDate")%>  Pick Up Time :<%= rs.getString("dueTimeShop")%></li>
					<li> Customer Delivery Time :<%= rs.getString("dueTimeDelivery")%></li>
					
					
					 </li>
			        </p> 
						<% 	
					 st1.close();
						 st2.close();
					c1.close();
					c2.close();
					 
				}%>
				<%
				 st.close();
				 c.close();
				//
			}catch(Exception e){
				System.out.print(e);
			}
			%>
				
			</header>

		<!-- Main -->
			<div id="main">

				<!-- One -->
					<section id="one">
						<header class="major">
							<h2>Please Select a Driver to Deliver the Order</h2><br />
							<h3>Follow mentioned drivers have been selected by the Fast Flower Delivery System..</h3>
						</header>
						<p>
						<table>
						<thead>Assigned Drivers 
						<th>Driver Name</th>
						<th>Driver Mail</th>
						<th>Rank</th>
						<th>Vehicle Number</th>
						<th>Vehicle Type</th>
						<th>Requested Charge</th>
						<th>Job Condition</th>
						</thead>
						
						<%Connection c=connection.getcon();
						Statement st=c.createStatement();
						int order=1;
						ResultSet rs=st.executeQuery("SELECT * FROM driverassign WHERE orderID='"+order+"'");
						while(rs.next()){
							String driverID=rs.getString("driverMail");
						%>	
						<tr>
						<%
						Connection c1=connection.getcon();
						Statement st1=c1.createStatement();
						ResultSet rs1=st1.executeQuery("SELECT * FROM driver WHERE drivermail='"+driverID+"'");
						rs1.next();
						%>
						<td><%=rs1.getString("fname")+" "+rs1.getString("mname")+" "+rs1.getString("lname") %></td>
						<td><%=driverID %></td>
						<td><%=rs1.getString("rank") %></td>
						
						<%
						Connection c2=connection.getcon();
						Statement st2=c2.createStatement();
						ResultSet rs2=st2.executeQuery("SELECT * FROM vehicle WHERE drivermail='"+driverID+"'");
						rs2.next();
						%>
						<td><%=rs2.getString("vehicleNo") %></td>
						<td><%=rs2.getString("type") %></td>
						<td><%=rs.getString("bid") %></td>
						<td><form action="driverselected.jsp?driverid=<%=driverID%>" method="post"><input type="submit" value="select"></form></td>
						</tr>
						<%c1.close();
						c2.close();%>
						<% }
						c.close();
						
						%>
						</table>
						
						</p>
						<ul class="actions">
							<li><a href="../Shop/shop.jsp" class="button">Back to Home Page</a></li>
						</ul>
					</section>
<!--  
				
				
				
			

			</div>

	
			
-->
	</body>
</html>