<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>メンバー登録</title>
</head>
<body>
  <form method="post" action="insert" id="entryForm">
    <table>
      <tr>
        <th><label for="">TwitterId</label></th>
        <td>
          <input id="twitterId" type="text" name="twitterId" class="pokemonNameText" />
        </td>
      </tr>
      <tr>
        <th><label for="">TwitterName</label></th>
        <td>
          <input id="twitterName" type="text" name="twitterName" class="pokemonNameText" />
        </td>
      </tr>
      <tr>
        <th><label for="">TwitterScreenName</label></th>
        <td>
          <input id="twitterScreenName" type="text" name="twitterScreenName" class="pokemonNameText" />
        </td>
      </tr>
      <tr>
        <th><label for="">TwitterToken</label></th>
        <td>
          <input id="twitterToken" type="text" name="twitterToken" class="pokemonNameText" />
        </td>
      </tr>
      <tr>
        <th><label for="">TwitterTokenSecret</label></th>
        <td>
          <input id="twitterTokenSecret" type="text" name="twitterTokenSecret" class="pokemonNameText" />
        </td>
      </tr>
      <tr>
        <th><label for="">TwitterProfileImageUrl</label></th>
        <td>
          <input id="twitterProfileImageUrl" type="text" name="twitterProfileImageUrl" class="pokemonNameText" />
        </td>
      </tr>
      <tr>
        <th><label for="">FriendCodes</label></th>
        <td>
          <input id="friendCode" type="text" name="friendCode" class="pokemonNameText" />
        </td>
      </tr>
      <tr>
        <th><label for="">ActiveTime</label></th>
        <td>
          <input id="activeTime" type="text" name="activeTime" class="pokemonNameText" />
        </td>
      </tr>
    </table>
    <p>
      <input type="submit" value="登録" />
    </p>
  </form>
</body>
</html>
