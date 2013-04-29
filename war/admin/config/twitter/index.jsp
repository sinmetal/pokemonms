<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>admin config twitter Index</title>
</head>
  <body>
    <p>Hello admin config twitter Index !!!</p>
    ${f:h(consumerKey) }
    ${f:h(consumerSecret) }
    <p><a class="btn" href="/admin/config/twitter/entry">登録</a></p>
  </body>
</html>
