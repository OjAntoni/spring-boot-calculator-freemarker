<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Calc</title>
</head>
<body>
<form action="/calc" method="post">
    Num1:<br>
    <@spring.formInput "operationDto.num1"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Num2:<br>
    <@spring.formInput "operationDto.num2"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    <@spring.formSingleSelect "operationDto.operationSign", operations, " " />
    <br>
    <input type="submit" value="Calculate">
    <br>
    <#if result??>
        <p>${result}</p>
    </#if>
    <a href="/home">Go Home</a>
</form>
</body>
</html>