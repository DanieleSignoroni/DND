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

		let elementId = 'thMappaUdc' + i + 'SearchBut'; //71953
		document.getElementById(elementId).style.display = displayNone; //71953

		let varName = 'isQtaPrelevataUMPrm' + i + 'Enabled';
		if (typeof window[varName] !== 'undefined' && window[varName] === false) {
			eval("document.forms[0]." + idFromName['QtaPrelevataUMPrm'+i]).readOnly = true; //.Metto in readOnly
			eval("document.forms[0]." + idFromName['QtaPrelevataUMPrm'+i]).addOF = function () {}; //.Rimuovo l' on focus standard
		}
	}
}