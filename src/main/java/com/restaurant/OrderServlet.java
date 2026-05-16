package com.restaurant;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] items = request.getParameterValues("item");

        int total = 0;
        StringBuilder bill = new StringBuilder();

        if (items != null) {

            for (String item : items) {

                // 🔹 Dosa
                if (item.equals("Dosa")) {
                    int qty = getQty(request, "qty1");
                    int amount = qty * 50;
                    total += amount;

                    bill.append("Dosa x ").append(qty)
                        .append(" = ₹").append(amount).append("<br>");
                }

                // 🔹 Idli
                if (item.equals("Idli")) {
                    int qty = getQty(request, "qty2");
                    int amount = qty * 30;
                    total += amount;

                    bill.append("Idli x ").append(qty)
                        .append(" = ₹").append(amount).append("<br>");
                }

                // 🔹 Vada
                if (item.equals("Vada")) {
                    int qty = getQty(request, "qty3");
                    int amount = qty * 25;
                    total += amount;

                    bill.append("Vada x ").append(qty)
                        .append(" = ₹").append(amount).append("<br>");
                }

                // 🔹 Upma
                if (item.equals("Upma")) {
                    int qty = getQty(request, "qty5"); // matches JSP
                    int amount = qty * 40;
                    total += amount;

                    bill.append("Upma x ").append(qty)
                        .append(" = ₹").append(amount).append("<br>");
                }

                // 🔹 Coffee
                if (item.equals("Coffee")) {
                    int qty = getQty(request, "qty4"); // matches JSP
                    int amount = qty * 15;
                    total += amount;

                    bill.append("Coffee x ").append(qty)
                        .append(" = ₹").append(amount).append("<br>");
                }

                // 🔹 Tea
                if (item.equals("Tea")) {
                    int qty = getQty(request, "qty6");
                    int amount = qty * 10;
                    total += amount;

                    bill.append("Tea x ").append(qty)
                        .append(" = ₹").append(amount).append("<br>");
                }
            }
        }

        // 🔸 If nothing selected
        if (total == 0) {
            bill.append("No items selected");
        }

        // 🔹 Send data to JSP
        request.setAttribute("billDetails", bill.toString());
        request.setAttribute("total", total);

        RequestDispatcher rd = request.getRequestDispatcher("bill.jsp");
        rd.forward(request, response);
    }
    
        
        

    // ✅ Helper method
    private int getQty(HttpServletRequest request, String param) {
        String q = request.getParameter(param);
        return (q != null && !q.isEmpty()) ? Integer.parseInt(q) : 0;
    }
}