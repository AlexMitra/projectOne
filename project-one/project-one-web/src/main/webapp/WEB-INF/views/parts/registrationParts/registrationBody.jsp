<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 registration-area">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="center"><a class="link-text-color" href="/project-one-web/personalArea/login.html"><spring:message code="registration.form.log.in"/></a></h3>
                        </div>
                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                            <h3 align="center" class="link-text-color"><spring:message code="registration.form.signUp"/></h3>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
                    </div>
                

                <div class="form-login-screen row">   

    				<form:form method="post" modelAttribute="accountPageBean" class="form-horizontal" enctype="utf8">                        
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><p class="label-text"><spring:message code="registration.form.login"/></p></label>
                            <div class="col-sm-9">
                            	<spring:message code="registration.form.login" var="registrationFormLogin"/>
                                <form:input type="text" class="form-control" id="inputLogin" path="accountLogin" placeholder="${registrationFormLogin}"/>
                            </div>
                            <div class="col-sm-offset-3 col-sm-9">
                                <form:errors type="text" class="error-text-color" path="accountLogin"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label"><p class="label-text"><spring:message code="registration.form.email"/></p></label>
                            <div class="col-sm-9">
                            	<spring:message code="registration.form.email" var="registrationFormEmail"/>
                                <form:input type="email" class="form-control" id="inputEmail" placeholder="${registrationFormEmail}" path="accountEmail"/>
                            </div>
                            <div class="col-sm-offset-3 col-sm-9">
                                <form:errors type="text" class="error-text-color" path="accountEmail"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label"><p class="label-text"><spring:message code="registration.form.password"/></p></label>
                            <div class="col-sm-9">
                            	<spring:message code="registration.form.password" var="registrationFormPassword"/>
                                <form:input type="password" class="form-control" id="inputPassword" placeholder="${registrationFormPassword}" path="accountPassword"/>
                            </div>
                            <div class="col-sm-offset-3 col-sm-9">
                                <form:errors type="text" class="error-text-color" path="accountPassword"/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><p class="label-text"><spring:message code="registration.form.passwordOnceMore"/></p></label>
                            <div class="col-sm-9">
                            	<spring:message code="registration.form.passwordOnceMore" var="registrationFormPasswordOnceMore"/>
                                <form:input type="password" class="form-control" id="inputPasswordOnceMore" placeholder="${registrationFormPasswordOnceMore}" path="accountPasswordOnceMore"/>
                            </div>
                            <div class="col-sm-offset-3 col-sm-9">
                            	<form:errors type="text" class="error-text-color" path="accountPasswordOnceMore"/>
                                <form:errors type="text" class="error-text-color"/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" name="registration" class="btn btn-default"><spring:message code="registration.form.createAccount"/></button>
                            </div>
                        </div>
                    </form:form>
                </div>
                
                
				</div>
            </div>
        </div>



