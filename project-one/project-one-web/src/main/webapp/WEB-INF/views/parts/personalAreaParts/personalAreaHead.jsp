<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


    <meta name="description" content="Сайт для бесплатного обмена вещами">
    <meta name="keywords" content="Калиласка, Kalilaska">
    <meta http-equiv="content-type" content="text/html;" charset="utf-8">
    <meta name="_csrf" content="${_csrf.token}"/>	
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
    <title>ZABIRAI</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/forViews/css/bootstrap.css"/>"  rel="stylesheet">
    <link href="<c:url value="/resources/forViews/css/font-awesome.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/forViews/css/syle.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/forViews/css/columnLink.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/forViews/css/simple-sidebar.css"/>" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>    
    <script src="<c:url value="/resources/forViews/js/SearchAccounts.js"/>"></script>
    <script src="<c:url value="/resources/forViews/js/AccountsTable.js"/>"></script>
    <script src="<c:url value="/resources/forViews/js/WorkWithData.js"/>"></script>
    <script src="<c:url value="/resources/forViews/js/WorkWithElements.js"/>"></script>
    <script src="<c:url value="/resources/forViews/js/AccountsTableControlButtons.js"/>"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->