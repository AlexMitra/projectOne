<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="center">Вход</h3>
                        </div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="center"><a class="link-text-color" href="/project-one-web/personalArea/registration.html">Регистрация</a></h3>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                    </div>
                </div>

                <div class="form-login-screen">
                
                    <form:form action="${loginUrl}" modelAttribute="accountPageBean" method="post" class="form-horizontal" >

                        	<c:if test="${param.error != null}">
								<p>
									Invalid username and password.
								</p>
							</c:if>
								<c:if test="${param.logout != null}">
								<p>
									You have been logged out.
								</p>
							</c:if>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Логин</label>
                            <div class="col-sm-10">
                            	<form:input type="text" class="form-control" id="inputLogin" placeholder="Login" path="accountLogin"/>                                
                            </div>
<!--                             <div class="col-sm-10">                                -->
<%--                                 <font type="text" class="error-text-color">${accountPageBean.loginCheck}</font> --%>
<!--                             </div> -->
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">Пароль</label>
                            <div class="col-sm-10">                                
                                <form:input type="password" class="form-control" id="inputPassword" placeholder="Password" path="accountPassword"/>
                            </div>
<!--                             <div class="col-sm-10">                                -->
<%--                                 <font type="text" class="error-text-color">${accountPageBean.passwordCheck}</font> --%>
<!--                             </div> -->
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
                        
                        <!-- CSRF Protection -->
<!--                         <input type="hidden" -->
<%-- 							name="${_csrf.parameterName}" --%>
<%-- 							value="${_csrf.token}"/> --%>
		
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">                                
                                <button type="submit" name="logIn" class="btn btn-default">Войти</button>
                            </div>
                        </div>
                    </form:form>
                </div>

            </div>
        </div>

