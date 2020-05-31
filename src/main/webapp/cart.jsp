<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>EC | Carrito</title>
        <%@include file="css.jsp" %>
        <script src="https://www.paypalobjects.com/api/checkout.js"></script>

        <%
            request.getSession();
            System.out.println("ESTOY EN CART JSP");
            System.out.println(request.getSession().getAttribute("usuario"));

            String user;
            if (request.getSession().getAttribute("usuario") != null) {
                user = request.getSession().getAttribute("usuario").toString();
                System.out.println("Entré al if");
            } else {
                user = "";
                System.out.println("Entré al else");

            }
            System.out.println("Pasé el if. Usuario= " + user);
        %>
    </head><!--/head-->

    <body>

        <%@include file="header.jsp" %>

        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="#">Carrito</a></li>
                        <li class="active">Lista de productos</li>
                    </ol>
                    <%                                if (user == "") {
                            out.print("<h1>Ingresa a tu cuenta para empezar a comprar</h1>");
                        } else {
                            out.print("<h2>Selecciona productos para meterlos a tu carrito y después comprarlos</h2>");
                        }
                    %>
                </div>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Producto</td>
                                <td class="description"></td>
                                <td class="price">Precio</td>
                                <td class="quantity">Cantidad</td>
                                <td class="total">Total</td>
                                <td class="total">Estado</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.cart}" var="pro">
                                <c:if test="${pro.p.precionuevo!=0.00}">
                                            <c:set  var="total" value="${total+pro.p.precionuevo*pro.cantidad}"/>
                                        </c:if>
                                        <c:if test="${pro.p.precionuevo==0.00}">
                                            <c:set  var="total" value="${total+pro.p.precio*pro.cantidad}"/>
                                        </c:if>
                                
                                
                                <tr>
                                    <td class="cart_product">
                                        <a href=""><img src="foto/${pro.p.img}" width="110px" alt=""></a>
                                    </td>
                                    <td class="cart_description">
                                        <h4><a href="">${pro.p.nombre}</a></h4>
                                        <p>ID Referencia Web: ${pro.p.webid}</p>
                                    </td>
                                    <td class="cart_price">


                                        <c:if test="${pro.p.precionuevo!=0.00}">
                                            <p>${pro.p.precionuevo} MXN</p>
                                        </c:if>
                                        <c:if test="${pro.p.precionuevo==0.00}">
                                            <p>${pro.p.precio} MXN</p>
                                        </c:if>







                                    </td>
                                    <td class="cart_quantity">
                                        <div class="cart_quantity_button">
                                            <a class="cart_quantity_up" href=""> + </a>
                                            <input class="cart_quantity_input" type="text" name="quantity" value="${pro.cantidad}" autocomplete="off" size="2">
                                            <a class="cart_quantity_down" href=""> - </a>
                                        </div>
                                    </td>
                                    <td class="cart_total">
                                        <p id="precio_1" class="cart_total_price">
                                            <fmt:setLocale value="en_US"/>
                                            
                                            <c:if test="${pro.p.precionuevo!=0.00}">
                                                <fmt:formatNumber value="${pro.p.precionuevo*pro.cantidad}" type="currency"/> MXN
                                            </c:if>
                                        <c:if test="${pro.p.precionuevo==0.00}">
                                            <fmt:formatNumber value="${pro.p.precio*pro.cantidad}" type="currency"/> MXN
                                        </c:if>

                                        </p>
                                    </td>
                                    
                                    <td class="cart_description">
                                        <h4>Esperando Pago</h4>
                                    </td>
                                    <td class="cart_delete">
                                        <a class="cart_quantity_delete" href="?T=D&id=${pro.p.webid}"><i class="fa fa-times"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">
                <div class="heading">
                    <h3>Pago</h3>
                </div>
                <div class="row">

                    <div class="col-sm-10">
                        <div class="total_area">
                            <ul>

                                <li>Sub Total: <span>${total} MXN</span>  </li>
                                <li>IVA(16%): <span>${total*0.16} MXN</span>  </li>
                                <li><h3>Total: <span>${total+(total*0.16)} MXN</span>  </h3></li>
                            </ul>
                            

                            <div>
                                <a class="btn btn-default update" href="Inicio">Seguir comprando</a>
                            </div>


                            <div align="right">
                                <%@include file="checkout.jsp" %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section><!--/#do_action-->
        <%@include file="footer.xhtml" %>
        <!--%@include file="js.jsp" %-->


        <!--<img src="data:image/jpeg;base64,">-->
    </body>
</html>
