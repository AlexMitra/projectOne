<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


    <div class="modal fade" id="add-adCategory-dialog" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title"><spring:message code="personalArea.adCategoriesTable.dialog.add.header"/></h4> </div>
                <div class="modal-body">
                	<div class="form-add-adCategory-screen">

                	<form id="form-for-add-adCategory" action="http://localhost:8080/project-one-web/personalArea/admin/api/ad_category/new" method="post" class="form-horizontal" enctype="utf8">
                	                    
                        <div class="form-group">
                            <label class="control-label"><spring:message code="personalArea.adCategoriesTable.dialog.add.name"/></label>
                            <input type="text" class="form-control" id="add-adCategory-inputAdCategoryName" name="adCategoryName"/>
                            
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label"><spring:message code="personalArea.adCategoriesTable.dialog.add.description"/></label>
                            <textarea class="form-control" id="add-adCategory-inputAdCategoryDescription" name="adCategoryDescription" rows="3"></textarea>                        
                            
                        </div>
                        
                        <div id="form-for-add-adCategory-valid-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.addAdCategory.form.NameOrDescription.notValid"/></font>
                        </div>
                        
                        <div id="form-for-add-adCategory-alreadyExists-message" class="error-text-color" style = "display: none;">                               
                            <font type="text"><spring:message code="error.addAdCategory.form.nameAlreadyExists"/></font>
                        </div>
                        
                    </form>
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button id="form-for-add-adCategory-close" type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="personalArea.adCategoriesTable.dialog.add.close"/></button>
                    <button type="submit" name="registration" class="btn btn-primary" onclick="adCategoriesTableAddButton.addAdCategory()"><spring:message code="personalArea.adCategoriesTable.dialog.add.create"/></button>
                </div>
            </div>
        </div>
    </div>
