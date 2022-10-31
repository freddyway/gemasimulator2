<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <jsp:useBean id="combosLoad" scope="session" class="es.redsys.configuracion.servlets.CombosLoad" /> --%>
<%-- <jsp:useBean id="transactionsLoad" scope="page"	class="es.redsys.configuracion.servlets.TransactionsLoad" /> --%>
<%-- <jsp:setProperty property="transac" name="transactionsLoad" value="31500"/> --%>

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

	<h3>Baja de Terminal (01083)</h3>
	
	<c:url var="url0" value="/index.jsp" />
	<c:url var="url" value="/bajaterminal" />
	<c:url var="url2" value="/bajaterminal?command=fila&rowid=" />
	
	<form action="${url}" method="post" class="form-horizontal">
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
			<tr>
			    <td><strong>C01</strong></td>
				<td class="warning">NUM-TERMINAL</td>
				<td><input type="text" id="c02" name="c02" value="${respuesta.c02}" size="2" maxlength="2"></td>
			</tr>
			<tr>
			    <td><strong>C02</strong></td>
				<td class="warning">BANCO</td>
				<td><input type="text" id="c03" name="c03" value="${respuesta.c03}" size="4" maxlength="4"></td>
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
	
	<c:if test="${not empty respuesta.listTR01083}">
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<tr style="background-color: #dcdcdc">
						<th>#</th>
						<th>C01</th>
						<th>C02</th>
						<th>C03</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rows" items="${respuesta.listTR01083}">
						<tr>
							<td><a href="${url2}${rows.id}">${rows.id}</a></td>
							<td>${rows.c01}</td>
							<td>${rows.c02}</td>
							<td>${rows.c03}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
 </div>	
</body>
</html>