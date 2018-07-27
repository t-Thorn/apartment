<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <!-- custom-theme -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- //custom-theme -->
    <link href="/mainpage/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/mainpage/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <link rel="stylesheet" type="text/css" href="/mainpage/css/jquery-ui1.css">
    <!-- font-awesome-icons -->
    <link href="/mainpage/css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome-icons -->
    <link href="http://fonts.googleapis.com/css?family=Oswald:300,400,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
          rel='stylesheet' type='text/css'>
</head>

<body>
<!-- header -->
<div class="header">
    <div class="container">
        <div class="w3_agile_logo">
            <h1><a href="index.html"><span>T</span>enements</a></h1>
        </div>
        <div class="user">
            <c:choose>
                <c:when test="${UID==null}">
                    <a href="/userlogin/userlogin.jsp?action=login">登陆</a>&nbsp;
                    <a href="/userlogin/userlogin.jsp?action=register">注册</a>
                </c:when>

                <c:otherwise>
                    <a href="/User?cz=dl">个人中心</a>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<div class="header_address_mail">
    <div class="container">
        <div class="agileits_w3layouts_header_address_grid">
            <ul>
                <li><a href="mailto:info@example.com">info@example.com</a></li>
                <li><i class="fa fa-phone" aria-hidden="true"></i></li>
                <li>+(000) 123 234 22</li>
            </ul>
        </div>
    </div>
</div>
<!-- header -->
<!-- banner -->
<div class="banner">
    <div class="container">
        <nav class="navbar navbar-default">
            <div class="navbar-header navbar-left">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
        </nav>
    </div>
</div>
<!-- //banner -->
<!-- banner-bottom -->
<div class="banner-bottom">
    <div class="container">
        <div class="col-md-6 w3layouts_banner_bottom_left">
            <h3>real estate investing, even on a very small scale, remains a tried and true
                means of building an individual's cash flow and wealth</h3>
        </div>
        <div class="clearfix"></div>

    </div>
</div>
<!-- //banner-bottom -->
<!-- services -->
<div class="services">
    <div class="container">
        <div class="w3layouts_header">
            <p><span><i class="fa fa-key" aria-hidden="true"></i></span></p>
            <h5>我们的<span>产品</span></h5>
        </div>
        <div class="w3_services_grids">
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid">
                    <div class="agile_services_grid1_sub">
                        <p>$ 32,000</p>
                    </div>
                    <div class="agileinfo_services_grid_pos">
                        <i class="fa fa-user-o" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>2 Bedroom house for rent</h3>
                    <h4 class="w3_agileits_service">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li>(543)</li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid2">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub1">
                        <p>$ 12,000</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos1">
                        <i class="fa fa-bath" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>High rise Buildings for rent</h3>
                    <h4 class="w3_agileits_service2">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li>(4321)</li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid1">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub">
                        <p>$ 45,000</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>Big luxury house for rent</h3>
                    <h4 class="w3_agileits_service1">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li>(854)</li>
                    </ul>
                </div>
            </div>
            <div class="col-md-6 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid3">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub2">
                        <p>$ 23,543</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos2">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>Low rise Buildings for rent</h3>
                    <h4 class="w3_agileits_service3">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li>(231)</li>
                    </ul>
                </div>
            </div>
            <div class="col-md-6 w3l_services_grid">
                <div class="w3ls_services_grid agileits_services_grid4">
                    <div class="agile_services_grid1_sub agileits_w3layouts_ser_sub3">
                        <p>$ 45,426</p>
                    </div>
                    <div class="agileinfo_services_grid_pos agile_services_grid_pos3">
                        <i class="fa fa-home" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="wthree_service_text">
                    <h3>Low rise Buildings for rent</h3>
                    <h4 class="w3_agileits_service4">Reality Agency</h4>
                    <ul>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-half-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        <li>(653)</li>
                    </ul>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- //services -->
<!-- skills -->
<div class="skills">
    <div class="container">
        <div class="w3layouts_header w3_agile_head">
            <p><span><i class="fa fa-bullseye" aria-hidden="true"></i></span></p>
            <h5>我们的 <span>服务</span></h5>
        </div>
        <div class="w3layouts_skills_grids">
            <div class="col-md-3 w3ls_about_guage">
                <h4>合理的费用</h4>
                <canvas id="gauge1" width="200" height="100"></canvas>
            </div>
            <div class="col-md-3 w3ls_about_guage">
                <h4>安全的环境</h4>
                <canvas id="gauge2" width="200" height="100"></canvas>
            </div>
            <div class="col-md-3 w3ls_about_guage">
                <h4>优秀的平台管理</h4>
                <canvas id="gauge3" width="200" height="100"></canvas>
            </div>
            <div class="col-md-3 w3ls_about_guage">
                <h4>贴心的服务</h4>
                <canvas id="gauge4" width="200" height="100"></canvas>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- //skills -->
<!-- featured-services -->
<div class="services">
    <div class="container">
        <div class="w3layouts_header">
            <p><span><i class="fa fa-building-o" aria-hidden="true"></i></span></p>
            <h5>我们的 <span>主要</span> 优势</h5>
        </div>
        <div class="w3layouts_skills_grids w3layouts_featured_services_grids">
            <div class="col-md-6 w3_featured_services_left">
                <div class="w3_featured_services_left_grid">
                    <div class="col-xs-4 w3_featured_services_left_gridl">
                        <div class="hi-icon-wrap hi-icon-effect-9 hi-icon-effect-9a">
                            <i class="hi-icon fa-cubes"> </i>
                        </div>
                    </div>
                    <div class="col-xs-8 w3_featured_services_left_gridr">
                        <h4>合理的费用</h4>
                        <p>费用在同地段处于中等水平,不定时的活动为你减负.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="w3_featured_services_left_grid">
                    <div class="col-xs-4 w3_featured_services_left_gridl">
                        <div class="hi-icon-wrap hi-icon-effect-9 hi-icon-effect-9a">
                            <i class="hi-icon fa-globe"> </i>
                        </div>
                    </div>
                    <div class="col-xs-8 w3_featured_services_left_gridr">
                        <h4>安全的环境</h4>
                        <p>有合理的保安以及监控测试,为你的人身安全提供极大保障</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="w3_featured_services_left_grid">

                    <div class="col-xs-4 w3_featured_services_left_gridl">
                        <div class="hi-icon-wrap hi-icon-effect-9 hi-icon-effect-9a">
                            <i class="hi-icon fa-gear"> </i>
                        </div>
                    </div>
                    <div class="col-xs-8 w3_featured_services_left_gridr">
                        <h4>便利的物业</h4>
                        <p>可靠的物业管理,让你的入住时光更加顺心.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="w3_featured_services_left_grid">

                    <div class="col-xs-4 w3_featured_services_left_gridl">
                        <div class="hi-icon-wrap hi-icon-effect-9 hi-icon-effect-9a">
                            <i class="hi-icon fa-handshake-o"> </i>
                        </div>
                    </div>
                    <div class="col-xs-8 w3_featured_services_left_gridr">
                        <h4>贴心的服务</h4>
                        <p>优秀的服务人员,为你提供快捷的入住服务.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>

            </div>
            <div class="col-md-6 w3_featured_services_right">
                <img src="images/7.jpg" alt=" " class="img-responsive"/>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- //featured-services -->
<!-- footer -->
<div class="newsletter">
    <div class="container">
        <div class="w3ls_footer_grid">
            <div class="col-md-4 w3ls_footer_grid_left">
                <div class="w3ls_footer_grid_leftl">
                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                </div>
                <div class="w3ls_footer_grid_leftr">
                    <h4>Location</h4>
                    <p>3481 Melrose Place, EF23 Beverly Hills, New York City, USA 90210.</p>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-4 w3ls_footer_grid_left">
                <div class="w3ls_footer_grid_leftl">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                </div>
                <div class="w3ls_footer_grid_leftr">
                    <h4>Email</h4>
                    <a href="mailto:info@example.com">info@example.com</a>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-4 w3ls_footer_grid_left">
                <div class="w3ls_footer_grid_leftl">
                    <i class="fa fa-phone" aria-hidden="true"></i>
                </div>
                <div class="w3ls_footer_grid_leftr">
                    <h4>Call Us</h4>
                    <p>(+000) 123 4571 121</p>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="w3l_footer_pos">
        <p>Copyright &copy; 2017.Company name All rights reserved.</p>
    </div>
</div>
<!-- //footer -->
<!-- gauge-meter -->
<script src="js/jquery.gauge.js"></script>
<script>
    $(document).ready(function () {
        $("#gauge1").gauge(80, {color: "#fb5710", unit: " %", type: "halfcircle"});
        $("#gauge2").gauge(90, {color: "#a821e7", unit: " %", type: "halfcircle"});
        $("#gauge3").gauge(95, {color: "#fbb810", unit: " %", type: "halfcircle"});
        $("#gauge4").gauge(90, {color: "#21d0e7", unit: " %", type: "halfcircle"});
    });
</script>
<!-- //gauge-meter -->
<!-- range -->
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type='text/javascript'>//<![CDATA[
$(window).load(function () {
    $("#slider-range").slider({
        range: true,
        min: 0,
        max: 2000,
        values: [50, 600],
        slide: function (event, ui) {
            $("#amount").val(ui.values[0] + " - " + ui.values[1]);
        }
    });
    $("#amount").val($("#slider-range").slider("values", 0) + " - " + $("#slider-range").slider("values", 1));

});//]]>
</script>
<!-- //range -->
<!-- start-smooth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();
            $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
        });
    });
</script>
<!-- start-smooth-scrolling -->
<!-- for bootstrap working -->
<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function () {
        /*
            var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
            };
        */

        $().UItoTop({easingType: 'easeOutQuart'});

    });
</script>
<!-- //here ends scrolling icon -->
</body>
</html>