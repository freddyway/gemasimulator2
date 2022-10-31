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
	<h3>Consulta de Cuenta Domiciliacion (31531)</h3>
	
	<c:url var="url0" value="/index.jsp" />
	<c:url var="url" value="/consulcuenta" />
	
	
	<form action="${url}" method="post" class="cssform">
		<jsp:include page="botones.jsp"/>
	    <input type="hidden" id="command" name="command">
	    
	    
		<table class="table table-bordered table-condensed">
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
		</table>
		
	</form>
	
	
	<c:if test="${not empty respuesta.codRespuesta}">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:choose>
					<c:when test="${respuesta.codRespuesta == '0000'}">
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
			</div>
		</div>		
	</c:if>
	
	<c:if test="${not empty respuesta.codRespODIN}">
		<div class="panel panel-default">
			<div class="panel-body">
					<c:choose>
					<c:when test="${respuesta.codRespODIN == '0000'}">
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

	<c:if test="${not empty respuesta.codRespJPA}">
		<div class="panel panel-default">
			<div class="panel-body">
						<div class="alert alert-success">
							<strong>Codigo Respuesta JPA:</strong> ${respuesta.codRespJPA}
						</div>
			
				</div>
		</div>		
	</c:if>
	
	<c:if test="${not empty respuesta.listTR31531}">
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<tr style="background-color: #dcdcdc">
						<th>#</th>
						<th>C12</th>
						<th>C13</th>
						<th>C20</th>
						<th>C21</th>
						<th>C34</th>
						<th>C36</th>
						<th>C37</th>
						<th>C38</th>
						<th>C39</th>
						<th>C41</th>
						<th>C42</th>						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rows" items="${respuesta.listTR31531}">
						<tr>
							<td><a href="${url2}${rows.id}">${rows.id}</a></td>
							<td>${rows.c12}</td>
							<td>${rows.c13}</td>
							<td>${rows.c20}</td>
							<td>${rows.c21}</td>
							<td>${rows.c34}</td>
							<td>${rows.c36}</td>
							<td>${rows.c37}</td>
							<td>${rows.c38}</td>
							<td>${rows.c39}</td>
							<td>${rows.c41}</td>
							<td>${rows.c42}</td>						
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
 </div>	
</body>
</html>