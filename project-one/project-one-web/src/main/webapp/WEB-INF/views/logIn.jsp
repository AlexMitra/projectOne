<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="description" content="Сайт для бесплатного обмена вещами">
    <meta name="keywords" content="Калиласка, Kalilaska">
    <meta http-equiv="content-type" content="text/html;" charset="utf-8">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>KALILASKA</title>

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

    <div class="container">
        <div class="row" align="center">
            <h1>KALILASKA</h1>
        </div>
        <div class="row">
            <div class="navbar navbar-inverse">
                <div class="container">
                    <div class="navbar-header">
                        <p><a class="navbar-brand" href="/project-one-web/home">K<i class="fa fa-heart-o"></i></a>
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
                            <li><a href="/project-one-web/logIn">Личный кабинет</a> 
                            </li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="center">Вход</h3>
                        </div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="center"><a class="link-text-color" href="/project-one-web/registration">Регистрация</a></h3>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                    </div>
                </div>

                <div class="form-login-screen">
                    <form class="form-horizontal">

                        <div class="form-group">
                            <label for="exampleInputName2" class="col-sm-2 control-label">Логин</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="exampleInputName2" placeholder="Login">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Пароль</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox">Запомнить меня
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Войти</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
        <div class="navbar navbar-fixed-bottom">
            <div class="row">
                <br>
                <h4 align="center">Сделано в Беларуси</h4>
            </div>
        </div>
    </div>



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=<c:url value="resources/otherViews/js/bootstrap.js"/>></script>
</body>


</html>

