<%-- 
    Document   : index
    Created on : Jan 23, 2018, 11:47:40 AM
    Author     : sarayar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>
        <h1>Sitio Weno</h1>
        <c:if test="${not empty sessionScope.usuario}">
            <%@include file="menu.jsp" %>
        </c:if>
