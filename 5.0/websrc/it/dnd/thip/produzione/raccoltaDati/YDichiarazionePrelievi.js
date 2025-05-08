var oldRilevDatiPrdTSOL = RilevDatiPrdTSOL;
var oldhideFields = hideFields;

RilevDatiPrdTSOL = function() {
	oldRilevDatiPrdTSOL();
	parent.document.getElementById('YRiposizionamentoUdcBut').style.display = displayNone;
	parent.document.getElementById('YChiamataUdcBut').style.display = displayNone;
	parent.document.getElementById('YGeneraUdsAuto').style.display = displayNone; //71946
	parent.document.getElementById('YGeneraUdsMan').style.display = displayNone; //71946
}

hideFields = function() {
	oldhideFields();
	var n = 21;
	var i = 1;
	for (i = 1; i < n; i++) {
		eval("document.forms[0]." + idFromName['MappaUdc' + i + '.CodiceAnagraficaUdc']).style.display = displayNone;
	}
}