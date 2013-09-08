
 
import java.beans.Statement;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceRef;
  

/**
 *
 * @author mg116726
 */
@WebServlet(name="addcust", urlPatterns={"/addcust"})
public class addcust extends HttpServlet {
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
                String dataSourceName = "ncyberdata";
		String dbURL = "jdbc:odbc:" + dataSourceName;
	try {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(dbURL, "", "");
			java.sql.Statement s=con.createStatement();
                       int ci = Integer.parseInt(request.getParameter("cid"));
                         String cn =  request.getParameter("cname");
                      String cp =request.getParameter("cphone"); 
                      String ca =  request.getParameter("cadd");
                      String cpr =request.getParameter("cproof"); 
               // out.println("  d"+cp+ca+"---------"+ci);
                String query="INSERT INTO master (userID, name,address,phone,proof)  VALUES ("+ci+", '"+cn+"', '"+ca+"', '"+cp+"', '"+cpr+"')";
	  s.executeQuery(query); 
                      con.commit(); 
                          
   } 
	 					catch (Exception err) {
	 				System.out.println("Error:} " + err);
	 			} 
	


            
			 

                
                
                
                
        //===========================================        
          finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
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
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
