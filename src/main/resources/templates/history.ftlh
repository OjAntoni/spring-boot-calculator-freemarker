<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>History</title>
</head>
<body>
<a href="/">Go home</a>
<ul>
    <#list userOperations as singleOperation>
        <li>${singleOperation}</li>
    </#list>
</ul>
</body>
</html>