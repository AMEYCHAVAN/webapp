 
 
import java.beans.Statement;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
  
@WebServlet(name="bille", urlPatterns={"/bille"})
public class bille extends HttpServlet {
    
   String a15,a16,a10,a12,a14;
                int z66,tc; 
                int z1,z2,z3,z4,z5;
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
                String dataSourceName = "ncyberdata";
		String dbURL = "jdbc:odbc:" + dataSourceName;
             
                 
	try { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(dbURL, "", "");
			java.sql.Statement s=con.createStatement();
                
 			 String query2="select * from comp;";
 		 		s.execute(query2 ); // select the data from the 											// table
 				 ResultSet rs2 = s.getResultSet();
 			   tc = Integer.parseInt(request.getParameter("pid"));
                            
                         while (rs2.next())  {
	 				 
                                                            int a2=Integer.parseInt(rs2.getString(2));
                                                            if(tc==a2)
                                                            { 	
                      a10 = rs2.getString(6);
      a15 = rs2.getString(4);
        a16 = rs2.getString(5);                                                       
                                                            }
                                                            }
 				Calendar cal = Calendar.getInstance();
 		 		
 			 	DateFormat df = new SimpleDateFormat("HH");
 			 	DateFormat df2 = new SimpleDateFormat("mm");
 				 	String date1=df.format(cal.getTime());
 				 	String date2=df2.format(cal.getTime());
 				 
                                         z1=Integer.parseInt(date1);
 			 	 z2=Integer.parseInt(a15);
 			 	 z3=Integer.parseInt(date2);
 			 	 z4=Integer.parseInt(a16);
 			 	 z5=z3-z4;
 			 	 
 		 	
 			 	 int z6=z1-z2;	
 			 	//System.out.println("z4555555:} " +z1);
 			 	 int z61=z6*60;
 			 	   z66=z61+z5;
 			//	a12=z66;
	//---------------------duration z66	
	 					} catch (Exception err) {
	 				System.out.println("Error:} " + err);
	 			} 
		
		try {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(dbURL, "", "");
			System.out.println("sucss");
			java.sql.Statement s4=con.createStatement();
			 String query4="select * from rate;";
		 		s4.execute(query4 ); // select the data from the 											// table
				 ResultSet rs4 = s4.getResultSet();
				while (rs4.next()) // this will step through our data row-by-row
	 				{a14=rs4.getString(3);	
	 			 
		 		}
                                
                                
			 	int z9=z66;
			 	int z10= z9/30;
			 	z10++;
			 	int z11=z10*Integer.parseInt(a14);
			 	//jTextField14.setText(""+z11);
			 	          //out.println("Bill amount "+z11+"---------");
 
                                
   out.println("<BODY><h2>Bill</hd><TABLE BORDER='1' CELLSPACING='2' CELLPADDING='2'>");                             
       
   out.println("<TR><TD>" + "PC no:"+ "</TD>");
   out.println("<TD>" + tc + "</TD></TR>");
    out.println("<TR><TD>" + "Member ID:"+ "</TD>");
   out.println("<TD>" + a10 + "</TD></TR>");
    out.println("<TR><TD>" + "Start time  :"+ "</TD>");
   out.println("<TD>"  +z2+":"+z4 + "</TD></TR>");
    out.println("<TR><TD>" + "Duration"+ "</TD>");
   out.println("<TD>" + z66 + "</TD></TR>");
    out.println("<TR><TD>" + "Total      "+ "</TD>");
   out.println("<TD>" + z11 + "</TD></TR>");
         
                
                
                } catch (Exception err) {
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
