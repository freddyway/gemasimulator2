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
		<c:url var="url0" value="/index.jsp" />
		<c:url var="url" value="/serviciodcc" />
		
		<div class="panel-group">
			<div class="panel panel-default">			    
				<div class="panel-heading">
                    <jsp:include page="navbars.jsp"/>
					<p>Marcar/Desmarcar Cuenta con Alta/Baja servicio DCC</p>
				</div>
				<div class="panel-body">
                    <c:if test="${param.command == 'fila'}">
					<form class="form-horizontal" action="${url}" method="post" id="form1" name="form1">
						<input type="hidden" id="command" name="command">
						<div class="panel panel-default">
							<div class="panel-body">
								 <jsp:include page="botones.jsp"/>				
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-body">
							    <div class="form-group form-group-sm">
							        <label class="control-label col-sm-4" for="id">#ID</label>
  									<div class="col-sm-2">
										<input type="text" class="form-control" id="id" name="id" maxlength="10" value="${respuesta.id}">
									</div>
								 </div>
								 
								 <div class="form-group form-group-sm">
									<label class="control-label col-sm-4" for="entidad">ENTIDAD</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="entidad" name="entidad" maxlength="4" value="${respuesta.entidad}">
									</div>
								  </div>
								 
								  <div class="form-group form-group-sm">
								    <label class="control-label col-sm-4" for="version">VERSION</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="version" name="version" maxlength="4" value="${respuesta.version}">
									</div>
							      </div>
								<div class="form-group form-group-sm">								    
									<label class="control-label col-sm-4" for="c01">NUM-COMERCIO.C00</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="c01" name="c01" maxlength="10" value="${respuesta.c01}">
									</div>
								</div>
								<div class="form-group form-group-sm">								    
									<label class="control-label col-sm-4" for="c02">BANCO.C01</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="c02" name="c02" maxlength="4" value="${respuesta.c02}">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-4" for="c03">SUCURSAL.C02</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="c03" name="c03" maxlength="4" value="${respuesta.c03}">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-4" for="c04">CHECK.C03</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="c04" name="c04" maxlength="2" value="${respuesta.c04}">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-4" for="c05">NUM-CUENTA.C04</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="c05" name="c05" maxlength="10" value="${respuesta.c05}">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-4" for="c06">CONDICIONES.C05</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="c06" name="c06" maxlength="2" value="${respuesta.c06}">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-4" for="c07">VALOR-INCREMENTAL.C06</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="c07" name="c07" maxlength="4" value="${respuesta.c07}">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-4" for="c08">SIGNO-AJUSTE-CAMBIO.C07</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="c08" name="c08" maxlength="1" value="${respuesta.c08}">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-4" for="c09">AJUSTE-CAMBIO-DCC.C08</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="c09" name="c09" maxlength="6" value="${respuesta.c09}">
									</div>
								</div>
							</div>
						</div>
					</form>
					</c:if>
				</div>
			</div>


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
<%-- 						<c:choose> --%>
<%-- 							<c:when test="${respuesta.codRespODIN == '1094'}"> --%>
<!-- 								<div class="alert alert-success"> -->
<%-- 									<strong>Codigo Respuesta ODIN:</strong> ${respuesta.codRespODIN} --%>
<!-- 								</div> -->
<%-- 							</c:when> --%>
<%-- 							<c:otherwise> --%>
<!-- 								<div class="alert alert-danger"> -->
<%-- 									<strong>Codigo Respuesta ODIN :</strong> ${respuesta.codRespODIN} --%>
<!-- 								</div> -->
<%-- 							</c:otherwise> --%>
<%-- 						</c:choose> --%>
					</div>
				</div>
			</c:if>

			<c:url var="url2" value="/serviciodcc?command=fila&rowid=" />

			<c:if test="${not empty respuesta.listTR32084}">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover table-condensed">
								<thead>
									<tr class="warning">
										<th>ID</th>
										<th>NUM-COMERCIO</th>
										<th>BANCO</th>
										<th>SUCURSAL</th>
										<th>CHECK</th>
										<th>NUM-CUENTA</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="rows" items="${respuesta.listTR32084}">
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
					</div>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>