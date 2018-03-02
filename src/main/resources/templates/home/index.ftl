<@override name="title">
 后台首页
</@override>
<@override name="content">
<section class="scrollable padder">
    <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
        <li>系统设置</li>
        <li>后台首页</li>
    </ul>
    <div class="m-b-md">
        <h3 class="m-b-none">熊猫，欢迎回来！</h3>
    </div>
    <section class="panel panel-default">
        <div class="row m-l-none m-r-none bg-light lter">
            <div class="col-sm-6 col-md-3 padder-v b-r b-light">
				<span class="fa-stack fa-2x pull-left m-r-sm">
				  <i class="fa fa-circle fa-stack-2x text-info"></i>
				  <i class="fa fa-male fa-stack-1x text-white"></i>
				  <span class="easypiechart pos-abt" data-percent="100" data-line-width="4" data-track-Color="#fff"
                        data-scale-Color="false" data-size="50" data-line-cap='butt' data-animate="1000"
                        data-target="#newuser" data-update="1000"></span>
				</span>
                <a class="clear" href="#">
                    <span class="h3 block m-t-xs"><strong id="newuser">52000</strong></span>
                    <small class="text-muted text-uc">新用户</small>
                </a>
            </div>
            <div class="col-sm-6 col-md-3 padder-v b-r b-light lt">
				<span class="fa-stack fa-2x pull-left m-r-sm">
				  <i class="fa fa-circle fa-stack-2x text-warning"></i>
				  <i class="fa fa-bug fa-stack-1x text-white"></i>
				  <span class="easypiechart pos-abt" data-percent="100" data-line-width="4" data-track-Color="#fff"
                        data-scale-Color="false" data-size="50" data-line-cap='butt' data-animate="2000"
                        data-target="#bugs" data-update="3000"></span>
				</span>
                <a class="clear" href="#">
                    <span class="h3 block m-t-xs"><strong id="bugs">468</strong></span>
                    <small class="text-muted text-uc">来访用户</small>
                </a>
            </div>
            <div class="col-sm-6 col-md-3 padder-v b-r b-light">
				<span class="fa-stack fa-2x pull-left m-r-sm">
				  <i class="fa fa-circle fa-stack-2x text-danger"></i>
				  <i class="fa fa-fire-extinguisher fa-stack-1x text-white"></i>
				  <span class="easypiechart pos-abt" data-percent="100" data-line-width="4" data-track-Color="#f5f5f5"
                        data-scale-Color="false" data-size="50" data-line-cap='butt' data-animate="3000"
                        data-target="#firers" data-update="5000"></span>
				</span>
                <a class="clear" href="#">
                    <span class="h3 block m-t-xs"><strong id="firers">359</strong></span>
                    <small class="text-muted text-uc">回头客</small>
                </a>
            </div>
            <div class="col-sm-6 col-md-3 padder-v b-r b-light lt">
				<span class="fa-stack fa-2x pull-left m-r-sm">
				  <i class="fa fa-circle fa-stack-2x icon-muted"></i>
				  <i class="fa fa-clock-o fa-stack-1x text-white"></i>
				</span>
                <a class="clear" href="#">
                    <span class="h3 block m-t-xs"><strong>31:50</strong></span>
                    <small class="text-muted text-uc">即将退出</small>
                </a>
            </div>
        </div>
    </section>
</section>
</@override>
<@extends name="../common/base.ftl"/>