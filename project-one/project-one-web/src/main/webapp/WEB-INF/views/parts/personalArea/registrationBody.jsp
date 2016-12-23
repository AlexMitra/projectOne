<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="center"><a class="link-text-color" href="/project-one-web/personalArea">Вход</a></h3>
                        </div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="center">Регистрация</h3>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                    </div>
                </div>

                <div class="form-login-screen">   

    				<form:form method="post" modelAttribute="account" class="form-horizontal" >                        
                        
                        <div class="form-group">
                            <label for="inputLogin" class="col-sm-2 control-label">Логин</label>
                            <div class="col-sm-10">
                                <form:input type="text" class="form-control" id="inputLogin" placeholder="Login" path="accountLogin"/>
                            </div>
                            <div class="col-sm-10">
                                <form:errors type="text" class="error-text-color" path="accountLogin"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputEmail" class="col-sm-2 control-label">Почта</label>
                            <div class="col-sm-10">
                                <form:input type="email" class="form-control" id="inputEmail" placeholder="Email" path="accountEmail"/>
                            </div>
                            <div class="col-sm-10">
                                <form:errors type="text" class="error-text-color" path="accountEmail"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword" class="col-sm-2 control-label">Пароль</label>
                            <div class="col-sm-10">
                                <form:input type="password" class="form-control" id="inputPassword" placeholder="Password" path="accountPassword"/>
                            </div>
                            <div class="col-sm-10">
                                <form:errors type="text" class="error-text-color" path="accountPassword"/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" name="registration" class="btn btn-default">Зарегистрироваться</button>
                            </div>
                        </div>
                    </form:form>
                </div>

            </div>
        </div>



