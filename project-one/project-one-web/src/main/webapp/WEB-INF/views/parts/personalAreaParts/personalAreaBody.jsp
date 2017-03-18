<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

		<tiles:insertDefinition name="accountsTableAddAccountDialog" flush="true"/>

        <div class="row">
        	<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
            	<div class="sidebar">
                    
                    <tiles:insertDefinition name="personalAreaInSideMenu" flush="true"/>
                    
  				</div>                
            </div>
                    <!-- Page Content  -->
                    <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 personalArea-body-area" align="left" >
                        
                    	<div id="personal-info" class="col-lg-12 personalArea-body-element" style="display: ">
                        	<h3 align="center"><spring:message code="personalArea.body.greetings"/>${accountPageBean.getAccountLogin()}!</h3>
                        </div>                                                	

						<security:authorize access="hasAuthority('Administrator')">
						<tiles:insertDefinition name="allAccountsBodyTemplate" flush="true"/>						
                        </security:authorize>
                    
                    <!-- Page Content -->  
                    </div>                    

                
         </div>