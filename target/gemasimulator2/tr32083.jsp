<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="header.jsp"/>
<script>
    $(document).ready(function() {      
		
	  
	  
	} ); //.ready()
    
	function execute(accion) {
		$('#command').val(accion);
	}
</script>
</head>

<body>
<div class="container">
    <jsp:include page="navbars.jsp"/>
	<h3>Baja servicio DCC</h3>
	<c:url var="url0" value="/index.jsp" />
	<a href="${url0}">Ir a Menu</a>

	<c:url var="url" value="/dispatcher/bajaservdcc/procesar" />
	<form action="${url}" method="post">
		<table border="1">
			<tr>
				<td>NUM-COMERCIO</td>
				<td><input type="text" id="c01" name="c01"	maxlength="10" value="${respuesta.c01}"></td>
			</tr>
			<tr>
				<td>BANCO</td>
				<td><input type="text" id="c02" name="c02"	maxlength="4" value="${respuesta.c02}">
				</td>
			</tr>
			<tr>
				<td>SUCURSAL</td>
				<td><input type="text" id="c03" name="c03" maxlength="4" value="${respuesta.c03}"></td>
			</tr>
			<tr>
				<td>CONDICIONES</td>
				<td><input type="text" id="c04" name="c04"	maxlength="1" value="${respuesta.c04}">
				</td>
			</tr>
			<tr>
				<td>VALOR-INCREMENTAL</td>
				<td><input type="text" id="c05" name="c05" maxlength="4" value="${respuesta.c05}"></td>
			</tr>
			<tr>
				<td>TECLA-VISA</td>
				<td><input type="text" id="c06" name="c06" value="${respuesta.c06}" size="1" maxlength="1"></td>
			</tr>
			<tr>
				<td>PORCENTUAL-VISA</td>
				<td><input type="text" id="c07" name="c07" value="${respuesta.c07}" size="4" maxlength="4"></td>
			</tr>
			<tr>
				<td>FEC-CAMB-VISA</td>
				<td><input type="text" id="c08" name="c08" value="${respuesta.c08}" size="8" maxlength="8"></td>
			</tr>
			<tr>
				<td>TECLA-MAST</td>
				<td><input type="text" id="c09" name="c09" value="${respuesta.c09}" size="1" maxlength="1"></td>
			</tr>
			<tr>
				<td>PORCENTUAL-MAST</td>
				<td><input type="text" id="c10" name="c10" value="${respuesta.c10}" size="4" maxlength="4"></td>
			</tr>
			<tr>
				<td>FEC-CAMB-MAST</td>
				<td><input type="text" id="c11" name="c11" value="${respuesta.c11}" size="8" maxlength="8"></td>
			</tr>
		</table>
		<input type="submit" value="Procesar">
	</form>
	
	<hr>
	<h2>Codigo Respuesta : ${respuesta.codRespuesta}</h2>
	
	<c:url var="url2" value="/dispatcher/bajaservdcc?fila=" />
	<c:set var="numFila" value="0"/>
	<table border="1">
    	<c:forEach var="rows" items="${transactionsLoad.listTR32083}">
			<tr>
			  <td><a href="${url2}${rows.c1}">${numFila}</a></td>
			  <td>${rows.c1}</td>
			</tr>											
		</c:forEach>
	</table>	
	</div>
</body>
</html>