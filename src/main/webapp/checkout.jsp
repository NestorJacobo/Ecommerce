<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="POST" target="_top">
    <input type="hidden" name="business" value="openalfa-facilitator@openalfa.com"/> <!--Correo de prueba para el sandbox-->
    <input type="hidden" name="return" value="${initParam['urlretorno']}"/>  <!--EcommerceJEE/Cart?T=F-->
    <input type="hidden" name="cmd" value="_cart"/>
    <input type="hidden" name="upload" value="1"/>
    
    
    <!--Ciclo de todos los productos-->
    <c:forEach items="${sessionScope.cart}" var="pro">
        <c:set var="c" value="${c+1}"/>
        <input type="hidden" name="item_name_${c}" value="${pro.p.nombre}"/>
        <input type="hidden" name="item_number_${c}" value="${pro.p.webid}"/>
        <input type="hidden" name="amount_${c}" value="${pro.p.precio}"/>
        <input type="hidden" name="quantity_${c}" value="${pro.cantidad}"/>
    </c:forEach>
    
    
    <!--Impuestos-->
    <input type="hidden" name="tax_cart" value="${total*0.16}"/>
     <input type="hidden" name="currency_code" value="MXN"/>
    <input type="image" src="https://www.sandbox.paypal.com/es_ES/ES/i/btn/btn_buynow_LG.gif" border="0" name="submit" alt="PayPal, la forma r�pida y segura de pagar en Internet.">
    <img alt="" border="0" src="https://www.sandbox.paypal.com/es_ES/i/scr/pixel.gif" width="1" height="1">

</form>