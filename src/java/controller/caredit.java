/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CarDAO;
import dal.StationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import model.Car;

/**
 *
 * @author Dell
 */
@MultipartConfig
@WebServlet(name="caredit", urlPatterns={"/caredit"})
public class caredit extends HttpServlet {
   
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
        StationDAO sdao = new StationDAO();
        if (request.getParameter("carID") != null) {
            int id = Integer.parseInt(request.getParameter("carID"));
            
            
            Car c = cdao.getCarByIdAdmin(id);
            List<Integer> priceList = cdao.getAllPriceID();
            List<Integer> stationList = sdao.getAllSationID();
            
            session.setAttribute("carEditAmin", c);
            session.setAttribute("priceList", priceList);
            session.setAttribute("stationList", stationList);
            
            
            
            response.sendRedirect("editcar.jsp");
        } else {
             Car car = (Car)session.getAttribute("carEditAmin");
             int id = car.getCarID();
             String carname = request.getParameter("carname");
             boolean avai = true;
             String available = request.getParameter("available");
             if(available.equals("0")) avai = false;
             
             String img= "";
             Part file = request.getPart("image");
             if(file.getSubmittedFileName().length()>0)
              img = uploadImage(file);
             else img = car.getImgage();
             
             int priceid = Integer.parseInt(request.getParameter("priceid"));
             int stationid = Integer.parseInt(request.getParameter("stationid"));
             int numberofseats = Integer.parseInt(request.getParameter("numberofseats"));
             int numberoflargebags = Integer.parseInt(request.getParameter("numberoflargebags"));
             int numberofsmallbags = Integer.parseInt(request.getParameter("numberofsmallbags"));
             
             
             Car editcar = new Car(id, carname, avai, img, priceid, stationid, numberofseats, numberoflargebags,numberofsmallbags,car.getReviewScore(),car.getReviewer());
             cdao.updateCar(editcar);
             response.sendRedirect("admin");
        
        }
    }
    
     public static String uploadImage(Part file) throws IOException{

        //Part file = request.getPart("image");//Get upload file
        String imgfileName = file.getSubmittedFileName(); //Get File name

        //Get upload path:
        String uploadPath = "C:\\Java\\3_Car_Renting_Bootstrap\\web\\img\\"+imgfileName;
        
        
        
        //Upload File
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();
        
            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        } catch (FileNotFoundException ex) {
        }
        
        
        String displayFileName = "img\\"+imgfileName; //File name to insert in SQL
        return  displayFileName;
        
        
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
