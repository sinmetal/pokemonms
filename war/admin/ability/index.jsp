<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>特性</title>
</head>
<body>
<form action="${f:url('insert')}" method="post">
  <textarea name="abilityData" class="${f:errorClass('abilityData', 'err')}">${f:h(abilityData)}</textarea>${f:h(errors.abilityData)}<br />
  <input type="submit" value="登録" />
</form>
<form action="${f:url('clear')}" method="post">
  <input type="submit" value = "全削除" />
</form>
<c:forEach var="e" items="${abilitys}">
  ${f:h(e.abilityName) }
  <hr />
</c:forEach>
</body>
</html>
