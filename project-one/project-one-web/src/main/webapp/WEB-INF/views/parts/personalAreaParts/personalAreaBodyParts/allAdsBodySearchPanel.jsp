<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

                                    <div class="form-group input-group">
                                    	<div class="input-group-btn">
                                            <button id="search-ads-menu-button-1" type="button" class="btn btn-default dropdown-toggle" 
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" 
                                            onclick="displayAdsSearchOptions.DisplaySearchOptionOne()">By Name
                                                <span class="caret"></span>
                                            </button>
                                            <ul id="search-ads-option-1" class="dropdown-menu">
                                                <li><a id = "search-ads-by-name" href="#search-ads-by-name" onclick="adsSearcher.searchByName()">By Name</a> 
                                                </li>
                                                <li class="divider"></li>
                                                <li><a id = "search-ads-by-author" href="#search-ads-by-author" onclick="adsSearcher.searchByAuthor()">By Author</a>
                                                </li>											
                                            </ul>

                                            <button id="search-ads-menu-button-2" type="button" class="btn btn-default dropdown-toggle" 
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" 
                                            onclick="displayAdsSearchOptions.DisplaySearchOptionTwo()">At first
                                                <span class="caret"></span>
                                            </button>
                                            <ul id="search-ads-option-2" class="dropdown-menu">
                                                <li><a id = "search-ads-at-first" href="#search-ads-at-first" onclick="adsSearcher.searchAtFirstLetters()">At First</a> 
                                                </li>
                                                <li class="divider"></li>
                                                <li><a id = "search-ads-anywhere" href="#search-ads-anywhere" onclick="adsSearcher.searchAnywhere()">Anywhere</a>
                                                </li>
                                            </ul>
                                        </div>

                                        <input id = "search-ads" type="text" class="form-control" onkeyup="workWithData.getSearchedAdsData()">
                                        <span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i></button></span>
                                    </div>