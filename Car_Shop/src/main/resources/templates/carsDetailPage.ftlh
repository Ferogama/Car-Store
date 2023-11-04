<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/cars">Catalog</a>
        <a class="p-2 text-blue" href="/logout">Logout</a>
    </nav>
</div>
<div class="container">
    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body text-center">
                    <h3>Model: ${cars.model}</h3>
                    <p>Name: ${cars.name}</p>
                    <p>Color: ${cars.color}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="comment-section">
                <h5>Comments</h5>
                <ul>
                    <#list comments as comment>
                        <li>${comment.text}</li>
                        <#if role == 'ADMIN'>
                            <form action="/deleteComment/${comment.id}" method="get">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-primary">Delete comment</button>
                            </form>
                        </#if>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="comment-section">
                <h5>Add a Comment</h5>
                <form action="/addComment/${cars.id}" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <div class="form-group">
                        <input name="text" type="text" class="form-control" id="text" placeholder="Enter comment">
                    </div>
                    <button type="submit" class="btn btn-primary">Add comment</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
