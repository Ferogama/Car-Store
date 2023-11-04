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
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal">Добавление машины</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/cars">Catalog</a>
    </nav>
</div>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="/addCar" method="post" enctype="multipart/form-data">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                <div class="form-group">
                    <label for="color">Color</label>
                    <select name="color" class="form-control" id="color">
                        <option value="Red" style="color: red;">Red</option>
                        <option value="Blue" style="color: blue;">Blue</option>
                        <option value="Green" style="color: green;">Green</option>
                        <option value="Green" style="color: yellow;">Yellow</option>
                        <option value="Green" style="color: orange;">Orange</option>
                        <option value="Green" style="color: black;">Black</option>
                        <option value="White" style="color: white; background-color: black;">White</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="Model">Model </label>
                    <input name="Model" type="model" class="form-control" id="model" placeholder="Enter model of car">
                </div>

                <div class="form-group">
                    <label for="nameInput">Name</label>
                    <input name="Name" type="name" class="form-control" id="name" placeholder="Enter name of car">
                </div>

                <div class="form-group">
                    <label for="image">Image</label>
                    <input name="file" type="file" class="form-control-file" id="image">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add Car</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>