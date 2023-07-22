<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">GemaOro</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
          <li>
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Comercios <b class="caret"></b></a>
              <ul class="dropdown-menu">
   					<li><a href="<c:url value="/altacomercio?command=consultar"/>">(31500).Alta de Comercio</a></li>
					<li><a href="tr31502.jsp">(31502).Consulta de Comercio</a></li>
					<li><a href="tr31503.jsp">(31503).Modificacion de Comercio</a></li>                  
              </ul>
          </li>
          <li>
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cuentas <b class="caret"></b></a>
              <ul class="dropdown-menu">
					<li><a href="<c:url value="/altacuenta?command=consultar"/>">(31530).Alta Cuenta Domiciliacion</a></li>
					<li><a href="tr31531.jsp">(31531).Consulta Cuenta Domiciliacion</a></li>
					<li><a href="<c:url value="/modifcuenta?command=consultar"/>">(31532).Modificacion Cuenta Domiciliacion</a></li>
					<li><a href="tr31533.jsp">(31533).Baja Cuenta Domiciliacion</a></li>
					<li><a href="tr31534.jsp">(31534).Marcar prioridad a una cuenta de domiciliación</a></li>              
					<li><a href="<c:url value="/altacuentaodin?command=consultar"/>">(71530).Alta Cuenta Domiciliacion Odin</a></li>
              </ul>
          </li>
          <li>
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Gestion DCC <b class="caret"></b></a>
              <ul class="dropdown-menu">
					<li><a href="tr32081.jsp">(32081).Modificacion Servicio DCC</a></li>
					<li><a href="tr32082.jsp">(32082).Alta Servicio DCC</a></li>
					<li><a href="tr32083.jsp">(32083).Baja servicio DCC</a></li>	
					<li><a href="<c:url value="/serviciodcc?command=consultar" />">(32084).Marcar/Desmarcar Cuenta con Alta/Baja servicio DCC</a></li>									              
              </ul>
          </li>      
          <li>
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Terminales <b class="caret"></b></a>
              <ul class="dropdown-menu">
					<li><a href="tr31510.jsp">(31510).Alta de Terminal</a></li>
					<li><a href="tr31510.jsp">(01083).Baja de Terminal</a></li>
              </ul>
          </li>
          <li>
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Tarjetas <b class="caret"></b></a>
              <ul class="dropdown-menu">
					<li><a href="tr31245.jsp">(31245).Consulta de Saldo</a></li>
					<li><a href="tr01380.jsp">(01380).ESTADO ACTIVACION TARJETAS (CONSULTA)</a></li>
					<li><a href="tr31390.jsp">(31390).Alta Tarjeta</a></li>
					<li><a href="tr31660.jsp">(31660).ACTIVACION DESACTIVACION DE UNA TARJETA</a></li>
					<li><a href="tr31240.jsp">(31240).Carga Tarjeta PrePago</a></li>
					<li><a href="tr31030.jsp">(31042).Cambio Estado Tarjeta</a></li>
					<li><a href="tr01026.jsp">(01026).Ampliacion de Limites de tarjeta</a></li>
              </ul>
          </li>
          <li>
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Descuentos <b class="caret"></b></a>
              <ul class="dropdown-menu">
					<li><a href="tr31521.jsp">(31521).Consulta de Descuentos</a></li>
					<li><a href="tr31522.jsp">(31522).Modificacion de Descuentos</a></li>
              </ul>
          </li>  
          <li>
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Trafico Gema <b class="caret"></b></a>
              <ul class="dropdown-menu">
					<li><a href="traffic.jsp">Cargar Transaccion</a></li>					
              </ul>
          </li>                      
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
