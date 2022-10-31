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

	<h3>Consulta de Comercio (31502)</h3>
	
	<c:url var="url0" value="/index.jsp" />
	<c:url var="url" value="/consulcomercio" />
	
	
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
			<tr>
			    <td><strong>C01</strong></td>
				<td class="warning">NOMBRE-COMERCIO</td>
				<td><input type="text" id="c02" name="c02" value="${respuesta.c02}" size="25" maxlength="25"></td>
			</tr>
			<tr>
			    <td><strong>C02</strong></td>
				<td class="warning">CODIGO-INTEGRACION</td>
				<td><input type="text" id="c03" name="c03" value="${respuesta.c03}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C03</strong></td>
				<td class="warning">TIPO-COMER-SUC</td>
				<td><input type="text" id="c04" name="c04" value="${respuesta.c04}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C04</strong></td>
				<td class="warning">COD-ACTIVIDAD</td>
				<td><input type="text" id="c05" name="c05" value="${respuesta.c05}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C05</strong></td>
				<td class="warning">DIRECCION</td>
				<td><input type="text" id="c06" name="c06" value="${respuesta.c06}" size="40" maxlength="40"></td>
			</tr>
			<tr>
			    <td><strong>C06</strong></td>
				<td class="warning">CODIGO-POSTAL</td>
				<td><input type="text" id="c07" name="c07" value="${respuesta.c07}" size="5" maxlength="5"></td>
			</tr>
			<tr>
			    <td><strong>C07</strong></td>
				<td class="warning">COD-LOCALIDAD</td>
				<td><input type="text" id="c08" name="c08" value="${respuesta.c08}" size="3" maxlength="3"></td>
			</tr>
			<tr>
			    <td><strong>C08</strong></td>
				<td class="warning">LOCALIDAD</td>
				<td><input type="text" id="c09" name="c09" value="${respuesta.c09}" size="13" maxlength="13"></td>
			</tr>
			<tr>
			    <td><strong>C09</strong></td>
				<td class="warning">TIPO-COMERCIO</td>
				<td><input type="text" id="c10" name="c10" value="${respuesta.c10}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C10</strong></td>
				<td class="warning">NUM-TELEFONO</td>
				<td><input type="text" id="c11" name="c11" value="${respuesta.c11}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C11</strong></td>
				<td class="warning">BANCO-CONTRATANTE</td>
				<td><input type="text" id="c12" name="c12" value="${respuesta.c12}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C12</strong></td>
				<td class="warning">SUC-CONTRATANTE</td>
				<td><input type="text" id="c13" name="c13" value="${respuesta.c13}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C13</strong></td>
				<td class="warning">NUM-IMPRINTER</td>
				<td><input type="text" id="c14" name="c14" value="${respuesta.c14}" size="2" maxlength="2"></td>
			</tr>
			<tr>
			    <td><strong>C14</strong></td>
				<td class="warning">LIMITE-CONSULTA</td>
				<td><input type="text" id="c15" name="c15" value="${respuesta.c15}" size="6" maxlength="6"></td>
			</tr>
			<tr>
			    <td><strong>C15</strong></td>
				<td class="warning">LIMITE-ORO</td>
				<td><input type="text" id="c16" name="c16" value="${respuesta.c16}" size="6" maxlength="6"></td>
			</tr>
			<tr>
			    <td><strong>C16</strong></td>
				<td class="warning">LIMITE-CONSULTA-EUROS</td>
				<td><input type="text" id="c17" name="c17" value="${respuesta.c17}" size="6" maxlength="6"></td>
			</tr>							
			<tr>
			    <td><strong>C17</strong></td>
				<td class="warning">LIMITE-ORO-EUROS</td>
				<td><input type="text" id="c18" name="c18" value="${respuesta.c18}" size="6" maxlength="6"></td>
			</tr>							
			<tr>
			    <td><strong>C18</strong></td>
				<td class="warning">SUPERVISOR</td>
				<td><input type="text" id="c19" name="c19" value="${respuesta.c19}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C19</strong></td>
				<td class="warning">TIPO-DOC</td>
				<td><input type="text" id="c20" name="c20" value="${respuesta.c20}" size="2" maxlength="2"></td>
			</tr>
			<tr>
			    <td><strong>C20</strong></td>
				<td class="warning">NUM-DOC</td>
				<td><input type="text" id="c21" name="c21" value="${respuesta.c21}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C21</strong></td>
				<td class="warning">AFINIDAD</td>
				<td><input type="text" id="c22" name="c22" value="${respuesta.c22}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C22</strong></td>
				<td class="warning">CAE</td>
				<td><input type="text" id="c23" name="c23" value="${respuesta.c23}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C23</strong></td>
				<td class="warning">IAE</td>
				<td><input type="text" id="c24" name="c24" value="${respuesta.c24}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C24</strong></td>
				<td class="warning">FECHA-CONTRATO</td>
				<td><input type="text" id="c25" name="c25" value="${respuesta.c25}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C25</strong></td>
				<td class="warning">SERVICIO-DCC</td>
				<td><input type="text" id="c26" name="c26" value="${respuesta.c26}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C26</strong></td>
				<td class="warning">FECHA-ALTA-DCC</td>
				<td><input type="text" id="c27" name="c27" value="${respuesta.c27}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C27</strong></td>
				<td class="warning">CAE-AET</td>
				<td><input type="text" id="c28" name="c28" value="${respuesta.c28}" size="13" maxlength="13"></td>
			</tr>
			<tr>
			    <td><strong>C28</strong></td>
				<td class="warning">TELEFONO-AUX</td>
				<td><input type="text" id="c29" name="c29" value="${respuesta.c29}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C29</strong></td>
				<td class="warning">HORARIO-CONTACTO</td>
				<td><input type="text" id="c30" name="c30" value="${respuesta.c30}" size="1" maxlength="1"></td>
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
	
	<c:if test="${not empty respuesta.listTR31500}">
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
					<c:forEach var="rows" items="${respuesta.listTR31500}">
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