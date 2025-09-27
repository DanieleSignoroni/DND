function SubscriptionOL() {
	setFieldMandatory("Endpoint", true);
	let myEndpoint = window.location.host;
	let endpointField = document.forms[0].Endpoint;
	
	myEndpoint += "/" + webAppPath + "/";

	if (endpointField) {
		endpointField.value = myEndpoint;
	}
}