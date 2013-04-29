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
    <form method="post" action="insert" id="entryForm">
      <fieldset>
        <div class="clearfix">
          <label for="xInput">consumerKey</label>
          <div class="input">
            <input class="span2" id="consumerKey" name="consumerKey" type="text" />
          </div>
          <label for="xInput">consumerSecret</label>
          <div class="input">
            <input class="span2" id="consumerSecret" name="consumerSecret" type="text" />
          </div>
        </div>
      </fieldset>

      <div class="actions">
        <button type="submit" class="btn primary">登録</button>
      </div>
    </form>
  </body>
</html>
