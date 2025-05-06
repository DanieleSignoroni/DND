var oldRilevDatiPrdTSOL = RilevDatiPrdTSOL;

RilevDatiPrdTSOL = function() {
	oldRilevDatiPrdTSOL();
	parent.document.getElementById('YRiposizionamentoUdcBut').style.display = displayBlock;
	parent.document.getElementById('YChiamataUdcBut').style.display = displayBlock;
	parent.document.getElementById('YGeneraUdsAuto').style.display = displayNone; //71XXX
	parent.document.getElementById('YGeneraUdsMan').style.display = displayNone; //71XXX
}

function ychiamataUdcAction() {
	setInnerText(document.getElementById("ErroriList"), "");
	var className = eval("document.forms[0].thClassName.value");
	runActionDirect('CHIAMATA_UDC', 'action_submit', className, null, 'same', 'no');
}

function yRiposizionamentoUdcAction() {
	setInnerText(document.getElementById("ErroriList"), "");
	var className = eval("document.forms[0].thClassName.value");
	runActionDirect('RIPOSIZIONA_UDC', 'action_submit', className, null, 'same', 'no');
}