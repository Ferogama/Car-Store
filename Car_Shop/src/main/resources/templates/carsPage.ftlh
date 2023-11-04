<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cars Catalog </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .delete-button {
            position: absolute;
            top: 370px;
            right: 3px;
        }
        .change-button {
            position: absolute;
            top: 370px;
            left: 3px;

        }
        body {
            background-color: #272a2d;
        }
    </style>
</head>
<body>
<header>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <h5 class="my-0 mr-md-auto font-weight-normal">Cars store </h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <#if role == 'ADMIN'>
                <a class="p-2 text-dark" href="/addCar">Add Car</a>
            </#if>
            <#if role == 'ADMIN'>
                <a class="p-2 text-dark" href="/users">Users</a>
            </#if>
            <a class="p-2 text-dark" href="/profile">Profile</a>
            <a class="p-2 text-blue" href="/logout">Logout</a>
        </nav>
    </div>
</header>

<div class="container">
    <div class="card-deck row mb-3 text-center">
        <#list carsList as car>
            <div class="col-md-3 mb-4">
                <div class="card box-shadow">
                    <div class="card-header">
                        <img src="data:image/jpeg;base64,${car.image}" alt="Car Image" style="width:100%; height:200px;">
                        <form action="/cars/delete/${car.id}" method="get">
                            <#if role == 'ADMIN'>
                                <button class="delete-button">🗑</button>
                            </#if>
                        </form>

                        <form action="/cars/update/${car.id}" method="get">
                            <#if role == 'ADMIN'>
                                <button class="change-button">✍</button>
                            </#if>
                        </form>
                    </div>

                    <div class="card-body">
                        <h5 class="card-title">Model: ${car.model}</h5>
                        <p class="card-text">Name: ${car.name}</p>
                        <p class="card-text">Color: ${car.color}</p>
                        <a href="/cars/${car.id}"> Подробнее </a>
                    </div>

                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>
