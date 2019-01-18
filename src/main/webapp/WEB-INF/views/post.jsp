<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label>
        Title: <input name="title" type="text">
    </label>
    <br/>
    <label>
        Start date: <input name="startDate" type="text">
    </label>
    <br/>
    <label>
        Term: <select name="term">
        <option value="FULL_TIME">Full-time</option>
        <option value="PART_TIME">Part-time</option>
        <option value="REMOTE">Remote</option>
    </select>
    </label>
    <br/>
    <label>
        Location: <input name="location" type="text">
    </label>
    <br/>
    <label>
        Job description: <input name="jobDescription" type="text">
    </label>
    <br/>
    <label>
        Job responsibilities: <input name="jobResponsibilities" type="text">
    </label>
    <br/>
    <label>
        Required qualifications: <input name="requiredQualifications" type="text">
    </label>
    <br/>
    <label>
        Enabled: <input type="checkbox" name="enabled">
    </label>
    <br/>
    <input type="submit" value="Post job announcement">
</form>
</body>
</html>