<%-- 
    Document   : editnote
    Created on : 1-Oct-2021, 9:05:58 PM
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
        <h2>Edit Note</h2>
        <form method="POST" action="note">
        <h3>Title: </h3> <input type="text" name="edit_title" value="${note.title}" >
        <br>
        <h3>Contents: </h3> <textarea  name="edit_contents" rows="5" cols="16" placeholder="${note.content}"></textarea>
        <br>
        <input type="submit" value="Save">
        </form>

    </body>
</html>
