<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

	
        <!-- Page Content -->
        <div class="container login-area">
 
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Этот сервис временно не доступен
                    	<small>by exception handler</small>
                    </h1>                    
                </div>
            </div>
            
            <div class="row"><div class="col-lg-12">
                    <p>Message:</p>
                    <h4>${exceptionMessage}</h4>
                </div> 
            </div>
        </div>
