/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;


import dal.ContractDAO;
import dal.StationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Contract;
import model.Station;

/**
 *
 * @author Dell
 */
@WebServlet(name="stationsearch", urlPatterns={"/stationsearch"})
public class stationsearch extends HttpServlet {
   
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

        String saddress = request.getParameter("stationsearch");
        StationDAO sdao = new StationDAO();
        List<Station> adminStation = new ArrayList<>();
        if(saddress.length()==0){
            adminStation = sdao.getAllSation();
            session.setAttribute("adminStation", adminStation);
        } else {
            adminStation = sdao.getAllSationByAddress(saddress);
            session.setAttribute("adminStation", adminStation);
        }
        
        String curlink = "station";
        session.setAttribute("curlink", curlink);
        
        int stapage = adminStation.size()/10+1;
        int stacurpage = 1;
        List<Station> admin10Station = select10Station(adminStation, stacurpage);
        session.setAttribute("admin10Station", admin10Station);
        session.setAttribute("stapage", stapage);
        session.setAttribute("stacurpage", stacurpage);
        
        response.sendRedirect("admin.jsp");
    } 
    
    
    public static List<Station> select10Station( List<Station> sList, int pageNum){
        List<Station> top10List = new ArrayList<>();
        for(int i = pageNum*10-10;i<=pageNum*10-1;i++){
            if(i>=sList.size()) {
                break;
            } else {
                top10List.add(sList.get(i));
            }
        }
        
        return top10List;
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
