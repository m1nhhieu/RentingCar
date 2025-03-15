/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Customer;

/**
 *
 * @author Dell
 */
@WebServlet(name="forgot", urlPatterns={"/forgot"})
public class forgot extends HttpServlet {
   
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
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        
        CustomerDAO cdao = new CustomerDAO();
        Customer customer = cdao.getCustomerByUsername(username);
        
        if(customer.getEmail().equalsIgnoreCase(email)){
            sendMessage(customer.getEmail());
            cdao.changePasswordByUsername(customer, "123456");
            response.sendRedirect("newpass.jsp");
        } else {
            request.setAttribute("loi", "Incorrect email");
            request.getRequestDispatcher("forgot.jsp").forward(request, response);
        }
    }
    
    public static void sendMessage(String email){
        String from = "nguyenvuan112004@gmail.com";
        String pass = "uqpnbasgeqqgbyxb";
        
        
        //Khai bao cac thuoc tinh de gui Email
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        
        //Dang nhap vao gmail ban dau de gui tin nhan cho cac gmail khac
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass); 
            }
        };
        
        
        //Tao phien lam viec cho gmail
        Session session = Session.getInstance(props,auth);
        
        
        //Gui email:
        String to =email;
        
        MimeMessage msg = new MimeMessage(session); //Tao tin nhan de gui
        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(from); //Nguoi gui
            //Nguoi Nhan
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));  
            
            //Tieu de email:
            msg.setSubject("Recover your password " + System.currentTimeMillis());
            
            //Quy dinh ngay gui:
            msg.setSentDate(new Date());
            
            //Quy dinh email nhan phan hoi, su dung trong TH muon gui den 1 email
            // khac email nhan ban dau
            //msg.setReplyTo(InternetAddress.parse(to, false)); 
            
            
            //Noi dung 
            msg.setText("Your new password is 123456. Please change your password after login!", "UTF-8");
            
            
            //Gui email
            Transport.send(msg);
            
            
        } catch (MessagingException ex) {
            System.out.println("Can not send");
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
