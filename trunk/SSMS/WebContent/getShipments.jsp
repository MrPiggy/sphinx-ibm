<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ssms.autocomplete.CustIDList"%>
<%
    CustIDList db = new CustIDList();
 
 	String query = request.getParameter("id");
 	
    List<String> ids = db.getShipmentIDs(query);
 	
    Iterator<String> iterator = ids.iterator();
    
    while(iterator.hasNext()) {
        String id = (String)iterator.next();
        out.print(id + " ");
    }
%>
