<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Artista</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<div class="container">
        <c:if test="${not empty artista}">
            <h1>${artista.nombre} ${artista.apellido}</h1>
            <p><strong>Biografía:</strong> ${artista.biografia}</p>
            
            <hr>
            <h3>Canciones Compuestas:</h3>
            
            <table class="styled-table">
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Álbum</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${artista.canciones}" var="cancion">
                        <tr>
                            <td>${cancion.titulo}</td>
                            <td>${cancion.album}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <c:if test="${empty artista}">
            <p class="error">No se encontró el artista.</p>
        </c:if>

        <div style="margin-top: 20px; text-align: center;">
            <a href="/artistas" class="btn">Volver a lista de artistas</a>
        </div>
    </div>
</body>
</html>