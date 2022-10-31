<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<jsp:include page="header.jsp"/>
<head>
<script>
    $(document).ready(function() {   
    
  
	} ); //.ready()
    
	function execute(accion) {
		$('#command').val(accion);
	}
	
	function enable(){
	
	}
</script>

<style type="text/css">
	.panel-footer.panel-custom {
	    background: #8db0ef;
	    color: white;
	}
		
	.control-label.control-label-sm{
		font-size: 10px;
	}
</style>

</head>
<body>
    
  <div class="container">
  	<jsp:include page="navbars.jsp"/>
  	
	<c:url var="url0" value="/index.jsp" />
	<c:url var="url" value="/altatarjeta" />
		
	<form action="${url}" method="post" class="form-horizontal">
	    <input type="hidden" id="command" name="command">
	    <jsp:include page="botones.jsp"/>    
	    
		<hr>
	    <c:if test="${param.command == 'fila'}">
		    <div class="panel panel-primary">
				    <div class="panel-heading">
				    	<h3 class="panel-title">Alta de Tarjeta (31390)</h3>
				    </div>
				    <div class="panel-body" style="background-color: #f3fafe;">
				        
					    <div class="form-group form-group-sm row">
							<label for="id" class="col-sm-1 control-label">ID</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="id" name="id" value="${respuesta.id}" readonly="readonly">
							</div>
							<label for="entidad" class="col-sm-1 control-label">ENTIDAD</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="entidad" name="entidad" value="${respuesta.entidad}" >
							</div>
							<label for="version" class="col-sm-1 control-label">VERSION</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="version" name="version" value="${respuesta.version}">
							</div>
						</div>			
									
					    <div class="form-group form-group-sm row">
							<label for="c01" class="col-sm-1 control-label">Pan</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c01" name="c01" value="${respuesta.c01}" maxlength="19">
							</div>
							
							<label for="c02" class="col-sm-1 control-label">Fecha.Val</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c02" name="c02" value="${respuesta.c02}" maxlength="6">
							</div>
							
							<label for="c03" class="col-sm-1 control-label">Fecha.Caduc</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c03" name="c03" value="${respuesta.c03}" maxlength="6">
							</div>
						</div>						

					    <div class="form-group form-group-sm row">
							<label for="c04" class="col-sm-1 control-label">Riesgo</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c04" name="c04" value="${respuesta.c04}" maxlength="109">
							</div>
							
							<label for="c05" class="col-sm-1 control-label">tipo.Doc</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c05" name="c05" value="${respuesta.c05}" maxlength="2">
							</div>
							
							<label for="c06" class="col-sm-1 control-label">Num.Docu</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c06" name="c06" value="${respuesta.c06}" maxlength="9">
							</div>
						</div>						

					    <div class="form-group form-group-sm row">
							<label for="c07" class="col-sm-1 control-label">Per.Riesgo</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c07" name="c07" value="${respuesta.c07}" maxlength="1">
							</div>
							
							<label for="c08" class="col-sm-1 control-label">Sucur</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c08" name="c08" value="${respuesta.c08}" maxlength="4">
							</div>
							
							<label for="c09" class="col-sm-1 control-label">Ind.Estam</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c09" name="c09" value="${respuesta.c09}" maxlength="1">
							</div>
						</div>						

					    <div class="form-group form-group-sm row">
							<label for="c10" class="col-sm-1 control-label">Tipo.Produ</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c10" name="c10" value="${respuesta.c10}" maxlength="2">
							</div>
							
							<label for="c11" class="col-sm-1 control-label">Matri1</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c11" name="c11" value="${respuesta.c11}" maxlength="8">
							</div>
							
							<label for="c12" class="col-sm-1 control-label">Control.P3</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c12" name="c12" value="${respuesta.c12}" maxlength="16">
							</div>
						</div>		
										
					    <div class="form-group form-group-sm row">
							<label for="c13" class="col-sm-1 control-label">Control.PinP1</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c13" name="c13" value="${respuesta.c13}" maxlength="16">
							</div>
							
							<label for="c14" class="col-sm-1 control-label">Control.P1</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c14" name="c14" value="${respuesta.c14}" maxlength="16">
							</div>
							
							<label for="c15" class="col-sm-1 control-label">Clv.Cifrado</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c15" name="c15" value="${respuesta.c15}" maxlength="6">
							</div>
						</div>
												
					    <div class="form-group form-group-sm row">
							<label for="c16" class="col-sm-1 control-label">Pvv.Cifrado</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c16" name="c16" value="${respuesta.c16}" maxlength="4">
							</div>
							
							<label for="c17" class="col-sm-1 control-label">Pais.Tar</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c17" name="c17" value="${respuesta.c17}" maxlength="3">
							</div>
							
							<label for="c18" class="col-sm-1 control-label">Mone.Tar</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c18" name="c18" value="${respuesta.c18}" maxlength="3">
							</div>
						</div>
												
					    <div class="form-group form-group-sm row">
							<label for="c19" class="col-sm-1 control-label">Perfil.Comi</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c19" name="c19" value="${respuesta.c19}" maxlength="8">
							</div>
							
							<label for="c20" class="col-sm-1 control-label">Ind.Empresa</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c20" name="c20" value="${respuesta.c20}" maxlength="1">
							</div>
							
							<label for="c21" class="col-sm-1 control-label">Med.Emerg</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c21" name="c21" value="${respuesta.c21}" maxlength="7">
							</div>
						</div>
												
					    <div class="form-group form-group-sm row">
							<label for="c22" class="col-sm-1 control-label">Lim.Dia.Atm</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c22" name="c22" value="${respuesta.c22}" maxlength="7">
							</div>
							
							<label for="c23" class="col-sm-1 control-label">Ctas.Aso</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c23" name="c23" value="${respuesta.c23}" maxlength="1">
							</div>
							
							<label for="c24" class="col-sm-1 control-label">Cod.Idioma</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c24" name="c24" value="${respuesta.c24}" maxlength="1">
							</div>
						</div>						

					    <div class="form-group form-group-sm row">
							<label for="c25" class="col-sm-1 control-label">Lim.Dia.NoAtm</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c25" name="c25" value="${respuesta.c25}" maxlength="7">
							</div>
							
							<label for="c26" class="col-sm-1 control-label">Ind.Monedero</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c26" name="c26" value="${respuesta.c26}" maxlength="1">
							</div>
							
							<label for="c27" class="col-sm-1 control-label">Tipo.Moneda</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c27" name="c27" value="${respuesta.c27}" maxlength="3">
							</div>
						</div>
												
					    <div class="form-group form-group-sm row">
							<label for="c28" class="col-sm-1 control-label">Cod.Serv</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c28" name="c28" value="${respuesta.c28}" maxlength="3">
							</div>
							
							<label for="c29" class="col-sm-1 control-label">Tecno</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c29" name="c29" value="${respuesta.c29}" maxlength="1">
							</div>
							
							<label for="c30" class="col-sm-1 control-label">Forma.Carga</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c30" name="c30" value="${respuesta.c30}" maxlength="1">
							</div>
						</div>		
										
					    <div class="form-group form-group-sm row">
							<label for="c31" class="col-sm-1 control-label">Ind.Activa</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c31" name="c31" value="${respuesta.c31}" maxlength="1">
							</div>
							
							<label for="c32" class="col-sm-1 control-label">Uso.Normal</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c32" name="c32" value="${respuesta.c32}" maxlength="3">
							</div>
							
							<label for="c33" class="col-sm-1 control-label">Tipo.Saldo.Priv</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c33" name="c33" value="${respuesta.c33}" maxlength="1">
							</div>
						</div>
												
					    <div class="form-group form-group-sm row">
							<label for="c34" class="col-sm-1 control-label">Riesgo.Priv</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c34" name="c34" value="${respuesta.c34}" maxlength="10">
							</div>
							
							<label for="c35" class="col-sm-1 control-label">Banco</label>
							<div class="col-sm-2">
								<input class="form-control" type="text" id="c35" name="c35" value="${respuesta.c35}" maxlength="4">
							</div>							
						</div>						
												
				    </div>
				    
				    <div class="panel-footer panel-custom">
						Redsys 2020 &copy;
					</div>				    
		    </div>
	    
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
	
	<c:url var="url2" value="/altatarjeta?command=fila&rowid=" />
	<c:url var="url3" value="/altatarjeta?command=eliminar&rowid=" />
	<c:if test="${not empty respuesta.listTR31390}">
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<tr style="background-color: #dcdcdc">
						<th>#</th>
						<th>C01</th>
						<th>C02</th>
						<th>C03</th>
						<th>C05</th>
						<th>C06</th>
						<th>Command</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rows" items="${respuesta.listTR31390}">
						<tr>
							<td><a href="${url2}${rows.id}">${rows.id}</a></td>
							<td>${rows.c01}</td>
							<td>${rows.c02}</td>
							<td>${rows.c03}</td>
							<td>${rows.c05}</td>
							<td>${rows.c06}</td>
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