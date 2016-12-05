<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="description" content="Сайт для бесплатного обмена вещами">
    <meta name="keywords" content="Калиласка, Kalilaska">
    <meta http-equiv="content-type" content="text/html;" charset="utf-8">
    <title>KALILASKA</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/home/css/bootstrap.css"/>"  rel="stylesheet">
    <link href="<c:url value="/resources/home/css/font-awesome.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/home/css/syle.css"/>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div class="container">
        <div class="row" align="center">
            <h1>KALILASKA</h1>
        </div>
        <div class="row">
            <div class="navbar navbar-inverse">
                <div class="container">
                    <div class="navbar-header">
                        <p><a class="navbar-brand" href="#">K<i class="fa fa-heart-o"></i></a>
                        </p>

                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                            <span class="sr-only">Открыть навигацию</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>

                    <div class="collapse navbar-collapse" id="responsive-menu" align="center">
                        <ul class="nav navbar-nav">
                            <li><a href="#">О нас</a> 
                            </li>
                            <li><a href="#">Kаталог</a> 
                            </li>
                            <li><a href="#">Мероприятия</a> 
                            </li>
                            <li><a href="#">Личный кабинет</a> 
                            </li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="container">
                    <div id="carousel" class="carousel slide">
                        <!--Индикаторы слайдов-->
                        <ol class="carousel-indicators">
                            <li class="active" data-target="#carousel" data-slide-to="0"></li>
                            <li data-target="#carousel" data-slide-to="1"></li>
                            <li data-target="#carousel" data-slide-to="2"></li>
                        </ol>

                        <!--Слайды-->
                        <div class="carousel-inner">
                            <div class="item active" align="center">
                                <div class="full-screen">
                                    <img class="full-screen" src="<c:url value="resources/home/images/simple1.jpg"/>" alt="">
                                </div>
                                <div class="carousel-caption">
                                    <h3>Slide1</h3>
                                    <p>description1</p>
                                </div>
                            </div>
                            <div class="item" align="center">
                                <div class="full-screen">
                                    <img class="full-screen" src=<c:url value="resources/home/images/simple.jpg"/> alt="">
                                </div>
                                <div class="carousel-caption">
                                    <h3>Slide2</h3>
                                    <p>description2</p>
                                </div>
                            </div>
                            <div class="item" align="center">
                                <div class="full-screen">
                                    <img class="full-screen" src=<c:url value="resources/home/images/simple.jpg"/> alt="">
                                </div>
                                <div class="carousel-caption">
                                    <h3>Slide3</h3>
                                    <p>description3</p>
                                </div>
                            </div>
                        </div>

                        <!--Стрелки переключения слайдов-->
                        <a href="#carousel" class="left carousel-control" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span> 
                        </a>
                        <a href="#carousel" class="right carousel-control" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span> 
                        </a>

                    </div>
                </div>
            </div>
        </div>
        <div class="navbar navbar-btn">
            <div class="row">
                <br>
                <h4 align="center">Сделано в Беларуси</h4>
            </div>
        </div>
    </div>



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=<c:url value="resources/home/js/bootstrap.js"/>></script>
</body>

</html>

