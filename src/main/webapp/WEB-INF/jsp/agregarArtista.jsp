<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Artista</title>
<link rel="stylesheet" href="/css/styles.css">

</head>
<body>
    <div class="container">
        <h1>🎤 Agregar Nuevo Artista</h1>

        <form:form action="/artistas/procesa/agregar" method="post" modelAttribute="artista">
            
            <div class="form-group">
                <form:label path="nombre">Nombre:</form:label>
                <form:input path="nombre"/>
                <form:errors path="nombre" class="error"/>
            </div>

            <div class="form-group">
                <form:label path="apellido">Apellido:</form:label>
                <form:input path="apellido"/>
                <form:errors path="apellido" class="error"/>
            </div>

            <div class="form-group">
                <form:label path="biografia">Biografía:</form:label>
                <form:textarea path="biografia" rows="5" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px;"/>
                <form:errors path="biografia" class="error"/>
            </div>

            <input type="submit" value="Guardar Artista" class="btn"/>
        </form:form>

        <br>
        <div style="text-align: center;">
            <a href="/artistas" class="btn" style="background-color: #b2bec3; color: #333;">Volver a la lista</a>
        </div>

    </div>
</body>
</html>