<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="/css/materialize.min.css" media="screen,projection"/>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script type="text/javascript" src="/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="/js/materialize.min.js"></script>
    <title>TDL</title>
</head>
<body>
<div class="container">
    <h3 align="center" style="font-family: 'Calibri Light'">Новая заметка </h3>
    <form method="POST" action="/newTask" class="col s12">
        <div style="margin: auto" class="input-field col s12">
            <label for="taskContent"><input name="name" id="taskContent" type="text" class="validate">Ваша
                зметка</label>
        </div>
    <#--<div class="input-field col s6">-->
    <#--<label>Дата выполнения:-->
    <#--<input style="width:50%;" type="date" id="datepicker"/>-->
    <#--</label>-->
    <#--</div>-->
    <#--<div class="input-field col s6">-->
    <#--<p>-->
    <#--<input type="checkbox" class="filled-in" id="checkStar"/>-->
    <#--<label for="checkStar">Важное</label>-->
    <#--</p>-->
    <#--</div>-->
        <div class="bottom_buttons">
            <a class="waves-effect waves-light btn-large" href="/">Венуться к заметкам</a>
            <div class="col s6 right">
                <button class="btn-large waves-effect waves-light" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </div>
    </form>
</div>
</body>
</html>