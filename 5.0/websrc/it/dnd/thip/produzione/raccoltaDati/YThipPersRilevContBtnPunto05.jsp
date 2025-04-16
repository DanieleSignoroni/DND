<td align="left">
	<button id="YChiamataUdcBut" class="btnFooter" type="button"
		onclick="ychiamataUdcAction()">Chiamata UDC</button>
</td>
<td align="left">
	<button id="YRiposizionamentoUdcBut" class="btnFooter" type="button"
		onclick="yRiposizionamentoUdcAction()">Riposizionamento UDC</button>
</td>
<script>
function ychiamataUdcAction(){
	var rilframe = document.getElementById('rilframe');
	rilframe.contentWindow.ychiamataUdcAction();
}

function yRiposizionamentoUdcAction(){
	var rilframe = document.getElementById('rilframe');
	rilframe.contentWindow.yRiposizionamentoUdcAction();
}
</script>