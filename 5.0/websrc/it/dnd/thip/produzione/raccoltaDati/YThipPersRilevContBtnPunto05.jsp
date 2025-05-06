<td align="left">
	<button style="display:none;" id="YChiamataUdcBut" class="btnFooter" type="button"
		onclick="ychiamataUdcAction()">Chiamata UDC</button>
</td>
<td align="left">
	<button style="display:none;" id="YRiposizionamentoUdcBut" class="btnFooter" type="button"
		onclick="yRiposizionamentoUdcAction()">Riposizionamento UDC</button>
</td>
<!-- 71946 Inizio -->
<td align="left">
	<button style="display:none;" id="YGeneraUdsAuto" class="btnFooter" type="button"
		onclick="yGeneraUdsAutoAction()">Genera UDS Automaticamente</button>
</td>
<td align="left">
	<button style="display:none;" id="YGeneraUdsMan" class="btnFooter" type="button"
		onclick="yGeneraUdsManAction()">Genera UDS manualmente</button>
</td>
<!-- 71946 Fine -->
<script>
function ychiamataUdcAction(){
	var rilframe = document.getElementById('rilframe');
	rilframe.contentWindow.ychiamataUdcAction();
}

function yRiposizionamentoUdcAction(){
	var rilframe = document.getElementById('rilframe');
	rilframe.contentWindow.yRiposizionamentoUdcAction();
}
//71946 Inizio
function yGeneraUdsAutoAction(){
	var rilframe = document.getElementById('rilframe');
	rilframe.contentWindow.yGeneraUdsAutoAction();
}
function yGeneraUdsManAction(){
	var rilframe = document.getElementById('rilframe');
	rilframe.contentWindow.yGeneraUdsManAction();
}
//71946	Fine
</script>