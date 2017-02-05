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
                                <a id = "allAccounts" href="#allAccounts">Пользователи</a>
<!--                                 <a id = "allAccounts" href="/project-one-web/personalArea/api/allAccounts">Пользователи</a> -->
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
                            	<div id="personal-info" class="col-lg-12" style="display: ">
                            		<h3 align="center">Glad to see you, ${accountPageBean.accountLogin}!</h3>
                            	</div>
                                <div id="accounts" class="col-lg-12" style = "display: none;">
                                    <h2>Accounts</h2>                                    
                                    <div class="form-group input-group">
                                    	<div class="input-group-btn">
                                            <button id="menu-button-1" type="button" class="btn btn-default dropdown-toggle" 
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" 
                                            onclick="displayMenuOne()">By Login
                                                <span class="caret"></span>
                                            </button>
                                            <ul id="menu-1" class="dropdown-menu">
                                                <li><a href="#">by login</a> 
                                                </li>
                                                <li class="divider"></li>
                                                <li><a href="#">by email</a>
                                                </li>
                                                <li class="divider"></li>
                                                <li><a href="#">by status</a>
                                                </li>
                                            </ul>

                                            <button id="menu-button-2" type="button" class="btn btn-default dropdown-toggle" 
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" 
                                            onclick="displayMenuTwo()">At first
                                                <span class="caret"></span>
                                            </button>
                                            <ul id="menu-2" class="dropdown-menu">
                                                <li><a href="#">at first</a> 
                                                </li>
                                                <li class="divider"></li>
                                                <li><a href="#">anywhere</a>
                                                </li>
                                            </ul>
                                        </div>

                                        <script>
                                        	menuOne = document.getElementById("menu-1");
                                        	menuTwo = document.getElementById("menu-2");
                                        	
                                            function displayMenuOne() {
                                                
                                                menuOne.removeAttribute("style");
                                                hideElement("menu-2");                                                
                                            }

                                            function displayMenuTwo() {
                                                
                                                menuTwo.removeAttribute("style");
                                                hideElement("menu-1");
                                            }                                           

                                        </script>
                                        <input type="text" class="form-control">
                                        <span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i></button></span>
                                    </div>
                                    
                                    <div  id="accounts-table" class="table-responsive accounts-table-area">                                    
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Login</th>
                                                    <th>Email</th>
                                                    <th>Password</th>
                                                    <th>Status</th>
                                                </tr>
                                            </thead>                                            
                                            <tbody id="accounts-data">
                                               
                                            </tbody>                                            
                                        </table>
                                    </div>
                                                                        
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

