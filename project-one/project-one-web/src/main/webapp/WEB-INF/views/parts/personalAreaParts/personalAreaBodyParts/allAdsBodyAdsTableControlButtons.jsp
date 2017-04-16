<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

                                    <!-- For Enabled -->
                                    <div  id="enabled-ads-control-buttons" class="btn-group btn-group-justified" role="group">
                                    	
                                    	<div class="btn-group" role="group">
    										<button id="unselect-all-ads-button" type="button" class="btn btn-default" aria-label="Unselect All" disabled onclick="WorkWithAdsTableElements.unselectAllCheckboxes()"><spring:message code="personalArea.adsTable.controlButtons.unselectAll"/></button>
  										</div>
  										
  										<div class="btn-group" role="group">
    										<button id="update-ad-button" type="button" class="btn btn-default" data-toggle="modal" data-target="#edit-ad-dialog" onclick="adsTableEditButton.showDialog()" disabled><spring:message code="personalArea.adsTable.controlButtons.edit"/></button>
  										</div>
  										<div class="btn-group" role="group">
    										<button id="disable-ad-button" type="button" class="btn btn-danger" data-toggle="modal" data-target="#disable-ad-dialog" onclick="adsTableDisableButton.showDialog()" disabled ><spring:message code="personalArea.adsTable.controlButtons.disable"/></button>
  										</div>  										
  										
									</div>
									
									<!-- For Disabled -->
									<div id="disabled-ads-control-buttons" class="btn-group btn-group-justified" role="group" style = "display: none;">
										
										<div class="btn-group" role="group">
    										<button id="enable-ad-button" type="button" class="btn btn-primary" data-toggle="modal" data-target="#enable-ad-dialog" onclick="adsTableEnableButton.showDialog()" disabled ><spring:message code="personalArea.adsTable.controlButtons.enable"/></button>
  										</div>
  										<security:authorize access="hasAuthority('Administrator')">
  										<div class="btn-group" role="group">
    										<button id="delete-ad-button" type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete-ad-dialog" onclick="adsTableDeleteButton.showDialog()" disabled ><spring:message code="personalArea.adsTable.controlButtons.delete"/></button>
  										</div>
  										</security:authorize>
									</div>