<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="col-lg-3 col-md-3 col-xs-3">
	<div class="sidebar">
	<form name="input" action="http://localhost:8080/project-one-web/ads.html" method="get">
                <ul class="sidebar-nav">
                    <li class="sidebar-brand">
                        <p class="categories-list">Categories</p>
                    </li>
                    
                    <c:set var="allCategories" value="${adsPageBean.getAllAdCategories()}"/>                    
                    <c:forEach items="${allCategories}" var="category">

                    	<li>
                        	<span>
                            	<label class="category-type" >
                            		
                            		<c:if test="${adsPageBean.isCategorySelected(category.getAdCategoryId()) eq true}">
                            			<input type="checkbox" id="checkbox-category-${category.getAdCategoryId()}" name="category-${category.getAdCategoryId()}" value="${category.getAdCategoryId()}" onclick="if(this.checked){AdsCategories.addCheckboxToList(this.id)} else {AdsCategories.removeCheckboxFromList(this.id)}" checked="checked"> <spring:message code="${category.getAdCategoryI18n()}" text="${category.getAdCategoryName()}"/>
                            			<c:set var="testvar" value="${category.getAdCategoryId()}"/>
                            			<script>
    										var id = '${testvar}';
    										AdsCategories.addCheckboxToList("checkbox-category-" + id);
    										document.getElementById("adsPage-categoriesForm-selected").checked = true;
										</script>
                            		</c:if>
                            		<c:if test="${adsPageBean.isCategorySelected(category.getAdCategoryId()) eq false}">
                            			<input type="checkbox" id="checkbox-category-${category.getAdCategoryId()}" name="category-${category.getAdCategoryId()}" value="${category.getAdCategoryId()}" onclick="if(this.checked){AdsCategories.addCheckboxToList(this.id)} else {AdsCategories.removeCheckboxFromList(this.id)}"> <spring:message code="${category.getAdCategoryI18n()}"  text="${category.getAdCategoryName()}"/>
                            		</c:if>
                            		
								<%-- <input type="checkbox" id="checkbox-category-${category.getAdCategoryId()}" value="category" name="${category.getAdCategoryId()}" onclick="if(this.checked){AdsCategories.addCategoryToList(this.id)} else {AdsCategories.removeCategoryFromList(this.id)}"> <spring:message code="${category.getAdCategoryI18n()}"/> --%>
                                </label>
                            </span>
                        </li>

                    </c:forEach>
                    
					
                </ul>
                <input type="checkbox" id="adsPage-categoriesForm-selected" name="selected" value="true" hidden="true">
                <input type="checkbox" id="adsPage-categoriesForm-clear" name="clearForm" value="false" hidden="true"> 
                <input id="adsPage-categoriesForm-submit" type="submit" value="Submit" hidden="true">
	</form>

	</div>
</div>