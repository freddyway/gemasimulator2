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
	<h3>(31534)Marcar prioridad a una cuenta de domiciliación</h3>
	
	<c:url var="url0" value="/index.jsp" />
	<c:url var="url" value="/cuentaprior" />
	
	
	<form action="${url}" method="post" class="cssform">
		<jsp:include page="botones.jsp"/>
	    <input type="hidden" id="command" name="command">
	    
	    <c:if test="${param.command == 'fila'}">
		<table class="table table-bordered table-condensed">
			<tr>
			    <td><strong>#</strong></td>
				<td class="info">ID</td>
				<td><input type="text" id="id" name="id" value="${respuesta.id}" size="10" maxlength="10"></td>
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
		</table>
		
		<div class="row">
			<div class='col-sm-2'>
				<div class="form-group">
					<div class='input-group date' id='datetimepicker2'>
						<input type='text' class="form-control" /> <span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				$(function() {
					$('#datetimepicker2').datetimepicker({
						locale : 'es',
						format: 'L'
					});
				});
			</script>
		</div>
    	</c:if>
	</form>
	
	
	<c:if test="${not empty respuesta.codRespuesta}">
		<div class="panel panel-default">
			<div class="panel-body">
				<c:choose>
					<c:when test="${respuesta.codRespuesta == '1094'}">
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
	
		<c:url var="url2" value="/cuentaprior?command=fila&rowid=" />
		<c:if test="${not empty respuesta.listTR31534}">
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
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rows" items="${respuesta.listTR31534}">
							<tr>
								<td><a href="${url2}${rows.id}">${rows.id}</a></td>
								<td>${rows.c01}</td>
								<td>${rows.c02}</td>
								<td>${rows.c03}</td>
								<td>${rows.c04}</td>
								<td>${rows.c05}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
 </div>	
</body>
</html>