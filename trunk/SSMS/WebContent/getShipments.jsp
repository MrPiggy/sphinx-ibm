<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ssms.autocomplete.CustIDList"%>
<%
    CustIDList db = new CustIDList();
 
 	String query = request.getParameter("id");
 	
    List<String> ids = db.getShipmentIDs(query);
 	
    Iterator<String> iterator = ids.iterator();
    out.print("[");
    while(iterator.hasNext()) {
        String id = (String)iterator.next();
        if (iterator.hasNext())
        	out.print("\"" + id + "\",");
        else
        	out.print("\"" + id + "\"");
    }
    out.print("]");
%>
