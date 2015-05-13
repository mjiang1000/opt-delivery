/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jm.gis.csu;

import com.intepower.dal.vm_gpsDAO;
import com.intepower.model.vm_gps;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;



/**
 *
 * @author Admin
 */
@WebServlet(name = "vm_gpsServlet", urlPatterns = {"/vm_gpsServlet"})
public class vm_gpsServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            JSONObject data =new JSONObject(request.getParameter("data"));
//            data.getJSONObject(request.getParameter("data"));         
            int VehiID = data.getInt("VehiID");
            String PlatNum = data.getString("PlatNum");
            String PushTime = data.getString("PushTime");
            Double Lon = data.getDouble("Lon");
            Double Lat = data.getDouble("Lat");
            vm_gps gpsModel = new vm_gps(0,VehiID, PlatNum, PushTime, Lon, Lat);
            JSONObject obj = new JSONObject();
            try {
                vm_gpsDAO gpsDAO = new vm_gpsDAO();
                try {
                   Boolean addSucc = gpsDAO.add(gpsModel);
                   obj.put("succ",addSucc);
                  
                } catch (SQLException ex) {
                    obj.put("err", ex.toString());
                    Logger.getLogger(vm_gpsServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NamingException ex) {
                obj.put("err", ex.toString());
                Logger.getLogger(vm_gpsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.print(obj.toString());
        }catch(JSONException ex){
        } 
        finally {
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
