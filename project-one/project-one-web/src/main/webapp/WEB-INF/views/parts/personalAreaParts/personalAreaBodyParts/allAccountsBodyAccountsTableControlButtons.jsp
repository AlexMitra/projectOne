<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>   

                                    <div class="btn-group btn-group-justified" role="group">
                                    	<div class="btn-group" role="group">
    										<button id="unselect-all-account-button" type="button" class="btn btn-default" aria-label="Unselect All" disabled onclick="workWithElements.unselectAllCheckboxes()">Unselect All</button>
  										</div>
  										<div class="btn-group" role="group">
    										<button id="add-account-button" type="button" class="btn btn-default" aria-label="Add">Add</button>
  										</div>
  										<div class="btn-group" role="group">
    										<button id="update-account-button" type="button" class="btn btn-default" aria-label="Edit" disabled>Edit</button>
  										</div>
  										<div class="btn-group" role="group">
    										<button id="delete-account-button" type="button" class="btn btn-danger" aria-label="Delete" disabled>Delete</button>
  										</div>
									</div>