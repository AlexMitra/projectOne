<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

                                    <div id="select-roles">
                                		<a class="btn btn-primary-my" role="button" data-toggle="collapse" href="#role-variants" aria-expanded="false">
                                    		Roles
                                		</a>

                                		<div class="collapse" id="role-variants">
                                    		<div class="well">
                                        		<div id="role-checkboxes" class="row">

                                        			<c:set var="allRoles" value="${accountPageBean.getAllRoles()}"/>
                                        			<c:forEach items="${allRoles}" var="role">
                                        				<div class="col-lg-4 col-md-4 col-sm-4">
                                                			<div class="checkbox">
                                                    			<label>
                                                        			<input type="checkbox" id="checkbox-${role}" onclick="if(this.checked){searchOptions.addRole(this.id)} else {searchOptions.removeRole(this.id)}"><c:out value="${role}"/>
                                                    			</label>
                                                			</div>
                                            			</div>
                                        			</c:forEach>
                                        			
                                        		</div>
                                    		</div>
                                		</div>
                            		</div>