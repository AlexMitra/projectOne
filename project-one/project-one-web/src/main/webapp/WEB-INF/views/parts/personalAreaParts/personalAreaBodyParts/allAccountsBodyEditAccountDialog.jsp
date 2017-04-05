<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


    <div class="modal fade" id="edit-account-dialog" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 id="edit-account-dialog-title" class="modal-title"><spring:message code="personalArea.accountsTable.controlButtons.edit.header"/></h4> </div>
                <div class="modal-body">
                	<div class="form-edit-account-screen">

                	<form id="form-for-edit-account" action="" method="post" class="form-horizontal" enctype="utf8">
                	                    
                        <div class="form-group">
                            <label class="control-label"><spring:message code="registration.form.login"/></label>
                            <input type="text" class="form-control" id="edit-account-inputLogin" name="accountLogin" value=""/>
                            
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label"><spring:message code="registration.form.email"/></label>
                            <input type="email" class="form-control" id="edit-account-inputEmail" name="accountEmail" value=""/>                            
                            
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label"><spring:message code="registration.form.password"/></label>
                            <input type="password" class="form-control" id="edit-account-inputPassword" name="accountPassword"/>
                            
                        </div><br>                      
                        
                        <div class="form-group">                        
                        <div class="dropdown">
  							<button class="btn btn-default dropdown-toggle" type="button" id="edit-account-rolesList" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    						<spring:message code="personalArea.accountsTable.controlButtons.edit.roles.input"/>
    							<span class="caret"></span>
  							</button>
  							
  							<c:set var="allRoles" value="${accountPageBean.getAllAuthorities()}"/>
  							
  							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
  								<c:forEach items="${allRoles}" var="role">
    							<li><a id="li-${role.getRoleStatus()}" href="#" onclick="accountsTableEditButton.addRoleToList(this.id)"><c:out value="${role.getRoleStatus()}"/></a></li>    							
    							</c:forEach>
  							</ul>
						</div><br>
						
						<div id="edit-account-form-role-list"><font class="role-list-marker">Test <a href="#" onclick=""><i class="fa fa-times" aria-hidden="true"></i></a></font></div>
						</div>
                        
                        <div id="form-for-edit-account-loginEmail-valid-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.editAccount.form.loginEmail.notValid"/></font>
                        </div>
                        
                        <div id="form-for-edit-account-pass-valid-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.editAccount.form.password.notValid"/></font>
                        </div>
                        
                        <div id="form-for-edit-account-alreadyExists-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.registration.form.loginOrEmailAlreadyExists"/></font>
                        </div>
                        
                        <div id="form-for-edit-account-InternalServerError-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.editAccount.form.InternalServerError"/></font>
                        </div>
                        
                    </form>
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button id="form-for-edit-account-close" type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="personalArea.accountsTable.controlButtons.add.close"/></button>
                    <button type="submit" name="registration" class="btn btn-primary" onclick="accountsTableEditButton.rolesValidationBefore()"><spring:message code="personalArea.accountsTable.controlButtons.edit.saveButton"/></button>
                </div>
            </div>
        </div>
    </div>
