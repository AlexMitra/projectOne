<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

                                    <!-- For Enabled -->
                                    <div  id="enabled-adCategories-control-buttons" class="btn-group btn-group-justified" role="group">
                                    	
                                    	<div class="btn-group" role="group">
    										<button id="unselect-all-adCategories-button" type="button" class="btn btn-default" aria-label="Unselect All" disabled onclick="WorkWithAdCategoriesTableElements.unselectAllCheckboxes()"><spring:message code="personalArea.adCategoriesTable.controlButtons.unselectAll"/></button>
  										</div>
  										<div class="btn-group" role="group">
    										<button id="add-adCategory-button" type="button" class="btn btn-default" data-toggle="modal" data-target="#add-adCategory-dialog" onclick="adCategoriesTableAddButton.showDialog()"><spring:message code="personalArea.adCategoriesTable.controlButtons.add"/></button>
  										</div>
  										<div class="btn-group" role="group">
    										<button id="update-adCategory-button" type="button" class="btn btn-default" data-toggle="modal" data-target="#edit-adCategory-dialog" onclick="adCategoriesTableEditButton.showDialog()" disabled><spring:message code="personalArea.adCategoriesTable.controlButtons.edit"/></button>
  										</div>
  										<div class="btn-group" role="group">
    										<button id="disable-adCategory-button" type="button" class="btn btn-danger" data-toggle="modal" data-target="#disable-adCategory-dialog" onclick="adCategoriesTableDisableButton.showDialog()" disabled ><spring:message code="personalArea.adCategoriesTable.controlButtons.disable"/></button>
  										</div>  										
  										
									</div>
									
									<!-- For Disabled -->
									<div id="disabled-adCategories-control-buttons" class="btn-group btn-group-justified" role="group" style = "display: none;">
										
										<div class="btn-group" role="group">
    										<button id="enable-adCategory-button" type="button" class="btn btn-primary" data-toggle="modal" data-target="#enable-adCategory-dialog" onclick="adCategoriesTableEnableButton.showDialog()" disabled ><spring:message code="personalArea.adCategoriesTable.controlButtons.enable"/></button>
  										</div>
  										<security:authorize access="hasAuthority('Administrator')">
  										<div class="btn-group" role="group">
    										<button id="delete-adCategory-button" type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete-adCategory-dialog" onclick="adCategoriesTableDeleteButton.showDialog()" disabled ><spring:message code="personalArea.adCategoriesTable.controlButtons.delete"/></button>
  										</div>
  										</security:authorize>
									</div>