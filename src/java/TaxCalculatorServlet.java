/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Models.TaxCalculationOutputs;
import Models.TaxData;
import Models.TaxYearModel;
import Models.TaxableIncomeModel;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NM Shiundlana
 */
public class TaxCalculatorServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TaxCalculatorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TaxCalculatorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        System.out.println(request);
        
        float salary = Float.parseFloat(request.getParameter("salary")); 
        int age = Integer.parseInt(request.getParameter("age")); //1 - for below 65 2 - for 65 - 75 3 - for above 75
        int medical_aid = Integer.parseInt(request.getParameter("medical_aid")); 
        int year = Integer.parseInt(request.getParameter("year")); 
        
        TaxCalculationOutputs results = handleTaxCalculationInputs(salary, age, medical_aid, year);
        
        response.setContentType("application/json;charset=UTF-8");
        
        TaxYearModel yearTaxData = TaxData.getYear(year);
        
        String json = new Gson().toJson(results);
        
        response.getWriter().write(json);       
        
    }
    
    private TaxCalculationOutputs handleTaxCalculationInputs(float salary, int age_class, int num_medical_aid_members, int year){
        TaxCalculationOutputs results = null;
        
        
        
        TaxYearModel yearTaxData = TaxData.getYear(year);
        
        TaxableIncomeModel income = yearTaxData.getTaxableIncomeModel(salary);
        
        results = new TaxCalculationOutputs(year, salary, 
                yearTaxData.getTaxRebatesModel(age_class), yearTaxData.getTaxThresholdModel(age_class), 
                yearTaxData.getTaxableIncomeModel(salary), yearTaxData.getMedicalAid(),
                yearTaxData
        );
        
        return results;
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
