<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Canción</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h1>Editar Canción: ${cancion.titulo}</h1>

    <form:form action="/canciones/procesa/editar/${cancion.id}" method="post" modelAttribute="cancion">
        
        <div class="form-group">
            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo"/>
            <form:errors path="titulo" class="error"/>
        </div>

        <div class="form-group">
            <form:label path="artista">Artista:</form:label>
            <form:input path="artista"/>
            <form:errors path="artista" class="error"/>
        </div>

        <div class="form-group">
            <form:label path="album">Álbum:</form:label>
            <form:input path="album"/>
            <form:errors path="album" class="error"/>
        </div>

        <div class="form-group">
            <form:label path="genero">Género:</form:label>
            <form:input path="genero"/>
            <form:errors path="genero" class="error"/>
        </div>

        <div class="form-group">
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma"/>
            <form:errors path="idioma" class="error"/>
        </div>

        <input type="submit" value="Actualizar Canción" class="btn"/>
    </form:form>

    <br>
    <a href="/canciones" class="btn">Volver a lista de canciones</a>
</body>
</html>