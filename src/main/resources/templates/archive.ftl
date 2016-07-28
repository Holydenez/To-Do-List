<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="/css/materialize.min.css" media="screen,projection"/>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script type="text/javascript" src="/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="/js/materialize.min.js"></script>
    <title>TDL</title>

</head>

<body bgcolor="#EAF1F3">
<div class="container">
<#--<div class="col s12"> Для пользователей -->
<#--<i class="material-icons prefix">account_circle</i>-->
<#--<label>Hello ${UserName}</label>-->
<#--</div>-->
    <h1 align="center" style="font-family: 'Calibri Light'">АРХИВ</h1>
    <div class="row">
    <#list currentUser.user.tasks>
        <#items as task>
            <#if task.isDone()>
                <div class="hoverable s12 col showHoverBtn">
                    <div class="col s4 m4 center-align">
                        <#if task.isChecked()>
                            <a> <img src="/img/star.png" width="17%" height="17%"></a>
                        <#else>
                            <a> <img src="/img/emptyStar.png" width="19%" height="19%"></a>
                        </#if>
                    </div>
                    <div class="col s4 m4 center-align">
                        <p>${task.name}</p>
                    </div>
                    <div class="showHoverBtn col s4 m4">
                        <div class="hiddendiv">
                            <a class=" waves-effect waves-light btn center-align "
                               href="/task/archive/remove?id=${task.id}">Вернуть</a>
                        </div>
                    </div>
                </div>
            </#if>
        </#items>
    <#else>
        <div>
            <label>Задачи не найдены</label>
        </div>
    </#list>
    </div>
    <div class="bottom_buttons">
        <div class="col s6">
            <a class="waves-effect waves-light btn-large" href="/task/all">Вернуться</a>
        </div>
    </div>
</div>
</body>
</html>