<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>

<head>
	<tiles:insertAttribute name="head"/>
</head>

<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="menuBar"/>
	<tiles:insertAttribute name="body"/>
	<tiles:insertAttribute name="footer"/>

</body>

</html>

