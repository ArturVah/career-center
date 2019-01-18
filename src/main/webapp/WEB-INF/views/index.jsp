<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .titles {
            background-color: #FFFAA9;
            width: 30%;
            height: 100%;
            float: left;
        }

        .content {
            background-color: bisque;
            width: 70%;
            height: 100%;
            float: left;
        }

        .clear {
            clear: both;
        }
    </style>
</head>
<body>
<div class="titles">
    <c:forEach var="jobTitle" items="${jobTitles}">
        <a href="/jobs/${jobTitle.id}">${jobTitle.title}</a>
        <br/>
    </c:forEach>
</div>
<div class="content">

</div>
<div class="clear">
</div>
</body>
</html>
