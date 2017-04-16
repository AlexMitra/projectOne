<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">

		<security:authorize access="hasAnyAuthority('Administrator', 'Moderator')">			
			<tiles:insertDefinition name="adsViewBodyDisableAdDialog" flush="true"/>
		</security:authorize>

        <!-- Sidebar -->       
        <tiles:insertDefinition name="adsBodySidebar"/>

        <!-- Page Content -->
        <tiles:insertDefinition name="adsBodyAdsArea"/>              

</div>