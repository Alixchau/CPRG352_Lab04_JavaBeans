<%-- 
    Document   : viewnote
    Created on : 1-Oct-2021, 9:05:47 PM
    Author     : Alix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <h3>Title:</h3><p name="viewTitle"> ${note.title}</p>
        <br>
        <h3>Contents: </h3><p name="viewContent"> ${note.content}</p>
        <br>
        <a href="note?edit">Edit</a>
    </body>
</html>
