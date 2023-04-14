<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            TRAVTEL 
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
            body {
                min-height: 100vh;
                display: flex;
                flex-direction: column;
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
                <form action="FrontEnd" method="post">
                    <input type="hidden" name="pageName" value="home" />
                    <input type="hidden" name="username" value="<%=session.getAttribute("username")%>" />
                    <input type="submit" value="My Bookings" />
                </form>
                </font></td>
            </tr>
        </table>
        <br>
        
        <br>
        
        
        
        <BR>
        <h1>Booking <%=request.getAttribute("hotelName")%></h1>
                <BR>
        <form action="FrontEnd" method="post">
            <input type="hidden" name="pageName" value="booked" />
            <input type="hidden" name="hotelID" value=<%=request.getAttribute("hotelID")%> />
            <input type="hidden" name="username" value=<%=session.getAttribute("username")%> />
        <table align = "center">
            <tr><td>
                    <h3>Billing Address</h3></td>
        </tr><tr><td>
                <label for="fname">Full Name</label></td>
                <td><input type="text" id="fname" name="firstname" placeholder="Full Name"></td>
        </tr><tr><td>
                <label for="email"> Email</label></td>
            <td><input type="text" id="email" name="email" placeholder="Email"></td>
        </tr><tr><td>
                <label for="adr"> Address</label></td>
            <td><input type="text" id="adr" name="address" placeholder="Address"></td>
         
         </tr><tr><td>
                 <h3>Payment</h3> </td>
        
        <div>
         </tr><tr><td>
                 <label for="cname">Name on Card</label></td>
             <td><input type="text" id="cname" name="cardname" placeholder="Name on Card"></td>
 </tr><tr><td>
        </div>
        <div>
            <label for="ccnum">Credit card number</label></td>
        <td><input type="text" id="ccnum" name="cardnumber" placeholder="0000-0000-0000-0000"></td>
        </div>
        <div>
             </tr><tr><td>
                     <label for="expyear">Exp Year</label></td>
                 <td><input type="text" id="expyear" name="expyear" placeholder="YYYY"></td>
        </div>
        <div>
             </tr><tr><td>
                     <label for="cvv">CVV</label></td>
                 <td><input type="text" id="cvv" name="cvv" placeholder="cvv"></td>
                  </tr><tr><td>
        </div>
        </td><td>
        <input type="submit" value="Continue to checkout"/></td>
        </tr>
            </table>
        </form>
        <br><br>
        <footer>
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
        </footer>
    </body>
</html>
