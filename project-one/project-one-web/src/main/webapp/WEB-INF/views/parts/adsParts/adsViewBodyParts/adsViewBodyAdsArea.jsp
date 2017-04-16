<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

        <div align="center" class="all-ads-area">
        	<c:set var="allAds" value="${adsPageBean.getAllAds()}"/>
        	<c:forEach items="${allAds }" var="ad">  
            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 one-ad-area">             
                <div class="one-ad-block">
                    <a id="ad-${ad.getAdId()}" class="one-ad-name" href="/project-one-web/ads/ad_${ad.getAdId()}.html">
                    	<div class="ads-page-ad-name-container">
                    		<p><font id="ads-page-ad-${ad.getAdId()}">${ad.getAdName()} </font>
                    		<security:authorize access="hasAnyAuthority('Administrator', 'Moderator')">
                    			<a id="disable-ad-${ad.getAdId()}" class="ads-page-disable-ad" href="#" data-toggle="modal" data-target="#ads-page-disable-ad-dialog" onclick="adsPageDisableAd.showDialog(this.id)"> <i class="fa fa-times" aria-hidden="true"></i> </a>
                    		</security:authorize>
                    		</p>
                    	</div>
                        <img class="one-ad-image" src="${pageContext.servletContext.contextPath}/resources/forViews/images/Dino.png" alt="">
<%--                         <img class="one-ad-image" src="<c:url value="resources/forViews/images/Dino.png"/>" alt=""> --%>
                    </a>
                    <font>${ad.getAdId()}</font>
<!--                     <a class="like-counter" href="#2"> -->
<!--                         <i class="fa fa-heart like fa-lg" aria-hidden="true"></i> 77 -->
<!--                     </a> -->
<!--                     <a class="comments-counter" href="#2"> -->
<!--                         <i class="fa fa-comment-o comments fa-lg" aria-hidden="true"></i> 55 -->
<!--                     </a> -->
                </div>
            </div>
            </c:forEach>
            
        </div>
        
        <div class="next-previous-buttons-area">
        
        <!-- Previous page -->
        	<c:if test="${adsPageBean.getPageNumber() eq 0 }">
        		<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12 next-previous-button"> <a class="button-name button-disabled" href="#"><font><spring:message code="adsPage.buttons.previousPage"/></font> </a> </div>
        	</c:if>
        	<c:if test="${adsPageBean.getPageNumber() gt 0 }">
        		<c:if test="${adsPageBean.getPageNumber()-1 eq 0}">
        			<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12 next-previous-button"> <a class="button-name" href="/project-one-web/ads.html"><font><spring:message code="adsPage.buttons.previousPage"/>(1)</font> </a> </div>
        		</c:if>
        		<c:if test="${adsPageBean.getPageNumber()-1 gt 0}">
        			<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12 next-previous-button"> <a class="button-name" href="/project-one-web/ads/page${adsPageBean.getPageNumber() - 1}.html"><font><spring:message code="adsPage.buttons.previousPage"/>(<c:out value="${adsPageBean.getPageNumber()}"/>)</font> </a> </div>
        		</c:if>
        	</c:if>
        	
        	 <!-- Next page -->
        	<c:if test="${adsPageBean.isLastPage() eq true }">
        		<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12 next-previous-button"> <a class="button-name button-disabled" href="#"><font><spring:message code="adsPage.buttons.nextPage"/></font> </a> </div>
        	</c:if>
        	
        	<c:if test="${adsPageBean.isLastPage() eq false }">
        		<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12 next-previous-button"> <a class="button-name" href="/project-one-web/ads/page${adsPageBean.getPageNumber() + 2}.html"><font><spring:message code="adsPage.buttons.nextPage"/>(<c:out value="${adsPageBean.getPageNumber()+2}"/>)</font> </a> </div>
        	</c:if>
            
            
        </div>