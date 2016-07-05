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
    <h3 align="center" style="font-family: 'Calibri Light'">Редактирование заметки</h3>
    <form method="POST" action="/task/edit">
        <input name="id" id="taskid" type="hidden" value="${task.id}">

        <div class="row">
            <div style="margin: auto" class="input-field col s12">
                <label for="taskContent">Ваша заметка</label>
                <input name="name" id="taskContent" type="text" class="validate" value="${task.name}">
            </div>
            <div class="input-field col s12">
                    <input name="checked" type="checkbox" class="filled-in validate" id="checkStar" checked value="true"/>
                    <label for="checkStar">Важное</label>
            </div>
        </div>
        <div class="bottom_buttons">
            <div class="row">
                <div class="col s6 left">
                    <a class="waves-effect waves-light btn-large left" href="/task/all">Вернуться</a>
                </div>
                <div class="col s6 right">
                    <button class="btn-large waves-effect waves-light right" type="submit" name="action">Сохранить
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>