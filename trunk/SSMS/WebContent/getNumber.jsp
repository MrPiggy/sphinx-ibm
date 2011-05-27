<%@page import="ssms.autocomplete.CustIDList"%>
<%
    CustIDList db = new CustIDList();
 
 	String query = request.getParameter("id");
 	
    String number = db.getNumber(query);
 	
 	out.println(number);
%>
