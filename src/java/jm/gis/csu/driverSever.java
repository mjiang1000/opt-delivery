/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jm.gis.csu;

import com.google.gson.Gson;
import com.intepower.dal.vm_driversDAO;
import com.intepower.model.vm_drivers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


/**
 *
 * @author Admin
 */
@WebServlet(name = "driverSever", urlPatterns = {"/driverSever"})
public class driverSever extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//         response.setContentType("json;charset=UTF-8");
        try {
            String wid = request.getParameter("IDNum");
//            wid = "421127119299999990";
            String where = "IDNum =" + wid;
            vm_drivers driverModel = null;
            try {
                vm_driversDAO driverDAO = new vm_driversDAO();
                try {
                    driverModel = driverDAO.getModel(where);
                    JSONObject obj = new JSONObject();
                    Gson gson = new Gson();
                    String toJson = gson.toJson(driverModel);
                    obj.put("isDriver",true);
                    obj.put("info",toJson);
                    out.print(obj.toString());
                } catch (SQLException ex) {
                }
            } catch (NamingException ex) {
            }

        } catch (Exception ex) {
            int i = 0;
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
