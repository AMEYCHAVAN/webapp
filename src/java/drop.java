
 
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
@WebServlet(name="drop", urlPatterns={"/drop"})
public class drop extends HttpServlet {
    public int aa=0;
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String dataSourceName = "ncyberdata";
		String dbURL = "jdbc:odbc:" + dataSourceName;

        try {
            out.println("<h2>Servlet ClientServlet at " + request.getContextPath () + "</h2>");
              
                            out.println("Result:"+aa);
            String i =  request.getParameter("value1");
            if (aa==99){  
            RequestDispatcher r4=request.getRequestDispatcher("bill.jsp");
                                       r4.forward(request, response);  
            }
   //-------------------------------------------------             
                
     try { 
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        			Connection con = DriverManager.getConnection(dbURL, "", "");
			java.sql.Statement s=con.createStatement();
                         String query2="select * from comp;";
 		 		s.execute(query2 ); // select the data from the 											// table
 				 ResultSet rs2 = s.getResultSet();
 			
 				 while (rs2.next()) // this will step through our data row-by-row
	 				{
	 				//System.out.println(Integer.parseInt(jTextField7.getText())+"---"+Integer.parseInt(rs2.getString(1)));
	 	 int a1 = Integer.parseInt(request.getParameter("value1"));

	 	int a2=Integer.parseInt(rs2.getString(2));
		int a3=Integer.parseInt(rs2.getString(3));
		 
		// out.println("  d"+a1+a2+"---------"+a3);
                if(a1==a2&& a3==0)
	 	{	out.println(" ");
                   RequestDispatcher r5=request.getRequestDispatcher("dropentry.jsp");
                                       r5.forward(request, response);  
                    JOptionPane.showMessageDialog(null,
	 		    "PC no "+a1+" is not in use.",
	 		    "ERROR CYBERMAN",
	 		    JOptionPane.WARNING_MESSAGE);
	 	} else if (a1==a2&& a3==1) 
                {
            
	 	// CyberConnection.createconnection();
 		  String query="update comp set status=0 where compID="+a1+";";
		  s.executeQuery(query); 
                      con.commit(); 
                  
                  
                 RequestDispatcher r4=request.getRequestDispatcher("bill.jsp");
                                      r4.forward(request, response);  
               JOptionPane.showMessageDialog(null,
	 		    "PC no "+a1+" is Closed",
	 		    " CYBERMAN",
	 		    JOptionPane.INFORMATION_MESSAGE);
                      //out.println("PC no "+a1+" is Closed:");
                        
                         aa=99;
            
             
         
                } 
 		 
    
    } 
		}
 				 
 				 catch (Exception err) {
	 				System.out.println("Error:} " + err);
	 			}            
                
 //-----------------------------------            
        } finally { 
            out.close();
        }
    } 

 
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
