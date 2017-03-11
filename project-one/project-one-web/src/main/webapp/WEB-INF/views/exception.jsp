<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>

<head>
	<tiles:insertAttribute name="head"/>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="menuBar"/>
	
        <!-- Page Content -->
        <div class="container">
 
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Упс</h1>
                    <ol class="breadcrumb">                        
                        <li class="active">Exception Handler</li>
                    </ol>
                </div>
            </div>
            <!-- /.row -->
 
            <!-- Content Row -->
            <div class="row">
 
                <div class="col-lg-12">
                    <p>Message:</p>
                    <b>${exceptionMsg}</b>
                </div>
 
            </div>
            <!-- /.row -->
 
            <hr>
 
        </div>
        <!-- /.container -->
	<tiles:insertAttribute name="footer"/>
</body>

</html>