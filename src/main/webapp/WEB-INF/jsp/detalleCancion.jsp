<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de Canción</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<div class="container">
        <h1>🎶 ${cancion.titulo}</h1>
        
        <p><strong>Artista:</strong> <c:out value="${cancion.artista.nombre} ${cancion.artista.apellido}"/></p>
        <p><strong>Álbum:</strong> <c:out value="${cancion.album}"/></p>
        <p><strong>Género:</strong> <c:out value="${cancion.genero}"/></p>
        <p><strong>Idioma:</strong> <c:out value="${cancion.idioma}"/></p>
        
        <hr>
        
        <p><strong>ID:</strong> <c:out value="${cancion.id}"/></p>
        <p><strong>Fecha de Creación:</strong> <fmt:formatDate value="${cancion.fechaCreacion}" pattern="dd/MM/yyyy HH:mm"/></p>
        <p><strong>Última Actualización:</strong> <fmt:formatDate value="${cancion.fechaActualizacion}" pattern="dd/MM/yyyy HH:mm"/></p>
        
        <hr>
        
        <p>
            <a href="/canciones/formulario/editar/${cancion.id}">
                <button class="btn">Editar esta canción</button>
            </a>
        </p>
        <form action="/canciones/eliminar/${cancion.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            
            <button type="submit" class="btn btn-danger">Eliminar Canción</button>
        </form>
        <p>
            <a href="/canciones" class="btn">Volver a lista de canciones</a>
        </p>
    </div>
</body>
</html>