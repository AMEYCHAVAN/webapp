
 
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
@WebServlet(name="loginn", urlPatterns={"/loginn"})
public class loginn extends HttpServlet {
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
		String dataSourceName = "ncyberdata";
		String dbURL = "jdbc:odbc:" + dataSourceName;

        try {
            out.println("<h2>Servlet ClientServlet at " + request.getContextPath () + "</h2>");
                
                             out.println("Result:");

                String i =  request.getParameter("USERID");
                String j =request.getParameter("PASSWORD");
               // int re=i+j;
              
                //out.println("<br/>");
                out.println("Result:");
                out.println("" + i + " + " + j + " = ");
        //========================================================
                try {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(dbURL, "", "");
			java.sql.Statement s=con.createStatement();
                        
 			//Statement s = con.createStatement();
 			 String query2="select * from user;";
 		 		s.execute(query2); // select the data from the 											// table
 				 ResultSet rs5 = s.getResultSet();
             //   out.println("Resultmkkmkkkkkkkkkkkkkkkk:");

                                 int x=0;
 			 	String u1=i;
 			 	String u2=j;
 				 while (rs5.next()) // this will step through our data row-by-row
	 				{
 					//System.out.println(rs5.getString(2));
 					   String u3 = rs5.getString(2);
 					  String u4 = rs5.getString(3);
 					 if( u1.equals(u3) && u2.equals(u4) )
 			 	 	 {out.println("--LOGIN");
 			 	 	x=1;
                                         RequestDispatcher r3=request.getRequestDispatcher("homee.jsp");
                                       r3.forward(request, response);
 			 	 	 	}
 
 	 	 
 	 	 
  		 
 	 			}//while end
 				 if(x==0)
 			 	{ JOptionPane.showMessageDialog(null,
	 		 	 		    "Wrong Userid Or Password",
	 		 	 		    "ERROR CYBERMAN",
	 		 	 		    JOptionPane.WARNING_MESSAGE);	}
  		  	 
	} 
	 					catch (Exception err) {
	 				System.out.println("Error:} " + err);
	 			} 
	


            
			 

                
                
                
                
        //===========================================        
        } finally { 
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
