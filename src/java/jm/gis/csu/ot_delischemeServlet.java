/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jm.gis.csu;

import com.google.gson.Gson;
import com.intepower.dal.ot_delischemeDAO;
import com.intepower.model.ot_delischeme;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ot_delischemeServlet", urlPatterns = {"/ot_delischemeServlet"})
public class ot_delischemeServlet extends HttpServlet {

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
            JSONObject obj = new JSONObject();
            Gson gson = new Gson();
//            JSONObject data = new JSONObject(request.getParameter("data"));
//            String Vechicle = data.getString("Vechicle");
            String Vechicle = "123456789";
            String where = "Vechicle = " + Vechicle + " and State = 0";
            ot_delischemeDAO de_DAO = new ot_delischemeDAO();
            List<ot_delischeme> de_model_list = null;
            de_model_list = de_DAO.getList(where);
           
            String toJson = gson.toJson(de_model_list);
            obj.put("succ","true");
            obj.put("list",toJson);
            
            out.print(obj);
        } catch(Exception ex){
            out.print( ex.toString());
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
