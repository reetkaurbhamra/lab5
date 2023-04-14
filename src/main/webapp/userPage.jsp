
<%@page import="com.mycompany.helper.BookingsXML"%>
<%@page import="com.mycompany.helper.Booking"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.text.SimpleDateFormat" %>
<%@page import= "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Your Bookings 
        </title>
        <style>
            table.table2 {
            border: 1px dashed #4a4673;
            border-collapse: collapse;
            }
            m{
              color: rgb(28, 30, 54);
              text-align: left;
            } 
            footer {
                margin-top: auto;
            }
        </style>
        <link rel="icon" href="Resources/logo.png" type="image/icon type">        
    </head>
    <body bgcolor="#e9f2ff"><!--For beige #F5F5DC-->
        

        <table  style="font-family:monospace" font-weight:"900" width="100%">
            <tr>
                <td><img src="Resources/logo.png" width = "150px"></td>
                <td  align="right"><font size="+1"><a href="index.html">Home</a>    |    
                <a href="about.html">About</a>    |    
                Contact    
            </tr>
        </table>
        <br>
        <br>
        
        Welcome <%=session.getAttribute("username")%>!!
        
        <br>
        <br>
        
        Your Bookings ->
        
        <% 
            BookingsXML userBookings = (BookingsXML) request.getAttribute("userBookings");
        %>
        
        <table align="center" bgcolor="#F5F5DC"  cellpadding = "10" border="1" class="table2">
            
            <tr>
                <th> Hotel Name </th>
                <th> Hotel Address </th>
                <th> Start Date </th>
                <th> End Date </th>
                <th> Cancel Booking </th>
            </tr>
            <% 
                ArrayList<Booking> bookings = userBookings.getBookings();
                if (bookings != null) {
                    for (Booking b : bookings) {
            %>
            <form action="FrontEnd" method="post">
            <tr>
                <td> <%=b.getHotelName()%> </td>
                <td> <%=b.getHotelLocation()%></td>
                <td> <%=b.getStartDate()%></td>
                <td> <%=b.getEndDate()%></td>
                <td><input type="submit" name="pageName" value="rate"/></td>
            <input type="hidden" name="hotelID" value="<%=b.getHotelID()%>"/>
            <input type="hidden" name="hotelName" value="<%=b.getHotelName()%>"/>
            </tr>
            </form>
            <%
                }}
            %>
        </table>
        
        <br>
        <br>
        
        <form action="FrontEnd" method="post">
            <input type="hidden" name="pageName" value="search" />
            <table align = "center">
                <tr>
                    <td><input type="submit" value="Book Another Hotel"></td>
                </tr>
            </table>
        </form>
        
        <br>
        <br>
        <br>
        <br>
        <br>
        <footer>
        <div>
        <marquee behavior="" direction="right">
            <table style="font-family:monospace">
                <tr>
                    <td rowspan="3"><img src="Resources/flowers.png"><img src="Resources/monkey.png" width="50px">
                    <img src="Resources/flowers.png"><img src="Resources/monkey.png" width="30px">
                    <img src="Resources/flowers.png"><img src="Resources/lemur.png" width="50px">
                    <img src="Resources/flowers.png"> </td>
                    <td align = "center" bgcolor="#f2f8ff">Designed by the</td>
                    <td rowspan="3"><img src="Resources/flowers.png"><img src="Resources/penguin.png" width="30px">
                        <img src="Resources/flowers.png"><img src="Resources/monkey.png" width="50px">
                        <img src="Resources/flowers.png"><img src="Resources/monkey.png" width="30px">
                        <img src="Resources/flowers.png"></td>
                </tr>
                <tr align = "center" bgcolor="#f2f8ff">
                    <td>Cast of Madagascar.</td>
                </tr>
                <tr>
                    <td align = "center" bgcolor="#f2f8ff">Run by Humans.</td>
                </tr>
            </table></marquee>

            <table bgcolor="4b548b" width = "100%">
                <tr>
                    <td rowspan = "4"><img src= "Resources/logoDark.png" width = "150px"></td>
                    <td> <font color="white">Follow our Blog </td>
                </tr>
                <tr>
                    <td> <font color="white">Follow us on Instagram </td>
                </tr>
                <tr>
                    <td> <font color="white">Follow us on Twitter </td>
                </tr>
                <tr>
                    <td> <font color="white">Follow us on Facebook </td>
                </tr>
            </table> 
        </div>
    </footer>
    </body>
</html>