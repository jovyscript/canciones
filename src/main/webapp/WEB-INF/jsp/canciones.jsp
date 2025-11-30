<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Canciones</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class= "container">
	<h1>🎤 Todas las Canciones</h1>
    
    <table class="styled-table">
        <thead>
            <tr>
                <th>Título</th>
                <th>Artista</th>
                <th>Acción</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${canciones}" var="cancion">
            <tr>
                <td><c:out value="${cancion.titulo}"/></td>
                <td><c:out value="${cancion.artista.nombre}"/> <c:out value="${cancion.artista.apellido}"/></td>
                <td>
                    <a href="/canciones/detalle/${cancion.id}" class="btn">Detalle</a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
		<div style="text-align: center;">
            <a href="/canciones/formulario/agregar" class="btn">Agregar Nueva Canción</a>
        </div>
        <div style="text-align: center; margin-top: 10px;">
    		<a href="/artistas" class="btn-secundario">Ir a Artistas</a>
		</div>
</div>    
</body>
</html>