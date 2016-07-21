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
    <h1 align="center" style="font-family: 'Calibri Light'">Authorization</h1>
    <form role="form" action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="row">
            <div class="s12 col">
                <label for="email">Email address</label>
                <input type="email" name="email" id="email" required autofocus value="">
            </div>
            <div class="s12 col">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" required value="">
            </div>
            <div class="s6 col">
            <button class="btn waves-effect waves-light" type="submit" name="action">Зарегестрироваться
                <i class="material-icons right">send</i>
            </button>
            </div>
        </div>
    </form>

<#if error.isPresent()>
    <p>The email or password you have entered is invalid, try again.</p>
</#if>
</div>
</body>
</html>