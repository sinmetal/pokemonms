// This file was automatically generated from storage.soy.
// Please don't edit this file by hand.

goog.provide('templates.storage');

goog.require('soy');
goog.require('soy.StringBuilder');


templates.storage.pokemon = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="storage-list-back"><div class="storage-list"><div class="storage-column-id"><div class="storage-id">', soy.$$escapeHtml(opt_data.id), '</div><div class="float-left"      ><a href="edit?key=', soy.$$escapeHtml(opt_data.key), '&version=', soy.$$escapeHtml(opt_data.version), '"><img src="/img/icon/edit.png" alt="編集" title="編集"/></a></div><div class="margin-left-10"><a href="delete?key=', soy.$$escapeHtml(opt_data.key), '&version=', soy.$$escapeHtml(opt_data.version), '" onclick="return confirm(\'削除してもよろしいですか？\')"><img src="/img/icon/remove.png" alt="削除" title="削除"/></a></div></div><div class="storage-column-name"><div class="pokemon-name float-left">', soy.$$escapeHtml(opt_data.pokemonName), '</div><div class="gender-name"            >', soy.$$escapeHtml(opt_data.genderName), '</div><div class="nickname"               >', soy.$$escapeHtml(opt_data.nickname), '</div><div class="ability-name"           >', soy.$$escapeHtml(opt_data.abilityName), '</div><div class="person-name"            >', soy.$$escapeHtml(opt_data.personName), '</div></div><div class="storage-column-status"><div>', soy.$$escapeHtml(opt_data.individualH), '</div><div>', soy.$$escapeHtml(opt_data.effortH), '</div><div>', soy.$$escapeHtml(opt_data.lv50H), '</div></div><div class="storage-column-status"><div>', soy.$$escapeHtml(opt_data.individualA), '</div><div>', soy.$$escapeHtml(opt_data.effortA), '</div><div>', soy.$$escapeHtml(opt_data.lv50A), '</div></div><div class="storage-column-status"><div>', soy.$$escapeHtml(opt_data.individualB), '</div><div>', soy.$$escapeHtml(opt_data.effortB), '</div><div>', soy.$$escapeHtml(opt_data.lv50B), '</div></div><div class="storage-column-status"><div>', soy.$$escapeHtml(opt_data.individualC), '</div><div>', soy.$$escapeHtml(opt_data.effortC), '</div><div>', soy.$$escapeHtml(opt_data.lv50C), '</div></div><div class="storage-column-status"><div>', soy.$$escapeHtml(opt_data.individualD), '</div><div>', soy.$$escapeHtml(opt_data.effortD), '</div><div>', soy.$$escapeHtml(opt_data.lv50D), '</div></div><div class="storage-column-status"><div>', soy.$$escapeHtml(opt_data.individualS), '</div><div>', soy.$$escapeHtml(opt_data.effortS), '</div><div>', soy.$$escapeHtml(opt_data.lv50S), '</div></div><div class="storage-column-trick"><div class="span1-5 float-left"     >', soy.$$escapeHtml(opt_data.trick1stName), '</div><div class="span1-5"      >', soy.$$escapeHtml(opt_data.trick2ndName), '</div><div class="span1-5 clear-left"                  >', soy.$$escapeHtml(opt_data.trick3rdName), '</div><div class="span1-5 float-left"                  >', soy.$$escapeHtml(opt_data.trick4thName), '</div><div class="span0-5 float-left">', soy.$$escapeHtml(opt_data.awakenPowerElementName), '</div><div class="span0-5">', soy.$$escapeHtml(opt_data.awakenPowerEdge), '</div></div><div class="storage-column-remark"><div>', soy.$$escapeHtml(opt_data.remark), '</div></div></div></div>');
  return opt_sb ? '' : output.toString();
};


templates.storage.pokemonList = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var pokemonList75 = opt_data.pokemonList;
  var pokemonListLen75 = pokemonList75.length;
  if (pokemonListLen75 > 0) {
    for (var pokemonIndex75 = 0; pokemonIndex75 < pokemonListLen75; pokemonIndex75++) {
      var pokemonData75 = pokemonList75[pokemonIndex75];
      templates.storage.pokemon({key: pokemonData75.key, version: pokemonData75.version, id: pokemonData75.id, pokemonName: pokemonData75.pokemonName, nickname: pokemonData75.nickname, personName: pokemonData75.personName, genderName: pokemonData75.genderName, abilityName: pokemonData75.abilityName, individualH: pokemonData75.individualH, individualA: pokemonData75.individualA, individualB: pokemonData75.individualB, individualC: pokemonData75.individualC, individualD: pokemonData75.individualD, individualS: pokemonData75.individualS, effortH: pokemonData75.effortH, effortA: pokemonData75.effortA, effortB: pokemonData75.effortB, effortC: pokemonData75.effortC, effortD: pokemonData75.effortD, effortS: pokemonData75.effortS, lv50H: pokemonData75.lv50H, lv50A: pokemonData75.lv50A, lv50B: pokemonData75.lv50B, lv50C: pokemonData75.lv50C, lv50D: pokemonData75.lv50D, lv50S: pokemonData75.lv50S, trick1stName: pokemonData75.trick1stName, trick2ndName: pokemonData75.trick2ndName, trick3rdName: pokemonData75.trick3rdName, trick4thName: pokemonData75.trick4thName, awakenPowerElementName: pokemonData75.awakenPowerElementName, awakenPowerEdge: pokemonData75.awakenPowerEdge, remark: pokemonData75.remark}, output);
    }
  } else {
    output.append('No pokemon list.');
  }
  return opt_sb ? '' : output.toString();
};


templates.storage.profile = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="row"><div class="span"><a href="http://twitter.com/', soy.$$escapeHtml(opt_data.twitterScreenName), '"><img src="', soy.$$escapeHtml(opt_data.twitterProfileImageUrl), '"></img></a></div><div class="span1"><div class="row"><div class="span1"><h5><a href="http://twitter.com/', soy.$$escapeHtml(opt_data.twitterScreenName), '">', soy.$$escapeHtml(opt_data.twitterName), '</a></h5></div><div class="span1"><h5><a href="http://twitter.com/', soy.$$escapeHtml(opt_data.twitterScreenName), '">', soy.$$escapeHtml(opt_data.twitterScreenName), '</a></h5></div></div></div></div>');
  return opt_sb ? '' : output.toString();
};


templates.storage.boxList = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<ul class="nav nav-list"><li class="nav-header">BattleBox</li><li class="active"><a href="#">バトル1</a></li><li><a href="#">バトル2</a></li><li class="nav-header">KidsBox</li><li><a href="#">キッズ1</a></li><li><a href="#">キッズ2</a></li><li class="nav-header">TradeBox</li><li><a href="#">里親募集中1</a></li><li><a href="#">里親募集中2</a></li><li><a href="#">交換募集中1</a></li><li><a href="#">交換募集中2</a></li></ul>');
  return opt_sb ? '' : output.toString();
};
