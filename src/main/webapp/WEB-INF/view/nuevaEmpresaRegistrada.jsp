<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<body>
	<c:import url="logout-parcial.jsp"></c:import>
		<c:if test="${not empty empresa }">
			Empresa ${ empresa } registrada!
		</c:if>
		<c:if test="${ empty empresa }">
			Ninguna empresa registrada!
		</c:if>
	</body>
</html>
