/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CarDAO;
import dal.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Car;
import model.Cart;
import model.Customer;

/**
 *
 * @author Dell
 */
@WebServlet(name="addtocart", urlPatterns={"/addtocart"})
public class addtocart extends HttpServlet {
   
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
        CarDAO cdao = new CarDAO();
        CartDAO cartdao = new CartDAO();
        Customer customer = (Customer)session.getAttribute("customer");
        int carID = Integer.parseInt(request.getParameter("cid"));
        
        
        
        Car car = cdao.getCarByID(carID+"");
        
        String pickupdate = session.getAttribute("pickupdate")+"";
        String pickuptime = session.getAttribute("pickuptime")+"";
        String dropoffdate = session.getAttribute("dropoffdate")+"";
        String dropofftime = session.getAttribute("dropofftime")+"";
        String pickupdatetime = pickupdate+" "+pickuptime;
        String dropoffdatetime = dropoffdate+" "+dropofftime;
        int diff = Integer.parseInt(session.getAttribute("diff")+"");
         
        
        Cart cart = new Cart(0, carID, customer.getUsername(), pickupdatetime, dropoffdatetime, car.getStationID(), car.getStationID(), diff, car.getPickuplocation());
        cartdao.insertCart(cart);

        cdao.updateAvailableTo0(carID+"");
        int totalCart = cartdao.countTotalCarInCart(customer.getUsername());
        session.setAttribute("totalCart", totalCart);
        response.sendRedirect("product.jsp");
       
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
