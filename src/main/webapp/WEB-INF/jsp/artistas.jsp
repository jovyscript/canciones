<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Artistas</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<div class="container">
        <h1>🎤 Artistas</h1>
        <ul style="list-style-type: none; padding: 0;">
            <c:forEach items="${artistas}" var="artista">
                <li style="margin: 10px 0; background: #f9f9f9; padding: 10px; border-radius: 5px;">
                    <a href="/artistas/detalle/${artista.id}" style="text-decoration: none; color: #333; font-weight: bold;">
                        ${artista.nombre} ${artista.apellido}
                    </a>
                </li>
            </c:forEach>
        </ul>
        
        <div style="text-align: center; margin-top: 20px;">
            <a href="/artistas/formulario/agregar" class="btn">Agregar Nuevo Artista</a>
            <a href="/canciones" class="btn">Ir a Canciones</a>
        </div>
    </div>
</body>
</html>