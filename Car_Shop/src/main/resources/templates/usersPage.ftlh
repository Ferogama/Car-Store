<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal">Cars store </h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/cars">Catalog</a>
        <a class="p-2 text-dark" href="/profile">Profile</a>
        <a class="p-2 text-blue" href="/logout">Logout</a>
    </nav>
</div>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <#list usersList as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>
                    <form action="/users/del/${user.id}" method="get">
                        <input type="submit" value="Удалить пользователя"/>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>