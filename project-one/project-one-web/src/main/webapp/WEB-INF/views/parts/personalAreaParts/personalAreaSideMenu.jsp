<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


                    <!-- Sidebar -->
                    <div id="sidebar-wrapper">
                        <ul class="sidebar-nav">
                            <li class="sidebar-brand">
                                <p class="personal-area-name">Личный кабинет(${accountPageBean.getUsername()})</p>
                            </li>
                            <li>
                                <a href="#">Сообщения</a>
                            </li>
                            
                            <security:authorize access="hasAuthority('Administrator')">
                            <li>
                                <a id = "allAccounts" href="#allAccounts" onclick="workWithData.getAccountsData()">Пользователи</a>
                            </li>
                            </security:authorize>
                            
                            <li>
                                <a href="#">Объявления</a>
                            </li>
                            <li>
                                <a href="#">Мероприятия</a>
                            </li>
                            <li>                                
                                <c:url var="logoutUrl" value="/personalArea/logout.html"/>
                                <form id="my-logout-form" action="${logoutUrl}" method="post">
                                
                                	<a href="#" onclick="document.getElementById('my-logout-form').submit();">Выход</a>
                                	<input type="hidden" 
                                		name="${_csrf.parameterName}" 
                                		value="${_csrf.token}"/>
                                </form>
                            </li>
                        </ul>									
				
					<!-- /#sidebar-wrapper -->	
                    </div>
                    

