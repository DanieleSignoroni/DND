<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///D:\3rdParty\Panthera4.6.0\websrc\dtd/xhtml1-transitional.dtd">
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
     new com.thera.thermfw.web.WebForm(request, response, "RilevDatiPrdTSForm", "RilevDatiPrdTS", null, "it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSFormActionAdapter", false, false, false, false, true, true, null, 1, true, "it/thera/thip/produzione/raccoltaDati/DichiarazionePrelievi.js"); 
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

<title></title>
</head>
<body bottommargin="0" leftmargin="0" onfocus="manageKeyPad();" onbeforeunload="<%=RilevDatiPrdTSForm.getBodyOnBeforeUnload()%>" onclick="manageKeyPad();" onload="<%=RilevDatiPrdTSForm.getBodyOnLoad()%>" onunload="<%=RilevDatiPrdTSForm.getBodyOnUnload()%>" rightmargin="0" topmargin="0"><%
   RilevDatiPrdTSForm.writeBodyStartElements(out); 
%> 
<!--Fix 15250--><!-- Fix 31082 -->

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


<table class="maintable" style="height:100%">
  <tr valign="top">
    <td colspan="2" style="height:15px"></td>
  </tr>
  <tr valign="top">
    <td width="15px"></td>
    <td width="1">
      <table cellpadding="3" cellspacing="3">
        <tr valign="top">
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "DescrizioneOperatore", null); 
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
</td>
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
</td>
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
        <tr id="TrOrdine" valign="top"> <!-- Fix 14722 Aggiunto Id-->
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

          </td>
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
        <tr style="display:none">
          <td colspan="2">
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
  WebTextInput RilevDatiPrdTSIdRisorsa =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdRisorsa"); 
  RilevDatiPrdTSIdRisorsa.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdRisorsa.getClassType()%>" id="<%=RilevDatiPrdTSIdRisorsa.getId()%>" maxlength="<%=RilevDatiPrdTSIdRisorsa.getMaxLength()%>" name="<%=RilevDatiPrdTSIdRisorsa.getName()%>" size="<%=RilevDatiPrdTSIdRisorsa.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSIdRisorsa.write(out); 
%>

            <% 
  WebTextInput RilevDatiPrdTSIdAmbiente =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdAmbiente"); 
  RilevDatiPrdTSIdAmbiente.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdAmbiente.getClassType()%>" id="<%=RilevDatiPrdTSIdAmbiente.getId()%>" maxlength="<%=RilevDatiPrdTSIdAmbiente.getMaxLength()%>" name="<%=RilevDatiPrdTSIdAmbiente.getName()%>" size="<%=RilevDatiPrdTSIdAmbiente.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSIdAmbiente.write(out); 
%>

            <% 
  WebTextInput RilevDatiPrdTSTipoBolla =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "TipoBolla"); 
  RilevDatiPrdTSTipoBolla.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSTipoBolla.getClassType()%>" id="<%=RilevDatiPrdTSTipoBolla.getId()%>" maxlength="<%=RilevDatiPrdTSTipoBolla.getMaxLength()%>" name="<%=RilevDatiPrdTSTipoBolla.getName()%>" size="<%=RilevDatiPrdTSTipoBolla.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSTipoBolla.write(out); 
%>

            <% 
  WebTextInput RilevDatiPrdTSTempo =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "Tempo"); 
  RilevDatiPrdTSTempo.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSTempo.getClassType()%>" id="<%=RilevDatiPrdTSTempo.getId()%>" maxlength="<%=RilevDatiPrdTSTempo.getMaxLength()%>" name="<%=RilevDatiPrdTSTempo.getName()%>" size="<%=RilevDatiPrdTSTempo.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSTempo.write(out); 
%>

            <% 
  WebTextInput RilevDatiPrdTSNote =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "Note"); 
  RilevDatiPrdTSNote.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSNote.getClassType()%>" id="<%=RilevDatiPrdTSNote.getId()%>" maxlength="<%=RilevDatiPrdTSNote.getMaxLength()%>" name="<%=RilevDatiPrdTSNote.getName()%>" size="<%=RilevDatiPrdTSNote.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSNote.write(out); 
%>

            <% 
  WebTextInput RilevDatiPrdTSCurrentNumPag =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "CurrentNumPag"); 
  RilevDatiPrdTSCurrentNumPag.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSCurrentNumPag.getClassType()%>" id="<%=RilevDatiPrdTSCurrentNumPag.getId()%>" maxlength="<%=RilevDatiPrdTSCurrentNumPag.getMaxLength()%>" name="<%=RilevDatiPrdTSCurrentNumPag.getName()%>" size="<%=RilevDatiPrdTSCurrentNumPag.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSCurrentNumPag.write(out); 
%>
<!-- Fix 18536 -->
            <% 
  WebTextInput RilevDatiPrdTSQuantita =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "Quantita"); 
  RilevDatiPrdTSQuantita.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQuantita.getClassType()%>" id="<%=RilevDatiPrdTSQuantita.getId()%>" maxlength="<%=RilevDatiPrdTSQuantita.getMaxLength()%>" name="<%=RilevDatiPrdTSQuantita.getName()%>" size="<%=RilevDatiPrdTSQuantita.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSQuantita.write(out); 
%>
<!-- Fix 20491 -->
			<% 
  WebTextInput RilevDatiPrdTSQtaScarto =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaScarto"); 
  RilevDatiPrdTSQtaScarto.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaScarto.getClassType()%>" id="<%=RilevDatiPrdTSQtaScarto.getId()%>" maxlength="<%=RilevDatiPrdTSQtaScarto.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaScarto.getName()%>" size="<%=RilevDatiPrdTSQtaScarto.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSQtaScarto.write(out); 
%>
<!-- Fix 26494 -->
            <% 
  WebTextInput RilevDatiPrdTSOreRilevate =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "OreRilevate"); 
  RilevDatiPrdTSOreRilevate.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSOreRilevate.getClassType()%>" id="<%=RilevDatiPrdTSOreRilevate.getId()%>" maxlength="<%=RilevDatiPrdTSOreRilevate.getMaxLength()%>" name="<%=RilevDatiPrdTSOreRilevate.getName()%>" size="<%=RilevDatiPrdTSOreRilevate.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSOreRilevate.write(out); 
%>
<!-- Fix 25175 -->
            <% 
  WebTextInput RilevDatiPrdTSMinutiRilevati =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "MinutiRilevati"); 
  RilevDatiPrdTSMinutiRilevati.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSMinutiRilevati.getClassType()%>" id="<%=RilevDatiPrdTSMinutiRilevati.getId()%>" maxlength="<%=RilevDatiPrdTSMinutiRilevati.getMaxLength()%>" name="<%=RilevDatiPrdTSMinutiRilevati.getName()%>" size="<%=RilevDatiPrdTSMinutiRilevati.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSMinutiRilevati.write(out); 
%>
<!-- Fix 25175 -->
            <% 
  WebTextInput RilevDatiPrdTSSecondiRilevati =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "SecondiRilevati"); 
  RilevDatiPrdTSSecondiRilevati.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSSecondiRilevati.getClassType()%>" id="<%=RilevDatiPrdTSSecondiRilevati.getId()%>" maxlength="<%=RilevDatiPrdTSSecondiRilevati.getMaxLength()%>" name="<%=RilevDatiPrdTSSecondiRilevati.getName()%>" size="<%=RilevDatiPrdTSSecondiRilevati.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSSecondiRilevati.write(out); 
%>
<!-- Fix 30080 -->
            <% 
  WebTextInput RilevDatiPrdTSOraFine =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "OraFine"); 
  RilevDatiPrdTSOraFine.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSOraFine.getClassType()%>" id="<%=RilevDatiPrdTSOraFine.getId()%>" maxlength="<%=RilevDatiPrdTSOraFine.getMaxLength()%>" name="<%=RilevDatiPrdTSOraFine.getName()%>" size="<%=RilevDatiPrdTSOraFine.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSOraFine.write(out); 
%>
<!-- Fix 30440 -->
            <% 
  WebTextInput RilevDatiPrdTSDataFine =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DataFine"); 
  RilevDatiPrdTSDataFine.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDataFine.getClassType()%>" id="<%=RilevDatiPrdTSDataFine.getId()%>" maxlength="<%=RilevDatiPrdTSDataFine.getMaxLength()%>" name="<%=RilevDatiPrdTSDataFine.getName()%>" size="<%=RilevDatiPrdTSDataFine.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSDataFine.write(out); 
%>
<!-- Fix 30440 -->
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
  WebTextInput RilevDatiPrdTSQuantitaSec =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QuantitaSec"); 
  RilevDatiPrdTSQuantitaSec.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQuantitaSec.getClassType()%>" id="<%=RilevDatiPrdTSQuantitaSec.getId()%>" maxlength="<%=RilevDatiPrdTSQuantitaSec.getMaxLength()%>" name="<%=RilevDatiPrdTSQuantitaSec.getName()%>" size="<%=RilevDatiPrdTSQuantitaSec.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSQuantitaSec.write(out); 
%>
<!-- Fix 32135 -->
            <% 
  WebTextInput RilevDatiPrdTSQtaScartoSec =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaScartoSec"); 
  RilevDatiPrdTSQtaScartoSec.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaScartoSec.getClassType()%>" id="<%=RilevDatiPrdTSQtaScartoSec.getId()%>" maxlength="<%=RilevDatiPrdTSQtaScartoSec.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaScartoSec.getName()%>" size="<%=RilevDatiPrdTSQtaScartoSec.getSize()%>" type="Hidden"><% 
  RilevDatiPrdTSQtaScartoSec.write(out); 
%>
<!-- Fix 32135 -->
            </td>
            <!-- Fix 39680 Inizio -->
            <td style="display:none">
              <% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantita =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantita"); 
  RilevDatiPrdTSRicalcoloQuantita.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantita.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantita.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantita.write(out); 
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
  <tr>
    <td width="15px"></td>
    <td height="100%">
      <div style="height:100%;overflow:auto;">
      <table cellpadding="1" cellspacing="1">
        <tr>
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "IdMateriale1", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="Materiale1"><%label.write(out);%></label><%}%></td>
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "QtaPrelevataUMPrm1", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="QtaPrelevataUMPrm1" style="margin: 0 60 0 0;"><%label.write(out);%></label><%}%></td>
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "IdUMPrmMat1", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="IdUMPrmMat1" style="margin: 0 30 0 0;"><%label.write(out);%></label><%}%></td>
          <td nowrap><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "RilevDatiPrdTS", "IdLotto1", null); 
   label.setParent(RilevDatiPrdTSForm); 
%><label class="<%=label.getClassType()%>" for="Lotto1"><%label.write(out);%></label><%}%></td>
          <!-- Fix 26036 - inizio -->
          <td nowrap><label class="labelro" id="LabelPers1" style="display:none">LabelPers1</label></td>
          <td nowrap><label class="labelro" id="LabelPers2" style="display:none">LabelPers2</label></td>
          <td nowrap><label class="labelro" id="LabelPers3" style="display:none">LabelPers3</label></td>
          <td nowrap><label class="labelro" id="LabelPers4" style="display:none">LabelPers4</label></td>
          <td nowrap><label class="labelro" id="LabelPers5" style="display:none">LabelPers5</label></td>
          <!-- Fix 26036 - fine -->
        </tr>
        <!-- Fix 14722 blocco commentato -->
      <!--/table>     </td>   </tr>   <tr>     <td width="15px"></td>     <td>       <table cellpadding="3" cellspacing="3"-->
        <tr id="TR1_1">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale1 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale1", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale1.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale1.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale1.setOnKeyBlur("onKeyBlurArticolo(1)"); 
  RilevDatiPrdTSMateriale1.setOnKeyChange("resetDatiMateriale(1)"); 
  RilevDatiPrdTSMateriale1.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale1.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale1.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale1.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale1"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione1 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione1", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione1.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione1.setOnSearchBack("verificaDatiArticoli(1)"); 
  RilevDatiPrdTSMaterialeVersione1.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione1.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione1.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione1"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig1 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig1", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig1.setExtraRelatedClassAD("IdAzienda,IdConfigurazione"); 
  RilevDatiPrdTSMaterialeConfig1.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig1.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig1.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig1.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig1"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm1 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm1"); 
  RilevDatiPrdTSQtaPrelevataUMPrm1.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm1.setOnChange("recuperaQtaSec(1);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm1.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm1.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm1.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm1.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm1.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm1.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat1 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat1"); 
  RilevDatiPrdTSIdUMPrmMat1.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat1.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat1.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat1.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat1.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat1.write(out); 
%>
</td>
            <td><% 
  WebMultiSearchForm RilevDatiPrdTSLotto1 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto1", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto1.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto1.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig1,IdConfigurazione;   IdVersione1,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto1.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto1.write(out); 
%>
<!--<span class="multisearchform" id="Lotto1"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc1 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc1", false, false, false, 1, null, null); 
RilevDatiPrdTSMappaUdc1.setParent(RilevDatiPrdTSForm); 
RilevDatiPrdTSMappaUdc1.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc1"></span>--></td>
        </tr>
        <tr id="TR1_2">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale1 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale1"); 
  RilevDatiPrdTSDescrizioneMateriale1.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale1.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale1.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale1.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale1.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale1.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec1 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec1"); 
  RilevDatiPrdTSQtaPrelevataUMSec1.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec1.setOnChange("recuperaQtaPrm(1);recuperaQtaArrotondateSec(1);"); 
  RilevDatiPrdTSQtaPrelevataUMSec1.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec1.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec1.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec1.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec1.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec1.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat1 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat1"); 
  RilevDatiPrdTSIdUMSecMat1.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat1.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat1.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat1.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat1.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat1.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl1TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl1 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl1"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl1.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl1.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl1.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl1.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
        <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl1 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl1", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl1.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl1.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl1"></span>--></td>
        </tr>
        <tr id="TR2_1" style="margin: 10 10 10 10;display:none;"> <!--Fix 18536-->
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale2 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale2", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale2.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale2.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale2.setOnKeyBlur("onKeyBlurArticolo(2)"); 
  RilevDatiPrdTSMateriale2.setOnKeyChange("resetDatiMateriale(2)"); 
  RilevDatiPrdTSMateriale2.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale2.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale2.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale2.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale2"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione2 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione2", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione2.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione2.setOnSearchBack("verificaDatiArticoli(2)"); 
  RilevDatiPrdTSMaterialeVersione2.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione2.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione2.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione2"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig2 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig2", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig2.setExtraRelatedClassAD("IdAzienda,IdConfigurazione"); 
  RilevDatiPrdTSMaterialeConfig2.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig2.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig2.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig2.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig2"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm2 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm2"); 
  RilevDatiPrdTSQtaPrelevataUMPrm2.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm2.setOnChange("recuperaQtaSec(2);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm2.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm2.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm2.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm2.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm2.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm2.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat2 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat2"); 
  RilevDatiPrdTSIdUMPrmMat2.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat2.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat2.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat2.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat2.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat2.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto2 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto2", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto2.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto2.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig2,IdConfigurazione;   IdVersione2,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto2.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto2.write(out); 
%>
<!--<span class="multisearchform" id="Lotto2"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc2 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc2", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc2.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc2.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc2"></span>--></td>
        </tr>
        <tr id="TR2_2" style="display:none;"> <!--Fix 18536-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale2 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale2"); 
  RilevDatiPrdTSDescrizioneMateriale2.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale2.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale2.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale2.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale2.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale2.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec2 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec2"); 
  RilevDatiPrdTSQtaPrelevataUMSec2.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec2.setOnChange("recuperaQtaPrm(2);recuperaQtaArrotondateSec(2);"); 
  RilevDatiPrdTSQtaPrelevataUMSec2.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec2.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec2.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec2.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec2.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec2.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat2 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat2"); 
  RilevDatiPrdTSIdUMSecMat2.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat2.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat2.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat2.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat2.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat2.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl2TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl2 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl2"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl2.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl2.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl2.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl2.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
        <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl2 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl2", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl2.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl2.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl2"></span>--></td>
        </tr>
        <tr id="TR3_1" style="margin: 10 10 10 10;display:none;"> <!--Fix 18536-->
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale3 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale3", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale3.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale3.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale3.setOnKeyBlur("onKeyBlurArticolo(3)"); 
  RilevDatiPrdTSMateriale3.setOnKeyChange("resetDatiMateriale(3)"); 
  RilevDatiPrdTSMateriale3.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale3.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale3.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale3.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale3"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione3 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione3", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione3.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione3.setOnSearchBack("verificaDatiArticoli(3)"); 
  RilevDatiPrdTSMaterialeVersione3.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione3.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione3.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione3"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig3 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig3", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig3.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig3.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig3.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig3.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig3"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm3 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm3"); 
  RilevDatiPrdTSQtaPrelevataUMPrm3.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm3.setOnChange("recuperaQtaSec(3);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm3.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm3.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm3.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm3.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm3.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm3.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat3 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat3"); 
  RilevDatiPrdTSIdUMPrmMat3.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat3.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat3.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat3.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat3.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat3.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto3 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto3", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto3.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto3.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig3,IdConfigurazione;   IdVersione3,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto3.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto3.write(out); 
%>
<!--<span class="multisearchform" id="Lotto3"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc3 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc3", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc3.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc3.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc3"></span>--></td>
        </tr>
        <tr id="TR3_2" style="display:none;"> <!--Fix 18536-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale3 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale3"); 
  RilevDatiPrdTSDescrizioneMateriale3.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale3.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale3.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale3.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale3.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale3.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec3 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec3"); 
  RilevDatiPrdTSQtaPrelevataUMSec3.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec3.setOnChange("recuperaQtaPrm(3);recuperaQtaArrotondateSec(3);"); 
  RilevDatiPrdTSQtaPrelevataUMSec3.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec3.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec3.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec3.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec3.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec3.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat3 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat3"); 
  RilevDatiPrdTSIdUMSecMat3.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat3.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat3.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat3.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat3.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat3.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl3TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl3 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl3"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl3.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl3.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl3.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl3.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl3 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl3", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl3.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl3.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl3"></span>--></td>
        </tr>
        <tr id="TR4_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale4 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale4", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale4.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale4.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale4.setOnKeyBlur("onKeyBlurArticolo(4)"); 
  RilevDatiPrdTSMateriale4.setOnKeyChange("resetDatiMateriale(4)"); 
  RilevDatiPrdTSMateriale4.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale4.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale4.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale4.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale4"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione4 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione4", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione4.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione4.setOnSearchBack("verificaDatiArticoli(4)"); 
  RilevDatiPrdTSMaterialeVersione4.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione4.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione4.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione4"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig4 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig4", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig4.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig4.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig4.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig4.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig4"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm4 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm4"); 
  RilevDatiPrdTSQtaPrelevataUMPrm4.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm4.setOnChange("recuperaQtaSec(4);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm4.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm4.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm4.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm4.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm4.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm4.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat4 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat4"); 
  RilevDatiPrdTSIdUMPrmMat4.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat4.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat4.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat4.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat4.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat4.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto4 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto4", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto4.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto4.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig4,IdConfigurazione;   IdVersione4,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto4.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto4.write(out); 
%>
<!--<span class="multisearchform" id="Lotto4"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc4 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc4", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc4.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc4.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc4"></span>--></td>
        </tr>
        <tr id="TR4_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale4 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale4"); 
  RilevDatiPrdTSDescrizioneMateriale4.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale4.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale4.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale4.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale4.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale4.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec4 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec4"); 
  RilevDatiPrdTSQtaPrelevataUMSec4.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec4.setOnChange("recuperaQtaPrm(4);recuperaQtaArrotondateSec(4);"); 
  RilevDatiPrdTSQtaPrelevataUMSec4.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec4.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec4.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec4.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec4.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec4.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat4 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat4"); 
  RilevDatiPrdTSIdUMSecMat4.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat4.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat4.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat4.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat4.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat4.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl4TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl4 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl4"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl4.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl4.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl4.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl4.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl4 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl4", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl4.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl4.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl4"></span>--></td>
        </tr>
        <tr id="TR5_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale5 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale5", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale5.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale5.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale5.setOnKeyBlur("onKeyBlurArticolo(5)"); 
  RilevDatiPrdTSMateriale5.setOnKeyChange("resetDatiMateriale(5)"); 
  RilevDatiPrdTSMateriale5.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale5.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale5.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale5.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale5"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione5 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione5", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione5.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione5.setOnSearchBack("verificaDatiArticoli(5)"); 
  RilevDatiPrdTSMaterialeVersione5.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione5.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione5.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione5"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig5 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig5", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig5.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig5.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig5.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig5.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig5"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm5 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm5"); 
  RilevDatiPrdTSQtaPrelevataUMPrm5.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm5.setOnChange("recuperaQtaSec(5);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm5.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm5.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm5.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm5.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm5.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm5.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat5 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat5"); 
  RilevDatiPrdTSIdUMPrmMat5.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat5.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat5.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat5.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat5.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat5.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto5 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto5", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto5.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto5.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig5,IdConfigurazione;   IdVersione5,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto5.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto5.write(out); 
%>
<!--<span class="multisearchform" id="Lotto5"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc5 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc5", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc5.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc5.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc5"></span>--></td>
        </tr>
        <tr id="TR5_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale5 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale5"); 
  RilevDatiPrdTSDescrizioneMateriale5.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale5.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale5.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale5.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale5.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale5.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec5 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec5"); 
  RilevDatiPrdTSQtaPrelevataUMSec5.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec5.setOnChange("recuperaQtaPrm(5);recuperaQtaArrotondateSec(5);"); 
  RilevDatiPrdTSQtaPrelevataUMSec5.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec5.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec5.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec5.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec5.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec5.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat5 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat5"); 
  RilevDatiPrdTSIdUMSecMat5.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat5.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat5.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat5.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat5.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat5.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl5TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl5 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl5"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl5.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl5.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl5.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl5.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl5 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl5", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl5.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl5.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl5"></span>--></td>
        </tr>
        <tr id="TR6_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale6 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale6", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale6.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale6.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale6.setOnKeyBlur("onKeyBlurArticolo(6)"); 
  RilevDatiPrdTSMateriale6.setOnKeyChange("resetDatiMateriale(6)"); 
  RilevDatiPrdTSMateriale6.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale6.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale6.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale6.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale6"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione6 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione6", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione6.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione6.setOnSearchBack("verificaDatiArticoli(6)"); 
  RilevDatiPrdTSMaterialeVersione6.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione6.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione6.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione6"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig6 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig6", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig6.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig6.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig6.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig6.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig6"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm6 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm6"); 
  RilevDatiPrdTSQtaPrelevataUMPrm6.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm6.setOnChange("recuperaQtaSec(6);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm6.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm6.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm6.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm6.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm6.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm6.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat6 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat6"); 
  RilevDatiPrdTSIdUMPrmMat6.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat6.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat6.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat6.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat6.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat6.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto6 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto6", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto6.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto6.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig6,IdConfigurazione;   IdVersione6,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto6.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto6.write(out); 
%>
<!--<span class="multisearchform" id="Lotto6"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc6 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc6", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc6.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc6.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc6"></span>--></td>
        </tr>
        <tr id="TR6_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale6 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale6"); 
  RilevDatiPrdTSDescrizioneMateriale6.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale6.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale6.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale6.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale6.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale6.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec6 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec6"); 
  RilevDatiPrdTSQtaPrelevataUMSec6.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec6.setOnChange("recuperaQtaPrm(6);recuperaQtaArrotondateSec(6);"); 
  RilevDatiPrdTSQtaPrelevataUMSec6.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec6.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec6.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec6.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec6.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec6.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat6 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat6"); 
  RilevDatiPrdTSIdUMSecMat6.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat6.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat6.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat6.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat6.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat6.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl6TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl6 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl6"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl6.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl6.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl6.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl6.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl6 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl6", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl6.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl6.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl6"></span>--></td>
        </tr>
        <tr id="TR7_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale7 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale7", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale7.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale7.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale7.setOnKeyBlur("onKeyBlurArticolo(7)"); 
  RilevDatiPrdTSMateriale7.setOnKeyChange("resetDatiMateriale(7)"); 
  RilevDatiPrdTSMateriale7.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale7.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale7.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale7.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale7"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione7 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione7", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione7.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione7.setOnSearchBack("verificaDatiArticoli(7)"); 
  RilevDatiPrdTSMaterialeVersione7.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione7.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione7.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione7"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig7 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig7", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig7.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig7.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig7.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig7.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig7"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm7 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm7"); 
  RilevDatiPrdTSQtaPrelevataUMPrm7.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm7.setOnChange("recuperaQtaSec(7);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm7.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm7.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm7.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm7.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm7.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm7.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat7 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat7"); 
  RilevDatiPrdTSIdUMPrmMat7.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat7.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat7.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat7.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat7.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat7.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto7 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto7", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto7.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto7.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig7,IdConfigurazione;   IdVersione7,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto7.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto7.write(out); 
%>
<!--<span class="multisearchform" id="Lotto7"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc7 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc7", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc7.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc7.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc7"></span>--></td>
        </tr>
        <tr id="TR7_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale7 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale7"); 
  RilevDatiPrdTSDescrizioneMateriale7.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale7.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale7.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale7.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale7.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale7.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec7 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec7"); 
  RilevDatiPrdTSQtaPrelevataUMSec7.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec7.setOnChange("recuperaQtaPrm(7);recuperaQtaArrotondateSec(7);"); 
  RilevDatiPrdTSQtaPrelevataUMSec7.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec7.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec7.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec7.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec7.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec7.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat7 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat7"); 
  RilevDatiPrdTSIdUMSecMat7.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat7.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat7.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat7.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat7.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat7.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl7TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl7 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl7"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl7.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl7.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl7.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl7.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl7 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl7", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl7.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl7.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl7"></span>--></td>
        </tr>
        <tr id="TR8_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale8 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale8", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale8.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale8.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale8.setOnKeyBlur("onKeyBlurArticolo(8)"); 
  RilevDatiPrdTSMateriale8.setOnKeyChange("resetDatiMateriale(8)"); 
  RilevDatiPrdTSMateriale8.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale8.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale8.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale8.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale8"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione8 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione8", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione8.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione8.setOnSearchBack("verificaDatiArticoli(8)"); 
  RilevDatiPrdTSMaterialeVersione8.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione8.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione8.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione8"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig8 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig8", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig8.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig8.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig8.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig8.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig8"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm8 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm8"); 
  RilevDatiPrdTSQtaPrelevataUMPrm8.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm8.setOnChange("recuperaQtaSec(8);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm8.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm8.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm8.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm8.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm8.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm8.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat8 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat8"); 
  RilevDatiPrdTSIdUMPrmMat8.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat8.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat8.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat8.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat8.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat8.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto8 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto8", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto8.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto8.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig8,IdConfigurazione;   IdVersione8,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto8.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto8.write(out); 
%>
<!--<span class="multisearchform" id="Lotto8"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc8 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc8", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc8.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc8.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc8"></span>--></td>
        </tr>
        <tr id="TR8_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale8 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale8"); 
  RilevDatiPrdTSDescrizioneMateriale8.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale8.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale8.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale8.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale8.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale8.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec8 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec8"); 
  RilevDatiPrdTSQtaPrelevataUMSec8.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec8.setOnChange("recuperaQtaPrm(8);recuperaQtaArrotondateSec(8);"); 
  RilevDatiPrdTSQtaPrelevataUMSec8.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec8.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec8.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec8.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec8.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec8.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat8 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat8"); 
  RilevDatiPrdTSIdUMSecMat8.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat8.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat8.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat8.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat8.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat8.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl8TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl8 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl8"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl8.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl8.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl8.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl8.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl8 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl8", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl8.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl8.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl8"></span>--></td>
        </tr>
        <tr id="TR9_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale9 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale9", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale9.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale9.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale9.setOnKeyBlur("onKeyBlurArticolo(9)"); 
  RilevDatiPrdTSMateriale9.setOnKeyChange("resetDatiMateriale(9)"); 
  RilevDatiPrdTSMateriale9.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale9.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale9.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale9.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale9"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione9 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione9", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione9.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione9.setOnSearchBack("verificaDatiArticoli(9)"); 
  RilevDatiPrdTSMaterialeVersione9.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione9.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione9.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione9"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig9 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig9", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig9.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig9.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig9.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig9.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig9"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm9 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm9"); 
  RilevDatiPrdTSQtaPrelevataUMPrm9.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm9.setOnChange("recuperaQtaSec(9);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm9.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm9.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm9.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm9.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm9.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm9.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat9 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat9"); 
  RilevDatiPrdTSIdUMPrmMat9.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat9.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat9.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat9.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat9.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat9.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto9 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto9", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto9.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto9.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig9,IdConfigurazione;   IdVersione9,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto9.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto9.write(out); 
%>
<!--<span class="multisearchform" id="Lotto9"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc9 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc9", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc9.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc9.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc9"></span>--></td>
        </tr>
        <tr id="TR9_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale9 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale9"); 
  RilevDatiPrdTSDescrizioneMateriale9.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale9.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale9.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale9.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale9.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale9.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec9 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec9"); 
  RilevDatiPrdTSQtaPrelevataUMSec9.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec9.setOnChange("recuperaQtaPrm(9);recuperaQtaArrotondateSec(9);"); 
  RilevDatiPrdTSQtaPrelevataUMSec9.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec9.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec9.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec9.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec9.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec9.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat9 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat9"); 
  RilevDatiPrdTSIdUMSecMat9.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat9.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat9.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat9.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat9.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat9.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl9TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl9 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl9"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl9.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl9.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl9.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl9.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl9 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl9", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl9.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl9.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl9"></span>--></td>
        </tr>
        <tr id="TR10_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale10 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale10", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale10.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale10.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale10.setOnKeyBlur("onKeyBlurArticolo(10)"); 
  RilevDatiPrdTSMateriale10.setOnKeyChange("resetDatiMateriale(10)"); 
  RilevDatiPrdTSMateriale10.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale10.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale10.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale10.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale10"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione10 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione10", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione10.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione10.setOnSearchBack("verificaDatiArticoli(10)"); 
  RilevDatiPrdTSMaterialeVersione10.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione10.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione10.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione10"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig10 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig10", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig10.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig10.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig10.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig10.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig10"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm10 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm10"); 
  RilevDatiPrdTSQtaPrelevataUMPrm10.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm10.setOnChange("recuperaQtaSec(10);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm10.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm10.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm10.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm10.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm10.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm10.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat10 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat10"); 
  RilevDatiPrdTSIdUMPrmMat10.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat10.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat10.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat10.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat10.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat10.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto10 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto10", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto10.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto10.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig10,IdConfigurazione;   IdVersione10,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto10.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto10.write(out); 
%>
<!--<span class="multisearchform" id="Lotto10"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc10 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc10", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc10.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc10.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc10"></span>--></td>
        </tr>
        <tr id="TR10_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale10 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale10"); 
  RilevDatiPrdTSDescrizioneMateriale10.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale10.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale10.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale10.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale10.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale10.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec10 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec10"); 
  RilevDatiPrdTSQtaPrelevataUMSec10.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec10.setOnChange("recuperaQtaPrm(10);recuperaQtaArrotondateSec(10);"); 
  RilevDatiPrdTSQtaPrelevataUMSec10.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec10.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec10.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec10.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec10.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec10.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat10 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat10"); 
  RilevDatiPrdTSIdUMSecMat10.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat10.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat10.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat10.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat10.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat10.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl10TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl10 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl10"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl10.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl10.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl10.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl10.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl10 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl10", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl10.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl10.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl10"></span>--></td>
        </tr>
        <tr id="TR11_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale11 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale11", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale11.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale11.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale11.setOnKeyBlur("onKeyBlurArticolo(11)"); 
  RilevDatiPrdTSMateriale11.setOnKeyChange("resetDatiMateriale(11)"); 
  RilevDatiPrdTSMateriale11.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale11.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale11.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale11.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale11"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione11 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione11", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione11.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione11.setOnSearchBack("verificaDatiArticoli(11)"); 
  RilevDatiPrdTSMaterialeVersione11.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione11.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione11.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione11"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig11 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig11", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig11.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig11.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig11.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig11.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig11"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm11 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm11"); 
  RilevDatiPrdTSQtaPrelevataUMPrm11.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm11.setOnChange("recuperaQtaSec(11);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm11.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm11.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm11.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm11.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm11.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm11.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat11 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat11"); 
  RilevDatiPrdTSIdUMPrmMat11.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat11.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat11.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat11.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat11.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat11.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto11 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto11", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto11.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto11.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig11,IdConfigurazione;   IdVersione11,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto11.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto11.write(out); 
%>
<!--<span class="multisearchform" id="Lotto11"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc11 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc11", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc11.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc11.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc11"></span>--></td>
        </tr>
        <tr id="TR11_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale11 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale11"); 
  RilevDatiPrdTSDescrizioneMateriale11.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale11.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale11.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale11.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale11.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale11.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec11 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec11"); 
  RilevDatiPrdTSQtaPrelevataUMSec11.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec11.setOnChange("recuperaQtaPrm(11);recuperaQtaArrotondateSec(11);"); 
  RilevDatiPrdTSQtaPrelevataUMSec11.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec11.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec11.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec11.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec11.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec11.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat11 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat11"); 
  RilevDatiPrdTSIdUMSecMat11.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat11.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat11.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat11.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat11.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat11.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl11TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl11 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl11"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl11.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl11.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl11.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl11.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl11 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl11", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl11.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl11.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl11"></span>--></td>
        </tr>
        <tr id="TR12_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale12 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale12", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale12.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale12.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale12.setOnKeyBlur("onKeyBlurArticolo(12)"); 
  RilevDatiPrdTSMateriale12.setOnKeyChange("resetDatiMateriale(12)"); 
  RilevDatiPrdTSMateriale12.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale12.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale12.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale12.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale12"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione12 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione12", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione12.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione12.setOnSearchBack("verificaDatiArticoli(12)"); 
  RilevDatiPrdTSMaterialeVersione12.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione12.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione12.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione12"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig12 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig12", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig12.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig12.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig12.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig12.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig12"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm12 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm12"); 
  RilevDatiPrdTSQtaPrelevataUMPrm12.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm12.setOnChange("recuperaQtaSec(12);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm12.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm12.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm12.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm12.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm12.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm12.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat12 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat12"); 
  RilevDatiPrdTSIdUMPrmMat12.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat12.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat12.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat12.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat12.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat12.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto12 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto12", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto12.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto12.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig12,IdConfigurazione;   IdVersione12,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto12.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto12.write(out); 
%>
<!--<span class="multisearchform" id="Lotto12"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc12 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc12", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc12.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc12.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc12"></span>--></td>
        </tr>
        <tr id="TR12_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale12 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale12"); 
  RilevDatiPrdTSDescrizioneMateriale12.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale12.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale12.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale12.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale12.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale12.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec12 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec12"); 
  RilevDatiPrdTSQtaPrelevataUMSec12.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec12.setOnChange("recuperaQtaPrm(12);recuperaQtaArrotondateSec(12);"); 
  RilevDatiPrdTSQtaPrelevataUMSec12.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec12.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec12.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec12.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec12.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec12.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat12 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat12"); 
  RilevDatiPrdTSIdUMSecMat12.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat12.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat12.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat12.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat12.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat12.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl12TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl12 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl12"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl12.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl12.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl12.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl12.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl12 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl12", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl12.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl12.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl12"></span>--></td>
        </tr>
        <tr id="TR13_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale13 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale13", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale13.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale13.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale13.setOnKeyBlur("onKeyBlurArticolo(13)"); 
  RilevDatiPrdTSMateriale13.setOnKeyChange("resetDatiMateriale(13)"); 
  RilevDatiPrdTSMateriale13.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale13.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale13.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale13.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale13"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione13 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione13", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione13.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione13.setOnSearchBack("verificaDatiArticoli(13)"); 
  RilevDatiPrdTSMaterialeVersione13.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione13.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione13.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione13"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig13 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig13", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig13.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig13.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig13.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig13.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig13"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm13 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm13"); 
  RilevDatiPrdTSQtaPrelevataUMPrm13.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm13.setOnChange("recuperaQtaSec(13);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm13.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm13.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm13.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm13.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm13.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm13.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat13 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat13"); 
  RilevDatiPrdTSIdUMPrmMat13.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat13.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat13.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat13.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat13.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat13.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto13 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto13", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto13.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto13.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig13,IdConfigurazione;   IdVersione13,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto13.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto13.write(out); 
%>
<!--<span class="multisearchform" id="Lotto13"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc13 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc13", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc13.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc13.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc13"></span>--></td>
        </tr>
        <tr id="TR13_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale13 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale13"); 
  RilevDatiPrdTSDescrizioneMateriale13.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale13.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale13.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale13.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale13.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale13.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec13 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec13"); 
  RilevDatiPrdTSQtaPrelevataUMSec13.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec13.setOnChange("recuperaQtaPrm(13);recuperaQtaArrotondateSec(13);"); 
  RilevDatiPrdTSQtaPrelevataUMSec13.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec13.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec13.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec13.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec13.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec13.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat13 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat13"); 
  RilevDatiPrdTSIdUMSecMat13.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat13.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat13.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat13.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat13.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat13.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl13TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl13 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl13"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl13.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl13.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl13.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl13.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl13 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl13", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl13.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl13.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl13"></span>--></td>
        </tr>
        <tr id="TR14_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale14 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale14", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale14.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale14.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale14.setOnKeyBlur("onKeyBlurArticolo(14)"); 
  RilevDatiPrdTSMateriale14.setOnKeyChange("resetDatiMateriale(14)"); 
  RilevDatiPrdTSMateriale14.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale14.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale14.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale14.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale14"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione14 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione14", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione14.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione14.setOnSearchBack("verificaDatiArticoli(14)"); 
  RilevDatiPrdTSMaterialeVersione14.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione14.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione14.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione14"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig14 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig14", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig14.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig14.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig14.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig14.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig14"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm14 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm14"); 
  RilevDatiPrdTSQtaPrelevataUMPrm14.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm14.setOnChange("recuperaQtaSec(14);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm14.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm14.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm14.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm14.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm14.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm14.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat14 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat14"); 
  RilevDatiPrdTSIdUMPrmMat14.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat14.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat14.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat14.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat14.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat14.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto14 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto14", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto14.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto14.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig14,IdConfigurazione;   IdVersione14,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto14.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto14.write(out); 
%>
<!--<span class="multisearchform" id="Lotto14"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc14 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc14", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc14.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc14.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc14"></span>--></td>
        </tr>
        <tr id="TR14_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale14 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale14"); 
  RilevDatiPrdTSDescrizioneMateriale14.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale14.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale14.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale14.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale14.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale14.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec14 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec14"); 
  RilevDatiPrdTSQtaPrelevataUMSec14.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec14.setOnChange("recuperaQtaPrm(14);recuperaQtaArrotondateSec(14);"); 
  RilevDatiPrdTSQtaPrelevataUMSec14.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec14.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec14.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec14.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec14.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec14.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat14 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat14"); 
  RilevDatiPrdTSIdUMSecMat14.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat14.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat14.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat14.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat14.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat14.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl14TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl14 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl14"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl14.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl14.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl14.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl14.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl14 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl14", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl14.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl14.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl14"></span>--></td>
        </tr>
        <tr id="TR15_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale15 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale15", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale15.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale15.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale15.setOnKeyBlur("onKeyBlurArticolo(15)"); 
  RilevDatiPrdTSMateriale15.setOnKeyChange("resetDatiMateriale(15)"); 
  RilevDatiPrdTSMateriale15.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale15.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale15.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale15.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale15"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione15 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione15", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione15.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione15.setOnSearchBack("verificaDatiArticoli(15)"); 
  RilevDatiPrdTSMaterialeVersione15.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione15.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione15.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione15"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig15 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig15", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig15.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig15.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig15.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig15.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig15"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm15 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm15"); 
  RilevDatiPrdTSQtaPrelevataUMPrm15.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm15.setOnChange("recuperaQtaSec(15);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm15.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm15.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm15.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm15.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm15.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm15.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat15 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat15"); 
  RilevDatiPrdTSIdUMPrmMat15.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat15.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat15.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat15.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat15.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat15.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto15 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto15", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto15.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto15.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig15,IdConfigurazione;   IdVersione15,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto15.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto15.write(out); 
%>
<!--<span class="multisearchform" id="Lotto15"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc15 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc15", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc15.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc15.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc15"></span>--></td>
        </tr>
        <tr id="TR15_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale15 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale15"); 
  RilevDatiPrdTSDescrizioneMateriale15.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale15.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale15.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale15.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale15.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale15.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec15 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec15"); 
  RilevDatiPrdTSQtaPrelevataUMSec15.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec15.setOnChange("recuperaQtaPrm(15);recuperaQtaArrotondateSec(15);"); 
  RilevDatiPrdTSQtaPrelevataUMSec15.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec15.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec15.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec15.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec15.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec15.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat15 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat15"); 
  RilevDatiPrdTSIdUMSecMat15.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat15.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat15.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat15.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat15.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat15.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl15TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl15 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl15"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl15.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl15.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl15.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl15.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl15 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl15", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl15.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl15.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl15"></span>--></td>
        </tr>
        <tr id="TR16_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale16 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale16", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale16.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale16.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale16.setOnKeyBlur("onKeyBlurArticolo(16)"); 
  RilevDatiPrdTSMateriale16.setOnKeyChange("resetDatiMateriale(16)"); 
  RilevDatiPrdTSMateriale16.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale16.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale16.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale16.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale16"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione16 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione16", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione16.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione16.setOnSearchBack("verificaDatiArticoli(16)"); 
  RilevDatiPrdTSMaterialeVersione16.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione16.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione16.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione16"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig16 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig16", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig16.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig16.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig16.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig16.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig16"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm16 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm16"); 
  RilevDatiPrdTSQtaPrelevataUMPrm16.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm16.setOnChange("recuperaQtaSec(16);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm16.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm16.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm16.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm16.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm16.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm16.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat16 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat16"); 
  RilevDatiPrdTSIdUMPrmMat16.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat16.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat16.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat16.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat16.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat16.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto16 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto16", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto16.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto16.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig16,IdConfigurazione;   IdVersione16,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto16.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto16.write(out); 
%>
<!--<span class="multisearchform" id="Lotto16"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc16 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc16", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc16.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc16.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc16"></span>--></td>
        </tr>
        <tr id="TR16_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale16 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale16"); 
  RilevDatiPrdTSDescrizioneMateriale16.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale16.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale16.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale16.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale16.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale16.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec16 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec16"); 
  RilevDatiPrdTSQtaPrelevataUMSec16.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec16.setOnChange("recuperaQtaPrm(16);recuperaQtaArrotondateSec(16);"); 
  RilevDatiPrdTSQtaPrelevataUMSec16.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec16.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec16.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec16.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec16.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec16.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat16 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat16"); 
  RilevDatiPrdTSIdUMSecMat16.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat16.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat16.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat16.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat16.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat16.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl16TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl16 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl16"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl16.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl16.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl16.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl16.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl16 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl16", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl16.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl16.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl16"></span>--></td>
        </tr>
        <tr id="TR17_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale17 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale17", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale17.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale17.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale17.setOnKeyBlur("onKeyBlurArticolo(17)"); 
  RilevDatiPrdTSMateriale17.setOnKeyChange("resetDatiMateriale(17)"); 
  RilevDatiPrdTSMateriale17.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale17.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale17.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale17.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale17"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione17 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione17", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione17.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione17.setOnSearchBack("verificaDatiArticoli(17)"); 
  RilevDatiPrdTSMaterialeVersione17.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione17.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione17.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione17"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig17 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig17", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig17.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig17.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig17.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig17.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig17"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm17 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm17"); 
  RilevDatiPrdTSQtaPrelevataUMPrm17.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm17.setOnChange("recuperaQtaSec(17);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm17.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm17.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm17.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm17.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm17.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm17.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat17 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat17"); 
  RilevDatiPrdTSIdUMPrmMat17.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat17.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat17.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat17.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat17.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat17.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto17 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto17", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto17.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto17.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig17,IdConfigurazione;   IdVersione17,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto17.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto17.write(out); 
%>
<!--<span class="multisearchform" id="Lotto17"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc17 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc17", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc17.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc17.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc17"></span>--></td>
        </tr>
        <tr id="TR17_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale17 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale17"); 
  RilevDatiPrdTSDescrizioneMateriale17.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale17.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale17.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale17.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale17.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale17.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec17 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec17"); 
  RilevDatiPrdTSQtaPrelevataUMSec17.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec17.setOnChange("recuperaQtaPrm(17);recuperaQtaArrotondateSec(17);"); 
  RilevDatiPrdTSQtaPrelevataUMSec17.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec17.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec17.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec17.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec17.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec17.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat17 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat17"); 
  RilevDatiPrdTSIdUMSecMat17.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat17.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat17.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat17.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat17.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat17.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl17TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl17 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl17"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl17.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl17.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl17.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl17.write(out); 
%>
</td> <!-- 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl17 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl17", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl17.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl17.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl17"></span>--></td>
        </tr>
        <tr id="TR18_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale18 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale18", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale18.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale18.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale18.setOnKeyBlur("onKeyBlurArticolo(18)"); 
  RilevDatiPrdTSMateriale18.setOnKeyChange("resetDatiMateriale(18)"); 
  RilevDatiPrdTSMateriale18.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale18.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale18.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale18.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale18"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione18 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione18", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione18.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione18.setOnSearchBack("verificaDatiArticoli(18)"); 
  RilevDatiPrdTSMaterialeVersione18.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione18.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione18.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione18"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig18 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig18", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig18.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig18.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig18.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig18.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig18"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm18 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm18"); 
  RilevDatiPrdTSQtaPrelevataUMPrm18.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm18.setOnChange("recuperaQtaSec(18);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm18.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm18.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm18.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm18.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm18.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm18.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat18 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat18"); 
  RilevDatiPrdTSIdUMPrmMat18.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat18.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat18.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat18.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat18.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat18.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto18 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto18", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto18.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto18.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig18,IdConfigurazione;   IdVersione18,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto18.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto18.write(out); 
%>
<!--<span class="multisearchform" id="Lotto18"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc18 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc18", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc18.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc18.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc18"></span>--></td>
        </tr>
        <tr id="TR18_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale18 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale18"); 
  RilevDatiPrdTSDescrizioneMateriale18.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale18.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale18.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale18.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale18.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale18.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec18 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec18"); 
  RilevDatiPrdTSQtaPrelevataUMSec18.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec18.setOnChange("recuperaQtaPrm(18);recuperaQtaArrotondateSec(18);"); 
  RilevDatiPrdTSQtaPrelevataUMSec18.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec18.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec18.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec18.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec18.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec18.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat18 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat18"); 
  RilevDatiPrdTSIdUMSecMat18.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat18.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat18.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat18.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat18.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat18.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl18TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl18 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl18"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl18.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl18.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl18.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl18.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl18 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl18", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl18.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl18.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl18"></span>--></td>
        </tr>
        <tr id="TR19_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale19 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale19", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale19.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale19.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale19.setOnKeyBlur("onKeyBlurArticolo(19)"); 
  RilevDatiPrdTSMateriale19.setOnKeyChange("resetDatiMateriale(19)"); 
  RilevDatiPrdTSMateriale19.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale19.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale19.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale19.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale19"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione19 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione19", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione19.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione19.setOnSearchBack("verificaDatiArticoli(19)"); 
  RilevDatiPrdTSMaterialeVersione19.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione19.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione19.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione19"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig19 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig19", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig19.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig19.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig19.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig19.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig19"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm19 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm19"); 
  RilevDatiPrdTSQtaPrelevataUMPrm19.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm19.setOnChange("recuperaQtaSec(19);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm19.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm19.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm19.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm19.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm19.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm19.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat19 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat19"); 
  RilevDatiPrdTSIdUMPrmMat19.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat19.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat19.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat19.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat19.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat19.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto19 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto19", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto19.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto19.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig19,IdConfigurazione;   IdVersione19,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto19.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto19.write(out); 
%>
<!--<span class="multisearchform" id="Lotto19"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc19 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc19", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc19.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc19.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc19"></span>--></td>
        </tr>
        <tr id="TR19_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale19 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale19"); 
  RilevDatiPrdTSDescrizioneMateriale19.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale19.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale19.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale19.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale19.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale19.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec19 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec19"); 
  RilevDatiPrdTSQtaPrelevataUMSec19.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec19.setOnChange("recuperaQtaPrm(19);recuperaQtaArrotondateSec(19);"); 
  RilevDatiPrdTSQtaPrelevataUMSec19.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec19.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec19.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec19.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec19.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec19.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat19 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat19"); 
  RilevDatiPrdTSIdUMSecMat19.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat19.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat19.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat19.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat19.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat19.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl19TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl19 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl19"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl19.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl19.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl19.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl19.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl19 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl19", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl19.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl19.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl19"></span>--></td>
        </tr>
        <tr id="TR20_1" style="display:none">
          <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSMateriale20 =  
     new it.thera.thip.base.articolo.web.ArticoloMultiSearchForm("RilevDatiPrdTS", "Materiale20", false, false, false, 1, null, null); 
  RilevDatiPrdTSMateriale20.setExtraRelatedClassAD("DescrizioneArticolo.Descrizione,UMPrmMag,UMSecMag"); 
  RilevDatiPrdTSMateriale20.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMateriale20.setOnKeyBlur("onKeyBlurArticolo(20)"); 
  RilevDatiPrdTSMateriale20.setOnKeyChange("resetDatiMateriale(20)"); 
  RilevDatiPrdTSMateriale20.setOnSearchBack("recuperaDatiMateriale()"); 
  RilevDatiPrdTSMateriale20.setAdditionalRestrictConditions("IdAnnoOrdine,IdClasseMateriale;IdNumeroOrdine,IdClasseMateriale;IdRigaAttivita,IdClasseMateriale;   TipoBolla,TipoArticolo;IdAnnoBolla,IdClasseMateriale;IdNumeroBolla,IdClasseMateriale;IdCausaleRilevazione,IdClasseMateriale"); 
  RilevDatiPrdTSMateriale20.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMateriale20.write(out); 
%>
<!--<span class="articolomultisearchform" id="Materiale20"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeVersione20 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MaterialeVersione20", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeVersione20.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeVersione20.setOnSearchBack("verificaDatiArticoli(20)"); 
  RilevDatiPrdTSMaterialeVersione20.setAdditionalRestrictConditions("IdAnnoOrdine,IdDisegnoTecnico;IdNumeroOrdine,IdDisegnoTecnico;IdRigaAttivita,IdDisegnoTecnico;   TipoBolla,StatoTecnico;IdAnnoBolla,IdDisegnoTecnico;IdNumeroBolla,IdDisegnoTecnico"); 
  RilevDatiPrdTSMaterialeVersione20.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeVersione20.write(out); 
%>
<!--<span class="multisearchform" id="MaterialeVersione20"></span>-->
            <% 
  WebMultiSearchForm RilevDatiPrdTSMaterialeConfig20 =  
     new it.thera.thip.datiTecnici.configuratore.web.ConfigurazioneMultiSearchForm("RilevDatiPrdTS", "MaterialeConfig20", false, false, false, 1, null, null); 
  RilevDatiPrdTSMaterialeConfig20.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMaterialeConfig20.setAdditionalRestrictConditions("IdAnnoOrdine,SintesiConfig;IdNumeroOrdine,SintesiConfig;IdRigaAttivita,SintesiConfig;   TipoBolla,TipoConfig;IdAnnoBolla,SintesiConfig;IdNumeroBolla,SintesiConfig"); 
  RilevDatiPrdTSMaterialeConfig20.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.MaterialiDoList"); 
  RilevDatiPrdTSMaterialeConfig20.write(out); 
%>
<!--<span class="configurazionemultisearchform" id="MaterialeConfig20"></span>--></td>
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMPrm20 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMPrm20"); 
  RilevDatiPrdTSQtaPrelevataUMPrm20.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm20.setOnChange("recuperaQtaSec(20);"); 
  RilevDatiPrdTSQtaPrelevataUMPrm20.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMPrm20.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMPrm20.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMPrm20.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMPrm20.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMPrm20.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
            <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMPrmMat20 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMPrmMat20"); 
  RilevDatiPrdTSIdUMPrmMat20.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMPrmMat20.getClassType()%>" id="<%=RilevDatiPrdTSIdUMPrmMat20.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMPrmMat20.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMPrmMat20.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMPrmMat20.write(out); 
%>
</td>
            <td nowrap><% 
  WebMultiSearchForm RilevDatiPrdTSLotto20 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "Lotto20", false, false, false, 1, null, null); 
  RilevDatiPrdTSLotto20.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSLotto20.setAdditionalRestrictConditions("IdAnnoOrdine,DescrizioneLotto;IdNumeroOrdine,DescrizioneLotto;   IdRigaAttivita,DescrizioneLotto;IdAnnoBolla,DescrizioneLotto;   IdNumeroBolla,DescrizioneLotto;IdEsternoConfig20,IdConfigurazione;   IdVersione20,CodiceVersione;TipoBolla,DatiComuniEstesi.Stato"); 
  RilevDatiPrdTSLotto20.setSpecificDOList("it.thera.thip.produzione.raccoltaDati.web.LottiMaterialiDoList"); 
  RilevDatiPrdTSLotto20.write(out); 
%>
<!--<span class="multisearchform" id="Lotto20"></span>--></td>
<td><% 
  WebMultiSearchForm RilevDatiPrdTSMappaUdc20 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MappaUdc20", false, false, false, 1, null, null); 
  RilevDatiPrdTSMappaUdc20.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMappaUdc20.write(out); 
%>
<!--<span class="multisearchform" id="MappaUdc20"></span>--></td>
        </tr>
        <tr id="TR20_2" style="display:none">
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSDescrizioneMateriale20 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "DescrizioneMateriale20"); 
  RilevDatiPrdTSDescrizioneMateriale20.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSDescrizioneMateriale20.getClassType()%>" id="<%=RilevDatiPrdTSDescrizioneMateriale20.getId()%>" maxlength="<%=RilevDatiPrdTSDescrizioneMateriale20.getMaxLength()%>" name="<%=RilevDatiPrdTSDescrizioneMateriale20.getName()%>" readonly size="59" tabindex="-1"><% 
  RilevDatiPrdTSDescrizioneMateriale20.write(out); 
%>
</td>
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSQtaPrelevataUMSec20 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "QtaPrelevataUMSec20"); 
  RilevDatiPrdTSQtaPrelevataUMSec20.setOnFocus("showKeyPad(this);"); 
  RilevDatiPrdTSQtaPrelevataUMSec20.setOnChange("recuperaQtaPrm(20);recuperaQtaArrotondateSec(20);"); 
  RilevDatiPrdTSQtaPrelevataUMSec20.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSQtaPrelevataUMSec20.getClassType()%>" id="<%=RilevDatiPrdTSQtaPrelevataUMSec20.getId()%>" maxlength="<%=RilevDatiPrdTSQtaPrelevataUMSec20.getMaxLength()%>" name="<%=RilevDatiPrdTSQtaPrelevataUMSec20.getName()%>" size="11"><% 
  RilevDatiPrdTSQtaPrelevataUMSec20.write(out); 
%>
</td> <!--Fix 22941 Tolto tabindex="-1"-->
          <td nowrap><% 
  WebTextInput RilevDatiPrdTSIdUMSecMat20 =  
     new com.thera.thermfw.web.WebTextInput("RilevDatiPrdTS", "IdUMSecMat20"); 
  RilevDatiPrdTSIdUMSecMat20.setParent(RilevDatiPrdTSForm); 
%>
<input class="<%=RilevDatiPrdTSIdUMSecMat20.getClassType()%>" id="<%=RilevDatiPrdTSIdUMSecMat20.getId()%>" maxlength="<%=RilevDatiPrdTSIdUMSecMat20.getMaxLength()%>" name="<%=RilevDatiPrdTSIdUMSecMat20.getName()%>" readonly size="2" tabindex="-1"><% 
  RilevDatiPrdTSIdUMSecMat20.write(out); 
%>
</td>
          <td id="RicalcoloQuantitaPrl20TD" nowrap style="display:none;"><% 
  WebCheckBox RilevDatiPrdTSRicalcoloQuantitaPrl20 =  
     new com.thera.thermfw.web.WebCheckBox("RilevDatiPrdTS", "RicalcoloQuantitaPrl20"); 
  RilevDatiPrdTSRicalcoloQuantitaPrl20.setParent(RilevDatiPrdTSForm); 
%>
<input id="<%=RilevDatiPrdTSRicalcoloQuantitaPrl20.getId()%>" name="<%=RilevDatiPrdTSRicalcoloQuantitaPrl20.getName()%>" type="checkbox" value="Y"><%
  RilevDatiPrdTSRicalcoloQuantitaPrl20.write(out); 
%>
</td> <!-- Fix 39680 -->
        </tr>
        <tr style="display:none">
          <td><% 
  WebMultiSearchForm RilevDatiPrdTSMagazzinoPrl20 =  
     new com.thera.thermfw.web.WebMultiSearchForm("RilevDatiPrdTS", "MagazzinoPrl20", false, false, false, 1, null, null); 
  RilevDatiPrdTSMagazzinoPrl20.setParent(RilevDatiPrdTSForm); 
  RilevDatiPrdTSMagazzinoPrl20.write(out); 
%>
<!--<span class="multisearchform" id="MagazzinoPrl20"></span>--></td>
        </tr>
      </table>
      </div>
   </td>
  </tr>
  <tr>
  <td width="15px"></td>
  <!-- Fix 18536 Inizio -->
  <td>
    <table style="height:100%; width:100%">
      <tr>
        <td align="left"><button id="NuovaRigaBut" name="NuovaRigaBut" onclick="NuovaRiga()" type="button"><%= ResourceLoader.getString("it/thera/thip/produzione/raccoltaDati/resources/RilevDatiPrdTS", "ButNuovaRiga")%></button></td>
        <td align="center" width="40%"><label id="numPag" name="numPag"></label></td><!-- Fix 19148 -->
        <td align="right">
          <button id="PaginaPrecBut" name="PaginaPrecBut" onclick="PaginaPrec()" type="button"><%= ResourceLoader.getString("it/thera/thip/produzione/raccoltaDati/resources/RilevDatiPrdTS", "PaginaPrec")%></button>
          <button id="PaginaSuccBut" name="PaginaSuccBut" onclick="PaginaSucc()" type="button"><%= ResourceLoader.getString("it/thera/thip/produzione/raccoltaDati/resources/RilevDatiPrdTS", "PaginaSucc")%></button>
        </td>
      </tr>
    </table>
  </td>
  <!-- Fix 18536 Fine -->
  </tr>
   <!--Fix 15250 inizio-->
   <tr><td> 
   <!-- Fix 32648 Inizio -->
   <!-- <iframe  id="KeyPad" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"    style="display:none; position: absolute; left: 120; top:300; width:107; height:155;" src="it/thera/thip/produzione/raccoltaDati/KeyPad.jsp"></iframe>-->
   <iframe frameborder="0" id="KeyPad" marginheight="0" marginwidth="0" scrolling="no" src="it/thera/thip/produzione/raccoltaDati/KeyPad.jsp" style="display:none; position: absolute; left: 120; top:300; width:152; height:160;"></iframe>
    <!-- Fix 32648 Fine -->
</td>
  </tr><!--Fix 15250 fine-->
  <tr>
    <td colspan="3"><label class="labelError" id="ErroriList"></label></td>
  </tr>
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
