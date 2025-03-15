/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dal.CarDAO;
import dal.ContractDAO;
import dal.CustomerDAO;
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
import java.util.Stack;
import model.Car;
import model.Contract;
import model.Customer;
import model.Station;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns = {"/admin"})
public class admin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
        int totalCar = cdao.getTotalCarAdmin();
        int totalCarBeingHired = cdao.getTotalCarBeingHired();
        int totalCategories = cdao.getTotalCategories();

        //HOME
        ContractDAO condao = new ContractDAO();
        int totalsales = condao.getTotalSale();

        CustomerDAO cudao = new CustomerDAO();
        int totaluser = cudao.getTotalCustomer();

        StationDAO sdao = new StationDAO();
        int totalstation = sdao.getTotalStation();

        session.setAttribute("totalCar", totalCar);
        session.setAttribute("totalCarBeingHired", totalCarBeingHired);
        session.setAttribute("totalCategories", totalCategories);
        session.setAttribute("totalsales", totalsales);
        session.setAttribute("totaluser", totaluser);
        session.setAttribute("totalstation", totalstation);

        
        
        //CUSTOMER
        List<Customer> adminCustomer = cudao.getAllCustomer();
        session.setAttribute("adminCustomer", adminCustomer);
        
        
        //Car Products:
        List<Car> carListAdmin = cdao.getAllCarAdmin();
        session.setAttribute("carListAdmin", carListAdmin);
        
        
        //Later user for editcar and addcar
        List<Integer> priceList = cdao.getAllPriceID();
        List<Integer> stationList = sdao.getAllSationID();
        session.setAttribute("priceList", priceList);
        session.setAttribute("stationList", stationList);
        
        
        //STATIONS:
        List<Station> adminStation = sdao.getAllSation();
        session.setAttribute("adminStation", adminStation);
        int stapage = adminStation.size()/10+1;
        int stacurpage = 1;
        List<Station> admin10Station = select10Station(adminStation, stacurpage);
        session.setAttribute("admin10Station", admin10Station);
        session.setAttribute("stapage", stapage);
        session.setAttribute("stacurpage", stacurpage);
        
        //CONTRACTS
        List<Contract> contractList = condao.getAllContract();
        session.setAttribute("contractAdminList", contractList);
        
        int page = carListAdmin.size()/3+1;
        if(page==0) page = 1;
        int curpage = 1;

        List<Car> adcList3 = select3Car(carListAdmin,curpage);
        session.setAttribute("adcList3", adcList3);
        session.setAttribute("adpage", page);
        session.setAttribute("adcurpage", curpage);
        
        String curlink = "home";
        session.setAttribute("curlink", curlink);
        
        
        response.sendRedirect("admin.jsp");

        

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
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
