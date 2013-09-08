
 
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
  

/**
 *
 * @author mg116726
 */
@WebServlet(name="addent", urlPatterns={"/addent"})
public class addent extends HttpServlet {
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
                String dataSourceName = "ncyberdata";
		String dbURL = "jdbc:odbc:" + dataSourceName;
               
                   out.println("  d");
	try {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(dbURL, "", "");
			java.sql.Statement s=con.createStatement();
                       int ci = Integer.parseInt(request.getParameter("mid"));
                        int cp = Integer.parseInt(request.getParameter("pid")); 
               out.println("  d"+cp+ci+"---------" );
            //    String query="INSERT INTO master (userID, name,address,phone,proof)  VALUES ("+ci+", '"+cn+"', '"+ca+"', '"+cp+"', '"+cpr+"')";
//	  s.executeQuery(query); 
               //       con.commit(); 
               //=============
                
	 	 			s.execute("select userID from master"); // select the data from the 											// table
	 				ResultSet rs = s.getResultSet();
	 				int cou=0;
	 				 
	 				  
	 				while (rs.next()) // this will step through our data row-by-row
	 				{ 
	 					 int uid22 = Integer.parseInt(rs.getString(1));
	 					//System.out.println("Data found ddd " +uid2+uid22);
	 					if (ci==uid22)  
	 				{	 cou=1;				}	 
	 				 	
	 				} 			 
	 				if (cou==0)  
	 				{JOptionPane.showMessageDialog(null,
	 		 	 		    "Member id not found.",
	 		 	 		    "ERROR CYBERMAN",
	 		 	 		    JOptionPane.WARNING_MESSAGE);
 										}	 
	 				 String query2="select * from comp;";
	 		 		s.execute(query2 ); // select the data from the 											// table
	 				 ResultSet rs2 = s.getResultSet();
	 				int cou2 = 0;			 
	 	 				while (rs2.next()) // this will step through our data row-by-row
	 	 				{
	 	 				 
	 	 	int a2=Integer.parseInt(rs2.getString(2));
 	 	

 	 		if(cp==a2&& rs2.getInt(3)==0)
	 	 	{	  cou2=3;				}	 
	 				 	
 				 			 
 			
	 	 				}
	 	 				
	 					if (cou2!=3)  
	 	 				{JOptionPane.showMessageDialog(null,
	 	 		 	 		    "PC no "+cp+" is busy.",
	 	 		 	 		    "ERROR CYBERMAN",
	 	 		 	 		    JOptionPane.WARNING_MESSAGE);					}
	 	 				if (cou==1&&cou2==3)
	 	 				{
                                                    
	 	 					 
	 	 					Calendar cal = Calendar.getInstance();
	 	 			 	 
	 	 				 	DateFormat df = new SimpleDateFormat("HH");
	 	 				 	DateFormat df2 = new SimpleDateFormat("mm");
	 	 				 	String utime=df.format(cal.getTime());
	 	 				 	String utime2=df2.format(cal.getTime());
	 	 					String query3="update comp set status=1, stime ='"+utime+"' , etime ='"+utime2+"',user="+ci+"  where compID="+cp+";";
	 	 					//System.out.println(query3);
	 	 					 
                                                 s.executeQuery(query3); 
                                                          con.commit(); 
	 	 				}
               
    
//================	 
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
