<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<c:choose>
	<c:when test="${question.typeCode eq 'select'}">
		<c:forEach items="${question.dataList}" var="data">
		<button name="answer" value="${data.id}">${f:h(data.label)}</button>
		</c:forEach>
	</c:when>
	<c:when test="${question.typeCode eq 'checkbox'}">
		<c:forEach items="${question.data }" var="data">
		${f:h(data.label)}<input type="checkbox" name="answerArray" value="${data.id}"/>
		</c:forEach>
	</c:when>
</c:choose>
