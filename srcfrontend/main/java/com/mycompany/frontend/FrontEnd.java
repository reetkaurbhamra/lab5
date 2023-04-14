package com.mycompany.frontend;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.NewCookie;
import com.mycompany.business.Business;
import com.mycompany.helper.HotelsXML;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import com.mycompany.helper.Hotel;
import java.util.List;


@WebServlet(name = "FrontEnd", urlPatterns = { "/FrontEnd" })
public class FrontEnd extends HttpServlet {

    Authenticate autho;

    public FrontEnd() {
        autho = new Authenticate();
    }

    private final String authenticationCookieName = "login_token";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    private Map.Entry<String, String> isAuthenticated(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = "";

        System.out.println("TOKEN IS");
        try {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if (cookie.getName().equals(authenticationCookieName)) {
                    token = cookie.getValue();
                }
            }
        } catch (Exception e) {}

        if (!token.isEmpty())
            try {
                if (this.autho.verify(token).getKey()) {
                    Map.Entry entry = new AbstractMap.SimpleEntry<String, String>(token,
                            this.autho.verify(token).getValue());
                    return entry;

                } else {
                    Map.Entry entry = new AbstractMap.SimpleEntry<String, String>("", "");
                    return entry;
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
            }

        Map.Entry entry = new AbstractMap.SimpleEntry<String, String>("", "");
        return entry;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String token = isAuthenticated(request).getKey();
        String uname = isAuthenticated(request).getValue();
        String username = null;
        
        RequestDispatcher req;
        String hiddenParam = request.getParameter("pageName");
        switch (hiddenParam) {
            case "login":
                username = request.getParameter("username");
                String password = request.getParameter("password");
                boolean isAuthenticated = Business.isAuthenticated(username, password);
                if (isAuthenticated) {
                    token = autho.createJWT("FrontEnd", username, 100000);
                    HttpSession hs = request.getSession();
                    hs.setAttribute("username", username);
                    Cookie newCookie = new Cookie(authenticationCookieName, token);
                    response.addCookie(newCookie);
                    
                    request.setAttribute("userBookings", Business.userBookingsService(username));
                    req = request.getRequestDispatcher("userPage.jsp");
                    req.forward(request, response);
                }
                break;
            case "search": 
                String query = request.getParameter("query");
                request.setAttribute("hotelResults", Business.searchService(query, token));
                req = request.getRequestDispatcher("searchPage.jsp");
                req.forward(request, response);
                break;
            case "book":
                System.out.println("hotelNAMEbook: " + request.getParameter("hotelName") + " ");
                request.setAttribute("hotelName", request.getParameter("hotelName"));
                String hi = request.getParameter("hotelID");
                request.setAttribute("hotelID", hi);
                req = request.getRequestDispatcher("bookPage.jsp");
                req.forward(request, response);
                break;
            case "booked":
                String hotelID = request.getParameter("hotelID");
                Business.bookService(hotelID, username);
                request.setAttribute("userBookings", Business.userBookingsService(username));
                req = request.getRequestDispatcher("userPage.jsp");
                req.forward(request, response);
                break;
            case "home":
                request.setAttribute("userBookings", Business.userBookingsService(username));
                req = request.getRequestDispatcher("userPage.jsp");
                req.forward(request, response);
                break;
            case "rate":
                request.setAttribute("hotelName", request.getParameter("hotelName"));
                request.setAttribute("hotelID", request.getParameter("hotelID"));
                req = request.getRequestDispatcher("ratePage.jsp");
                req.forward(request, response);
                break;
            case "rated":
                int rating = Integer.parseInt(request.getParameter("Rate"));
                Business.rateService(request.getParameter("hotelID"), rating);
                req = request.getRequestDispatcher("ratedPage.jsp");
                req.forward(request, response);
                break;
        }   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
