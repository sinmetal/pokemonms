<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>管理画面トップ</title>
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
        <h4>Config</h4>
        <table>
          <thead>
            <tr>
              <th>Key</th>
              <th>Value</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>TwitterConsumerKey</td>
              <td>${f:h(twitterConsumerKey)}</td>
            </tr>
            <tr>
              <td>TwitterConsumerSecret</td>
              <td>${f:h(twitterConsumerSecret)}</td>
            </tr>
          </tbody>
        </table>

        <h4>MasterData</h4>
        <table>
          <thead>
            <tr>
              <th>Key</th>
              <th>Count</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>図鑑</td>
              <td>${pokemonCount}</td>
            </tr>
            <tr>
              <td>特性</td>
              <td>${abilityCount}</td>
            </tr>
            <tr>
              <td>技</td>
              <td>${trickCount}</td>
            </tr>
          </tbody>
        </table>

        <h4>UserData</h4>
        <table>
          <thead>
            <tr>
              <th>Key</th>
              <th>Count</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>全メンバー</td>
              <td>${memberCount}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>
