<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

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

