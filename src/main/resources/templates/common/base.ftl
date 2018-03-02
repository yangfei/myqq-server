<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="utf-8" />
    <title> <@block name="title" ></@block> </title>
    <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="/css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="/css/app.css" type="text/css" />
    <link rel="stylesheet" href="/css/screen.css" type="text/css" />
    <@block name="css" ></@block>
    <!--[if lt IE 9]>
    <script src="/js/ie/html5shiv.js"></script>
    <script src="/js/ie/respond.min.js"></script>
    <script src="/js/ie/excanvas.js"></script>
    <![endif]-->

</head>
<content class="">
<section class="hbox stretch">
    <section id="content">
        <section class="vbox">
        <@block name="content" ></@block>
        </section>
        <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen, open" data-target="#nav,html"></a>
    </section>
    <aside class="bg-light lter b-l aside-md hide" id="notes">
        <div class="wrapper">通知</div>
    </aside>
</section>
<script src="/js/jquery.min.js"></script>
<script src="/js/charts/easypiechart/jquery.easy-pie-chart.js"></script>
<script src="/js/app.plugin.js"></script>
<@block name="script" ></@block>
</content>
</html>