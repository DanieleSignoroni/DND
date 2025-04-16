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
	runActionDirect('RIPOSIZIONA_UDC_SCELTA_OPERATORE', 'action_submit', className, null, 'same', 'no');

	//	var idReparto = document.getElementById("IdRepartoTD"+index).innerHTML;
	//	document.getElementById('extraTable').parentNode.parentNode.style.display = displayNone;
	//	document.getElementById('BollaLavorazione').parentNode.parentNode.style.display = displayBlock;
	//	document.getElementById('Titolo').parentNode.parentNode.style.display = displayBlock;
	//	
	//	parent.document.getElementById('Conferma').style.display = displayBlock;
	//	
	//	document.getElementById('BollaLavorazione').style.background = mCo;
	//	document.getElementById('BollaLavorazione').focus();
	//	document.forms[0].IdOperatore.value = idReparto; //.Porto il valore del reparto qui
}

function conferma() {
	var className = eval("document.forms[0].thClassName.value");
	runActionDirect('CONFERMA_RIPOSIZIONAMENTO_UDC', 'action_submit', className, null, 'same', 'no');
}
