<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ssms.autocomplete.CustIDList"%>
<%
    CustIDList db = new CustIDList();
 
    List<String> ids = db.getIDs();
 	
    Iterator<String> iterator = ids.iterator();
    
    while(iterator.hasNext()) {
        String id = (String)iterator.next();
        out.println(id);
    }
%>
