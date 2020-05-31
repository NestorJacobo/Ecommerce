<%@page import="cad.ProductoCad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="JavaBeans.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">



        <title>EC |  Inicio</title>
        <%@include file="css.jsp" %>



    </head><!--/head-->

    <body>
        <img src="images/img_login/inicio_frutas.png" style="width:100%;"/>
        <%@include file="header.jsp" %>
        <h2 class="title text-center"> BIENVENIDO </h2>
        <%@include file="slider.xhtml" %>  


    <section>
        <div class="container">
            <div class="row">


                <div class="col-sm-15 padding-right">
                    <div class="features_items"><!--features_items-->




                        <h2 class="title text-center">Productos destacados</h2>
                        <%! ArrayList<Producto> datos;%>
                        <%                                                    if (Integer.parseInt(session.getAttribute("category").toString()) > 0) {
                                datos = ProductoCad.listarProductosPorCategoria(session.getAttribute("moneda").toString(), Integer.parseInt(session.getAttribute("category").toString()));
                            } else if (Integer.parseInt(session.getAttribute("brand").toString()) > 0) {
                                datos = ProductoCad.listarProductosPorMarca(session.getAttribute("moneda").toString(), Integer.parseInt(session.getAttribute("brand").toString()));
                            } else {
                                datos = ProductoCad.listarProductosRecomendados(session.getAttribute("moneda").toString());
                            }
                        %>
                        <c:forEach var="p" items="<%= datos%>">
                            <div class="col-sm-4">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="${p.img}" alt="" />.
                                            <h2 <c:if test="${p.stock==0}"> class="gris" </c:if>>
                                                <c:choose>

                                                    <c:when test="${p.precionuevo!=0}">

                                                        $ ${p.precionuevo}0  ${sessionScope.moneda} <strike class="gris">$ ${p.precio}0</strike> 

                                                    </c:when>
                                                    <c:otherwise>
                                                        $ ${p.precio}0 ${sessionScope.moneda} 
                                                    </c:otherwise>
                                                </c:choose>

                                            </h2>
                                            <p>${p.nombre}</p>
                                            <span class="btn btn-default add-to-cart <c:if test="${p.stock==0}"> disabled </c:if>"><i class="fa fa-shopping-cart"></i>Agregar al carrito</span>
                                            </div>

                                            <div class="product-overlay <c:if test="${p.stock==0}"> grisfondo </c:if>">
                                                <div class="overlay-content">
                                                <c:choose>
                                                    <c:when test="${p.precionuevo!=0}">
                                                        <h2>${sessionScope.moneda} ${p.precionuevo}</h2>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:if test="${p.precionuevo==0}">
                                                            <h2>${sessionScope.moneda} ${p.precio}</h2>
                                                        </c:if>
                                                    </c:otherwise>
                                                </c:choose>
                                                <p>${p.nombre}</p>
                                                <a href="Cart?id=${p.webid}&T=O" class="btn btn-default add-to-cart <c:if test="${p.stock==0}"> disabled </c:if>"><i class="fa fa-shopping-cart"></i>Agregar al carrito</a>
                                                </div>
                                            </div>
                                        <c:choose>
                                            <c:when test="${p.precionuevo!=0}">
                                                <img src="images/home/sale.png" class="new" alt="producto en promoción"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:if test="${p.nuevo}">
                                                    <img src="images/home/new.png" class="new" alt="producto nuevo"/>
                                                </c:if>
                                            </c:otherwise>
                                        </c:choose>

                                    </div>
                                    <div class="choose">
                                        <ul class="nav nav-pills nav-justified">
                                            <li><a href=""><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></a></li>



                                            </a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div><!--features_items-->

                </div>		
                </section>

                <%@include file="footer.xhtml"%>



                <!--<img src="data:image/jpeg;base64,">-->
                </body>
                </html>
