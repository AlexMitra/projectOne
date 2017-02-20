<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

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