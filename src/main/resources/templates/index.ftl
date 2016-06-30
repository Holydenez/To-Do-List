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

<body>
<h1 align="center" style="font-family: 'Calibri Light'">TO-DO LIST</h1>
<section>
    <h1>Hello ${name}</h1>
    <table style="width:90%; margin: auto" class="highlight centered bordered responsive-table">
        <thead>
        <tr>
            <div style="width:90%; margin: auto" class="row">
                <div class="col s12">
                    <ul class="tabs">
                        <li class="tab col s3"><a class="active">Работа</a></li>
                        <li class="tab col s3"><a>Дом</a></li>
                        <li class="tab col s3"><a>Покупки</a></li>
                        <li class="tab col s3"><a>Учеба</a></li>
                    </ul>
                </div>
            </div>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <p>
                    <input type="checkbox" class="filled-in" id="checkbox"/>
                    <label for="checkbox">Сделано</label>
                </p>
            </td>
            <td>
                <div class="input-field col s6">
                    <p>pewpewpew</p>
                </div>
            </td>
            <td>
                <div class="input-field col s6">
                    <i class="small material-icons">grade</i>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</section>
<div class="bottom_buttons">
    <a class="waves-effect waves-light btn-large left"><i class="material-icons right">cloud</i>SAVE</a>
    <a class="btn-floating btn-large waves-effect waves-light red right" href="newTask.html"><i
            class="material-icons">add</i></a>
</div>
</body>
</html>