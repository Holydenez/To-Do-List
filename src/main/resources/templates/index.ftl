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
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper">
            <a data-activates='dropdown1' data-beloworigin="true" data-hover="true" data-gutter="12px"
               class="dropdown-button btn red"
               href="/logout">${currentUser.user.email}</a>
            <ul id='dropdown1' class='dropdown-content'>
                <li><a href="/logout">Logout</a></li>
            </ul>
            <ul class="right hide-on-med-and-down">
                <li><a class="dropdown-button" data-activates='dropdownCategory' data-alignment="left"
                       data-hover="true"
                       data-beloworigin="false" data-constrainwidth="false">Категории</a></li>

                <li><a href="/task/archive/">Архив</a></li>
            </ul>
            <ul id='dropdownCategory' class='dropdown-content'  style="width:70%">
                <li>
                    <form method="POST" action="/task/chooseCategory">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="row">
                            <div class="col s8">
                                <div>
                                    <div class="input-field col s12">
                                        <select name="category" id="category" type="text">
                                            <option value="Дела">Дела</option>
                                            <option value="Покупки">Покупки</option>
                                        </select>
                                        <label>Выбор категории</label>
                                    </div>
                                </div>
                            </div>
                            <div class="col s4">
                                <button class="btn btn-medium waves-effect waves-light right" type="submit"
                                        name="action">Выбрать
                                </button>
                            </div>
                        </div>
                    </form>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container s10">
    <h1 align="center" style="font-family: 'Calibri Light'">TO-DO LIST</h1>
    <div class="row">
        <div class="col s3">
            <a class="btn-floating  btn-small" href="/task/sort?taskSortType=${currentUser.taskSortType}">
                <i class="small material-icons">swap_vert</i></a>
        </div>
        <div class="col s6">
            <h5 align="center" style="font-family: 'Calibri Light'">${currentUser.selectedCategory}</h5>
        </div>
        <div class="col s3"></div>
    </div>
    <div class="row">
        <div class="col s12">
            <ul class="tabs">
                <li class="tab col s3"><a href="#test1">Test 1</a></li>
                <li class="tab col s3"><a class="active" href="#test2">Test 2</a></li>
                <li class="tab col s3 disabled"><a href="#test3">Disabled Tab</a></li>
                <li class="tab col s3"><a href="#test4">Test 4</a></li>
            </ul>
        </div>
        <div id="test1" class="col s12">Test 1</div>
        <div id="test2" class="col s12">Test 2</div>
        <div id="test3" class="col s12">Test 3</div>
        <div id="test4" class="col s12">Test 4</div>
    </div>
    <div class="row">
        <#list tasks>
            <#items as task>
                <#if task.category == currentUser.selectedCategory>
                    <div class="hoverable s12 col showHoverBtn">
                        <div class="col s4 m4 center-align">
                            <#if task.isChecked()>
                                <a href="/task/unchecked?id=${task.id}"> <img src="/img/star.png" width="17%"
                                                                              height="17%"></a>
                            <#else>
                                <a href="/task/checked?id=${task.id}"> <img src="/img/emptyStar.png" width="19%"
                                                                            height="19%"></a>
                            </#if>
                        </div>
                        <div class="col s4 m4 center-align">
                            <#if  task.isPlanDateFailed()>
                                <p id="TaskName">${task.name}</p>
                                <label style="color: red" for="TaskName">${(task.planDate?date)!''}</label>
                            <#else>
                                <p id="TaskName">${task.name}</p>
                                <label for="TaskName">${(task.planDate?date)!''}</label>
                            </#if>

                        </div>
                        <div class="showHoverBtn col s4 m4">
                            <div class="hiddendiv">
                                <a class=" waves-effect waves-light btn left-align"
                                   href="/task/archive/add?id=${task.id}">Сделано</a>
                            </div>
                            <div class="hiddendiv">
                                <a class="btn-floating red btn-medium" href="/task/edit?id=${task.id}"> <i
                                        class="medium material-icons">mode_edit</i></a>
                            </div>
                        </div>
                    </div>
                <#else>
                </#if>
            </#items>
        <#else>
            <div>
                <label>Задачи не найдены</label>
            </div>
        </#list>
    </div>
    <div class="bottom_buttons">
        <a class="btn-floating btn-large waves-effect waves-light red right" href="/task/create"><i
                class="material-icons">note_add</i></a>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
        $('.modal-trigger').leanModal();
    });
    $(document).ready(function () {
        $('select').material_select();
    });
</script>
</html>