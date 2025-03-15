/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import dal.CarDAO;
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
import model.Car;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns={"/loadcar"})
public class loadcar extends HttpServlet {
   
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
        CarDAO cdao = new CarDAO();
        HttpSession session = request.getSession();
        String pickuplocation = session.getAttribute("pickuplocation")+"";
        
        
        List<Car> cList = cdao.getAllCityCar(pickuplocation);
        List<Integer> iList = cdao.getAllCategory();
        int totalCarProduct = cdao.countTotalCar(pickuplocation);
        int page = totalCarProduct/3;
        if(page==0) page = 1;
        int curpage = 1;

        List<Car> cList3 = select3Car(cList,curpage);
        session.setAttribute("cList", cList);
        session.setAttribute("cList3", cList3);
        session.setAttribute("iList", iList);
        session.setAttribute("page", page);
        session.setAttribute("curpage", curpage);
        session.setAttribute("totalCarProduct", totalCarProduct);
        
        response.sendRedirect("product.jsp");
        
        
    }
    
    
    public static List<Car> select3Car( List<Car> cList, int pageNum){
        List<Car> top3List = new ArrayList<>();
        for(int i = pageNum*3-3;i<=pageNum*3-1;i++){
            if(i>=cList.size()) {
                break;
            } else {
                top3List.add(cList.get(i));
            }
        }
        
        return top3List;
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