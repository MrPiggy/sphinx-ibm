<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ssms.autocomplete.CustIDList"%>
<%@page import="ssms.entities.GoodsSpace"%>
<%
    CustIDList db = new CustIDList();
 
 	String query = request.getParameter("id");
 	
    List<GoodsSpace> goodsSpaces = db.getData(query);
 	
    Iterator<GoodsSpace> iterator = goodsSpaces.iterator();
    out.print("[");
    //[{"city":"San Diego","state":"CA","zip":"92101","value":"San Diego","label":"San Diego, CA 92101"}]
    while(iterator.hasNext()) {
        GoodsSpace shipment = (GoodsSpace)iterator.next();
        String id = shipment.getShipmentid();
        out.print("{\"id\":\"" + id + "\"," + "\"unit\":\"" + shipment.getNumber() + "\"," + "\"space\":\"" + shipment.getSpaceRequired() +"\",\"value\":\"" + id + "\",\"label\":\"" +  id + "\"}");
        if (iterator.hasNext())
        	out.print(",");
    }
    out.print("]");
%>
