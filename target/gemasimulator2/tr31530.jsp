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
	<h3>Alta de Cuenta de Domiciliacion</h3>
	
	<c:url var="url0" value="/index.jsp" />
	<c:url var="url" value="/altacuenta" />
	
	
	<form action="${url}" method="post" class="cssform">
	    <jsp:include page="botones.jsp"/>
	    
	    <input type="hidden" id="command" name="command">
	    
	    <c:if test="${param.command == 'fila' || param.command == 'new'}">
		<table class="table table-bordered table-condensed">
			<tr>
			    <td><strong>#</strong></td>
				<td class="info">ID</td>
				<td><input type="text" id="id" name="id" value="${respuesta.id}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>*</strong></td>
				<td class="info">ENTIDAD</td>
				<td><input type="text" id="entidad" name="entidad" value="${respuesta.entidad}" size="4" maxlength="4"></td>
			</tr>	
			<tr>
			    <td><strong>*</strong></td>
				<td class="info">VERSION</td>
				<td><input type="text" id="version" name="version" value="${respuesta.version}" size="4" maxlength="4"></td>
			</tr>		
			<tr>
			    <td><strong>C00</strong></td>
				<td class="warning">NUM-COMERCIO</td>
				<td><input type="text" id="c01" name="c01" value="${respuesta.c01}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C01</strong></td>
				<td class="warning">BANCO-CONTRATANTE</td>
				<td><input type="text" id="c02" name="c02" value="${respuesta.c02}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C02</strong></td>
				<td class="warning">SUCURSAL-CONTRATANTE</td>
				<td><input type="text" id="c03" name="c03" value="${respuesta.c03}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C03</strong></td>
				<td class="warning">CHECK-CUENTA</td>
				<td><input type="text" id="c04" name="c04" value="${respuesta.c04}" size="2" maxlength="2"></td>
			</tr>
			<tr>
			    <td><strong>C04</strong></td>
				<td class="warning">NUM-CUENTA</td>
				<td><input type="text" id="c05" name="c05" value="${respuesta.c05}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C05</strong></td>
				<td class="warning">CONDICIONES-ABONO</td>
				<td><input type="text" id="c06" name="c06" value="${respuesta.c06}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C06</strong></td>
				<td class="warning">MÁXIMO-IMPORTE</td>
				<td><input type="text" id="c07" name="c07" value="${respuesta.c07}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C07</strong></td>
				<td class="warning">IMPORTE-AVISO-BANCO</td>
				<td><input type="text" id="c08" name="c08" value="${respuesta.c08}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C08</strong></td>
				<td class="warning">CÓDIGO-MONEDA</td>
				<td><input type="text" id="c09" name="c09" value="${respuesta.c09}" size="3" maxlength="3"></td>
			</tr>
			<tr>
			    <td><strong>C09</strong></td>
				<td class="warning">BANCO-ADQUIRIENTE</td>
				<td><input type="text" id="c10" name="c10" value="${respuesta.c10}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C10</strong></td>
				<td class="warning">SUCURSAL-ADQUIRIENTE</td>
				<td><input type="text" id="c11" name="c11" value="${respuesta.c11}" size="4" maxlength="4"></td>
			</tr>
		</table>
		</c:if>
	</form>
	
	
	<c:if test="${not empty respuesta.codRespuesta}">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:choose>
					<c:when test="${respuesta.codRespuesta == '1092'}">
						<div class="alert alert-success">
							<strong>Codigo Respuesta TANDEM:</strong> ${respuesta.codRespuesta}
						</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-danger">
							<strong>Codigo Respuesta TANDEM:</strong> ${respuesta.codRespuesta}
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${respuesta.codRespODIN == '1092'}">
						<div class="alert alert-success">
							<strong>Codigo Respuesta ODIN:</strong> ${respuesta.codRespODIN}
						</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-danger">
							<strong>Codigo Respuesta ODIN :</strong> ${respuesta.codRespODIN}
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>		
	</c:if>
	
		<c:set var="url2" value="${url}?command=fila&rowid=" />
		<c:set var="url3" value="${url}?command=eliminar&rowid=" />
		<c:if test="${not empty respuesta.listTR31530}">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover table-condensed">
					<thead>
						<tr style="background-color: #dcdcdc">
							<th>#</th>
							<th>C01</th>
							<th>C02</th>
							<th>C03</th>
							<th>C04</th>
							<th>C05</th>
							<th>C06</th>
							<th>C07</th>
							<th>C08</th>
							<th>C09</th>
							<th>C10</th>
							<th>Commnand</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rows" items="${respuesta.listTR31530}">
							<tr>
								<td><a href="${url2}${rows.id}">${rows.id}</a></td>
								<td>${rows.c01}</td>
								<td>${rows.c02}</td>
								<td>${rows.c03}</td>
								<td>${rows.c04}</td>
								<td>${rows.c05}</td>
								<td>${rows.c06}</td>
								<td>${rows.c07}</td>
								<td>${rows.c08}</td>
								<td>${rows.c09}</td>
								<td>${rows.c10}</td>	
								<td>
									<a href="${url3}${rows.id}" class="btn btn-link btn-sm"> <span class="glyphicon glyphicon-erase"></span> Borrar</a>							
								</td>							
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
 </div>	
</body>
</html>