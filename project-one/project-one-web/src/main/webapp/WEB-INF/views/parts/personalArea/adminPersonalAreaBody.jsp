<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

        <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="container">
                <div id="wrapper">

                    <!-- Sidebar -->
                    <div id="sidebar-wrapper">
                        <ul class="sidebar-nav">
                            <li class="sidebar-brand">
                                <p class="personal-area-name">Личный кабинет(Admin)</p>
                            </li>
                            <li>
                                <a href="#">Сообщения</a>
                            </li>
                            <li>
                                <a href="/project-one-web/personalArea/api/users">Пользователи</a>
                            </li>
                            <li>
                                <a href="#">Объявления</a>
                            </li>
                            <li>
                                <a href="#">Мероприятия</a>
                            </li>
                            <li>
                                <a href="#">Выход</a>
                            </li>
                        </ul>
                    </div>
                    <!-- /#sidebar-wrapper -->

                    <!-- Page Content -->
                    <div id="page-content-wrapper">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-12">
                                <h3 align="center">Glad to see you, ${accountPageBean.accountLogin}!</h3>
                                
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /#page-content-wrapper -->

                </div>
                <!-- /#wrapper -->
            </div>
        </div>
    </div>

