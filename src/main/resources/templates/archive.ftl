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
    <script>$(".button-collapse").sideNav();</script>
    <title>TDL</title>

</head>

<body>
<div class="container">
<#--<div class="col s12"> Для пользователей -->
<#--<i class="material-icons prefix">account_circle</i>-->
<#--<label>Hello ${UserName}</label>-->
<#--</div>-->
    <h1 align="center" style="font-family: 'Calibri Light'">АРХИВ</h1>
    <section>

        <table style="width:90%; margin: auto" class="highlight centered bordered">

            <tbody>
            <#list tasks>
                <#items as task>
                <tr>
                    <td>
                        <a class="waves-effect waves-light btn left-align">Вернуть</a>
                    </td>
                    <td>
                        <div class="input-field col s6">
                            <p>${task.name}</p>
                        </div>
                    </td>
                    <td>
                        <div class="input-field col s6">
                            <#if task.isChecked()>
                                <img src="/img/star.png" width="30px" height="30px">
                            <#else>
                                <img src="/img/emptyStar.png" width="38px" height="38px">
                            </#if>

                        </div>
                    </td>
                    <td>
                        <a class="btn-floating red btn-medium"> <i class="medium material-icons">mode_edit</i></a>
                    </td>
                </tr>
                </#items>
            <#else>
            <tr>
                <td>
                    Задачи не найдены
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </section>
    <div class="bottom_buttons">
        <div class="col s6">
            <a class="waves-effect waves-light btn-large" href="/task/all">Вернуться</a>
        </div>
    </div>
</div>
</body>
</html>