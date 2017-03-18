<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


    <div class="modal fade" id="add-account-button" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title"><spring:message code="personalArea.accountsTable.controlButtons.add.header"/></h4> </div>
                <div class="modal-body">
                	<div class="form-add-account-screen">

                	<form id="form-for-add-account" action="http://localhost:8080/project-one-web/personalArea/admin/api/account/new" method="post" class="form-horizontal" enctype="utf8">
                	                    
                        <div class="form-group">
                            <label class="control-label"><spring:message code="registration.form.login"/></label>
                            <input type="text" class="form-control" id="add-account-inputLogin" name="accountLogin"/>
                            <div class="col-sm-offset-3 col-sm-9">
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label"><spring:message code="registration.form.email"/></label>
                            <input type="email" class="form-control" id="add-account-inputEmail" name="accountEmail"/>                            
                            <div class="col-sm-offset-3 col-sm-9">
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label"><spring:message code="registration.form.password"/></label>
                            <input type="password" class="form-control" id="add-account-inputPassword" name="accountPassword"/>
                            <div class="col-sm-offset-3 col-sm-9">
                            </div>
                        </div>
                        
                        <div id="form-for-add-account-valid-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.addAccount.form.LoginPasswordEmail.notValid"/></font>
                        </div>
                        
                        <div id="form-for-add-account-alreadyExists-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.registration.form.loginOrEmailAlreadyExists"/></font>
                        </div>
                        
                    </form>
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button id="form-for-add-account-close" type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="personalArea.accountsTable.controlButtons.add.close"/></button>
                    <button type="submit" name="registration" class="btn btn-primary" onclick="accountsTableAddButton.addAccount()"><spring:message code="registration.form.createAccount"/></button>
                </div>
            </div>
        </div>
    </div>
