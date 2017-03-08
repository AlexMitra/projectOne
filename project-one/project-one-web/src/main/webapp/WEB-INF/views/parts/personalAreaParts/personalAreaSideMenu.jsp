<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


                        <ul class="sidebar-nav">
                            <li class="sidebar-brand">
                                <p class="personal-area-name"><spring:message code="personalArea.sideMenu.personalArea"/>(${accountPageBean.getUsername()})</p>
                            </li>
                            <li>
                                <a href="#"><spring:message code="personalArea.sideMenu.myMessages" /></a>
                            </li>
                            
                            <security:authorize access="hasAuthority('Administrator')">
                            <li>
                                <a href="#"><spring:message code="personalArea.sideMenu.messages"/></a>
                            </li>
                            </security:authorize>
                            
                            <security:authorize access="hasAuthority('Administrator')">
                            <li>
                                <a id = "allAccounts" href="#allAccounts" onclick="workWithData.getAccountsData()"><spring:message code="personalArea.sideMenu.allAccounts"/></a>
                            </li>
                            </security:authorize>
                            
                            <li>
                                <a href="#"><spring:message code="personalArea.sideMenu.myAds"/></a>
                            </li>
                            
                            <security:authorize access="hasAuthority('Administrator')">
                            <li>
                                <a href="#"><spring:message code="personalArea.sideMenu.allAds"/></a>
                            </li>
                            </security:authorize>
                            
                            <li>
                                <a href="#"><spring:message code="personalArea.sideMenu.myActions"/></a>
                            </li>
                            
                            <security:authorize access="hasAuthority('Administrator')">
                            <li>
                                <a href="#"><spring:message code="personalArea.sideMenu.allActions"/></a>
                            </li>
                            </security:authorize>
                            
                            <li>                                
                                <c:url var="logoutUrl" value="/personalArea/logout.html"/>
                                <form id="my-logout-form" action="${logoutUrl}" method="post">
                                
                                	<a href="#" onclick="document.getElementById('my-logout-form').submit();"><spring:message code="personalArea.sideMenu.logOut"/></a>
                                	<input type="hidden" 
                                		name="${_csrf.parameterName}" 
                                		value="${_csrf.token}"/>
                                </form>
                            </li>
                        </ul>									
				

                    

