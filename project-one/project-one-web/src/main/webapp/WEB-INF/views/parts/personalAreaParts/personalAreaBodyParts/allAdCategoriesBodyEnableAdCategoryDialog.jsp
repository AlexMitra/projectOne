<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


    <div class="modal fade" id="enable-adCategory-dialog" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button id="enable-adCategory-dialog-close" type="button" class="close" data-dismiss="modal" aria-label="Close" ><span aria-hidden="true">&times;</span></button>
                    <h3 id="enable-adCategory-dialog-title" class="modal-title"><spring:message code="personalArea.adCategoriesTable.dialog.enable.header"/> </h3> </div>
                <div class="modal-body">
                	

                	<h4><spring:message code="personalArea.adCategoriesTable.dialog.enable.question"/></h4>
                    
                </div>
                
                <div class="modal-footer">
                    <button id="form-for-add-adCategory-close" type="button" class="btn btn-default" data-dismiss="modal" ><spring:message code="personalArea.adCategoriesTable.dialog.add.close"/></button>
                    <button type="button" name="enable" class="btn btn-primary" onclick="adCategoriesTableEnableButton.enableAdCategory()"><spring:message code="personalArea.adCategoriesTable.controlButtons.enable"/></button>
                </div>
            </div>
        </div>
    </div>
