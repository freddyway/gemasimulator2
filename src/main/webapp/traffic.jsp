<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trafico Gema</title>
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
		<div class="panel-group">
			<div class="panel panel-default">			    
				<div class="panel-heading">
					<p>Trafico Gema</p>
				</div>
				<div class="panel-body">
					<p>body</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>