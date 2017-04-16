<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="container">
                    <div id="carousel" class="carousel slide">
                        <!--Индикаторы слайдов-->
                        <c:set var="ads" value="${homePagebean.getAds()}"/>
                        <c:set var="classFlag" value="${false}"/>
                        <font id="first-ad-id" hidden=''>${homePagebean.getFirstAdId()}</font>
        				
                        <ol class="carousel-indicators">
                        	<c:if test="${ads ne null and ads.size() gt 0}">
                        		<c:forEach items="${ads }" var="ad">
									<c:if test="${classFlag eq false}">
        								<li class="active" data-target="#carousel" data-slide-to="${homePagebean.getNextSlide()}"></li>
        								<c:set var="classFlag" value="${true}"/>
        							</c:if>
        							<c:if test="${classFlag eq true}">
        								<li data-target="#carousel" data-slide-to="${homePagebean.getNextSlide()}"></li>
        							</c:if>
        						</c:forEach>
        					</c:if>
        					
        					<c:if test="${ads eq null or ads.size() eq 0}">
        						<li class="active" data-target="#carousel" data-slide-to="0"></li>
        					</c:if>
<!--                             <li class="active" data-target="#carousel" data-slide-to="0"></li> -->
<!--                             <li data-target="#carousel" data-slide-to="1"></li> -->
<!--                             <li data-target="#carousel" data-slide-to="2"></li> -->
                        </ol>

                        <!--Слайды-->
                        
                        <div class="carousel-inner">
                        <c:set var="classFlag" value="${false}"/>
                        	<c:if test="${ads ne null and ads.size() gt 0}">
                        		<c:forEach items="${ads}" var="ad">
                        			<c:if test="${classFlag eq false}">
                        				<div class="item active" align="center">
        							
                                			<div class="full-screen">
                                    			<img class="full-screen" src="<c:url value="resources/forViews/images/simple.jpg"/>" alt="">
                                			</div>
                                			<div class="carousel-caption">
                                    			<h3>${ad.getAdName()}</h3>
                                    			<p>${ad.getAdDescription()}</p>
                                			</div>
                            			</div>
                            			<c:set var="classFlag" value="${true}"/>
                        			</c:if>
                        			<c:if test="${classFlag eq true}">
                        				<div class="item" align="center">
        							
                                			<div class="full-screen">
                                    			<img class="full-screen" src="<c:url value="resources/forViews/images/simple.jpg"/>" alt="">
                                			</div>
                                			<div class="carousel-caption">
                                    			<h3>${ad.getAdName()}</h3>
                                    			<p>${ad.getAdDescription()}</p>
                                			</div>
                            			</div>
                        			</c:if>
        							
        						</c:forEach>

        					</c:if>
        					
        					<c:if test="${ads eq null or ads.size() eq 0}">
        						<div class="item active" align="center">
                                	<div class="full-screen">
                                    	<img class="full-screen" src="<c:url value="resources/forViews/images/simple1.jpg"/>" alt="">
                                	</div>
                                	<div class="carousel-caption">
                                    	<h3>You did not have ads</h3>
                                    	<p>[ ]--(-_-)--[ ]</p>
                                	</div>
                            	</div>
        					</c:if>
        					
        					
<!--                             <div class="item active" align="center"> -->
<!--                                 <div class="full-screen"> -->
<%--                                     <img class="full-screen" src="<c:url value="resources/forViews/images/Dino.png"/>" alt=""> --%>
<!--                                 </div> -->
<!--                                 <div class="carousel-caption"> -->
<%--                                     <h3>${homePagebean.getAds().get(0).getAdName()}</h3> --%>
<%--                                     <p>${homePagebean.getAds().get(0).getAdDescription()}</p> --%>
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <div class="item" align="center"> -->
<!--                                 <div class="full-screen"> -->
<!--                                     <img class="full-screen" src=<c:url value="resources/forViews/images/simple.jpg"/> alt=""> -->
<!--                                 </div> -->
<!--                                 <div class="carousel-caption"> -->
<%--                                     <h3>${homePagebean.getAds().get(1).getAdName()}</h3> --%>
<%--                                     <p>${homePagebean.getAds().get(1).getAdDescription()}</p> --%>
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <div class="item" align="center"> -->
<!--                                 <div class="full-screen"> -->
<!--                                     <img class="full-screen" src=<c:url value="resources/forViews/images/simple.jpg"/> alt=""> -->
<!--                                 </div> -->
<!--                                 <div class="carousel-caption"> -->
<%--                                     <h3>${homePagebean.getAds().get(2).getAdName()}</h3> --%>
<%--                                     <p>${homePagebean.getAds().get(2).getAdDescription()}</p> --%>
<!--                                 </div> -->
<!--                             </div> -->

                        </div>

                        <!--Стрелки переключения слайдов-->
                        <a href="#carousel" class="left carousel-control" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span> 
                        </a>
                        <a id="home-page-next-slide" href="#carousel" class="right carousel-control" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span> 
                        </a>
                        
                        <script type="text/javascript">
                        	$(document).ready(function(){								
								setInterval( function(){ 
	                        		document.getElementById("home-page-next-slide").click();
	                        	}  , 3000 );							
                        		
                        	})
                        
                        </script>

                    </div>
                </div>
            </div>
        </div>

