<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

        <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="container">
                <div id="wrapper">
                    
                    <tiles:insertDefinition name="personalAreaInSideMenu" flush="true"/>
                    

                    <!-- Page Content -->
                    <div id="page-content-wrapper">
                        
                    	<div id="personal-info" class="col-lg-12" style="display: ">
                        	<h3 align="center"><spring:message code="personalArea.body.greetings"/>${accountPageBean.getAccountLogin()}!</h3>
                        </div>                            	

						<security:authorize access="hasAuthority('Administrator')">
						<tiles:insertDefinition name="allAccountsBodyTemplate" flush="true"/>						
                        </security:authorize>
                    
                    <!-- /#page-content-wrapper -->    
                    </div>                    

                <!-- /#wrapper -->
                </div>                
            </div>
        </div>
    </div>

