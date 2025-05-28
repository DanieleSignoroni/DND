function RilevDatiPrdTSOL() {
	parent.document.getElementById('Indietro').style.display = displayBlock;
	parent.document.getElementById('StampaBolla').style.display = displayNone;
	parent.document.getElementById('ConfermaStampa').style.display = displayNone;
	parent.document.getElementById('ProssimaAtvBut').style.display = displayNone;
	parent.document.getElementById('MonitorBut').style.display = displayNone;
	parent.document.getElementById('YChiamataUdcBut').style.display = displayNone;
	parent.document.getElementById('YRiposizionamentoUdcBut').style.display = displayNone;
	parent.document.getElementById('YChiudiListaTesta').style.display = displayNone; //71979
}

function selectReparto(index) {
	var className = eval("document.forms[0].thClassName.value");
	eval("document.forms[0]." + idFromName['IdOperatore']).value = document.getElementById("IdOperatore" + index).value;
	runActionDirect('RIPOSIZIONA_UDC_SCELTA_OPERATORE', 'action_submit', className, null, 'same', 'no');
}

function conferma() {
	var className = eval("document.forms[0].thClassName.value");
	runActionDirect('CONFERMA_RIPOSIZIONAMENTO_UDC', 'action_submit', className, null, 'same', 'no');
}
