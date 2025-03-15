/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import dal.CartDAO;
import dal.CustomerDAO;
import dal.StationDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns={"/login"})
public class login extends HttpServlet {
   
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        String loi = "";
        CustomerDAO cudao = new CustomerDAO();
        StationDAO sdao = new StationDAO(); //Load data for pickuplocation
        
        Customer customer = cudao.getCustomerByUsernameAndPassWord(username, password);
        List<String> stationList = sdao.selectAllCity();
        session.setAttribute("stationList", stationList);
        
        String remember = request.getParameter("remember");
        if(customer != null){
            CartDAO cartdao = new CartDAO();
            int totalCart = cartdao.countTotalCarInCart(username);
            session.setAttribute("totalCart", totalCart);
            session.setAttribute("customer", customer);
            request.setAttribute("loi", "");
           
            if(remember!=null){
                Cookie user = new Cookie("userC", username);
                Cookie pass = new Cookie("passC", password);
                user.setMaxAge(60*60);  //Thoi gian ton tai cua cookie: 1h
                pass.setMaxAge(60*60);  
                response.addCookie(user);  //Add cookie len browser
                response.addCookie(pass);
            }
            
            if(customer.getRole().equalsIgnoreCase("customer"))
            response.sendRedirect("home.jsp");
            else
                response.sendRedirect("admin");

        } else {
            
            
            loi = "Username or password is incorrect!";
            request.setAttribute("loi", loi);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            
                        
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
        //processRequest(request, response);
        
        Cookie arr[] = request.getCookies();
        if(arr!=null)
        for (Cookie cookie : arr) {
            if(cookie.getName().equals("userC")){
                request.setAttribute("userC", cookie.getValue());
            }
            if(cookie.getName().equals("passC")){
                request.setAttribute("passC", cookie.getValue());
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
