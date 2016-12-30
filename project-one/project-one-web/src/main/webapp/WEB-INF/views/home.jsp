<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="description" content="Сайт для бесплатного обмена вещами">
    <meta name="keywords" content="Калиласка, Kalilaska">
    <meta http-equiv="content-type" content="text/html;" charset="utf-8">
    <title>ZABIRAI</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/forViews/css/bootstrap.css"/>"  rel="stylesheet">
    <link href="<c:url value="/resources/forViews/css/font-awesome.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/forViews/css/syle.css"/>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    
        <div class="row" align="center">
            <h1><spring:message code="homePage.menu.header" /></h1>
        </div>
        <div class="row">
            <div class="navbar navbar-inverse">
                <div class="container">
                    <div class="navbar-header">
                        <p><a class="navbar-brand" href="/project-one-web/home">Z<i class="fa fa-heart-o"></i></a>
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
                            <li><a href="#"><spring:message code="homePage.menu.aboutUs" /></a> 
                            </li>
                            <li><a href="#"><spring:message code="homePage.menu.posts" /></a> 
                            </li>
                            <li><a href="#"><spring:message code="homePage.menu.actions" /></a> 
                            </li>
                            <li><a href="/project-one-web/logIn"><spring:message code="homePage.menu.personalArea" /></a> 
                            </li>
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-language"></i><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li align="center"><b>
                                    	<a class="language-text-color" href="?language=en">
                                    		<spring:message code="application.language.en" />
                                    	EN</a></b> 
                                    </li>
                                    <li class="divider"></li>
                                    <li align="center"><b>
                                    	<a class="language-text-color" href="?language=ru">
                                    		<spring:message code="application.language.ru" />
                                    	RU</a></b> 
                                    </li>
                                    <li class="divider"></li>
                                    <li align="center"><b><a class="language-text-color" href="#">BLR</a></b> 
                                    </li>
                                </ul>
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
                                    <img class="full-screen" src="<c:url value="resources/otherViews/images/simple1.jpg"/>" alt="">
                                </div>
                                <div class="carousel-caption">
                                    <h3>Slide1</h3>
                                    <p>description1</p>
                                </div>
                            </div>
                            <div class="item" align="center">
                                <div class="full-screen">
                                    <img class="full-screen" src=<c:url value="resources/otherViews/images/simple.jpg"/> alt="">
                                </div>
                                <div class="carousel-caption">
                                    <h3>Slide2</h3>
                                    <p>description2</p>
                                </div>
                            </div>
                            <div class="item" align="center">
                                <div class="full-screen">
                                    <img class="full-screen" src=<c:url value="resources/otherViews/images/simple.jpg"/> alt="">
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
                <h4 align="center"><spring:message code="homePage.menu.footer" /></h4>
            </div>
        </div>
    



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=<c:url value="resources/otherViews/js/bootstrap.js"/>></script>
</body>

</html>

