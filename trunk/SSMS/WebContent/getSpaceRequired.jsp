<%@page import="ssms.autocomplete.CustIDList"%>
<%
    CustIDList db = new CustIDList();
 
 	String query = request.getParameter("id");
 	
    String space = db.getRequired(query);
 	
 	out.println(space);
%>
