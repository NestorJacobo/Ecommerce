<%@page import="cad.VentasCad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="JavaBeans.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Security-Policy" content="default-src 'self'; img-src 'self';  script-src 'self' https://www.paypalobjects.com/api/checkout.js"></meta>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>EC | Historial</title>
        <%@include file="css.jsp" %>
        <script src="https://www.paypalobjects.com/api/checkout.js"></script>

        <%
            request.getSession();
            System.out.println("ESTOY EN HISTORIAL JSP");
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
    </head> 
    <body>
        <%@include file="header.jsp" %>
        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="#">Historial</a></li>
                        <li class="active">Compras realizadas</li>
                    </ol>
                    <h2>Historial de compras realizadas</h2>
                </div>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="description">ID Venta</td>
                                <td class="description">ID producto</td>
                                <td class="description">Nombre producto</td>
                                <td class="quantity">Cantidad</td>
                                <td class="quantity">Precio unitario</td>
                                <td class="price">Precio total (Con IVA)</td>
                                <td class="description">Fecha</td>
                                <td class="description">Estado</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%! ArrayList<Venta> datos;%> 
                            <% datos = VentasCad.listarHistorial(user);
                            %>    
                            <c:forEach var="p" items="<%= datos%>">
                                <tr>
                                    <td class="cart_description">
                                        <p>${p.idventa}</p>
                                    </td>
                                    <td class="cart_description">
                                        <p>${p.idproducto}</p>
                                    </td>
                                    <td class="cart_description">
                                        <p>${p.nombreproducto}</p>
                                    </td>
                                    <td class="cart_description">
                                            <p>${p.cantidad}</p>
                                    </td>
                                    <td class="cart_price">
                                        <p id="precio_1" class="cart_total_price">
                                            <fmt:setLocale value="en_US"/>
                                            <fmt:formatNumber value="${p.preciounitario}" type="currency"/> MXN
                                        </p>
                                    </td>
                                    <td class="cart_total">
                                        <p id="precio_1" class="cart_total_price">
                                            <fmt:setLocale value="en_US"/>
                                            <fmt:formatNumber value="${p.preciototal}" type="currency"/> MXN
                                        </p>
                                    </td>
                                    <td class="cart_description">
                                            <p>${p.fecha}</p>
                                    </td>
                                    <td class="cart_description">
                                            <p>${p.estado}</p>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <section id="do_action">
            <div class="container">
            </div>
        </section>
        <%@include file="footer.xhtml" %>
    </body>
</html>
