<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta name="description" content="Responsive Admin Template"/>
    <meta name="author" content="SmartUniversity"/>
    <title>Spice Hotel | Bootstrap 4 Admin Dashboard Template + UI Kit</title>
    <!-- google font -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
          rel="stylesheet" type="text/css"/>
    <!-- icons -->
    <link href="assets/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css"/>
    <!--bootstrap -->
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- Material Design Lite CSS -->
    <link rel="stylesheet" href="assets/plugins/material/material.min.css">
    <link rel="stylesheet" href="assets/css/material_style.css">
    <!-- animation -->
    <link href="assets/css/pages/animate_page.css" rel="stylesheet">
    <!-- Template Styles -->
    <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/plugins.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/responsive.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/theme-color.css" rel="stylesheet" type="text/css"/>
    <!-- dropzone -->
    <link href="assets/plugins/dropzone/dropzone.css" rel="stylesheet" media="screen">
    <!-- Date Time item CSS -->
    <link rel="stylesheet"
          href="assets/plugins/material-datetimepicker/bootstrap-material-datetimepicker.css"/>
    <!-- favicon -->
    <link rel="shortcut icon" href="assets/img/favicon.ico"/>
</head>
<!-- END HEAD -->
<body class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white dark-sidebar-color logo-dark">
<div class="page-wrapper">
    <!-- start header -->
    <div class="page-header navbar navbar-fixed-top">
        <div class="page-header-inner ">
            <!-- logo start -->
            <div class="page-logo">
                <a href="index.html">
                    <img alt="" src="assets/img/logo.png">
                    <span class="logo-default">Spice</span> </a>
            </div>
            <!-- logo end -->


            <!-- start mobile menu -->

            <!-- end mobile menu -->
            <!-- start header menu -->
            <div class="top-menu">
                <ul class="nav navbar-nav pull-right">
                    <!-- start notification dropdown -->

                    <!-- end notification dropdown -->
                    <!-- start message dropdown -->
                    <!-- start manage user dropdown -->
                    <li class="dropdown dropdown-user">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"
                           data-hover="dropdown" data-close-others="true">
                            <img alt="" class="img-circle " src="assets/img/dp.jpg"/>
                            <span class="username username-hide-on-mobile"> ${sessionScope.Name} </span>
                            <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-default animated jello">
                            <li>
                                <a href="/User?param=0">
                                    <i class="icon-logout"></i> Log Out </a>
                            </li>
                        </ul>
                    </li>
                    <!-- end manage user dropdown -->
                </ul>
            </div>
        </div>
    </div>
    <!-- end header -->
    <!-- start page container -->
    <div class="page-container">
        <!-- start sidebar menu -->
        <div class="sidebar-container">
            <div class="sidemenu-container navbar-collapse collapse fixed-menu">
                <div id="remove-scroll">
                    <ul class="sidemenu page-header-fixed p-t-20" data-keep-expanded="false"
                        data-auto-scroll="true" data-slide-speed="200">
                        <li class="sidebar-toggler-wrapper hide">
                            <div class="sidebar-toggler">
                                <span></span>
                            </div>
                        </li>

                        <li class="menu-heading">
                            <span>-- 功能列表</span>
                        </li>
                        <li class="nav-item start">
                            <a href="#" class="nav-link nav-toggle">
                                <i class="material-icons">dashboard</i>
                                <span class="title">数据分析</span>
                                <span class="selected"></span>
                                <span class="arrow open"></span>
                            </a>
                            <ul class="sub-menu">
                                <li class="nav-item">
                                    <a href="/Analyse" class="nav-link ">
                                        <span class="title">分析</span>
                                        <span class="selected"></span>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="nav-item active">
                            <a href="#" class="nav-link nav-toggle">
                                <i class="material-icons">business_center</i>
                                <span class="title">预定</span>
                                <span class="arrow"></span>
                            </a>
                            <ul class="sub-menu">
                                <li class="nav-item ">
                                    <a href="new_booking.jsp" class="nav-link ">
                                        <span class="title">新的预定</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="/Booking" class="nav-link ">
                                        <span class="title">查看预定</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link nav-toggle">
                                <i class="material-icons">vpn_key</i>
                                <span class="title">房间信息</span>
                                <span class="arrow"></span>
                            </a>
                            <ul class="sub-menu">
                                <li class="nav-item">
                                    <a href="add_room.jsp" class="nav-link ">
                                        <span class="title">添加房间</span>
                                    </a>
                                </li>
                                <li class="nav-item ">
                                    <a href="/Room" class="nav-link ">
                                        <span class="title">查看所有房间</span>
                                    </a>
                                </li>
                                <li class="nav-item ">
                                    <a href="repair_room_admin.jsp" class="nav-link ">
                                        <span class="title">公寓报修</span>
                                    </a>
                                </li>
                                <li class="nav-item ">
                                    <a href="/Repair" class="nav-link ">
                                        <span class="title">报修管理</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link nav-toggle">
                                <i class="material-icons">group</i>
                                <span class="title">房客</span>
                                <span class="arrow"></span>
                            </a>
                            <ul class="sub-menu">
                                <li class="nav-item">
                                    <a href="add_staff.jsp" class="nav-link ">
                                        <span class="title">添加房客</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="/SS?cz=view" class="nav-link ">
                                        <span class="title">房客信息查询</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link nav-toggle">
                                <i class="material-icons">group</i>
                                <span class="title">用户</span>
                                <span class="arrow"></span>
                            </a>
                            <ul class="sub-menu">
                                <li class="nav-item">
                                    <a href="add_user.jsp" class="nav-link ">
                                        <span class="title">添加用户</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="/User?cz=view" class="nav-link ">
                                        <span class="title">查看所有用户</span>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="menu-heading m-t-20">

                    </ul>
                </div>
            </div>
        </div>
        <!-- end sidebar menu -->
        <!-- start page content -->
        <div class="page-content-wrapper">
            <div class="page-content">
                <div class="page-bar">
                    <div class="page-title-breadcrumb">
                        <div class=" pull-left">
                            <div class="page-title">修改订单</div>
                        </div>
                        <ol class="breadcrumb page-breadcrumb pull-right">
                            <li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
                                                                   href="index.html">Home</a>&nbsp;<i
                                    class="fa fa-angle-right"></i>
                            </li>
                            <li><a class="parent-item" href="">预定</a>&nbsp;<i
                                    class="fa fa-angle-right"></i>
                            </li>
                            <li class="active">修改订单</li>
                        </ol>
                    </div>
                </div>
                <form method="post" name="editbook" action="/Booking">
                    <input type="hidden" name="bid" value="${book.getId()}">
                    <input type="hidden" name="roomid" value="${book.getRoom_Num()}">
                    <input type="hidden" name="param" value="3">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="card-box">
                                <div class="card-body row">
                                    <div class="col-lg-6 p-t-20">
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
                                            <input class="mdl-textfield__input" type="text"
                                                   name="name"
                                                   value="${book.getBook_Person()}" id="txtFirstName">
                                            <label class="mdl-textfield__label">姓名</label>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 p-t-20">
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
                                            <input class="mdl-textfield__input" type="text"
                                                   value="${book.getMobilephone()}" name="phone"
                                                   pattern="-?[0-9]*(\.[0-9]+)?" id="text5">
                                            <label class="mdl-textfield__label"
                                                   for="text5">联系方式</label>
                                            <span class="mdl-textfield__error">Number required!</span>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 p-t-20">
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
                                            <input class="mdl-textfield__input" type="text"
                                                   value="${book.getBook_PersonID()}" id="txtCity" name="id">
                                            <label class="mdl-textfield__label">ID</label>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 p-t-20">
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height txt-full-width">
                                            <input class="mdl-textfield__input" type="text"
                                                   id="sample2" value="${gender}"
                                                   readonly
                                                   tabIndex="-1"
                                                   name="gender">
                                            <label for="sample2" class="pull-right margin-0">
                                                <i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
                                            </label>
                                            <label for="sample2"
                                                   class="mdl-textfield__label">性别</label>
                                            <ul data-mdl-for="sample2"
                                                class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                                                <li class="mdl-menu__item" data-val="DE">男</li>
                                                <li class="mdl-menu__item" data-val="BY">女</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 p-t-20">
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
                                            <input class="mdl-textfield__input" type="text"
                                                   value="${book.getBook_StartTime()}" id="date" name="begintime">
                                            <label class="mdl-textfield__label">到达时间</label>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 p-t-20">
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
                                            <input class="mdl-textfield__input" type="text"
                                                   value="${book.getBook_FinalTime()}" id="date1"
                                                   name="finishtime">
                                            <label class="mdl-textfield__label">离开时间</label>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 p-t-20">
                                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height txt-full-width">
                                            <input class="mdl-textfield__input" type="text"
                                                   id="list3" value="${roomtype}"
                                                   tabIndex="-1" name="type">
                                            <label for="list3" class="pull-right margin-0">
                                                <i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
                                            </label>
                                            <label for="list3"
                                                   class="mdl-textfield__label">房间类型</label>
                                            <ul data-mdl-for="list3"
                                                class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                                                <li class="mdl-menu__item" data-val="1">单人间</li>
                                                <li class="mdl-menu__item" data-val="2">双人间</li>
                                                <li class="mdl-menu__item" data-val="3">三人间</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 p-t-20 text-center">
                                        <button type="button"
                                                class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink" onclick="validate()">
                                            提交
                                        </button>
                                        <button type="button"
                                                class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 btn-default" onclick="cancel()">
                                            取消
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- end page content -->
    </div>
    <!-- end page container -->
    <!-- start footer -->
    <div class="page-footer">
        <div class="page-footer-inner"> 2018 &copy; Spice Hotel Template By
            <a href="mailto:redstartheme@gmail.com" target="_top" class="makerCss">RedStar Theme</a>
        </div>
        <div class="scroll-to-top">
            <i class="icon-arrow-up"></i>
        </div>
    </div>
    <!-- end footer -->
</div>
<!-- start js include path -->
<script src="assets/plugins/jquery/jquery.min.js"></script>
<script src="assets/plugins/popper/popper.min.js"></script>
<script src="assets/plugins/jquery-blockui/jquery.blockui.min.js"></script>
<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- bootstrap -->
<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- Common js-->
<script src="assets/js/app.js"></script>
<script src="assets/js/layout.js"></script>
<script src="assets/js/theme-color.js"></script>
<!-- Material -->
<script src="assets/plugins/material/material.min.js"></script>
<script src="assets/js/pages/material_select/getmdl-select.js"></script>
<script src="assets/plugins/material-datetimepicker/moment-with-locales.min.js"></script>
<script src="assets/plugins/material-datetimepicker/bootstrap-material-datetimepicker.js"></script>
<script src="assets/plugins/material-datetimepicker/datetimepicker.js"></script>
<!-- dropzone -->
<script src="assets/plugins/dropzone/dropzone.js"></script>
<script src="assets/plugins/dropzone/dropzone-call.js"></script>
<!-- animation -->
<script src="assets/js/pages/ui/animations.js"></script>
<!-- end js include path -->
<script>
    function cancel() {
        window.location.href = "/Booking";
    }

    function validate() {
        //验证表单完整性
        var flag = true;
        $("input[type='text']").each(function () {
            if ($(this).val() == "") {
                alert("请填写完整!");
                flag = false;
                return false;
            }
        })
        if (flag == true) {
            editbook.submit();
        }
        else {
            return false;
        }
    }
</script>
</body>
</html>