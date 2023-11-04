<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        header {
            background-color: #50c878;
            color: white;
        }
        body {
            background-color: #272a2d;
            color: white;
        }
    </style>
</head>
<body>
<header>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-black border-bottom box-shadow navbar">
        <h5 class="my-0 mr-md-auto font-weight-normal">Profile</h5>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-white" href="/cars">Catalog</a>
            <a class="p-2 text-white" href="/logout">Logout</a>
        </nav>
    </div>
</header>
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
    <div role="main" class="inner cover">
        <p>ID: ${id}</p>
        <p>EMAIL: ${email}</p>
        <p>ROLE: ${role}</p>
    </div>
    <form action="" method="get">
        <button>Изменить</button>
    </form>
</div>
</body>
</html>
