<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Canciones</title>
</head>
<body>
<h1>Todas las Canciones</h1>
    
    <table>
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
                <td><c:out value="${cancion.artista}"/></td>
                <td>
                    <a href="/canciones/detalle/${cancion.id}">Detalle</a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/canciones/formulario/agregar">
        <button>Agregar Nueva Canción</button>
    </a>
</body>
</html>