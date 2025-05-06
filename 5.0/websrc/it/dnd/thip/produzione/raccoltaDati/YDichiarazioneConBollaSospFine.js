var oldRilevDatiPrdTSOL = RilevDatiPrdTSOL;

RilevDatiPrdTSOL = function() {
	oldRilevDatiPrdTSOL();
	parent.document.getElementById('YRiposizionamentoUdcBut').style.display = displayNone;
	parent.document.getElementById('YChiamataUdcBut').style.display = displayNone;
	parent.document.getElementById('YGeneraUdsAuto').style.display = displayBlock; //71946
	parent.document.getElementById('YGeneraUdsMan').style.display = displayBlock; //71946
}

//71946 Inizio

function nonGestirePicking() {
	var nonGestirePicking = document.forms[0].YNonGestirePicking.checked;
	if (nonGestirePicking) {
		document.forms[0].YNumeroPzBauletto.readOnly = true;
		document.forms[0].YNumeroPzUds.readOnly = true;
		document.forms[0].YIdTipoUds.readOnly = true;
	} else {
		document.forms[0].YNumeroPzBauletto.readOnly = false;
		document.forms[0].YNumeroPzUds.readOnly = false;
		document.forms[0].YIdTipoUds.readOnly = false;
	}
}

function yGeneraUdsAutoAction() {
	setInnerText(document.getElementById("ErroriList"), "");
	var className = eval("document.forms[0].thClassName.value");
	runActionDirect('GEN_UDS_AUTOMATICA', 'action_submit', className, null, 'same', 'no');
}

function yGeneraUdsManAction() {
	var idTipoUds = document.forms[0].YIdTipoUds.value;
	if (idTipoUds == null || idTipoUds == undefined || idTipoUds === "") {
		window.alert('Tipo UDS obbligatorio');
	} else {
		var url = "it.dnd.thip.produzione.raccoltaDati.web.AzioneGeneraUdsManualmente?IdTipoUds=" + idTipoUds;
		setLocationOnWindow(document.getElementById('winListFrame').contentWindow, url);
	}
}

//71946 Fine