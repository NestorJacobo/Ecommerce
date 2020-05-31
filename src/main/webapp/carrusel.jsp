<%-- 
    Document   : header
    Created on : 20/04/2020, 09:48:06 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"/>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="description" content=""/>
        <meta name="author" content=""/>
        <title>Carrusel</title>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/font-awesome.min.css" rel="stylesheet"/>
        <link href="css/prettyPhoto.css" rel="stylesheet"/>
        <link href="css/animate.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="css/responsive.css" rel="stylesheet"/>
        <link href="css/price-range.css" rel="stylesheet"/>
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/icono.png"/>
        <link rel="icon" href="images/icono.png" type="image/x-icon"/>

        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png"/>
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png"/>
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png"/>
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png"/>

        <script type="text/javascript" src="http://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=1U21EeuAty6ve6uDOTF_jrEtQeu15jS1e02it7Cywytry6Hcv13N3EyOqdIBaSipWOroUG40LU5GSxg2CjG4RhdImQjpNFkgwTykkrpMqbc" charset="UTF-8"></script>
        <script>

            $(document).ready(function () {
                $('.carousel').carousel();
            });
        </script>
    </head>
    <body>        
        <header id="header">
            <h:form>		
                  <div class="container">

            <div align="center">
                <img src="images/img_login/productitos.jpeg" style="max-width:100%; width:auto;height: auto"/>               
            </div> 
            <div class="carousel"  id="item2" style="max-width:100%; width:auto;height: auto">
                <a class="carousel-item" href="#one!"><img src="images/img_login/M1.jpg" /></a>
                <a class="carousel-item" href="#two!"><img src="images/img_login/M2.jpg" /></a>
                <a class="carousel-item" href="#three!"><img src="images/img_login/M5.jpg" /></a>
                <a class="carousel-item" href="#four!"><img src="images/img_login/M6.jpg" /></a>
                <a class="carousel-item" href="#five!"><img src="images/img_login/M7.jpg" /></a>
                <a class="carousel-item" href="#five!"><img src="images/img_login/M8.jpg" /></a>
                <a class="carousel-item" href="#five!"><img src="images/img_login/M9.jpg" /></a>
            </div> 

        </div>
        
            </h:form>
        </header>
    </body>
</html>
