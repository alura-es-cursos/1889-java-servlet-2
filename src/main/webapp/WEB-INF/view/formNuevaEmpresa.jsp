<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>

	<form action="${ linkEntradaServlet}" method="post">
	
		Nombre empresa: <input type="text" name="nombre"/>
		Fecha Abertura: <input type="text" name="fecha"/>
		
		<input type="hidden" name="accion" value="NuevaEmpresa">
		
		<input type="submit"/>
	
	</form>

</body>
</html>