<%@page import="control.Payu"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.UUID"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<c:set var="total" value="${total+(total*0.19)}"/>
<c:set var="mo" value="${moneda}"/>
<%
SimpleDateFormat formato=new SimpleDateFormat("ddMyyyyhhmmss");
String referencia=formato.format(new Date())+UUID.randomUUID();
String signature="2uih1qqur9t5tmaomb8ilt62p9~516359~"+referencia+"~"+pageContext.getAttribute("total")+"~"+pageContext.getAttribute("mo");

%>

<form method="post" action="https://gateway.payulatam.com/ppp-web-gateway/">
  <input name="merchantId"    type="hidden"  value="516359"   >
  <input name="accountId"     type="hidden"  value="517806" >
  <input name="description"   type="hidden"  value="Pagos productos E-Shopper"  >
  <input name="referenceCode" type="hidden"  value="<%=referencia%>" >
  <input name="amount"        type="hidden"  value="<%= pageContext.getAttribute("total") %>"   >
  <input name="tax"           type="hidden"  value=<fmt:formatNumber currencySymbol="" value="${total*0.19}" type="currency"/>  >
  <input name="taxReturnBase" type="hidden"  value="${0.19}" >
  <input name="currency"      type="hidden"  value="${moneda}" >
  <input name="signature"     type="hidden"  value="<%= Payu.MD5(signature) %>"  >
  <input name="buyerEmail"    type="email"  value="" placeholder="Correo" required >
  <input name="buyerFullName"    type="text"  value="" placeholder="Nombre completo" required value='<%=pageContext.getAttribute("total")%>'>
  <input name="responseUrl"    type="hidden"  value="<%= "http://localhost:8080"+request.getContextPath()+"/Success" %>" >
  <input name="confirmationUrl"    type="hidden"  value="<%= "http://localhost:8080"+request.getContextPath()+"/Confirmation" %>" >
  <input name="Submit" type="image"  src="images/payu.png" alt="Pagar con PayU" title="Pagar con PayU" >
</form>
