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

function selectUDC(index) {
	var className = eval("document.forms[0].thClassName.value");
	eval("document.forms[0]." + idFromName['IdMateriale1']).value = document.getElementById("CodMappaUDC" + index).value;
	if (document.getElementById("SaldoKey" + index) != null && document.getElementById("SaldoKey" + index) != undefined) {
		eval("document.forms[0]." + idFromName['BollaLavorazione']).value = document.getElementById("SaldoKey" + index).value;
	}
	runActionDirect('CHIAMATA_UDC_SCELTA_UDC', 'action_submit', className, null, 'same', 'no');
}

function recuperaArticoloAttivitaFinale() { //71978
	var numeroRitornoVersamento = document.forms[0].NumeroRitornoVersamento.value;
	var ajaxRequest = null;
	if (window.XMLHttpRequest) {
		ajaxRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (ajaxRequest != null) {
		var params = "?NumeroRitornoVersamento=" + numeroRitornoVersamento;
		var url = "/" + webAppPath + "/" + servletPath + "/it.dnd.thip.produzione.raccoltaDati.web.RecuperaArticoloNumeroRitornoVersamento" + params;
		ajaxRequest.open("GET", url, true);
		ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		ajaxRequest.onreadystatechange = function() {
			if (ajaxRequest.readyState == 4) {
				var result = JSON.parse(ajaxRequest.responseText);
				if (result["IdArticolo"])
					eval("document.forms[0]." + idFromName['IdArticolo']).value = result["IdArticolo"];
			}
		};
		ajaxRequest.send(null);
	}

}