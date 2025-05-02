var oldRilevDatiPrdTSOL = RilevDatiPrdTSOL;

RilevDatiPrdTSOL = function() {
	oldRilevDatiPrdTSOL();
	parent.document.getElementById('YRiposizionamentoUdcBut').style.display = displayNone;
	parent.document.getElementById('YChiamataUdcBut').style.display = displayNone;
}

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