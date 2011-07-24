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
<form method="post" action="/pc/inquiry">
<p>${inquiry.inquiryTitle}</p>
<p>${inquiry.inquiryCode}</p>
<c:forEach items="${inquiry.inquiryDataPackListRef.modelList}" var="pack">
<p>Q${pack.questionNumber} : ${f:h(pack.questionTitle)}</p>
<c:choose>
	<c:when test="${pack.inquiryType.code eq 'select'}">
		<c:forEach items="${pack.answerListRef.modelList}" var="answer">
		<label><input type="radio" name="q${pack.questionNumber}" value="${answer.id}"/>${f:h(answer.label)}</label>
		</c:forEach>
	</c:when>
	<c:when test="${pack.inquiryType.code eq 'checkbox'}">
		<c:forEach items="${pack.answerListRef.modelList}" var="answer">
		<label>${f:h(answer.label)}<input type="checkbox" name="q${pack.questionNumber}Array" value="${answer.id}"/></label>
		</c:forEach>
	</c:when>
</c:choose>

</c:forEach>

<p>
<input type="submit" name="back" value="戻る">
<input type="submit" name="next" value="次へ">
</p>
<input type="hidden" name="step" value="${step}"/>
<input type="hidden" name="answerSessionKey" value="${f:h(answerSessionKey)}"/>
</form>
</body>
</html>
