var oldRilevDatiPrdTSOL = RilevDatiPrdTSOL;

RilevDatiPrdTSOL = function() {
	oldRilevDatiPrdTSOL();
	parent.document.getElementById('YRiposizionamentoUdcBut').style.display = displayNone;
	parent.document.getElementById('YChiamataUdcBut').style.display = displayNone;
	parent.document.getElementById('YGeneraUdsAuto').style.display = displayBlock; //71XXX
	parent.document.getElementById('YGeneraUdsMan').style.display = displayBlock; //71XXX
}

//71XXX Inizio

function nonGestirePicking() {
	var nonGestirePicking = document.forms[0].YNonGestirePicking.checked;
	if(nonGestirePicking){
		document.forms[0].YNumeroPzBauletto.readOnly = true;
		document.forms[0].YNumeroPzUds.readOnly = true;
		document.forms[0].YIdTipoUds.readOnly = true;
	}else{
		document.forms[0].YNumeroPzBauletto.readOnly = false;
		document.forms[0].YNumeroPzUds.readOnly = false;
		document.forms[0].YIdTipoUds.readOnly = false;
	}
}

function yGeneraUdsAutoAction(){
	setInnerText(document.getElementById("ErroriList"), "");
	var className = eval("document.forms[0].thClassName.value");
	runActionDirect('GEN_UDS_AUTOMATICA', 'action_submit', className, null, 'same', 'no');
}

function yGeneraUdsManAction(){
	setInnerText(document.getElementById("ErroriList"), "");
	var className = eval("document.forms[0].thClassName.value");
	runActionDirect('GEN_UDS_MANUALE', 'action_submit', className, null, 'same', 'no');
}

//71XXX Fine