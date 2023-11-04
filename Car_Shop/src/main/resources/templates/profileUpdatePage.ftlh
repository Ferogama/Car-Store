<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile Update</title>
</head>
<body>
<h1>Update Profile</h1>
<form action="/update" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <label for="email">Current Email:</label>
    <input type="text" id="email" name="email" value="${user.email}" disabled>
    <br>
    <label for="newEmail">New Email:</label>
    <input type="email" id="newEmail" name="newEmail" required>
    <br>
    <label for="newPassword">New Password:</label>
    <input type="password" id="newPassword" name="newPassword" required>
    <br>
    <input type="hidden" name="id" value="${user.id}">
    <input type="submit" value="Update">
</form>
</body>
</html>
