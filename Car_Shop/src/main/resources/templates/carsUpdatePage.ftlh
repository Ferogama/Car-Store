<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>Add New Car</title>

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
<header>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <h5 class="my-0 mr-md-auto font-weight-normal">Update car </h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="/users">Users</a>
            <a class="p-2 text-blue" href="/cars">Catalog</a>
        </nav>
    </div>
</header>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="/updateCar" method="post" enctype="multipart/form-data">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="id" value="${car.id}"/>

                <div class="form-group">
                    <label for="color">Color</label>
                    <input name="color" type="text" class="form-control" id="color" value="${car.color}"
                           placeholder="Enter color of car">
                </div>

                <div class="form-group">
                    <label for="model">Model</label>
                    <input name="model" type="text" class="form-control" id="model" value="${car.model}"
                           placeholder="Enter model of car">
                </div>

                <div class="form-group">
                    <label for="name">Name</label>
                    <input name="name" type="text" class="form-control" id="name" value="${car.name}"
                           placeholder="Enter name of car">
                </div>

                <div class="form-group">
                    <label for="image">Изображение</label>
                    <input name="file" type="file" class="form-control-file" id="image">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Update Car</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>