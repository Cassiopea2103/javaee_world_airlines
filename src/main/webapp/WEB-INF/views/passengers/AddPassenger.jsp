<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create a new passenger</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Create a new user</h1>
    <form action="PassengersController" method="post">
        <fieldset>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>


            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dateOfBirth" required><br><br>

            <label for="gender">Gender: </label>
            <select id="gender" name="gender">
                <option value="" disabled selected>Select your gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
            </select> <br><br>


            <label for="password">Password:</label>
            <input type="text" id="password" name="password" required><br><br>

        </fieldset>

        <hr/>
        <input type="submit" value="Create passenger">
    </form>

    <p><a href="<%= request.getContextPath() %>/PassengersController">Back to passengers list</a></p>
</div>
</body>
</html>