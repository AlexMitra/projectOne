<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

    <div class="row ad-page-area">
        <!-- PATH -->
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ad-page-ad-area"> <font class="ad-path"><a class="ad-path-link" href="/project-one-web/ads/page${adsPageBean.getPageNumber()}.html"><spring:message code="adPage.backToAdsPage.link.name"/>(${adsPageBean.getPageNumber()+1})</a> <i class="glyphicon glyphicon-menu-right"></i> ${adPageBean.getAdName()}</font> </div>
        <!-- AD IMAGE -->
        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 ad-page-ad-area">
            <div class="ad-page-image-area"> <img class="ad-page-image" src="${pageContext.servletContext.contextPath}/resources/forViews/images/Dino.png" alt=""> <font class="ad-date-creation"><spring:message code="adPage.creationDate"/>: ${adPageBean.getFormatDate()}</font></div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 ad-page-ad-area">
            <h3>${adPageBean.getAdName()}</h3>
            <p>${adPageBean.getAdDescription()}</p>
        </div>
    </div>