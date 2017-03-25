<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

        <div align="center" class="all-ads-area">
        	<c:set var="allAds" value="${adsPageBean.getAllAds()}"/>
        	<c:forEach items="${allAds }" var="ad">  
            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 one-ad-area">             
                <div class="one-ad-block">
                    <a class="one-ad-name" href="#">
                    	<p>${ad.getAdName()}</p>
                        <img class="one-ad-image" src="<c:url value="resources/forViews/images/Dino.png"/>" alt="">
                    </a>
                    <font>${ad.getAdCreationDate()}</font>
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