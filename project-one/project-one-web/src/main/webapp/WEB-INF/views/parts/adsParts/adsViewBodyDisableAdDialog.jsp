<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


    <div class="modal fade" id="ads-page-disable-ad-dialog" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            	
                <div class="modal-header">
                    <button id="ads-page-disable-ad-dialog-close" type="button" class="close" data-dismiss="modal" aria-label="Close" ><span aria-hidden="true">&times;</span></button>
                    <h3 id="ads-page-disable-ad-dialog-title" class="modal-title"><spring:message code="personalArea.adsTable.dialog.disable.header"/> </h3> </div>
                <div class="modal-body">
                	

                	<h4><spring:message code="personalArea.adsTable.dialog.disable.question"/></h4>
                    
                </div>
                
                <div class="modal-footer">
                    <button id="ads-page-disable-ad-dialog-close2" type="button" class="btn btn-default" data-dismiss="modal" ><spring:message code="personalArea.adsTable.dialog.disable.close"/></button>
                    <button type="button" name="disable" class="btn btn-danger" onclick="adsPageDisableAd.disableAd()"><spring:message code="personalArea.adCategoriesTable.controlButtons.disable"/></button>
                </div>
            </div>
        </div>
    </div>
