package com.restaurant;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.sql.*;

@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bill = request.getParameter("billDetails");
        String totalStr = request.getParameter("total");

        int total = 0;

        if (totalStr != null && !totalStr.isEmpty()) {
            total = Integer.parseInt(totalStr);
        }

        System.out.println("Bill: " + bill);
        System.out.println("Total: " + total);

        int orderId = 0;

        try {
            Connection con = DBConnection.getConnection();

            if (con != null) {

                // 🔥 REAL ORDER INSERT WITH GENERATED KEY
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO orders(bill_details, total_amount) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
                );

                ps.setString(1, bill);
                ps.setInt(2, total);

                ps.executeUpdate();

                // 🔥 GET REAL ORDER ID (TOKEN NUMBER)
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    orderId = rs.getInt(1);
                }

                System.out.println("REAL ORDER ID GENERATED: " + orderId);

                con.close();

            } else {
                System.out.println("Connection is NULL ❌");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 🔥 SEND REAL TOKEN TO JSP
        request.setAttribute("orderId", orderId);
        request.setAttribute("total", total);

        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
        rd.forward(request, response);
    }
}