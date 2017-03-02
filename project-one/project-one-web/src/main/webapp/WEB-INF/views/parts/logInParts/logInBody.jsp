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
                
                    <form name="f" action="<c:url value='/perform_login'/>" method="post" class="form-horizontal" >

                        	
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Логин</label>
                            <div class="col-sm-10">
                            	<input type="text" name="username" class="form-control" placeholder="Login"/>                                
                            </div>
<!--                             <div class="col-sm-10">                                -->
<%--                                 <font type="text" class="error-text-color">${accountPageBean.loginCheck}</font> --%>
<!--                             </div> -->
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">Пароль</label>
                            <div class="col-sm-10">                                
                                <input type="password" name="password" class="form-control" placeholder="Password"/>
                            </div>

                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-4">
                                <div class="checkbox">
                                    <label>
                                        <input id="remember" type="checkbox" name="remember-me" value="true">Запомнить меня
                                    </label>
                                </div>
                            </div>
                            
                            <c:if test="${badAuthentication eq true}">
                        		<div class="col-sm-6 error-text-color">                               
                               		<font type="text">Bad login or password</font>
                        		</div>
                        	</c:if>
                        </div>
                        
                        <!-- CSRF Protection -->
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">                                
                                <button type="submit" name="submit" class="btn btn-default">Войти</button>
                            </div>
                        </div>
                        
                        
							
						<c:if test="${logout != null}">
							<p>${logout}</p>
						</c:if>
                    </form>
                </div>

            </div>
        </div>

