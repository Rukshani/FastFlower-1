<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="fastflower1.connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="fastflower1.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Shopping Cart - Check out</title>
        
        <link href="themesdemo/2/js-image-slider.css" rel="stylesheet" type="text/css" />
        <script src="themesdemo/2/js-image-slider.js" type="text/javascript"></script>
        <link href="generic.css" rel="stylesheet" type="text/css" />
    </head>

    <body style="margin:0; padding:0;background-image:url('imagesdemo/backimg.jpg');">
    <div align="right">
    	<form method="post" action="../logoutprocess.jsp">
    			<%=session.getAttribute("usermail") %>
				<input type="submit" value="Logout"></input>
			</form>
    </div>
        <form action="buyerdetails.jsp" method="post">   
            <%
                ArrayList it_list = (ArrayList) session.getAttribute("itemlist");

            %>
            <div class="container"><center>

                <div class="headbanner"><br/>
                    <h1 style="display:inline"><font color="#666666" face="Times New Roman, Times, serif" size="+5">Shopping Cart</font></h1><br /><hr />
                </div>
                <div class="mycontent">
                    <table width="500px">
                    
                    
                     <%
                            //for (int i = 0; i < it_list.size(); i++) {
                            	//Item itm=(Item)it_list.get(i);
                        %>
                        
                      <!-- 
                        <tr>
                            <td><%//out.print(itm.name);%></td> 
                            <td><%//out.print(itm.price);%></td> 
                        </tr>
                        <% //}%>
                    
                     -->
                       
                        
                        <tr>
                        
                        
                    <%
					try {	
						
						String username=session.getAttribute("usermail").toString();
                        PreparedStatement stv=connection.getcon().prepareStatement("select * from cart where customermail=?");
        				stv.setString(1,username);
        				ResultSet rsv=stv.executeQuery();
								
						//Statement stmt=connection.getcon().createStatement();
						//ResultSet rs = stmt.executeQuery("SELECT * FROM cart");
						ResultSetMetaData rsmd=rsv.getMetaData();
						int numberOfColumns = rsmd.getColumnCount();
						double pricetot=0;
						
						
						while(rsv.next()){							
							//for(int i=1;i<=numberOfColumns;i++){
								int quantity=rsv.getInt(4);
								System.out.println("quantity from check: "+quantity);
								pricetot=rsv.getDouble(3)*quantity;
								
								 
							//}
							
						}
						//out.print(pricetot);
						%>
						<tr>
                            <td style="font-weight:bold;color:rgba(255,51,51,1)">My Total</td><td style="font-weight:bold;color:rgba(255,51,51,1)">Rs <%out.print(pricetot);%></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Purchase" /></td>
                        </tr>	
						
					<% 
						
					} catch (Exception ex) {
						System.out.println(ex);
						System.err.println(ex);
					}
			
					%>
					
					<% 
					

					Object productID=session.getAttribute("productID");
					String sproductID=(String)productID;
					System.out.println("product id from session from checkoutttt page"+sproductID);	
					
					
					try {	
							
						//String username=session.getAttribute("usermail").toString();
                        PreparedStatement stp=connection.getcon().prepareStatement("select * from cart where productID=?");
        				stp.setObject(1,sproductID);
        				ResultSet rsp=stp.executeQuery();

						ResultSetMetaData rsmd=rsp.getMetaData();
						int numberOfColumns = rsmd.getColumnCount();
						double pricetot=0;
						
						
						while(rsp.next()){	
							String quantity=rsp.getString(4);
							session.setAttribute("quantity",quantity);
							
							
							
							
							System.out.println("rsp value:"+rsp.getString(4));
														
						}
					
						
					} catch (Exception ex) {
						System.out.println(ex);
						System.err.println(ex);
					}
					
						
					
					%>
					
					<%
					
					/*
					Object quantityy=session.getAttribute("quantity");
					System.out.println("quantity from session : "+quantityy);
								
					
					System.out.println("product id second print:"+sproductID);
					
						try {	
						
						String username=session.getAttribute("usermail").toString();
                        PreparedStatement stv=connection.getcon().prepareStatement("select * from product where itemID=?");
        				stv.setString(1,username);
        				ResultSet rsv=stv.executeQuery();
								
						ResultSetMetaData rsmd=rsv.getMetaData();
						int numberOfColumns = rsmd.getColumnCount();
						double pricetot=0;
						
						
						while(rsv.next()){							
							
							
						}
					
						
					} catch (Exception ex) {
						System.out.println(ex);
						System.err.println(ex);
					}
			
					
					*/
					
					%>
                        
                        </tr>
                        
                    </table>
                </div>
                
            </div>
        </form>
        
        <div id="sliderFrame">
        <div id="slider">
            <a><img src="imagesdemo/image-slider-1.JPG" alt="Fast Flower Delivery System" /></a>
            <a class="lazyImage" href="imagesdemo/image-slider-2.JPG"></a>
            <a><b data-src="imagesdemo/image-slider-3.jpg"></b></a>
            <a class="lazyImage" href="imagesdemo/image-slider-4.jpg" title=""></a>
        </div>
        <!--thumbnails-->
        <div id="thumbs">
            <div class="thumb">
                <div class="frame"><img src="imagesdemo/thumb1.jpg" /></div>
                <div class="thumb-content"><p>Fast Flower Delivery</p>Sri Lanka's largest e-commerce organization</div>
                <div style="clear:both;"></div>
            </div>
            <div class="thumb">
                <div class="frame"><img src="imagesdemo/thumb2.jpg" /></div>
                <div class="thumb-content"><p>Products</p>Availability of variety of products</div>
                <div style="clear:both;"></div>
            </div>
            <div class="thumb">
                <div class="frame"><img src="imagesdemo/thumb3.jpg" /></div>
                <div class="thumb-content"><p>Services</p>Provide utmost customer satisfaction</div>
                <div style="clear:both;"></div>
            </div>
            <div class="thumb">
                <div class="frame"><img src="imagesdemo/thumb4.jpg" /></div>
                <div class="thumb-content"><p>Delivery</p>Reliable and faster delivery</div>
                <div style="clear:both;"></div>
            </div>
        </div>
        <div style="clear:both;height:0;"></div>
        
    </body>
</html>

