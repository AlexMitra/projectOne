<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="center"><spring:message code="login.form.log.in" /></h3>
                        </div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="justify"><a class="link-text-color" href="/project-one-web/personalArea/registration.html"><spring:message code="login.form.signUp"/></a></h3>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                    </div>
                </div>

                <div class="form-login-screen">
                
                    <form name="f" action="<c:url value='/perform_login'/>" method="post" class="form-horizontal" >

                        	
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><spring:message code="login.form.login"/></label>
                            <div class="col-sm-10">
                            	<input type="text" name="username" class="form-control" placeholder="<spring:message code="login.form.login"/>"/>                                
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label"><spring:message code="login.form.password"/></label>
                            <div class="col-sm-10">                                
                                <input type="password" name="password" class="form-control" placeholder="<spring:message code="login.form.password"/>"/>
                            </div>

                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-4">
                                <div class="checkbox">
                                    <label>
                                        <input id="remember" type="checkbox" name="remember-me" value="true"><spring:message code="login.form.rememberMe"/>
                                    </label>
                                </div>
                            </div>
                            
                            <c:if test="${badAuthentication eq true}">
                        		<div class="col-sm-6 error-text-color">                               
                               		<font type="text"><spring:message code="login.form.badLoginOrPassword"/></font>
                        		</div>
                        	</c:if>
                        	<c:if test="${logOutSuccess eq true}">
                        		<div class="col-sm-6 success-text-color">                               
                               		<font type="text"><spring:message code="login.form.logOutSuccess"/></font>
                        		</div>
                        	</c:if>
                        </div>
                        
                        <!-- CSRF Protection -->
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">                                
                                <button type="submit" name="submit" class="btn btn-default"><spring:message code="login.form.log.in"/></button>
                            </div>
                        </div>
                        
                        
							
						<c:if test="${logout != null}">
							<p>${logout}</p>
						</c:if>
                    </form>
                </div>

            </div>
        </div>

