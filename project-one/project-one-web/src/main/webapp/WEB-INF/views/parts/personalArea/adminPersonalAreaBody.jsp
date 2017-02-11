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
                                <a id = "allAccounts" href="#allAccounts" onclick="workWithData.getAccountsData()">Пользователи</a>
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
                        
                            	<div id="personal-info" class="col-lg-12" style="display: ">
                            		<h3 align="center">Glad to see you, ${accountPageBean.accountLogin}!</h3>
                            	</div>
                                <div id="accounts" class="col-lg-12" style = "display: none;">
                                    <h2>Accounts</h2>                                    
                                    <div class="form-group input-group">
                                    	<div class="input-group-btn">
                                            <button id="menu-button-1" type="button" class="btn btn-default dropdown-toggle" 
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" 
                                            onclick="displaySearchOptions.DisplaySearchOptionOne()">By Login
                                                <span class="caret"></span>
                                            </button>
                                            <ul id="search-option-1" class="dropdown-menu">
                                                <li><a id = "search-by-login" href="#search-by-login" onclick="searcher.searchByLogin()">By Login</a> 
                                                </li>
                                                <li class="divider"></li>
                                                <li><a id = "search-by-email" href="#search-by-email" onclick="searcher.searchByEmail()">By Email</a>
                                                </li>
											<!--   <li class="divider"></li> -->
											<!--   <li><a id = "search-by-role" href="#search-by-role" onclick="searchByRole()">By Role</a> -->
											<!--   </li> -->
                                            </ul>

                                            <button id="menu-button-2" type="button" class="btn btn-default dropdown-toggle" 
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" 
                                            onclick="displaySearchOptions.DisplaySearchOptionTwo()">At first
                                                <span class="caret"></span>
                                            </button>
                                            <ul id="search-option-2" class="dropdown-menu">
                                                <li><a id = "search-at-first" href="#search-at-first" onclick="searcher.searchAtFirstLetters()">At First</a> 
                                                </li>
                                                <li class="divider"></li>
                                                <li><a id = "search-anywhere" href="#search-anywhere" onclick="searcher.searchAnywhere()">Anywhere</a>
                                                </li>
                                            </ul>
                                        </div>

                                        <input id = "search-accounts" type="text" class="form-control" onkeyup="workWithData.getSearchedData()">
                                        <span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i></button></span>
                                    </div>
                                    
                                    <div  id="accounts-table" class="table-responsive accounts-table-area">                                    
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                	<th>N</th>
                                                    <th>Id</th>
                                                    <th>Login</th>
                                                    <th>Email</th>
                                                    <th>Password</th>
                                                    <th>Role</th>
                                                </tr>
                                            </thead>                                            
                                            <tbody id="accounts-data">
                                               
                                            </tbody>                                            
                                        </table>
                                    </div>
									<!--  aria-label="..." -->
                                    <div class="btn-group btn-group-justified" role="group">
  										<div class="btn-group" role="group">
    										<button id="add-account" type="button" class="btn btn-default" aria-label="Add" disabled>Add</button>
  										</div>
  										<div class="btn-group" role="group">
    										<button id="update-account" type="button" class="btn btn-default" aria-label="Update" disabled>Update</button>
  										</div>
  										<div class="btn-group" role="group">
    										<button id="delete-account" type="button" class="btn btn-danger" aria-label="Delete" disabled>Delete</button>
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

