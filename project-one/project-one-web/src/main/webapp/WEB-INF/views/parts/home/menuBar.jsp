<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

    

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
                            <li><a href="/project-one-web/personalArea"><spring:message code="homePage.menu.personalArea" /></a> 
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
                                    <li align="center"><b>
                                    	<a class="language-text-color" href="?language=be">
                                    		<spring:message code="application.language.be" />
                                    	BLR</a></b> 
                                    </li>
                                </ul>
                            </li> 
                        </ul>          

                    </div>
                </div>
            </div>
        </div>
        

