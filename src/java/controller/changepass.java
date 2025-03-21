/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import dal.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns={"/changepass"})
public class changepass extends HttpServlet {
   
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
        
        String loi = "";
        String success="";
        CustomerDAO cdao = new CustomerDAO();
        Customer customer = (Customer)session.getAttribute("customer");
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String confirmpassword = request.getParameter("confirmpassword");
        
        if(oldpassword.equals(customer.getPassword())==false){
            loi = "Old password is incorrect!";
            request.setAttribute("loi", loi);
            request.getRequestDispatcher("changepass.jsp").forward(request, response);
        } else {
            if(newpassword.equals(confirmpassword)==false){
                loi = "New password and Confirm password are not the same!";
                request.setAttribute("loi", loi);
                request.getRequestDispatcher("changepass.jsp").forward(request, response);
            } else if(oldpassword.equals(newpassword)){
                loi = "Old password and new password must be different!";
                request.setAttribute("loi", loi);
                request.getRequestDispatcher("changepass.jsp").forward(request, response);
            } else {
                cdao.changePasswordByUsername(customer, newpassword);
                success ="Change successful!";
                request.setAttribute("loi", null);
                request.setAttribute("success", success);
                request.getRequestDispatcher("changepass.jsp").forward(request, response);
            }
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
