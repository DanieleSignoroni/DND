function inviaListaPrlLeanLift() {
	var target = "new";
	var key = document.forms[0].thKey.value;
	runActionDirect("INVIA_LISTA_PRL_LEAN_LIFT", "action_submit", document.forms[0].thClassName, key, target, "no");
}