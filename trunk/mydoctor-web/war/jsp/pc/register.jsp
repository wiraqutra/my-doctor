<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/global.css" />
<title>pc Register</title>
</head>
<body>
<p>新規登録</p>

<form name="registerForm" method="post" action="/pc/register">
	<p>EMAIL<input type="text" name="email" value="${f:h(email)}" class="${f:errorClass('email','err')}"/>${f:h(errors.email)}</p>
	<p>ニックネーム<input type="text" name="nickName" value="${f:h(nickName)}" class="${f:errorClass('nickName','err')}"/>${f:h(errors.nickName)}</p>
	<p><input type="submit" value="送信"/></p>
	<input type="hidden" name="cmd" value="submit"/>
</form>
</body>
</html>
