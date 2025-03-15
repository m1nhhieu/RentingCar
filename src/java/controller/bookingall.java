/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CarDAO;
import dal.CartDAO;
import dal.ContractDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import mail.MyEmail;
import model.Car;
import model.Cart;
import model.Contract;
import model.Customer;

/**
 *
 * @author Dell
 */
@WebServlet(name="bookingall", urlPatterns={"/bookingall"})
public class bookingall extends HttpServlet {
   
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
        CartDAO cartdao = new CartDAO();
        CarDAO cardao = new CarDAO();
        ContractDAO cdao = new ContractDAO();
        List<Car> carCartList = (List<Car>)session.getAttribute("carCartList");
        Customer customer = (Customer)session.getAttribute("customer");
        
        for (Car car : carCartList) {
            Cart cart = cartdao.getCartByCarIdAndUsename(car.getCarID()+"", customer.getUsername());
            Contract c = new Contract(car.getCarID()+"_"+cart.getPickUpDateTime(), car.getCarID(),cart.getPickUpDateTime(), cart.getReturnDateTime(), car.getStationID(), car.getStationID(), cart.getUsername(), car.getDailyprice()*cart.getTotalDayRent());
            cdao.addContract(c);
            cartdao.deleteCartByID(car.getCarID()+"", cart.getUsername());
            cardao.updateAvailableTo0(car.getCarID()+"");
        }
        
        MyEmail me = new MyEmail();
        me.informBooking(customer.getEmail());
        int totalCart = cartdao.countTotalCarInCart(customer.getUsername());
        session.setAttribute("totalCart", totalCart);
        response.sendRedirect("cart");
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
