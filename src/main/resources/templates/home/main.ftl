<#include "../common/head.ftl">
<section class="vbox">
    <header class="bg-dark dk header navbar navbar-fixed-top-xs">
        <div class="navbar-header aside-md">
            <a id="topbtn" class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open"
               data-target="#nav,html">
                <i class="fa fa-bars"></i>
            </a>
            <a href="#" class="navbar-brand" data-toggle="fullscreen"><img src="images/logo.png" class="m-r-sm">后台管理</a>
            <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".nav-user">
                <i class="fa fa-cog"></i>
            </a>
        </div>
        <ul class="nav navbar-nav navbar-right m-n hidden-xs nav-user">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <span class="thumb-sm avatar pull-left">
              <img src="images/avatar.jpg">
            </span>
                    熊猫<b class="caret"></b>
                </a>
                <ul class="dropdown-menu animated fadeInRight">
                    <span class="arrow top"></span>
                    <li>
                        <a href="#">系统设置</a>
                    </li>
                    <li>
                        <a href="profile.html">个人资料</a>
                    </li>
                    <li>
                        <a href="docs.html">帮助</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="modal.lockme.html" data-toggle="ajaxModal">退出</a>
                    </li>
                </ul>
            </li>
        </ul>
    </header>

    <section>
        <section class="hbox stretch">
            <!-- .aside -->
            <aside class="bg-dark lter aside-md hidden-print hidden-xs" id="nav">
                <section class="vbox">
                    <section class="w-f scrollable">
                        <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="5px" data-color="#333333">
                        <#include "../common/menu.ftl">
                        </div>
                    </section>
                    <footer class="footer lt hidden-xs b-t b-dark" id="footer">
                        <div id="chat" class="dropup">
                            <section class="dropdown-menu on aside-md m-l-n">
                                <section class="panel bg-white">
                                    <header class="panel-heading b-b b-light">在线聊天</header>
                                    <div class="panel-content animated fadeInRight">
                                        <p class="text-sm">没有在线的.</p>
                                        <p><a href="#" class="btn btn-sm btn-default">开始聊天</a></p>
                                    </div>
                                </section>
                            </section>
                        </div>
                        <div id="invite" class="dropup">
                            <section class="dropdown-menu on aside-md m-l-n">
                                <section class="panel bg-white">
                                    <header class="panel-heading b-b b-light">
                                        约翰 <i class="fa fa-circle text-success"></i>
                                    </header>
                                    <div class="panel-content animated fadeInRight">
                                        <p class="text-sm">没有联系人.</p>
                                        <p><a href="#" class="btn btn-sm btn-facebook"><i
                                                class="fa fa-fw fa-facebook"></i> 从Facebook邀请</a></p>
                                    </div>
                                </section>
                            </section>
                        </div>
                        <a href="#nav" data-toggle="class:nav-xs" class="pull-right btn btn-sm btn-dark btn-icon">
                            <i class="fa fa-angle-left text"></i>
                            <i class="fa fa-angle-right text-active"></i>
                        </a>
                        <div class="btn-group hidden-nav-xs">
                            <button type="button" title="Chats" class="btn btn-icon btn-sm btn-dark"
                                    data-toggle="dropdown" data-target="#chat"><i class="fa fa-comment-o"></i></button>
                            <button type="button" title="Contacts" class="btn btn-icon btn-sm btn-dark"
                                    data-toggle="dropdown" data-target="#invite"><i class="fa fa-facebook"></i></button>
                        </div>
                    </footer>
                </section>
            </aside>
            <!-- /.aside -->
            <iframe src="/home/index" id="rightFrame" name="rightFrame" frameborder="0" width="100%" height="100%"></iframe>
        </section>
    </section>
</section>
<#include "../common/foot.ftl">