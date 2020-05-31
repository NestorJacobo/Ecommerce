
<%@page import="cad.ProductoCad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="JavaBeans.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">
    <meta http-equiv="Content-Security-Policy" content="script-src 'self'"></meta>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>EC |  Productos</title>
    <%@include file="css.jsp" %>
    
<!--/head-->

<body>
	
    <%@include file="header.jsp" %>
	 
        

        <section>
		<div class="container">
			<div class="row">
				
				
				<div class="col-sm-15 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Todos los productos</h2>
                                                <%! ArrayList<Producto> datos;%>
                                                <%
                                                if(Integer.parseInt(session.getAttribute("category").toString())>0){
                                                    datos=ProductoCad.listarProductosPorCategoria(session.getAttribute("moneda").toString(),Integer.parseInt(session.getAttribute("category").toString()));
                                                }else if(Integer.parseInt(session.getAttribute("brand").toString())>0){
                                                    datos=ProductoCad.listarProductosPorMarca(session.getAttribute("moneda").toString(),Integer.parseInt(session.getAttribute("brand").toString()));
                                                }else{
                                                    datos=ProductoCad.listarProductosRecomendados(session.getAttribute("moneda").toString());
                                                }
                                                %>
                                                <c:forEach var="p" items="<%= datos %>">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="${p.img}" alt="" />
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
												<h2>${sessionScope.moneda} ${p.precio}</h2>
												<p>${p.nombre}</p>
												<a href="Cart?id=${p.webid}&action=order" class="btn btn-default add-to-cart <c:if test="${p.stock==0}"> disabled </c:if>"><i class="fa fa-shopping-cart"></i>Agregar al carrito</a>
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
                                                                                <li><a href="#" <c:if test="${p.stock==0}"> class="gris" </c:if>>
                                                                                    <c:choose>
                                                                                        <c:when test="${p.stock>0}">
                                                                                            <i class="fa fa-check-circle"></i>(<c:out value="${p.stock}"/>) Disponible
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <i class="fa fa-lock"></i>(<c:out value="${p.stock}"/>) Agotado
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                        
                                                                                    
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
