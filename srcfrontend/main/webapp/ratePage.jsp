
<%@page import="com.mycompany.helper.BookingsXML"%>
<%@page import="com.mycompany.helper.Booking"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.text.SimpleDateFormat" %>
<%@page import= "java.util.ArrayList" %>
<!DOCTYPE html>

<html>
    <head>
        <title>
            Rate Hotel
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
                Contact    |     
            </tr>
        </table>
        <br>
        <br>

        <br>
        <br>
        
        
        <table align = "center" bgcolor="#F3F2B0" border="2" class="table2">
            <tr><td>
        <form action="FrontEnd" method="post">
            <input type="hidden" name="pageName" value="rated"/>
            <input type="hidden" name="hotelID" value="<%=request.getAttribute("hotelID")%>"/>
            <table>
                <tr>
                    <td>
                        <h2><p align="center">How would you rate the experience at <%=request.getAttribute("hotelName")%>?</h2></p>
                    </td>
                </tr>
                <tr align = "center">
                    <td>
                <br>
                <b>Rating     </b>
                        <select name="Rate">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                          </select>
                    </td>
                </tr>
                <tr>
                    <td align = "left"><br><br>
                        <p align = "left"><label for="review">Write a Review</label></p></td>
                </tr>
                <tr>
                    <td>
                        <textarea id="review" name="review" rows="6" cols="80">Tell us more about your stay...</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="center"><input type="submit" value="rated"></td>
                </tr>
            </table>
        </form>
                </td></tr>
        </table>
        
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
