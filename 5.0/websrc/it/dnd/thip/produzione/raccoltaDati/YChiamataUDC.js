function RilevDatiPrdTSOL() {
	parent.document.getElementById('Indietro').style.display = displayBlock;
	parent.document.getElementById('StampaBolla').style.display = displayNone;
	parent.document.getElementById('ConfermaStampa').style.display = displayNone;
	parent.document.getElementById('ProssimaAtvBut').style.display = displayNone;
	parent.document.getElementById('MonitorBut').style.display = displayNone;
	parent.document.getElementById('YChiamataUdcBut').style.display = displayNone;
	parent.document.getElementById('YRiposizionamentoUdcBut').style.display = displayNone;
}

function selectReparto(index) {
	var className = eval("document.forms[0].thClassName.value");
	eval("document.forms[0]." + idFromName['IdOperatore']).value = document.getElementById("IdOperatore" + index).value;
	runActionDirect('CHIAMATA_UDC_SCELTA_OPERATORE', 'action_submit', className, null, 'same', 'no');
}

function conferma() {
	var className = eval("document.forms[0].thClassName.value");
	runActionDirect('CONFERMA_CHIAMATA_UDC', 'action_submit', className, null, 'same', 'no');
}

function selectUDC(index){
	var className = eval("document.forms[0].thClassName.value");
	eval("document.forms[0]." + idFromName['IdMateriale1']).value = document.getElementById("CodMappaUDC" + index).value;
	if(document.getElementById("SaldoKey" + index) != null && document.getElementById("SaldoKey" + index) != undefined){
		eval("document.forms[0]." + idFromName['BollaLavorazione']).value = document.getElementById("SaldoKey" + index).value;
	}
	runActionDirect('CHIAMATA_UDC_SCELTA_UDC', 'action_submit', className, null, 'same', 'no');
}
