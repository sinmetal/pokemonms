<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ポケモン図鑑</title>
</head>
<body>
<form action="${f:url('insert')}" method="post">
	<textarea name="pokemonData" class="${f:errorClass('pokemonData', 'err')}">${f:h(pokemonData)}</textarea>${f:h(errors.pokemonData)}<br />
	<input type="submit" value="登録" />
</form>
<a href="${f:url('delete')}" onclick="return confirm('全削除してもよろしいですか？')">全削除</a>
<c:forEach var="e" items="${pokemons}">
  ${f:h(e.worldGuideNo) },
  ${f:h(e.pokemonName) },
  ${f:h(e.elementType1st.name) },
  ${f:h(e.elementType2nd.name) },
  ${f:h(e.breedH) },
  ${f:h(e.breedA) },
  ${f:h(e.breedB) },
  ${f:h(e.breedC) },
  ${f:h(e.breedD) },
  ${f:h(e.breedS) },
  ${f:h(e.eggGroupType1st.name) },
  ${f:h(e.eggGroupType2nd.name) },
  ${f:h(e.abilityName1st) }${f:h(e.isAbilityDream1st) },
  ${f:h(e.abilityName2nd) }${f:h(e.isAbilityDream2nd) },
  ${f:h(e.abilityName3rd) }${f:h(e.isAbilityDream3rd) }
  <hr />
</c:forEach>
<c:forEach var="e" items="${pokemons}">
  '${f:h(e.pokemonName) }',
</c:forEach>
</body>
</html>
