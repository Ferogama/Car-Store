<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>Регистрация</title>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK3r7Mbas+3bFOmMYcels8+yTxTDa/Q2zcsKo7ETfP919rp"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-U7NYUkD0Ye5VgXCiUeEa9K58g3YfK7x8P1E1nf/xV+ncnYSKicilLeiFFxrqzJ+a"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-Jj5v8z+8HxgnPhvA5CwF+05JCirvXH8l/5Ic+qhTd4dtOzCmYT4ksZ2eaOrsERel"
            crossorigin="anonymous"></script>
</head>
<body>
<h5 style="text-align:center;">Зарегистрируйтесь</h5>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="/signUp" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="form-group">
                    <label for="email">Email</label>
                    <input name="email" type="email" class="form-control" id="email" placeholder="Введите email">
                    <#if errors?has_content>
                        <#list errors.fieldErrors as error>
                            <#if error.field == "email">
                                <div class="alert alert-danger">${error.defaultMessage}</div>
                            </#if>
                        </#list>
                    </#if>
                </div>
                <div class="form-group">
                    <label for="password">Пароль</label>
                    <input name="password" type="password" class="form-control" id="password" placeholder="Введите пароль">
                    <#if errors?has_content>
                        <#list errors.fieldErrors as error>
                            <#if error.field == "password">
                                <div class="alert alert-danger">${error.defaultMessage}</div>
                            </#if>
                        </#list>
                    </#if>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Создать аккаунт</button>
                    <a href="/signIn" class="btn btn-link">Войти здесь</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
