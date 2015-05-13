/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jm.gis.csu;

import com.google.gson.Gson;
import com.intepower.dal.ot_delischemeDAO;
import com.intepower.dal.ot_oilpickDAO;
import com.intepower.dal.vd_storageDAO;
import com.intepower.model.ot_delischeme;
import com.intepower.model.ot_oilpick;
import com.intepower.model.vd_storage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author min
 */
@WebServlet(name = "getOneDeli", urlPatterns = {"/getOneDeli"})
public class getOneDeli extends HttpServlet {

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
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            JSONObject obj = new JSONObject();
            Gson gson = new Gson();
            int ID = Integer.valueOf(request.getParameter("ID"));
//            int ID = 2;
            ot_delischemeDAO de_DAO = new ot_delischemeDAO();
            ot_delischeme model = new ot_delischeme();
            model = de_DAO.getModel(ID);
            if (model == null) {
                obj.put("succ", false);
                return;
            }
            ArrayList list = new ArrayList();
           
            String[] PickIDs = model.PickID.split(";");
            String[] BuyerNames = model.BuyerName.split(";");
            String[] Addresses = model.Address.split(";");

            for (int i = 0; i < PickIDs.length; i++) {
                JSONObject pickObj = new JSONObject();
                ot_oilpickDAO pick_dao = new ot_oilpickDAO();
                ot_oilpick pick_model = pick_dao.getModel(Integer.valueOf(PickIDs[i]));
                if (pick_model == null) {
                    obj.put("succ", false);
                    return;
                }
                pickObj.put("PickID", pick_model.ID);
                pickObj.put("BuyerName", BuyerNames[i]);
                pickObj.put("Address", Addresses[i]);
                pickObj.put("pickItem", pick_model);
                pick_model =null;
                list.add(pickObj);
                pickObj = null;
            }
            String toJson = gson.toJson(list);
            obj.put("succ", true);
            obj.put("OilPick", toJson);
            
            vd_storageDAO storageDAO = new vd_storageDAO();
            vd_storage  storageMosel = storageDAO.getModel(model.StorageID);
            toJson = gson.toJson(storageMosel);
            obj.put("storage", toJson);
            toJson = gson.toJson(model);
            obj.put("Sche", toJson);
            out.print(obj);
        } catch (Exception ex) {
            out.print(ex.toString());
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
