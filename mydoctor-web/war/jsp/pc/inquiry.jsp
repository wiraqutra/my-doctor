<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>質問票</title>
</head>
<body>
<p>${title}</p>
<p>Q${inquiryNo}</p>
<c:choose>
	<c:when test="${inquiry.typeCode eq 'select'}">
		<c:forEach items="${inquiry.data }" var="data">
		<button name="answer" value="${data.id}">${f:h(data.label)}</button>
		</c:forEach>
	</c:when>
	<c:when test="${inquiry.typeCode eq 'checkbox'}">
		<c:forEach items="${inquiry.data }" var="data">
		${f:h(data.label)}<input type="checkbox" name="answerArray" value="${data.id}"/>
		</c:forEach>
	</c:when>
</c:choose>
</body>
</html>
