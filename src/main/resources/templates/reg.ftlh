<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<form action="/user/reg" method="post">
    Name:<br>
    <@spring.formInput "newUser.name"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Username:<br>
    <@spring.formInput "newUser.username"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Password:<br>
    <@spring.formInput "newUser.password"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>