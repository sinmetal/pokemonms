<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>技</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <script src="/js/lib/bootstrap-dropdown.js"></script>

    <!-- Le styles -->
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/1.3.0/bootstrap.min.css">
    <link rel="stylesheet" href="/css/pokemonms.css">
    <style type="text/css">
      body {
        padding-top: 60px;
      }
    </style>
  </head>

  <body>
    <jsp:include page="/common/menu.jsp" flush="true" />

    <div class="container-fluid">
      <jsp:include page="/admin/common/sidemenu.jsp" flush="true" />

      <div class="ex-content">
        <form action="${f:url('insert')}" method="post">
          <textarea name="trickData" class="${f:errorClass('trickData', 'err')}">${f:h(trickData)}</textarea>${f:h(errors.trickData)}<br />
          <input type="submit" value="登録" />
        </form>
        <form action="${f:url('clear')}" method="post">
          <input type="submit" value = "全削除" />
        </form>

        <table>
          <thead>
            <tr>
              <th>技名</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="e" items="${tricks}">
              <td>${f:h(e.trickName) }</td>
            </c:forEach>
          </tbody>
        </table>

      </div>
    </div>
  </body>
</html>
