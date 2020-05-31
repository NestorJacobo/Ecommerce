<%-- 
    Document   : header
    Created on : 20/04/2020, 09:48:06 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  HttpSession sesion = request.getSession();
    String cadena = "";
    
        System.out.println("****Header:");
    if (sesion.getAttribute("usuario") != null) {
        cadena = sesion.getAttribute("usuario").toString();
        sesion.setMaxInactiveInterval(600);
        System.out.println("if");
        System.out.println(sesion);
        System.out.println(sesion.getAttribute("usuario"));
    } else {
        System.out.println("else");
        System.out.println(sesion.getAttribute("usuario"));
        cadena = "";

    }
    System.out.println("****Header");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <header id="header">
            <h:form>		
                <h:panelGroup class="header-middle"><!--header-middle-->
                    <h:panelGroup class="container">

                        <h:panelGroup class="logo pull-left col-sm-offset-1">

                        </h:panelGroup>


                        <h:panelGroup class="col-sm-11">
                            <h:panelGroup class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    
                                   <%
                                            out.println("<li>");
                                            out.println("<a><i></i>");
                                            out.println(cadena);
                                            out.println("</a>");
                                            out.println("</li>");

                                            if(!cadena.isEmpty()){
                                                 out.println("<li>");
                                                 out.println("<a href='Cart'>Carrito</a>");
                                                 out.println("<li>");
                                                 
                                                out.println("<li>");
                                                out.println("<a href='hist.jsp'>Mis Compras</a>");
                                                out.println("<li>");
                                                 
                                                 out.println("<li>");
                                                 out.println("<a href=\"CerrarSesion\">Cerrar Sesión</a>");
                                                 out.println("<li>");
                                            }else{
                                                 
                                                 out.println("<li>");
                                                 out.println("<a href=\"faces/registro.xhtml\">Regístrate</a>");
                                                 out.println("<li>");
                                                 
                                                 out.println("<li>");
                                                 out.println("<a href=\"faces/login.xhtml\">Ingresar</a>");
                                                 out.println("<li>");
                                            }

                                        %>       
                                        
                                </ul>
                            </h:panelGroup>
                        </h:panelGroup>

                    </h:panelGroup>
                </h:panelGroup>
            </h:form>
            <h:form>  
                <panelGroup class="header-bottom"><!--header-bottom-->
                    <panelGroup class="container">
                        <panelGroup class="row">
                            <panelGroup class="col-sm-9">
                                <panelGroup class="navbar-header">
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                        <span class="sr-only">Navegación</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                </panelGroup>

                                <panelGroup class="mainmenu pull-left col-sm-offset-1" style="border-style: hidden hidden solid hidden; border-color: red">
                                    <ul class="nav navbar-nav collapse navbar-collapse">
                                        <li><a href="Inicio" class="active">Inicio</a></li>
                                        <li><a href="Producto">Todos los Productos</a></li>
                                        <li><a href='promocion.jsp'>Promociones</a></li>
                                        <%--    <li class="dropdown"><a href="#">Mi Compra<i class="fa fa-angle-down"></i></a>
                                            <ul role="menu" class="sub-menu">
                                                <li><a href="Cart">Ver carrito</a></li> 

                                            </ul>
                                        </li> --%>

                                    </ul>
                                </panelGroup>
                            </panelGroup>
                            <panelGroup class="col-sm-2">
                                <panelGroup class="search_box pull-right">
                                    <input type="text" placeholder="Buscar..."/>
                                </panelGroup>
                            </panelGroup>
                        </panelGroup>
                    </panelGroup>
                </panelGroup>
            </h:form>
        </header>
    </body>
</html>
