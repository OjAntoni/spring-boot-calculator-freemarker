<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<p>Hello <span>
        <#if Session.user??>
            ${Session.user.name}
        </#if>
        </span></p>
<#if Session.user??>
    <a href="/calc">Calculate</a>
    <a href="/calc/history">History</a>
<#else>
    <a href="/user/reg">Registration</a>
    <a href="/user/auth">Authorization</a>
</#if>
</body>
</html>