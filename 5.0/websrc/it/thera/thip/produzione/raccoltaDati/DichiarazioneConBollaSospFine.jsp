<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///D:\3rd_Parties\Panthera4.7.5\websrc\dtd/xhtml1-transitional.dtd">
<html>
<!-- WIZGEN Therm 2.0.0 as Form - multiBrowserGen = true -->
<%=WebGenerator.writeRuntimeInfo()%>

<head>
<%@ page contentType="text/html; charset=Cp1252"%>
<%@ page import= " 
  java.sql.*, 
  java.util.*, 
  java.lang.reflect.*, 
  javax.naming.*, 
  com.thera.thermfw.common.*, 
  com.thera.thermfw.type.*, 
  com.thera.thermfw.web.*, 
  com.thera.thermfw.security.*, 
  com.thera.thermfw.base.*, 
  com.thera.thermfw.ad.*, 
  com.thera.thermfw.persist.*, 
  com.thera.thermfw.gui.cnr.*, 
  com.thera.thermfw.setting.*, 
  com.thera.thermfw.collector.*, 
  com.thera.thermfw.batch.web.*, 
  com.thera.thermfw.batch.*, 
  com.thera.thermfw.pref.* 
"%> 
<%
  ServletEnvironment se = (ServletEnvironment)Factory.createObject("com.thera.thermfw.web.ServletEnvironment"); 
  BODataCollector RilevDatiPrdTSBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm RilevDatiPrdTSForm =  
     new com.thera.thermfw.web.WebForm(request, response, "RilevDatiPrdTSForm", "RilevDatiPrdTS", null, "it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSFormActionAdapter", false, false, false, false, true, true, null, 1, true, "it/thera/thip/produzione/raccoltaDati/DichiarazioneConBollaSospFine.js"); 
  RilevDatiPrdTSForm.setServletEnvironment(se); 
  RilevDatiPrdTSForm.setJSTypeList(jsList); 
  RilevDatiPrdTSForm.setHeader(null); 
  RilevDatiPrdTSForm.setFooter(null); 
  RilevDatiPrdTSForm.setWebFormModifierClass("it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSWebFormModifier"); 
  RilevDatiPrdTSForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = RilevDatiPrdTSForm.getMode(); 
  String key = RilevDatiPrdTSForm.getKey(); 
  String errorMessage; 
  boolean requestIsValid = false; 
  boolean leftIsKey = false; 
  boolean conflitPresent = false; 
  String leftClass = ""; 
  try 
  {
     se.initialize(request, response); 
     if(se.begin()) 
     { 
        RilevDatiPrdTSForm.outTraceInfo(getClass().getName()); 
        String collectorName = RilevDatiPrdTSForm.findBODataCollectorName(); 
                RilevDatiPrdTSBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (RilevDatiPrdTSBODC instanceof WebDataCollector) 
            ((WebDataCollector)RilevDatiPrdTSBODC).setServletEnvironment(se); 
        RilevDatiPrdTSBODC.initialize("RilevDatiPrdTS", true, 1); 
        RilevDatiPrdTSForm.setBODataCollector(RilevDatiPrdTSBODC); 
        int rcBODC = RilevDatiPrdTSForm.initSecurityServices(); 
        mode = RilevDatiPrdTSForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           RilevDatiPrdTSForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = RilevDatiPrdTSBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              RilevDatiPrdTSForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 

  <title>Rilevazione Dati Prod. TS</title>
</head>
<!--<body leftmargin="0" rightmargin="0" topmargin="0" bottommargin="0" >--><!--Fix 13574 -->
<body bottommargin="0" leftmargin="0" onfocus="manageKeyPad();manageKeyPadOra();" onbeforeunload="<%=RilevDatiPrdTSForm.getBodyOnBeforeUnload()%>" onclick="manageKeyPad();manageKeyPadOra();" onload="<%=RilevDatiPrdTSForm.getBodyOnLoad()%>" onunload="<%=RilevDatiPrdTSForm.getBodyOnUnload()%>" rightmargin="0" topmargin="0"><%
   RilevDatiPrdTSForm.writeBodyStartElements(out); 
%> 
<!--Fix 13574 --><!-- Fix 31082 --> <!--Fix 42882 -->
<table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = RilevDatiPrdTSForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", RilevDatiPrdTSBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=RilevDatiPrdTSForm.getServlet()%>" method="post" name="RilevDatiPrdTSForm" style="height:100%"><%
  RilevDatiPrdTSForm.writeFormStartElements(out); 
%>


<table class="maintable"> <!--Fix 13264 -->
  <tr valign="top">
    <td style="height:10px"></td>
  </tr>
  <tr valign="top">
    <td width="15px"></td>
    <td width="1">
     <!-- <table cellpadding="5" cellspacing="5">--><!--Fix 13574 -->
      <table cellpadding="0" cellspacing="7"><!--Fix 13574 -->
        <!--<tr valign="top">--><!--Fix 13574 -->
        <tr><!--Fix 13574 -->
          <td nowrap width="163px"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "DescrizioneOperatore", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="DescrizioneOperatore"><%label.write(out);%></label><%}%></td>
          <td colspan="2"><% 
  WebTextInput RilevDatiPrdTSDescrizioneOperatore =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneOperatore"); 
  RilevDatiPrdTSDescrizioneOperatore.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneOperatore.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneOperatore.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneOperatore.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneOperatore.getName()%>" readonly size="40" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneOperatore.write(out); 
%>
</td> <!-- Fix 13175 -->
        </tr>
        <tr id="BollaTR">
          <td id="LabelBollaLavorazione" nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "BollaLavorazione", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="BollaLavorazione"><%label.write(out);%></label><%}%></td> <!-- Fix 14722 Aggiunto Id-->
          <td id="LabelBollaCucita" nowrap style="display:none;"><label class="thLabel" id="BollaCucita" name="BollaCucita">
 <% { WebLabelSimple label = new com.thera.thermfw.web.WebLabelSimple("it.thera.thip.produzione.raccoltaDati.resources.RilevDatiPrdTS", "LabelBollaCucita", null, null, null, null); 
 label.setParent(RilevDatiPrdTSForm); 
label.write(out); }%> 
</label></td> <!-- Fix 14722 -->
          <td><% 
  WebTextInput RilevDatiPrdTSBollaLavorazione =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "BollaLavorazione"); 
  RilevDatiPrdTSBollaLavorazione.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSBollaLavorazione.getClassType()%>" id="<%=RilevDatiPrdTSBollaLavorazione.getId()%>" maxlength="<%=RilevDatiPrdTSBollaLavorazione.getMaxLength()%>" name="<%=RilevDatiPrdTSBollaLavorazione.getName()%>" readonly size="25" tabindex="-1"><% 
  RilevDatiPrdTSBollaLavorazione.write(out); 
%>
</td> <!-- Fix 13175 -->
          <td><% 
  WebTextInput RilevDatiPrdTSDescrizioneBolla =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneBolla"); 
  RilevDatiPrdTSDescrizioneBolla.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneBolla.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneBolla.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneBolla.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneBolla.getName()%>" readonly size="30" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneBolla.write(out); 
%>
</td>
        </tr>
        <!--<tr valign="top">--><!--Fix 13574 -->
         <tr id="TrOrdine"> <!--Fix 13574 --> <!-- Fix 14722 Aggiunto Id-->
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "IdNumeroOrdine", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="IdNumeroOrdine"><%label.write(out);%></label><%}%></td>
          <td colspan="2">
            <% 
  WebTextInput RilevDatiPrdTSIdAnnoOrdine =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdAnnoOrdine"); 
  RilevDatiPrdTSIdAnnoOrdine.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdAnnoOrdine.getClassType()%>" id="<%=RilevDatiPrdTSIdAnnoOrdine.getId()%>" maxlength="<%=RilevDatiPrdTSIdAnnoOrdine.getMaxLength()%>" name="<%=RilevDatiPrdTSIdAnnoOrdine.getName()%>" readonly size="4" tabindex="-1"><% 
  RilevDatiPrdTSIdAnnoOrdine.write(out); 
%>

            <% 
  WebTextInput RilevDatiPrdTSIdNumeroOrdine =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdNumeroOrdine"); 
  RilevDatiPrdTSIdNumeroOrdine.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdNumeroOrdine.getClassType()%>" id="<%=RilevDatiPrdTSIdNumeroOrdine.getId()%>" maxlength="<%=RilevDatiPrdTSIdNumeroOrdine.getMaxLength()%>" name="<%=RilevDatiPrdTSIdNumeroOrdine.getName()%>" readonly size="<%=RilevDatiPrdTSIdNumeroOrdine.getSize()%>" style="width:228px" tabindex="-1"><% 
  RilevDatiPrdTSIdNumeroOrdine.write(out); 
%>

          </td> <!-- Fix 13175 -->
        </tr>
        <!-- Fix 14722 inizio-->
        <tr id="TrBollaCucita" style="display:none;" valign="top">
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "IdNumeroBolla", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="IdNumeroBolla"><%label.write(out);%></label><%}%></td>
          <td colspan="2">
            <% 
  WebTextInput RilevDatiPrdTSIdAnnoBolla =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdAnnoBolla"); 
  RilevDatiPrdTSIdAnnoBolla.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdAnnoBolla.getClassType()%>" id="<%=RilevDatiPrdTSIdAnnoBolla.getId()%>" maxlength="<%=RilevDatiPrdTSIdAnnoBolla.getMaxLength()%>" name="<%=RilevDatiPrdTSIdAnnoBolla.getName()%>" readonly size="4" tabindex="-1"><% 
  RilevDatiPrdTSIdAnnoBolla.write(out); 
%>

            <% 
  WebTextInput RilevDatiPrdTSIdNumeroBolla =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdNumeroBolla"); 
  RilevDatiPrdTSIdNumeroBolla.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdNumeroBolla.getClassType()%>" id="<%=RilevDatiPrdTSIdNumeroBolla.getId()%>" maxlength="<%=RilevDatiPrdTSIdNumeroBolla.getMaxLength()%>" name="<%=RilevDatiPrdTSIdNumeroBolla.getName()%>" readonly size="10" style="width:228px" tabindex="-1"><% 
  RilevDatiPrdTSIdNumeroBolla.write(out); 
%>

          </td>
        </tr>
        <!-- Fix 14722 fine-->
        <tr id="TrArticolo"> <!-- Fix 14722 Aggiunto id-->
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "IdArticolo", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="IdArticolo"><%label.write(out);%></label><%}%></td>
          <td><% 
  WebTextInput RilevDatiPrdTSIdArticolo =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdArticolo"); 
  RilevDatiPrdTSIdArticolo.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdArticolo.getClassType()%>" id="<%=RilevDatiPrdTSIdArticolo.getId()%>" maxlength="<%=RilevDatiPrdTSIdArticolo.getMaxLength()%>" name="<%=RilevDatiPrdTSIdArticolo.getName()%>" readonly size="25" tabindex="-1"><% 
  RilevDatiPrdTSIdArticolo.write(out); 
%>
</td> <!-- Fix 13175 -->
          <td><% 
  WebTextInput RilevDatiPrdTSDescrizioneArticolo =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneArticolo"); 
  RilevDatiPrdTSDescrizioneArticolo.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneArticolo.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneArticolo.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneArticolo.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneArticolo.getName()%>" readonly size="30" style="width: 300px;" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneArticolo.write(out); 
%>
</td><!-- Fix 33517 -->
        </tr>
        <!-- Fix 33517 inizio-->
        <tr id="TrConfigurazione" style="display:none"> 
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "IdEsternoConfig", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="IdEsternoConfig"><%label.write(out);%></label><%}%></td>
          <td><% 
  WebTextInput RilevDatiPrdTSIdEsternoConfig =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdEsternoConfig"); 
  RilevDatiPrdTSIdEsternoConfig.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdEsternoConfig.getClassType()%>" id="<%=RilevDatiPrdTSIdEsternoConfig.getId()%>" maxlength="<%=RilevDatiPrdTSIdEsternoConfig.getMaxLength()%>" name="<%=RilevDatiPrdTSIdEsternoConfig.getName()%>" readonly size="25" tabindex="-1"><% 
  RilevDatiPrdTSIdEsternoConfig.write(out); 
%>
</td> 
          <td><% 
  WebTextInput RilevDatiPrdTSDescrizioneConfig =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneConfig"); 
  RilevDatiPrdTSDescrizioneConfig.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneConfig.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneConfig.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneConfig.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneConfig.getName()%>" readonly size="50" style="width: 300px;" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneConfig.write(out); 
%>
</td>
        </tr>
        <!-- Fix 33517 fine-->
        <!-- Fix 30572 inizio-->
        <tr id="TrCommessa"> 
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "IdCommessa", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="IdCommessa"><%label.write(out);%></label><%}%></td>
          <td><% 
  WebTextInput RilevDatiPrdTSIdCommessa =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdCommessa"); 
  RilevDatiPrdTSIdCommessa.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdCommessa.getClassType()%>" id="<%=RilevDatiPrdTSIdCommessa.getId()%>" maxlength="<%=RilevDatiPrdTSIdCommessa.getMaxLength()%>" name="<%=RilevDatiPrdTSIdCommessa.getName()%>" readonly size="25" tabindex="-1"><% 
  RilevDatiPrdTSIdCommessa.write(out); 
%>
</td> 
          <td><% 
  WebTextInput RilevDatiPrdTSDescrizioneCommessa =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneCommessa"); 
  RilevDatiPrdTSDescrizioneCommessa.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneCommessa.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneCommessa.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneCommessa.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneCommessa.getName()%>" readonly size="30" style="width: 300px;" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneCommessa.write(out); 
%>
</td><!-- Fix 33517 -->
        </tr>
        <!-- Fix 30572 fine-->
				<tr>
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "OraFine", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="OraFine"><%label.write(out);%></label><%}%></td>
          <td colspan="2"><% 
  WebTextInput RilevDatiPrdTSOraFine =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "OraFine"); 
  RilevDatiPrdTSOraFine.setOnFocus("showKeyPadOra(this);"); 
  RilevDatiPrdTSOraFine.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSOraFine.getClassType()%>" id="<%=RilevDatiPrdTSOraFine.getId()%>" maxlength="<%=RilevDatiPrdTSOraFine.getMaxLength()%>" name="<%=RilevDatiPrdTSOraFine.getName()%>" readonly size="<%=RilevDatiPrdTSOraFine.getSize()%>" tabindex="-1"><% 
  RilevDatiPrdTSOraFine.write(out); 
%>
</td>
        </tr>
				<tr>
 	    	  <td><label id="RisorsaLabel">Risorsa</label></td>
					<td colspan="2"><% 
  WebSearchComboBox RilevDatiPrdTSRisorsa =  
     new com.thera.thermfw.web.WebSearchComboBox("RilevDatiPrdTS", "Risorsa", null, 2, null, false, "getRisorse"); 
  RilevDatiPrdTSRisorsa.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSRisorsa.write(out); 
%>
<!--<span class="searchcombobox" id="Risorsa"></span>--></td>
				</tr>
				<tr id="QuantitaTR">
          <td colspan="3">
            <table cellpadding="0" cellspacing="0">
              <tr>
                <td nowrap width="170px"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "Quantita", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="Quantita"><%label.write(out);%></label><%}%></td>
                <td><% 
  WebTextInput RilevDatiPrdTSQuantita =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "Quantita"); 
  RilevDatiPrdTSQuantita.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQuantita.setOnChange("recuperaQtaSec();"); 
  RilevDatiPrdTSQuantita.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQuantita.getClassType()%>" id="<%=RilevDatiPrdTSQuantita.getId()%>" maxlength="<%=RilevDatiPrdTSQuantita.getMaxLength()%>" name="<%=RilevDatiPrdTSQuantita.getName()%>" size="9"><% 
  RilevDatiPrdTSQuantita.write(out); 
%>
</td>
                <td width="10px"></td>
                <td><% 
  WebTextInput RilevDatiPrdTSIdUMPrm =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrm"); 
  RilevDatiPrdTSIdUMPrm.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrm.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrm.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrm.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrm.getName()%>" readonly size="3" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrm.write(out); 
%>
</td>
                <td width="55px"></td>
                <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "QtaScarto", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="QtaScarto"><%label.write(out);%></label><%}%></td>
                <td width="10px"></td>
                <td colspan="2"><% 
  WebTextInput RilevDatiPrdTSQtaScarto =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaScarto"); 
  RilevDatiPrdTSQtaScarto.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaScarto.setOnChange("recuperaQtaScartoSec();"); 
  RilevDatiPrdTSQtaScarto.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaScarto.getClassType()%>" id="<%=RilevDatiPrdTSQtaScarto.getId()%>" maxlength="<%=RilevDatiPrdTSQtaScarto.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaScarto.getName()%>" size="9"><% 
  RilevDatiPrdTSQtaScarto.write(out); 
%>
</td>
                <td width="10px"></td> <!-- Fix 39680 -->
                <td colspan="2" id="RicalcoloQuantitaTD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantita =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantita"); 
  RilevDatiPrdTSRicalcoloQuantita.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantita.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantita.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantita.write(out); 
%>
</td> <!-- Fix 39680 -->
              </tr>
              <tr height="10px">
              </tr>
              <tr id="QuantitaSecTR">
                <td nowrap></td>
                <td><% 
  WebTextInput RilevDatiPrdTSQuantitaSec =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QuantitaSec"); 
  RilevDatiPrdTSQuantitaSec.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQuantitaSec.setOnChange("recuperaQtaPrm();recuperaQtaArrotondateSec();"); 
  RilevDatiPrdTSQuantitaSec.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQuantitaSec.getClassType()%>" id="<%=RilevDatiPrdTSQuantitaSec.getId()%>" maxlength="<%=RilevDatiPrdTSQuantitaSec.getMaxLength()%>" name="<%=RilevDatiPrdTSQuantitaSec.getName()%>" size="9"><% 
  RilevDatiPrdTSQuantitaSec.write(out); 
%>
</td>
                <td width="10px"></td>
                <td><% 
  WebTextInput RilevDatiPrdTSIdUMSec =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSec"); 
  RilevDatiPrdTSIdUMSec.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSec.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSec.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSec.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSec.getName()%>" readonly size="3" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSec.write(out); 
%>
</td>
                <td width="55px"></td>
                <td nowrap></td>
                <td width="10px"></td>
                <td colspan="2"><% 
  WebTextInput RilevDatiPrdTSQtaScartoSec =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaScartoSec"); 
  RilevDatiPrdTSQtaScartoSec.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaScartoSec.setOnChange("recuperaQtaScartoPrm();recuperaQtaScartoArrotondateSec();"); 
  RilevDatiPrdTSQtaScartoSec.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaScartoSec.getClassType()%>" id="<%=RilevDatiPrdTSQtaScartoSec.getId()%>" maxlength="<%=RilevDatiPrdTSQtaScartoSec.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaScartoSec.getName()%>" size="9"><% 
  RilevDatiPrdTSQtaScartoSec.write(out); 
%>
</td>
              </tr>
            </table>
          </td>
        </tr>
			  <tr>
          <td nowrap><label>Saldo</label></td>
          <td><% 
  WebComboBox RilevDatiPrdTSSaldo =  
     new com.thera.thermfw.web.WebComboBox("RilevDatiPrdTS", "Saldo", null); 
  RilevDatiPrdTSSaldo.setParent(RilevDatiPrdTSForm); 
%>
<select id="<%=RilevDatiPrdTSSaldo.getId()%>" name="<%=RilevDatiPrdTSSaldo.getName()%>"><% 
  RilevDatiPrdTSSaldo.write(out); 
%> 
</select></td>
        </tr>
       	<tr id="RiprendiDichTR" style="display:none">
          <td nowrap></td>
          <td colspan="2" nowrap><% 
  WebCheckBox RilevDatiPrdTSRiprendiRilevSospesa =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RiprendiRilevSospesa"); 
  RilevDatiPrdTSRiprendiRilevSospesa.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRiprendiRilevSospesa.getId()%>" name="<%=RilevDatiPrdTSRiprendiRilevSospesa.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRiprendiRilevSospesa.write(out); 
%>
</td>
        </tr>
        <tr>
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "Note", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="Note"><%label.write(out);%></label><%}%></td>
					<td colspan="2" id="NoteTD"><% 
  WebTextInput RilevDatiPrdTSNote =  
     new com.thera.thermfw.web.WebTextArea("RilevDatiPrdTS", "Note"); 
  RilevDatiPrdTSNote.setParent(RilevDatiPrdTSForm); 
%>
<textarea class="<%=RilevDatiPrdTSNote.getClassType()%>" cols="65" id="<%=RilevDatiPrdTSNote.getId()%>" maxlength="<%=RilevDatiPrdTSNote.getMaxLength()%>" name="<%=RilevDatiPrdTSNote.getName()%>" rows="3" size="<%=RilevDatiPrdTSNote.getSize()%>"></textarea><% 
  RilevDatiPrdTSNote.write(out); 
%>
</td> <!-- Fix 13175 -->
        </tr>
        <!-- SOF3	71XXX	Inizio -->
        <tr>
	<td>
							  <% 
  WebCheckBox RilevDatiPrdTSYNonGestirePicking =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "YNonGestirePicking"); 
			RilevDatiPrdTSYNonGestirePicking.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSYNonGestirePicking.getId()%>" name="<%=RilevDatiPrdTSYNonGestirePicking.getName()%>" type="checkbox" value="Y"><%
RilevDatiPrdTSYNonGestirePicking.write(out); 
%>
	</td>
        </tr>
        <tr>
        	 <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "YIdTipoUds", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="YIdTipoUds"><%label.write(out);%></label><%}%></td>
<td><% 
  WebTextInput RilevDatiPrdTSYIdTipoUds =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "YIdTipoUds"); 
		RilevDatiPrdTSYIdTipoUds.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSYIdTipoUds.getClassType()%>" id="<%=RilevDatiPrdTSYIdTipoUds.getId()%>" maxlength="<%=RilevDatiPrdTSYIdTipoUds.getMaxLength()%>" name="<%=RilevDatiPrdTSYIdTipoUds.getName()%>" size="25" tabindex="-1"><% 
RilevDatiPrdTSYIdTipoUds.write(out); 
%>
</td> 
        </tr>
<tr>
        	 <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "YNumeroPzBauletto", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="YNumeroPzBauletto"><%label.write(out);%></label><%}%></td>
<td><% 
  WebTextInput RilevDatiPrdTSYNumeroPzBauletto =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "YNumeroPzBauletto"); 
		RilevDatiPrdTSYNumeroPzBauletto.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSYNumeroPzBauletto.getClassType()%>" id="<%=RilevDatiPrdTSYNumeroPzBauletto.getId()%>" maxlength="<%=RilevDatiPrdTSYNumeroPzBauletto.getMaxLength()%>" name="<%=RilevDatiPrdTSYNumeroPzBauletto.getName()%>" size="25" tabindex="-1"><% 
RilevDatiPrdTSYNumeroPzBauletto.write(out); 
%>
</td> 
        </tr>
<tr>
        	 <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "YNumeroPzUds", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="YNumeroPzUds"><%label.write(out);%></label><%}%></td>
<td><% 
  WebTextInput RilevDatiPrdTSYNumeroPzUds =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "YNumeroPzUds"); 
		RilevDatiPrdTSYNumeroPzUds.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSYNumeroPzUds.getClassType()%>" id="<%=RilevDatiPrdTSYNumeroPzUds.getId()%>" maxlength="<%=RilevDatiPrdTSYNumeroPzUds.getMaxLength()%>" name="<%=RilevDatiPrdTSYNumeroPzUds.getName()%>" size="25" tabindex="-1"><% 
RilevDatiPrdTSYNumeroPzUds.write(out); 
%>
</td> 
        </tr>
        <!-- SOF3	71XXX	Fine -->
				<tr>
		  	  <td colspan="3"><label class="labelError" id="ErroriList"></label></td>
		  	</tr>
				<tr style="display:none">
  				<td colspan="3">
					 <% 
  WebTextInput RilevDatiPrdTSIdOperatore =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdOperatore"); 
  RilevDatiPrdTSIdOperatore.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdOperatore.getClassType()%>" id="<%=RilevDatiPrdTSIdOperatore.getId()%>" maxlength="<%=RilevDatiPrdTSIdOperatore.getMaxLength()%>" name="<%=RilevDatiPrdTSIdOperatore.getName()%>" size="<%=RilevDatiPrdTSIdOperatore.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSIdOperatore.write(out); 
%>

				   <% 
  WebTextInput RilevDatiPrdTSTipoTimbratura =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "TipoTimbratura"); 
  RilevDatiPrdTSTipoTimbratura.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSTipoTimbratura.getClassType()%>" id="<%=RilevDatiPrdTSTipoTimbratura.getId()%>" maxlength="<%=RilevDatiPrdTSTipoTimbratura.getMaxLength()%>" name="<%=RilevDatiPrdTSTipoTimbratura.getName()%>" size="<%=RilevDatiPrdTSTipoTimbratura.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSTipoTimbratura.write(out); 
%>

					 <% 
  WebTextInput RilevDatiPrdTSIdCausaleRilevazione =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdCausaleRilevazione"); 
  RilevDatiPrdTSIdCausaleRilevazione.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdCausaleRilevazione.getClassType()%>" id="<%=RilevDatiPrdTSIdCausaleRilevazione.getId()%>" maxlength="<%=RilevDatiPrdTSIdCausaleRilevazione.getMaxLength()%>" name="<%=RilevDatiPrdTSIdCausaleRilevazione.getName()%>" size="<%=RilevDatiPrdTSIdCausaleRilevazione.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSIdCausaleRilevazione.write(out); 
%>

					 <% 
  WebTextInput RilevDatiPrdTSIdRigaAttivita =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdRigaAttivita"); 
  RilevDatiPrdTSIdRigaAttivita.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdRigaAttivita.getClassType()%>" id="<%=RilevDatiPrdTSIdRigaAttivita.getId()%>" maxlength="<%=RilevDatiPrdTSIdRigaAttivita.getMaxLength()%>" name="<%=RilevDatiPrdTSIdRigaAttivita.getName()%>" size="<%=RilevDatiPrdTSIdRigaAttivita.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSIdRigaAttivita.write(out); 
%>

					 <% 
  WebTextInput RilevDatiPrdTSTipoRisorsa =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "TipoRisorsa"); 
  RilevDatiPrdTSTipoRisorsa.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSTipoRisorsa.getClassType()%>" id="<%=RilevDatiPrdTSTipoRisorsa.getId()%>" maxlength="<%=RilevDatiPrdTSTipoRisorsa.getMaxLength()%>" name="<%=RilevDatiPrdTSTipoRisorsa.getName()%>" size="<%=RilevDatiPrdTSTipoRisorsa.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSTipoRisorsa.write(out); 
%>

 				   <% 
  WebTextInput RilevDatiPrdTSLivelloRisorsa =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "LivelloRisorsa"); 
  RilevDatiPrdTSLivelloRisorsa.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSLivelloRisorsa.getClassType()%>" id="<%=RilevDatiPrdTSLivelloRisorsa.getId()%>" maxlength="<%=RilevDatiPrdTSLivelloRisorsa.getMaxLength()%>" name="<%=RilevDatiPrdTSLivelloRisorsa.getName()%>" size="<%=RilevDatiPrdTSLivelloRisorsa.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSLivelloRisorsa.write(out); 
%>

				 	 <% 
  WebTextInput RilevDatiPrdTSIdAmbiente =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdAmbiente"); 
  RilevDatiPrdTSIdAmbiente.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdAmbiente.getClassType()%>" id="<%=RilevDatiPrdTSIdAmbiente.getId()%>" maxlength="<%=RilevDatiPrdTSIdAmbiente.getMaxLength()%>" name="<%=RilevDatiPrdTSIdAmbiente.getName()%>" size="<%=RilevDatiPrdTSIdAmbiente.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSIdAmbiente.write(out); 
%>
 <!-- Fix 12841 -->
 					 <% 
  WebTextInput RilevDatiPrdTSIdMacchina =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdMacchina"); 
  RilevDatiPrdTSIdMacchina.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdMacchina.getClassType()%>" id="<%=RilevDatiPrdTSIdMacchina.getId()%>" maxlength="<%=RilevDatiPrdTSIdMacchina.getMaxLength()%>" name="<%=RilevDatiPrdTSIdMacchina.getName()%>" size="<%=RilevDatiPrdTSIdMacchina.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSIdMacchina.write(out); 
%>
 <!-- Fix 12841 -->
                <% 
  WebTextInput RilevDatiPrdTSTipoBolla =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "TipoBolla"); 
  RilevDatiPrdTSTipoBolla.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSTipoBolla.getClassType()%>" id="<%=RilevDatiPrdTSTipoBolla.getId()%>" maxlength="<%=RilevDatiPrdTSTipoBolla.getMaxLength()%>" name="<%=RilevDatiPrdTSTipoBolla.getName()%>" size="<%=RilevDatiPrdTSTipoBolla.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSTipoBolla.write(out); 
%>
 <!-- Fix 14722 -->
					 <% 
  WebTextInput RilevDatiPrdTSStampaBolla =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "StampaBolla"); 
  RilevDatiPrdTSStampaBolla.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSStampaBolla.getClassType()%>" id="<%=RilevDatiPrdTSStampaBolla.getId()%>" maxlength="<%=RilevDatiPrdTSStampaBolla.getMaxLength()%>" name="<%=RilevDatiPrdTSStampaBolla.getName()%>" size="<%=RilevDatiPrdTSStampaBolla.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSStampaBolla.write(out); 
%>
<!-- Fix 30900 -->
					 <% 
  WebTextInput RilevDatiPrdTSIdConfigurazione =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdConfigurazione"); 
  RilevDatiPrdTSIdConfigurazione.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdConfigurazione.getClassType()%>" id="<%=RilevDatiPrdTSIdConfigurazione.getId()%>" maxlength="<%=RilevDatiPrdTSIdConfigurazione.getMaxLength()%>" name="<%=RilevDatiPrdTSIdConfigurazione.getName()%>" size="<%=RilevDatiPrdTSIdConfigurazione.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSIdConfigurazione.write(out); 
%>
<!-- Fix 33517 -->
					</td>
					<!-- Fix 39680 Inizio -->
					<td style="display:none">
					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl1 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl1"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl1.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl1.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl1.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl1.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl2 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl2"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl2.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl2.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl2.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl2.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl3 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl3"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl3.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl3.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl3.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl3.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl4 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl4"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl4.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl4.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl4.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl4.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl5 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl5"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl5.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl5.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl5.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl5.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl6 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl6"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl6.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl6.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl6.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl6.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl7 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl7"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl7.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl7.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl7.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl7.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl8 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl8"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl8.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl8.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl8.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl8.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl9 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl9"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl9.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl9.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl9.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl9.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl10 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl10"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl10.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl10.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl10.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl10.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl11 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl11"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl11.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl11.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl11.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl11.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl12 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl12"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl12.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl12.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl12.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl12.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl13 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl13"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl13.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl13.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl13.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl13.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl14 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl14"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl14.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl14.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl14.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl14.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl15 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl15"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl15.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl15.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl15.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl15.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl16 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl16"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl16.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl16.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl16.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl16.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl17 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl17"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl17.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl17.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl17.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl17.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl18 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl18"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl18.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl18.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl18.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl18.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl19 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl19"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl19.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl19.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl19.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl19.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl20 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl20"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl20.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl20.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl20.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl20.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers1 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers1"); 
  RilevDatiPrdTSRicalcoloQuantitaVers1.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers1.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers1.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers1.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers2 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers2"); 
  RilevDatiPrdTSRicalcoloQuantitaVers2.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers2.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers2.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers2.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers3 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers3"); 
  RilevDatiPrdTSRicalcoloQuantitaVers3.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers3.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers3.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers3.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers4 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers4"); 
  RilevDatiPrdTSRicalcoloQuantitaVers4.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers4.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers4.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers4.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers5 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers5"); 
  RilevDatiPrdTSRicalcoloQuantitaVers5.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers5.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers5.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers5.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers6 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers6"); 
  RilevDatiPrdTSRicalcoloQuantitaVers6.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers6.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers6.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers6.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers7 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers7"); 
  RilevDatiPrdTSRicalcoloQuantitaVers7.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers7.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers7.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers7.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers8 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers8"); 
  RilevDatiPrdTSRicalcoloQuantitaVers8.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers8.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers8.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers8.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers9 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers9"); 
  RilevDatiPrdTSRicalcoloQuantitaVers9.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers9.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers9.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers9.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers10 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers10"); 
  RilevDatiPrdTSRicalcoloQuantitaVers10.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers10.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers10.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers10.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers11 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers11"); 
  RilevDatiPrdTSRicalcoloQuantitaVers11.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers11.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers11.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers11.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers12 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers12"); 
  RilevDatiPrdTSRicalcoloQuantitaVers12.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers12.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers12.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers12.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers13 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers13"); 
  RilevDatiPrdTSRicalcoloQuantitaVers13.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers13.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers13.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers13.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers14 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers14"); 
  RilevDatiPrdTSRicalcoloQuantitaVers14.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers14.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers14.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers14.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers15 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers15"); 
  RilevDatiPrdTSRicalcoloQuantitaVers15.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers15.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers15.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers15.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers16 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers16"); 
  RilevDatiPrdTSRicalcoloQuantitaVers16.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers16.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers16.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers16.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers17 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers17"); 
  RilevDatiPrdTSRicalcoloQuantitaVers17.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers17.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers17.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers17.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers18 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers18"); 
  RilevDatiPrdTSRicalcoloQuantitaVers18.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers18.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers18.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers18.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers19 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers19"); 
  RilevDatiPrdTSRicalcoloQuantitaVers19.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers19.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers19.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers19.write(out); 
%>

					  <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaVers20 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaVers20"); 
  RilevDatiPrdTSRicalcoloQuantitaVers20.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaVers20.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaVers20.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaVers20.write(out); 
%>

					</td>
					<!-- Fix 39680 Fine -->                                     
				</tr>
      </table>
    </td>
  </tr>
  <tr><td> 
   <!-- Fix 32648 Inizio -->
   <!-- <iframe  id="KeyPad" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"    style="display:none; position: absolute; left: 120; top:300; width:107; height:155;" src="it/thera/thip/produzione/raccoltaDati/KeyPad.jsp"></iframe>-->
   <iframe frameborder="0" id="KeyPad" marginheight="0" marginwidth="0" scrolling="no" src="it/thera/thip/produzione/raccoltaDati/KeyPad.jsp" style="display:none; position: absolute; left: 120; top:300; width:152; height:160;"></iframe>
   <!-- Fix 32648 Fine -->
</td>
  </tr>
  <!-- Fix 42882 Inizio -->
  <tr><td>    
   <iframe frameborder="0" id="KeyPadOra" marginheight="0" marginwidth="0" scrolling="no" src="it/thera/thip/produzione/raccoltaDati/KeyPadOra.jsp" style="display:none; position: absolute; left: 120; top:300; width:152; height:160;"></iframe>
   </td>
  </tr>
  <!-- Fix 42882 Fine -->
</table>
<%
  RilevDatiPrdTSForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = RilevDatiPrdTSForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", RilevDatiPrdTSBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


<%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              RilevDatiPrdTSForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, RilevDatiPrdTSBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, RilevDatiPrdTSBODC.getErrorList().getErrors()); 
           if(RilevDatiPrdTSBODC.getConflict() != null) 
                conflitPresent = true; 
     } 
     else 
        errors.add(new ErrorMessage("BAS0000010")); 
  } 
  catch(NamingException e) { 
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("CBS000025", errorMessage));  } 
  catch(SQLException e) {
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("BAS0000071", errorMessage));  } 
  catch(Throwable e) {
     e.printStackTrace(Trace.excStream);
  }
  finally 
  {
     if(RilevDatiPrdTSBODC != null && !RilevDatiPrdTSBODC.close(false)) 
        errors.addAll(0, RilevDatiPrdTSBODC.getErrorList().getErrors()); 
     try 
     { 
        se.end(); 
     }
     catch(IllegalArgumentException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
     catch(SQLException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
  } 
  if(!errors.isEmpty())
  { 
      if(!conflitPresent)
  { 
     request.setAttribute("ErrorMessages", errors); 
     String errorPage = RilevDatiPrdTSForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", RilevDatiPrdTSBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = RilevDatiPrdTSForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
