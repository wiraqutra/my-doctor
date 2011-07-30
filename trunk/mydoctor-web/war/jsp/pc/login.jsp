<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>システムログイン画面</title>
</head>
<body>
<p><a href="<c:url value="/pc/login"><c:param name="m" value="gl"/><c:param name="ret" value="${ret}"/></c:url>">Google Accountでログイン</a></p>
<p><a href="<c:url value="/pc/login"><c:param name="m" value="tw"/><c:param name="ret" value="${ret}"/></c:url>">Twitter Accountでログイン</a></p>
<p><a href="<c:url value="/pc/login"><c:param name="m" value="fb"/><c:param name="ret" value="${ret}"/></c:url>">Facebook Accountでログイン</a></p>
<p><a href="<c:url value="/pc/register"/>">新規登録</a></p>
</body>
</html>
