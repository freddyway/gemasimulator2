<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="cache-control" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>gemasimulator - index.jsp</title>

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!-- <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->


<link rel="stylesheet" href="bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/dist/css/bootstrap-theme.min.css">
<script src="bootstrap/dist/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1>GemaOro Simulator 2</h1>			
			</div>
			<div class="panel-body">
				<ul>
					<li><a href="<c:url value="/altacomercio?command=consultar"/>">(31500).Alta de Comercio</a></li>
					<li><a href="tr31502.jsp">(31502).Consulta de Comercio</a></li>
					<li><a href="tr31503.jsp">(31503).Modificacion de Comercio</a></li>
					<li><a href="tr31510.jsp">(31510).Alta de Terminal</a></li>
					<li><a href="tr01083.jsp">(01083).Baja de Terminal</a></li>
					<li><a href="<c:url value="/altacuenta?command=consultar"/>">(31530).Alta Cuenta Domiciliacion</a></li>
					<li><a href="tr31531.jsp">(31531).Consulta Cuenta Domiciliacion</a></li>
					<li><a href="<c:url value="/modifcuenta?command=consultar"/>">(31532).Modificacion Cuenta Domiciliacion</a></li>
					<li><a href="tr31533.jsp">(31533).Baja Cuenta Domiciliacion</a></li>
					<li><a href="tr31534.jsp">(31534).Marcar prioridad a una cuenta de domiciliación</a></li>
					<li><a href="tr32081.jsp">(32081).Modificacion Servicio DCC</a></li>
					<li><a href="tr32082.jsp">(32082).Alta Servicio DCC</a></li>
					<li><a href="tr32083.jsp">(32083).Baja servicio DCC</a></li>	
					<li><a href="<c:url value="/serviciodcc?command=consultar" />">(32084).Marcar/Desmarcar Cuenta con Alta/Baja servicio DCC</a></li>
					<li><a href="tr31245.jsp">(31245).Consulta de Saldo</a></li>
					<li><a href="tr01380.jsp">(01380).Activar Tarjeta Estado</a></li>					
					<li><a href="<c:url value="/altatarjeta?command=consultar" />">(31390).Alta Tarjeta</a></li>
					<li><a href="<c:url value="/activtarj?command=consultar" />">(31660).Activar Tarjeta</a></li>
 					<li><a href="<c:url value="/cargaprepag?command=consultar" />">(31240).Carga Tarjeta Prepago</a></li>
 					<li><a href="<c:url value="/estadotarj?command=consultar" />">(31042).Cambio de Estado Tarjeta</a></li>
<!-- 					<li><a href="tr31240.jsp">(31240).Carga Tarjeta Prepago</a></li>					 -->
					<li><a href="tr31521.jsp">(31521).Consulta de Descuentos</a></li>
					<li><a href="tr31522.jsp">(31522).Modificacion de Descuentos</a></li>
					<li><a href="<c:url value="/altacuentaodin?command=consultar"/>">(71530).Alta Cuenta Domiciliacion Odin</a></li>
					<li><a href="traffic.jsp">Trafico Gema</a></li>									
				</ul>
			</div>
		</div>
	</div>	
</body>
</html>