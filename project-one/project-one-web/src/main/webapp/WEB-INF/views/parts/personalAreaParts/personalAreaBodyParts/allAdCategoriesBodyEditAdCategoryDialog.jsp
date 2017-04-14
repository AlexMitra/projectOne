<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


    <div class="modal fade" id="edit-adCategory-dialog" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button id="form-for-edit-adCategory-close" type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 id="edit-adCategory-dialog-title" class="modal-title"><spring:message code="personalArea.adCategoriesTable.dialog.edit.header"/></h4> </div>
                <div class="modal-body">
                	<div class="form-edit-adCategory-screen">

                	<form id="form-for-edit-adCategory" action="" method="post" class="form-horizontal" enctype="utf8">
                	                    
                        <div class="form-group">
                            <label class="control-label"><spring:message code="personalArea.adCategoriesTable.dialog.edit.name"/></label>
                            <input type="text" class="form-control" id="edit-adCategory-inputAdCategoryName" name="adCategoryName" value=""/>
                            
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label"><spring:message code="personalArea.adCategoriesTable.dialog.edit.i18n"/></label>
                            <input type="text" class="form-control" id="edit-adCategory-inputAdCategoryI18n" name="adCategoryI18n" value=""/>                            
                            
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label"><spring:message code="personalArea.adCategoriesTable.dialog.edit.description"/></label>
                            <textarea class="form-control" id="edit-adCategory-inputAdCategoryDescription" name="adCategoryDescription" rows="3"></textarea>
                            
                        </div><br>                      
                        

                        
                        <div id="form-for-edit-adCategory-valid-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.editAdCategory.form.NameOrI18n.notValid"/></font>
                        </div>
                        
                        <div id="form-for-edit-adCategory-alreadyExists-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.editAdCategory.form.NameOrI18nAlreadyExists"/></font>
                        </div>
                        
                    </form>
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button id="form-for-add-adCategory-close" type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="personalArea.adCategoriesTable.dialog.add.close"/></button>
                    <button type="submit" name="registration" class="btn btn-primary" onclick="adCategoriesTableEditButton.editAdCategory()"><spring:message code="personalArea.adCategoriesTable.dialog.edit.saveButton"/></button>
                </div>
            </div>
        </div>
    </div>
