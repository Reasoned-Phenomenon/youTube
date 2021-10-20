<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>You | Tube</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">
	
    <!-- Css Styles -->
    <link rel="stylesheet" href="../template/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../template/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../template/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../template/css/plyr.css" type="text/css">
    <link rel="stylesheet" href="../template/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../template/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../template/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../template/css/style.css" type="text/css">
    
    <!--google icon-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="css/google.css" type="text/css">

</head>


<body>

    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <!-- 메뉴바 -->
    <header class="header">

    </header>
    <!-- Header End -->

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="homepage.html"><i class="fa fa-home"></i> Home</a>
                        <a href="#">Categories</a>
                        <a href="#">Cat</a>
                        <span id="viTitleSpan"></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Anime Section Begin -->
    <section class="anime-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="anime__video__player">
                    	<!-- 비디오 들어가는 곳 -->
                    </div>
                    
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8">
                    <div class="anime__details__review">
                        <div class="section-title">
                            <h5>Reviews</h5>
                        </div>
                        
                        </div>
                    <div class="anime__details__form">
                        <div class="section-title">
                            <h5>Your Comment</h5>
                        </div>
                        <form action="#">
                            <textarea placeholder="Your Comment"></textarea>
                            <button type="submit"><i class="fa fa-location-arrow"></i> Review</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Anime Section End -->

<!-- Footer Section Begin -->
<footer class="footer">
<div class="page-up">
<a href="#" id="scrollToTopButton"><span class="arrow_carrot-up"></span></a>
</div>

<div class="container">
<div class="row">

<div class="col-lg-3">
<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
</div>

</div>
</div>
</footer>
<!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="../template/js/jquery-3.3.1.min.js"></script>
    <script src="../template/js/bootstrap.min.js"></script>
    <script src="../template/js/player.js"></script>
    <script src="../template/js/jquery.nice-select.min.js"></script>
    <script src="../template/js/mixitup.min.js"></script>
    <script src="../template/js/jquery.slicknav.js"></script>
    <script src="../template/js/owl.carousel.min.js"></script>
    <script src="../template/js/main.js"></script>
    
	<!--yoo-->   
    <script src="js/you-hf.js"></script>
	<script src="js/you-login.js"></script>
	<script src="js/you-watch.js"></script>
    
    <script>
    
	<%
	String viNum = request.getParameter("viNum");
	%>
	let viNum = <%=viNum%>
	
    $(document).ready(function () {
    	console.log('vi:'+viNum);
    	console.log(document.cookie);
    	
		makeHeader ();
        makeFooter ();
		profile();
		
    	showList(viNum);
    	setVideo(viNum);
    	getComment(viNum);
        
    })
    
    </script>

</body>

</html>