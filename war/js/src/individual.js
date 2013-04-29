var PokemonMS;
if(!PokemonMS) PokemonMS = {};
PokemonMS.func = {};

$(function() {
    $(".effortmax").click(function() { PokemonMS.func.setMaxValue($(this), 252); });
});

$(function() {
    $(".individualmax").click(function() { PokemonMS.func.setMaxValue($(this), 31); });
});

$(function() {
    $("#calculateButton").click(function() { PokemonMS.func.calculate(); });
});

PokemonMS.func.setMaxValue = function(element, maxValue) {
    element.parent().children("input").val(maxValue);
}

PokemonMS.func.calculate = function() {
    var validateRequired = function(value, containerId, title) {
        var container = $(containerId);
        if (value == "") {
            container.addClass("error");
            container.children(".input").children("span.help-inline").text(title + "は必須です。");
            return false;
        } else {
            container.removeClass("error");
            container.children(".input").children("span.help-inline").text("");
            return true;
        }
    }

    var pokemonName = $("#pokemonName").val();
    var personName = $("#personName").val();
    var pokemonNameValid = validateRequired(pokemonName, "#pokemonNameContainer", "ポケモン");
    var personNameValid = validateRequired(personName, "#personNameContainer", "せいかく");

    if (!pokemonNameValid || !personNameValid) {
        return;
    }

    var nowLv = $("#nowLv");
    if (nowLv.val() == "") {
        nowLv.val(50);
    }

    var lv50 = PokemonMS.func.getStates("lv50");
    var effort = PokemonMS.func.getStates("effort");

    var setIndividual = function(status, value) {
        var id = "#individual" + status;
        var viewIndividual = $(id).val();
        if (viewIndividual == 31 && value.match("31")) {
            return;
        }
        $(id).val(value);
    }

    $.get("/storage/individual", {
        pokemonName: pokemonName,
        personName: personName,
        nowLv: nowLv.val(),
        effortH: effort[0],
        effortA: effort[1],
        effortB: effort[2],
        effortC: effort[3],
        effortD: effort[4],
        effortS: effort[5],
        lv50H: lv50[0],
        lv50A: lv50[1],
        lv50B: lv50[2],
        lv50C: lv50[3],
        lv50D: lv50[4],
        lv50S: lv50[5],},
    function(data) {
        switch (data.status) {
            case "OK":
                setIndividual("H", data.individualH);
                setIndividual("A", data.individualA);
                setIndividual("B", data.individualB);
                setIndividual("C", data.individualC);
                setIndividual("D", data.individualD);
                setIndividual("S", data.individualS);
                break;
            case "NG":
                PokemonMS.func.setErrorMessage(data);
                break;
        }
    });
}

PokemonMS.func.getStates = function(prefix) {
    var statesArray = new Array("H","A","B","C","D","S");
    var statesValue = new Array(statesArray.length);
    for (var i = 0; i < statesArray.length; i++) {
        var id =  "#" + prefix + statesArray[i];
        var states = $(id);
        var value = states.val();
        if (value == "") {
            value = 0;
            states.val(value);
        }
        statesValue[i] = value;
    }
    return statesValue;
}

PokemonMS.func.setErrorMessage = function(data) {
    for (var k in data) {
        alert(k + data[k]);
    }
}