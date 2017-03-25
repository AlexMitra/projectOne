<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="col-lg-3 col-md-3 col-xs-3">
	<div class="sidebar">
                <ul class="sidebar-nav">
                    <li class="sidebar-brand">
                        <p class="categories-list">Categories</p>
                    </li>
                    <c:set var="allCategories" value="${adsPageBean.getAllAdCategories()}"/>
                    <c:forEach items="${allCategories}" var="category">

                    	<li>
                        	<span>
                            	<label class="category-type" >
                            		<input type="checkbox" id="checkbox-category-${category.getAdCategoryId()}"> <spring:message code="${category.getAdCategoryI18n()}"/>
                                	
                                </label>
                            </span>
                        </li>

                    </c:forEach>
<!--                     <li> -->
<!--                         <span> -->
<!--                             <label class="category-type" > -->
<!--                                 <input type="checkbox" value=""> Category 1 -->
<!--                             </label> -->
<!--                         </span> -->
<!--                     </li> -->
<!--                     <li> -->
<!--                         <span> -->
<!--                             <label class="category-type" > -->
<!--                                 <input type="checkbox" value=""> Category 2 -->
<!--                             </label>     -->
<!--                         </span> -->
<!--                     </li>                     -->
                </ul>


	</div>
</div>