/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class CalculateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String n1_raw = request.getParameter("n1");
        String n2_raw = request.getParameter("n2");
        String op = request.getParameter("op");
        op = (op == null) ? "+" : op;
        double n1, n2;
        try {
            n1 = Double.parseDouble(n1_raw);
            n2 = Double.parseDouble(n2_raw);
            String s = tinh(n1, n2, op);
            if(s==null){
                throw new Exception();
            }
            out.println("<h1>" + s + "</h1>");
        } catch (NumberFormatException e) {
            out.println("<h1>"+"whut?"+ "</h1>");
        } catch (Exception ex) {
            out.print("<h1>"+"WTF?"+ "</h1>");
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

    private String tinh(double x, double y, String o) {
        String s = "";
        switch (o) {
            case "+":
                s = "tong:" + (x + y);
                break;
            case "-":
                s = "hieu:" + (x - y);
                break;
            case "x":
                s = "tich:" + (x * y);
                break;
            case ":":
                if (y == 0) {
                    s = "khong chia cho 0";
                } else {
                    s = "thuong:" + (x / y);
                }
                break;
                default:
                    return null;
        }
        return s;
    }
}
