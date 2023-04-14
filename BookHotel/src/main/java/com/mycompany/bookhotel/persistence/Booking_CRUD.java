package com.mycompany.bookhotel.persistence;

import com.mycompany.bookhotel.helper.Booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;


public class Booking_CRUD {
    Connection conn = null;

    private static Connection connect() throws SQLException, Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connection = System.getenv("DB_URL");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://"+connection+"/BOOKINGS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
            System.out.println("Connection Established");
        } catch (Exception e) {
            System.out.println("Where is your JBDC driver");
            e.printStackTrace();
            throw e;
        }
        return conn;
    }
    
    private static Connection connectH() throws SQLException, Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connection = System.getenv("DB_URL");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://"+connection+"/SEARCH?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
            System.out.println("Connection Established");
        } catch (Exception e) {
            System.out.println("Where is your JBDC driver");
            e.printStackTrace();
            throw e;
        }
        return conn;
    }

    public static ArrayList<Booking> getUserBookings(String username) throws SQLException, Exception {
        Connection conn = connect();
        ArrayList<Booking> bookings = new ArrayList<>();

        String q = "SELECT * FROM BOOKINGS WHERE username = '" + username + "'";
        System.out.println(q);
        PreparedStatement ps = conn.prepareStatement(q);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int bookingID = rs.getInt("bookingID");
            int hotelID = rs.getInt("hotelID");
//            Date startDate = rs.getDate("startDate");
//            Date endDate = rs.getDate("endDate");
            String startDate = "2023-05-28";
            String endDate = "2023-06-03";
            String hn = getHotelInfo("hotelName", hotelID);
            String hl = getHotelInfo("location", hotelID);
            

            bookings.add(new Booking(bookingID, username, hotelID, startDate, endDate, hn, hl));
        }

        conn.close();
        return bookings;
    }
    
    public static String getHotelInfo(String q, int h) throws Exception {
        Connection conn = connectH();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HOTELS WHERE hotelID = " + h);
        ResultSet rs = ps.executeQuery();
        System.out.println(rs + " " + q);
        String res = "";
        
        if (rs.next()) {
            res = rs.getString(q);
        }
        
        conn.close();
        return res;
    }

    public static void createUserBooking(String username, int hotelID, Date startDate, Date endDate)
            throws SQLException, Exception {
        Connection conn = connect();

        String q = "INSERT INTO BOOKINGS VALUES(" + getLastBookingID() + ",'" + username + "'," + hotelID + ",'"
                + startDate + "','" + endDate + "')";
        System.out.println(q);
        PreparedStatement st = conn.prepareStatement(q);
        int rs = st.executeUpdate();

    }

    private static int getLastBookingID() throws SQLException, Exception {
        Connection conn = connect();
        System.out.println("getlastbookingID");
        int rs_1 = 100;
        String currentMaxBookingNumber = "SELECT MAX(bookingID) AS maxID FROM BOOKINGS";
        try {
            PreparedStatement sub_st = conn.prepareStatement(currentMaxBookingNumber);
            ResultSet rs_0 = sub_st.executeQuery();
            if (rs_0.next()) {
                rs_1 = rs_0.getInt("maxID") + 1;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return rs_1;
    }
}