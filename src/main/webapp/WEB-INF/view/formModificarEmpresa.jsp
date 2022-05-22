<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	
		Nombre empresa: <input type="text" name="nombre" value="${ empresa.nombre }"/>
		Fecha Abertura: <input type="text" name="fecha" value="<fmt:formatDate value="${empresa.fechaAbertura }" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value="${ empresa.id }"/>
		<input type="hidden" name="accion" value="ModificarEmpresa"/>
		<input type="submit"/>
	
	</form>

</body>
</html>