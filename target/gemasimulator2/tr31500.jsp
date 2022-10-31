<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<jsp:include page="header.jsp"/>
<head>
<script>
    $(document).ready(function() {   
    
      $.datepicker.setDefaults( $.datepicker.regional[ "es" ] );
      	   
   	  $('#c33').datepicker({
    	dateFormat: 'yymmdd',
    	minDate: '-0d',
    	maxDate: '+1d',
    	showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true,
		buttonText: "Elige fecha",
		showAnim: "slide"    	
		});
		
	  $('#c33').click(function() {
	    $('#c33').select();
	  });
	  	
	  $('#c35').datepicker({
    	dateFormat: 'yymmdd',
    	minDate: '-1d',
    	showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true,
		buttonText: "Elige fecha"  
		});
		
	  $('#c35').click(function() {
	    $('#c35').select();
	  });
	
// 	  if($('#grabar').val() != '')
// 	  	$('#grabar').prop('disabled', false);
// 	  else
// 	    $('#grabar').prop('disabled', true);
	  
// 	  $('#consulta').on('click',function() {
// 		 $('#grabar').removeAttr('disabled');
// 	  });

	} ); //.ready()
    
	function execute(accion) {
		$('#command').val(accion);
	}
	
	function enable(){
	
	}
</script>
</head>
<body>
    
  <div class="container">
  	<jsp:include page="navbars.jsp"/>
	<h3>Alta de Comercio (31500)</h3>
	
	<c:url var="url0" value="/index.jsp" />
	<c:url var="url" value="/altacomercio" />
	
	
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
				<td class="warning">SUPERVISOR</td>
				<td><input type="text" id="c15" name="c15" value="${respuesta.c15}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C15</strong></td>
				<td class="warning">TIPO-DOC</td>
				<td><input type="text" id="c16" name="c16" value="${respuesta.c16}" size="2" maxlength="2"></td>
			</tr>
			<tr>
			    <td><strong>C16</strong></td>
				<td class="warning">NUM-DOC</td>
				<td><input type="text" id="c17" name="c17" value="${respuesta.c17}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C17</strong></td>
				<td class="warning">AFINIDAD</td>
				<td><input type="text" id="c18" name="c18" value="${respuesta.c18}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C18</strong></td>
				<td class="warning">CAE</td>
				<td><input type="text" id="c19" name="c19" value="${respuesta.c19}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C19</strong></td>
				<td class="warning">CHECK-CTA</td>
				<td><input type="text" id="c20" name="c20" value="${respuesta.c20}" size="2" maxlength="2"></td>
			</tr>
			<tr>
			    <td><strong>C20</strong></td>
				<td class="warning">NUM-CUENTA</td>
				<td><input type="text" id="c21" name="c21" value="${respuesta.c21}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C21</strong></td>
				<td class="warning">TECLA-4B</td>
				<td><input type="text" id="c22" name="c22" value="${respuesta.c22}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C22</strong></td>
				<td class="warning">PORCENTUAL-4B</td>
				<td><input type="text" id="c23" name="c23" value="${respuesta.c23}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C23</strong></td>
				<td class="warning">TECLA-VISA</td>
				<td><input type="text" id="c24" name="c24" value="${respuesta.c24}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C24</strong></td>			
				<td class="warning">PORCENTUAL-VISA</td>
				<td><input type="text" id="c25" name="c25" value="${respuesta.c25}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C25</strong></td>
				<td class="warning">TECLA-OTRAS</td>
				<td><input type="text" id="c26" name="c26" value="${respuesta.c26}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C26</strong></td>
				<td class="warning">PORCENTUAL-OTRAS</td>
				<td><input type="text" id="c27" name="c27" value="${respuesta.c27}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C27</strong></td>
				<td class="warning">TECLA-GASOLEO</td>
				<td><input type="text" id="c28" name="c28" value="${respuesta.c28}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C28</strong></td>
				<td class="warning">PORCENTUAL-GASOLEO</td>
				<td><input type="text" id="c29" name="c29" value="${respuesta.c29}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C29</strong></td>
				<td class="warning">TECLA-MONEDERO</td>
				<td><input type="text" id="c30" name="c30" value="${respuesta.c30}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C30</strong></td>
				<td class="warning">PORCENTUAL-MONEDERO</td>
				<td><input type="text" id="c31" name="c31" value="${respuesta.c31}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C31</strong></td>
				<td class="warning">IAE</td>
				<td><input type="text" id="c32" name="c32" value="${respuesta.c32}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C32</strong></td>
				<td class="warning">FECHA-CONTRATO</td>
				<td><input type="text" id="c33" name="c33" value="${respuesta.c33}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C33</strong></td>
				<td class="warning">SERVICIO-DCC</td>
				<td><input type="text" id="c34" name="c34" value="${respuesta.c34}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C34</strong></td>
				<td class="warning">FECHA-ALTA-DCC</td>
				<td><input type="text" id="c35" name="c35" value="${respuesta.c35}" size="8" maxlength="8"></td>
			</tr>
			<tr>
			    <td><strong>C35</strong></td>
				<td class="warning">BANCO-CONTRATO-DCC</td>
				<td><input type="text" id="c36" name="c36" value="${respuesta.c36}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C36</strong></td>
				<td class="warning">SUCUR-CONTRATO-DCC</td>
				<td><input type="text" id="c37" name="c37" value="${respuesta.c37}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C37</strong></td>
				<td class="warning">CHECK-CTA-DCC</td>
				<td><input type="text" id="c38" name="c38" value="${respuesta.c38}" size="2" maxlength="2"></td>
			</tr>
			<tr>
			    <td><strong>C38</strong></td>
				<td class="warning">NUM-CUENTA-DCC</td>
				<td><input type="text" id="c39" name="c39" value="${respuesta.c39}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C39</strong></td>
				<td class="warning">CAE-AET</td>
				<td><input type="text" id="c40" name="c40" value="${respuesta.c40}" size="13" maxlength="13"></td>
			</tr>
			<tr>
			    <td><strong>C40</strong></td>
				<td class="warning">BANCO-CUENTA</td>
				<td><input type="text" id="c41" name="c41" value="${respuesta.c41}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C41</strong></td>
				<td class="warning">SUCURSAL-CUENTA</td>
				<td><input type="text" id="c42" name="c42" value="${respuesta.c42}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C42</strong></td>
				<td class="warning">TECLA-CUP</td>
				<td><input type="text" id="c43" name="c43" value="${respuesta.c43}" size="1" maxlength="1"></td>
			</tr>
			<tr>
			    <td><strong>C43</strong></td>
				<td class="warning">PORCENTUAL-CUP</td>
				<td><input type="text" id="c44" name="c44" value="${respuesta.c44}" size="4" maxlength="4"></td>
			</tr>
			<tr>
			    <td><strong>C44</strong></td>
				<td class="warning">TELEFONO-AUX</td>
				<td><input type="text" id="c45" name="c45" value="${respuesta.c45}" size="10" maxlength="10"></td>
			</tr>
			<tr>
			    <td><strong>C45</strong></td>
				<td class="warning">HORARIO-CONTACTO</td>
				<td><input type="text" id="c46" name="c46" value="${respuesta.c46}" size="1" maxlength="1"></td>
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
	
	<c:url var="url2" value="/altacomercio?command=fila&rowid=" />
	<c:url var="url3" value="/altacomercio?command=eliminar&rowid=" />
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
						<th>Command</th>
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