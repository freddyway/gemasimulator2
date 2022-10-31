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

	<h3>Modificacion de Descuentos (31522)</h3>
	
	<c:url var="url0" value="/index.jsp" />
	<c:url var="url" value="/modifdtos" />
	
	
	<form action="${url}" method="post" class="cssform">
		<jsp:include page="botones.jsp"/>
	    <input type="hidden" id="command" name="command">
	    
	    <c:if test="${param.command == 'fila' || param.command == 'new'}">
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
			<tr>
			    <td><strong>C01</strong></td>
				<td class="warning">BANCO</td>
				<td><input type="text" id="c02" name="c02" value="${respuesta.c02}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C02</strong></td>
				<td class="warning">SUCURSAL</td>
				<td><input type="text" id="c03" name="c03" value="${respuesta.c03}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C03</strong></td>
				<td class="warning">TECLA-4B</td>
				<td><input type="text" id="c04" name="c04" value="${respuesta.c04}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C04</strong></td>
				<td class="warning">DTO-PORCENTUAL-4B</td>
				<td><input type="text" id="c05" name="c05" value="${respuesta.c05}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C05</strong></td>
				<td class="warning">FECHA-CAMBIO-4B</td>
				<td><input type="text" id="c06" name="c06" value="${respuesta.c06}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C06</strong></td>
				<td class="warning">TECLA-4B</td>
				<td><input type="text" id="c07" name="c07" value="${respuesta.c07}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C07</strong></td>
				<td class="warning">DTO-PORCENTUAL-VISA</td>
				<td><input type="text" id="c08" name="c08" value="${respuesta.c08}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C08</strong></td>
				<td class="warning">FECHA-CAMBIO-VISA</td>
				<td><input type="text" id="c09" name="c09" value="${respuesta.c09}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C09</strong></td>
				<td class="warning">TECLA-OTRAS</td>
				<td><input type="text" id="c10" name="c10" value="${respuesta.c10}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C10</strong></td>
				<td class="warning">DTO-PORCENTUAL-OTRAS</td>
				<td><input type="text" id="c11" name="c11" value="${respuesta.c11}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C11</strong></td>
				<td class="warning">FECHA-CAMBIO-OTRAS</td>
				<td><input type="text" id="c12" name="c12" value="${respuesta.c12}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C12</strong></td>
				<td class="warning">TECLA-GASOLEO</td>
				<td><input type="text" id="c13" name="c13" value="${respuesta.c13}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C13</strong></td>
				<td class="warning">DTO-PORCENTUAL-GASOLEO</td>
				<td><input type="text" id="c14" name="c14" value="${respuesta.c14}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C14</strong></td>
				<td class="warning">FECHA-CAMBIO-GASOLEO</td>
				<td><input type="text" id="c15" name="c15" value="${respuesta.c15}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C15</strong></td>
				<td class="warning">TECLA-AFINIDAD</td>
				<td><input type="text" id="c16" name="c16" value="${respuesta.c16}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C16</strong></td>
				<td class="warning">DTO-PORCENTUAL-AFINIDAD</td>
				<td><input type="text" id="c17" name="c17" value="${respuesta.c17}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C17</strong></td>
				<td class="warning">FECHA-CAMBIO-AFINIDAD</td>
				<td><input type="text" id="c18" name="c18" value="${respuesta.c18}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C18</strong></td>
				<td class="warning">TECLA-MONEDERO</td>
				<td><input type="text" id="c19" name="c19" value="${respuesta.c19}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C19</strong></td>
				<td class="warning">DTO-PORCENTUAL-MONEDERO</td>
				<td><input type="text" id="c20" name="c20" value="${respuesta.c20}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C20</strong></td>
				<td class="warning">FECHA-CAMBIO-MONEDERO</td>
				<td><input type="text" id="c21" name="c21" value="${respuesta.c21}" size="8" maxlength="8"></td>
			</tr>
			
		</table>
		</c:if>
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
	
	
     	<c:set var="url2" value="${url}?command=fila&rowid=" />
		<c:set var="url3" value="${url}?command=eliminar&rowid=" />
		<c:if test="${not empty respuesta.listTR31522}">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover table-condensed">
					<thead>
						<tr style="background-color: #dcdcdc">
							<th>#</th>
							<th>C01</th>
							<th>C02</th>
							<th>C03</th>
							<th>Command</th>						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rows" items="${respuesta.listTR31522}">
							<tr>
								<td><a href="${url2}${rows.id}">${rows.id}</a></td>
								<td>${rows.c01}</td>
								<td>${rows.c02}</td>
								<td>${rows.c03}</td>
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