/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
//@WebServlet(name="TinhServlet",urlPatterns ={"/tinh"})
public class TinhServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dai_raw=request.getParameter("dai");
        String rong_raw=request.getParameter("rong");
        String cv=request.getParameter("cv");
        String dt=request.getParameter("dt");
        double a,b;
        String msg="";
        PrintWriter out = response.getWriter();
        try {
            a=Double.parseDouble(dai_raw);
            b=Double.parseDouble(rong_raw);
            if (cv==null && dt==null) {
                msg="<h1 style=\"text-align:center;color:red\">You didn't choose oparator, please try again!</h1>";
            }else if(cv!=null && dt==null){
                msg="Primeter = "+(a+b)*2;
            }else if(cv==null && dt!=null){
                msg="Area = "+(a*b);
            }else{
                msg="Area = "+(a*b)+"<br/>"+"Primeter = "+(a+b)*2;
            }
        } catch (NumberFormatException e) {
            out.print("<h1 style=\"text-align:center;color:red\">Input are wrong, please try again!</h1>");
        }
        out.print("<h1 style=\"text-align:center;color:green\">"+msg+"</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request, response);
    }
    
}
