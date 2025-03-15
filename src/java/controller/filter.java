/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import dal.CarDAO;
import dal.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Car;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns={"/filter"})
public class filter extends HttpServlet {
   
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
        String pickuplocation = session.getAttribute("pickuplocation")+"";
        String sql = "select c.*, s.pickupLocation, p.DailyPrice\n" +
                    "from Cars as c, Stations as s, PriceDetails as p\n" +
                    "where c.StationID = s.StationID and c.PriceID = p.PriceID\n" +
                    "and s.City = ? and c.Available=1 ";
        
        
        String sqlCount ="select count(c.CarID) as TotalCar\n" +
                    "from Cars as c, Stations as s, PriceDetails as p \n" +
                    "where c.StationID = s.StationID and c.PriceID = p.PriceID \n" +
                    "and s.City = ? and c.Available=1 ";
                    
                
        //Filter Categories
        String[] categoriesFilter = request.getParameterValues("categories");
        if(categoriesFilter!=null)
        if(categoriesFilter.length>0){
            sqlCount+="and (";
            sql+="and (";
            for (int i = 0; i < categoriesFilter.length; i++) {
                if(i==categoriesFilter.length-1){
                    sqlCount+="c.NumberOfSeats = "+categoriesFilter[i];
                    sql+="c.NumberOfSeats = "+categoriesFilter[i];
                }
                else{
                    sqlCount+="c.NumberOfSeats = "+categoriesFilter[i]+" or ";
                    sql+="c.NumberOfSeats = "+categoriesFilter[i]+" or ";
                    
                }
                
            }
            sqlCount+=") ";
            sql+=") ";
        }
        session.setAttribute("categoriesFilter", categoriesFilter);
        
        
        //Filter Review Score
        String reviewScoreFilter = request.getParameter("score");
        if(reviewScoreFilter!=null){
            sqlCount+="and c.ReviewScore > "+reviewScoreFilter+" ";
            sql+="and c.ReviewScore > "+reviewScoreFilter+" ";  
        }
        session.setAttribute("reviewScoreFilter", reviewScoreFilter);

        //Filter Deposit
        String depositFilter = request.getParameter("deposit");
        if(depositFilter!=null){
            if(depositFilter.contains("-")){
                String[] sa = depositFilter.split("-");
                sql+="and p.Deposit >= "+sa[0]+" ";
                sql+="and p.Deposit <= "+sa[1]+" ";
                sqlCount+="and p.Deposit >= "+sa[0]+" ";
                sqlCount+="and p.Deposit <= "+sa[1]+" ";
            }else{
                sql+="and p.Deposit >= "+depositFilter+" ";
                sqlCount+="and p.Deposit >= "+depositFilter+" ";

            }
            
        }
         session.setAttribute("depositFilter", depositFilter);
         sqlCount+="group by s.City";
        
        
        List<Car> cList = cdao.getAllCarFilter(sql,pickuplocation);
        
        String sortByPrice = request.getParameter("sort");
        session.setAttribute("sortByPrice", sortByPrice);
        if(sortByPrice!=null){
            if(sortByPrice.equals("low")){
            cList.sort(new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    return o1.getDailyprice()-o2.getDailyprice();
                }
            });
        }
        if(sortByPrice.equals("high")){
            cList.sort(new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    return -(o1.getDailyprice()-o2.getDailyprice());
                }
            });
        }
        }
        
        int page = (cList.size())/3;
        if(page==0) page = 1;
        int curpage = 1;
        List<Car> cList3 = select3Car(cList,curpage);
        session.setAttribute("cList3", cList3);

        int totalCarProduct = cdao.countTotalCarFilter(pickuplocation, sqlCount);
        session.setAttribute("totalCarProduct", totalCarProduct);
        session.setAttribute("cList", cList);
        session.setAttribute("page", page);
        session.setAttribute("curpage", curpage);
        session.setAttribute("sql", sql);
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
