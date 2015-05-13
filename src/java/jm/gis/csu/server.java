package jm.gis.csu;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Admin
 */
@WebServlet(name = "server", urlPatterns = {"/server"})
public class server extends HttpServlet {

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
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */

            //test base64decoder
            String imgData = request.getParameter("img");
            String pathTemp = "f:/temp.png";
            if (imgData == null) {
                return;
            }
            BASE64Decoder decoder = new BASE64Decoder();
            try {
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
            } catch (Exception e) {
            }


//            byte[] data = null;
//            String imgFilePath = "f:/d.png";
//
//            try {
//                InputStream in = new FileInputStream(imgFilePath);
//                data = new byte[in.available()];
//                in.read(data);
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            BASE64Encoder encoder = new BASE64Encoder();
//            String str = encoder.encode(data);// 返回Base64编码过的字节数组字符串 
            out.print("ok+");
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
