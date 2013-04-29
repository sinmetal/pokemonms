var elementList = [ 'ノーマル','ほのお','みず','でんき','くさ','こおり','かくとう','どく',
                    'じめん','ひこう','エスパー','むし','いわ','ゴースト','ドラゴン','あく','はがね'];

// wondowのonloadイベントでSuggestを生成
var start = function(){new Suggest.Local("awakenPowerType", "suggestElement", elementList);};
window.addEventListener ?
  window.addEventListener('load', start, false) :
  window.attachEvent('onload', start);
