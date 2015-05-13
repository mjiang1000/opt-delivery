/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jm.gis.csu;

import com.intepower.dal.ot_oilpickDAO;
import com.intepower.model.ot_oilpick;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Admin
 */
@WebServlet(name = "canvasServer", urlPatterns = {"/canvasServer"})
public class canvasServer extends HttpServlet {

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

            //test base64decoder
            JSONObject obj= new JSONObject();
            String imgData = request.getParameter("img");
            int PickID = Integer.valueOf( request.getParameter("PickID"));
        
            UUID  guid =  java.util.UUID.randomUUID();
            String filename = guid.toString();
            String pathTemp = "G:/jiangmin/img/png"+filename+".png";
            
            ot_oilpickDAO dao = new ot_oilpickDAO();
            ot_oilpick model = dao.getModel(PickID);
            ot_oilpick update = new ot_oilpick(
                    model.ID ,
                    model.OrderID ,
                    model.ScheID ,
                    model.SellerID,
                    model.SellerName,
                    model.BuyerID ,
                    model.BuyerName,
                    model.OilTypeID ,
                    model.OilType,
                    model.StorageID ,
                    model.StorName,
                    model.DeliType,
                    model.OilNum ,
                    model.PickTime,
                    model.GeneMan,
                    model.GeneTime ,
                    model.DeliPlace,
                    model.PickMan,
                    model.TradTime,
                    model.Remark,
                    model.LON ,
                    model.LAT ,
                    pathTemp                    );
            
            if (imgData == null) {
                obj.put("succ","false");
                out.print(obj.toString());
                return;
            }
            
           if( dao.update(update)){
               obj.put("succ","false");
               out.print(obj.toString());
               return;
           }
            BASE64Decoder decoder = new BASE64Decoder();
  
            byte[] bytes = decoder.decodeBuffer(imgData);
            OutputStream outStream = new FileOutputStream(pathTemp);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据  
                    bytes[i] += 256;
                }
            }
            outStream.write(bytes);
            outStream.flush();
            outStream.close();

            obj.put("succ","true");
            out.print(obj.toString());

        } catch (Exception e) {
            out.print(e);
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
