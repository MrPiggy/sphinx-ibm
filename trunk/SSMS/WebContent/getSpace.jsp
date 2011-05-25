<%@page import="ssms.autocomplete.CustIDList"%>
<%
    CustIDList db = new CustIDList();
 
 	String query = request.getParameter("id");
 	
    int space = db.getSpace(query);
 	
 	out.println(space);
%>
