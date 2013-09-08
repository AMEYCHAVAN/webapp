<%-- 
    Document   : addcust
    Created on : Apr 12, 2012, 11:25:28 PM
    Author     : Pyro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> add cust</title>
    </head>
    <body>
        
                 <script type="text/javascript">
         
        function check1()
        {

          var d=true;
          var b=true;
            var ca=document.forms[0].cadd.value;
            var ch=document.forms[0].cphone.value;
            var cr=document.forms[0].cproof.value;
            var ci=document.forms[0].cid.value;
            var cna=document.forms[0].cname.value;

            if(ca=="")
                {
                    alert('Please Enter Address' );
                    document.forms[0].pid.focus();
                }
                else if(ch=="" )
                {
                    alert('Please Enter Phone' );
                    document.forms[0].name.focus();
                }
                 else if(cr=="" )
                {
                    alert('Please enter Proof Id' );
                    document.forms[0].address.focus();
                }
                 else if(ci=="" )
                {
                    alert('Please enter Id' );
                    document.forms[0].age.focus();
                } 
                  else if(isNaN(ci))
                    {
                        alert('Enter id in numbers');
                    }
                                  else if(!isNaN(cna))
                    {
                        alert('Enter Name in alpha');
                    }
    
                    else if(isNaN(ch))
                    {
                        alert('Enter Phone in numbers');
                    }
                             else{
                    document.forms[0].submit();
                }
                
            return 1;
        }
        </script>

        
                    <form name="Submit" action="addcust">&nbsp;
    <p class=MsoNormal align=center style='text-align:center'><b style='mso-bidi-font-weight:
normal'><span style='font-size:20.0pt;mso-bidi-font-size:11.0pt;line-height:
115%'><a href="http://localhost:8084/webapp/homee.jsp">Cyber café management</a></span></b><b
style='mso-bidi-font-weight:normal'><span style='font-size:20.0pt;mso-bidi-font-size:
11.0pt;line-height:115%;font-family:"Times New Roman","serif"'><o:p></o:p></span></b></p>

             
<p class=MsoNormal align=center style='text-align:center'><b style='mso-bidi-font-weight:
normal'><span style='font-size:16.0pt;mso-bidi-font-size:11.0pt;line-height:
115%'>Add Customer<o:p></o:p></span></b></p>

<p class=MsoNormal align=center style='text-align:center'><b style='mso-bidi-font-weight:
normal'><span style='font-size:16.0pt;mso-bidi-font-size:11.0pt;line-height:
115%'>-------------------------------------------------------------------------------------------------------------------------<o:p></o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:14.0pt;mso-bidi-font-size:11.0pt;line-height:115%;font-family:
"Times New Roman","serif"'>Me id&nbsp&nbsp&nbsp&nbsp<input type="text" name="cid" value="999" size="5"/><o:p></o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:14.0pt;mso-bidi-font-size:11.0pt;line-height:115%;font-family:
"Times New Roman","serif"'>Name&nbsp&nbsp&nbsp<input type="text" name="cname" value="999" size="5"/><o:p></o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:14.0pt;mso-bidi-font-size:11.0pt;line-height:115%;font-family:
"Times New Roman","serif"'>Address <input type="text" name="cadd" value="999" size="5"/><o:p></o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:14.0pt;mso-bidi-font-size:11.0pt;line-height:115%;font-family:
"Times New Roman","serif"'>Phone&nbsp&nbsp&nbsp <input type="text" name="cphone" value="999" size="5"/><o:p></o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:14.0pt;mso-bidi-font-size:11.0pt;line-height:115%;font-family:
"Times New Roman","serif"'>Proof&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="cproof" value="999" size="5"/><o:p></o:p></span></b></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:115%;font-family:
"Times New Roman","serif"'><o:p>&nbsp;</o:p></span></p>


    
          <h1 align=center style='text-align:center'> <input type="submit" value="Add it" name="GetResult" onClick="check1()"/></h1>
       

</div>

</body>
</html>
