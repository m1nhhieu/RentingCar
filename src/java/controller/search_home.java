/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.catalina.startup.HomesUserDatabase;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns={"/search_home"})
public class search_home extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        //Sử lý để hiện thông tin tìm kiếm trong product.jsp
        String pickuplocation = request.getParameter("pickuplocation");
        String pickupdate = request.getParameter("pickupdate");
        String pickuptime = request.getParameter("pickuptime");
        String dropoffdate = request.getParameter("dropoffdate");
        String dropofftime = request.getParameter("dropofftime");
        
        session.setAttribute("pickuplocation", pickuplocation);
        session.setAttribute("pickupdate", pickupdate);
        session.setAttribute("pickuptime", pickuptime);
        session.setAttribute("dropoffdate", dropoffdate);
        session.setAttribute("dropofftime", dropofftime);
        String loi = "";
        
        //Khai bao Date and Time
        PrintWriter out = response.getWriter();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm");
        Date today = new Date();
        LocalDate td = LocalDate.parse(sdfDate.format(today),formatter);
        LocalDate pud = LocalDate.parse(pickupdate,formatter);
        LocalDate dod = LocalDate.parse(dropoffdate,formatter);
        
                
        //TH1: Pickupdate < today
        long diff = ChronoUnit.DAYS.between(td, pud);
        if(diff<=0){
            loi += "Pickup date must be > "+td + " at least 1 day"+"</br>";
            session.setAttribute("loi", loi);
            
//            request.setAttribute("loi", loi);
//            request.getRequestDispatcher("home.jsp").forward(request, response);
        }  
        
        
        
        //TH: Dropoff date < Pickup Date
        diff = ChronoUnit.DAYS.between(pud, dod);
        if(diff<0){
            loi += "Dropoff date must be >= "+pud+"</br>";
            session.setAttribute("loi", loi);
            
//            request.setAttribute("loi", loi);
//            request.getRequestDispatcher("home.jsp").forward(request, response);
        }  
       else 
        //Dropoff Date = Pickup Date, dropoff time < pickup time
        if(diff==0){
            try {
            Date put = sdfTime.parse(pickuptime);
            Date dot = sdfTime.parse(dropofftime);
            long i = (dot.getTime() - put.getTime())/(1000*60*60);
            if(i<1){
                loi += "Dropoff time must be >= "+pickuptime+" at least 1h"+"</br>";
                session.setAttribute("loi", loi);
                
//                request.setAttribute("loi", loi);
//                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            } catch (ParseException ex) {
            }
        } 
        if(loi.length()>0)
        response.sendRedirect("home.jsp");
        else {
            if(diff<1) diff=1;
            session.setAttribute("categoriesFilter", null);
            session.setAttribute("depositFilter", null);
            session.setAttribute("sortByPrice", null);
            session.setAttribute("reviewScoreFilter", null);
            session.setAttribute("loi", "");


            session.setAttribute("diff", diff);
            response.sendRedirect("loadcar");
        }
        

        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
