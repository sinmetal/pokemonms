<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<div class="topbar" data-dropdown="dropdown">
  <div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container-fluid">
      <a class="brand" href="/">PokemonMS α</a>
      <div class="nav-collapse">
      <ul class="nav">
        <li><a href="/storage">Home</a></li>
        <li><a href="#about">About</a></li>
        <li><a href="#LocalTradeStation">LTS</a></li>
        <li><a href="Tournament">Tournament</a></li>
        <li><a href="battle/index.html">Battle</a></li>
      </ul>
      <ul class="nav secondary-nav">
        <li class="menu">
          ${loginViewHelper.topMenuViewName}
          <ul class="menu-dropdown">
            <li><a href="#">Secondary link</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Another link</a></li>
          </ul>
        </li>
      </ul>
      </div>
    </div>
  </div>
  </div>
</div>