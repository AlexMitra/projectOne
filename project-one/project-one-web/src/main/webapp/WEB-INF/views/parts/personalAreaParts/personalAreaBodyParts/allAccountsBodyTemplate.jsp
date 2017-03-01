<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

                                <div id="accounts" class="col-lg-12" style = "display: none;">
                                    <h2>Accounts</h2>
                                    
                                    <tiles:insertAttribute name="searchPanel"/>

									<tiles:insertAttribute name="rolesButton"/>

									<tiles:insertAttribute name="accountsTable"/>
                                    
									<tiles:insertAttribute name="accountsTableControlButtons"/>

                                                                        
                                </div>
