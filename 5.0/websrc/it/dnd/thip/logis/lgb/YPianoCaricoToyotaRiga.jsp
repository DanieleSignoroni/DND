<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///W:\PthDev\Projects\Panthera\DND\WebContent\dtd/xhtml1-transitional.dtd">
<html>
<!-- WIZGEN Therm 2.0.0 as Form riga indipendente - multiBrowserGen = true -->
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
  BODataCollector YPianoCaricoToyotaRigaBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebFormForIndipendentRowForm YPianoCaricoToyotaRigaForm =  
     new com.thera.thermfw.web.WebFormForIndipendentRowForm(request, response, "YPianoCaricoToyotaRigaForm", "YPianoCaricoToyotaRiga", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, false, null); 
  YPianoCaricoToyotaRigaForm.setServletEnvironment(se); 
  YPianoCaricoToyotaRigaForm.setJSTypeList(jsList); 
  YPianoCaricoToyotaRigaForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YPianoCaricoToyotaRigaForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YPianoCaricoToyotaRigaForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YPianoCaricoToyotaRigaForm.getMode(); 
  String key = YPianoCaricoToyotaRigaForm.getKey(); 
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
        YPianoCaricoToyotaRigaForm.outTraceInfo(getClass().getName()); 
        String collectorName = YPianoCaricoToyotaRigaForm.findBODataCollectorName(); 
	     YPianoCaricoToyotaRigaBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YPianoCaricoToyotaRigaBODC instanceof WebDataCollector) 
            ((WebDataCollector)YPianoCaricoToyotaRigaBODC).setServletEnvironment(se); 
        YPianoCaricoToyotaRigaBODC.initialize("YPianoCaricoToyotaRiga", true, 0); 
        YPianoCaricoToyotaRigaForm.setBODataCollector(YPianoCaricoToyotaRigaBODC); 
        int rcBODC = YPianoCaricoToyotaRigaForm.initSecurityServices(); 
        mode = YPianoCaricoToyotaRigaForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YPianoCaricoToyotaRigaForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YPianoCaricoToyotaRigaBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YPianoCaricoToyotaRigaForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YPianoCaricoToyotaRigaForm); 
   request.setAttribute("menuBar", menuBar); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="menuBar"/> 
</jsp:include> 
<% 
  menuBar.write(out); 
  menuBar.writeChildren(out); 
%> 
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(YPianoCaricoToyotaRigaForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YPianoCaricoToyotaRigaForm.getBodyOnBeforeUnload()%>" onload="<%=YPianoCaricoToyotaRigaForm.getBodyOnLoad()%>" onunload="<%=YPianoCaricoToyotaRigaForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YPianoCaricoToyotaRigaForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YPianoCaricoToyotaRigaForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YPianoCaricoToyotaRigaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YPianoCaricoToyotaRigaForm.getServlet()%>" method="post" name="YPianoCaricoToyotaRigaForm" style="height:100%"><%
  YPianoCaricoToyotaRigaForm.writeFormStartElements(out); 
%>

      <table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
        <tr>
          <td style="height:0">
            <% menuBar.writeElements(out); %> 

          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% myToolBarTB.writeChildren(out); %> 

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YPianoCaricoToyotaRigaAnnoDocumento =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyotaRiga", "AnnoDocumento"); 
  YPianoCaricoToyotaRigaAnnoDocumento.setParent(YPianoCaricoToyotaRigaForm); 
%>
<input class="<%=YPianoCaricoToyotaRigaAnnoDocumento.getClassType()%>" id="<%=YPianoCaricoToyotaRigaAnnoDocumento.getId()%>" maxlength="<%=YPianoCaricoToyotaRigaAnnoDocumento.getMaxLength()%>" name="<%=YPianoCaricoToyotaRigaAnnoDocumento.getName()%>" size="<%=YPianoCaricoToyotaRigaAnnoDocumento.getSize()%>" type="hidden"><% 
  YPianoCaricoToyotaRigaAnnoDocumento.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YPianoCaricoToyotaRigaNumeroDocumento =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyotaRiga", "NumeroDocumento"); 
  YPianoCaricoToyotaRigaNumeroDocumento.setParent(YPianoCaricoToyotaRigaForm); 
%>
<input class="<%=YPianoCaricoToyotaRigaNumeroDocumento.getClassType()%>" id="<%=YPianoCaricoToyotaRigaNumeroDocumento.getId()%>" maxlength="<%=YPianoCaricoToyotaRigaNumeroDocumento.getMaxLength()%>" name="<%=YPianoCaricoToyotaRigaNumeroDocumento.getName()%>" size="<%=YPianoCaricoToyotaRigaNumeroDocumento.getSize()%>" type="hidden"><% 
  YPianoCaricoToyotaRigaNumeroDocumento.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YPianoCaricoToyotaRigaNumeroRigaDocumento =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyotaRiga", "NumeroRigaDocumento"); 
  YPianoCaricoToyotaRigaNumeroRigaDocumento.setParent(YPianoCaricoToyotaRigaForm); 
%>
<input class="<%=YPianoCaricoToyotaRigaNumeroRigaDocumento.getClassType()%>" id="<%=YPianoCaricoToyotaRigaNumeroRigaDocumento.getId()%>" maxlength="<%=YPianoCaricoToyotaRigaNumeroRigaDocumento.getMaxLength()%>" name="<%=YPianoCaricoToyotaRigaNumeroRigaDocumento.getName()%>" size="<%=YPianoCaricoToyotaRigaNumeroRigaDocumento.getSize()%>" type="hidden"><% 
  YPianoCaricoToyotaRigaNumeroRigaDocumento.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td height="100%">
            <!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YPianoCaricoToyotaRigaForm); 
 mytabbed.addTab("tab1", "it.dnd.thip.logis.lgb.resources.YPianoCaricoToyotaRiga", "tab1", "YPianoCaricoToyotaRiga", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
              <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab1")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab1"); %>
                <table style="width: 100%;">
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "IdArticolo", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="Articolo"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPianoCaricoToyotaRigaArticolo =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyotaRiga", "Articolo", false, false, true, 1, null, null); 
  YPianoCaricoToyotaRigaArticolo.setParent(YPianoCaricoToyotaRigaForm); 
  YPianoCaricoToyotaRigaArticolo.write(out); 
%>
<!--<span class="multisearchform" id="Articolo"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "IdRigaMateriale", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="AttivitaEsecMateriale"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPianoCaricoToyotaRigaAttivitaEsecMateriale =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyotaRiga", "AttivitaEsecMateriale", false, false, true, 4, null, null); 
  YPianoCaricoToyotaRigaAttivitaEsecMateriale.setParent(YPianoCaricoToyotaRigaForm); 
  YPianoCaricoToyotaRigaAttivitaEsecMateriale.write(out); 
%>
<!--<span class="multisearchform" id="AttivitaEsecMateriale"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "IdCodiceMissione", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="Missione"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPianoCaricoToyotaRigaMissione =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyotaRiga", "Missione", false, false, true, 2, null, null); 
  YPianoCaricoToyotaRigaMissione.setParent(YPianoCaricoToyotaRigaForm); 
  YPianoCaricoToyotaRigaMissione.write(out); 
%>
<!--<span class="multisearchform" id="Missione"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "NumRitornoAttivita", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="NumRitornoAttivita"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YPianoCaricoToyotaRigaNumRitornoAttivita =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyotaRiga", "NumRitornoAttivita"); 
  YPianoCaricoToyotaRigaNumRitornoAttivita.setParent(YPianoCaricoToyotaRigaForm); 
%>
<input class="<%=YPianoCaricoToyotaRigaNumRitornoAttivita.getClassType()%>" id="<%=YPianoCaricoToyotaRigaNumRitornoAttivita.getId()%>" maxlength="<%=YPianoCaricoToyotaRigaNumRitornoAttivita.getMaxLength()%>" name="<%=YPianoCaricoToyotaRigaNumRitornoAttivita.getName()%>" size="<%=YPianoCaricoToyotaRigaNumRitornoAttivita.getSize()%>"><% 
  YPianoCaricoToyotaRigaNumRitornoAttivita.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "IdCliente", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="Cliente"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPianoCaricoToyotaRigaCliente =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyotaRiga", "Cliente", false, false, true, 1, null, null); 
  YPianoCaricoToyotaRigaCliente.setParent(YPianoCaricoToyotaRigaForm); 
  YPianoCaricoToyotaRigaCliente.write(out); 
%>
<!--<span class="multisearchform" id="Cliente"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "NumeroRiferimento", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="NumeroRiferimento"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YPianoCaricoToyotaRigaNumeroRiferimento =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyotaRiga", "NumeroRiferimento"); 
  YPianoCaricoToyotaRigaNumeroRiferimento.setParent(YPianoCaricoToyotaRigaForm); 
%>
<input class="<%=YPianoCaricoToyotaRigaNumeroRiferimento.getClassType()%>" id="<%=YPianoCaricoToyotaRigaNumeroRiferimento.getId()%>" maxlength="<%=YPianoCaricoToyotaRigaNumeroRiferimento.getMaxLength()%>" name="<%=YPianoCaricoToyotaRigaNumeroRiferimento.getName()%>" size="<%=YPianoCaricoToyotaRigaNumeroRiferimento.getSize()%>"><% 
  YPianoCaricoToyotaRigaNumeroRiferimento.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "QuantitaRichiestaUmPrm", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="QuantitaRichiestaUmPrm"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YPianoCaricoToyotaRigaQuantitaRichiestaUmPrm =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyotaRiga", "QuantitaRichiestaUmPrm"); 
  YPianoCaricoToyotaRigaQuantitaRichiestaUmPrm.setParent(YPianoCaricoToyotaRigaForm); 
%>
<input class="<%=YPianoCaricoToyotaRigaQuantitaRichiestaUmPrm.getClassType()%>" id="<%=YPianoCaricoToyotaRigaQuantitaRichiestaUmPrm.getId()%>" maxlength="<%=YPianoCaricoToyotaRigaQuantitaRichiestaUmPrm.getMaxLength()%>" name="<%=YPianoCaricoToyotaRigaQuantitaRichiestaUmPrm.getName()%>" size="<%=YPianoCaricoToyotaRigaQuantitaRichiestaUmPrm.getSize()%>"><% 
  YPianoCaricoToyotaRigaQuantitaRichiestaUmPrm.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "QuantitaPrelevataUmPrm", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="QuantitaPrelevataUmPrm"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YPianoCaricoToyotaRigaQuantitaPrelevataUmPrm =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyotaRiga", "QuantitaPrelevataUmPrm"); 
  YPianoCaricoToyotaRigaQuantitaPrelevataUmPrm.setParent(YPianoCaricoToyotaRigaForm); 
%>
<input class="<%=YPianoCaricoToyotaRigaQuantitaPrelevataUmPrm.getClassType()%>" id="<%=YPianoCaricoToyotaRigaQuantitaPrelevataUmPrm.getId()%>" maxlength="<%=YPianoCaricoToyotaRigaQuantitaPrelevataUmPrm.getMaxLength()%>" name="<%=YPianoCaricoToyotaRigaQuantitaPrelevataUmPrm.getName()%>" size="<%=YPianoCaricoToyotaRigaQuantitaPrelevataUmPrm.getSize()%>"><% 
  YPianoCaricoToyotaRigaQuantitaPrelevataUmPrm.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "Priorita", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="Priorita"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YPianoCaricoToyotaRigaPriorita =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyotaRiga", "Priorita"); 
  YPianoCaricoToyotaRigaPriorita.setParent(YPianoCaricoToyotaRigaForm); 
%>
<input class="<%=YPianoCaricoToyotaRigaPriorita.getClassType()%>" id="<%=YPianoCaricoToyotaRigaPriorita.getId()%>" maxlength="<%=YPianoCaricoToyotaRigaPriorita.getMaxLength()%>" name="<%=YPianoCaricoToyotaRigaPriorita.getName()%>" size="<%=YPianoCaricoToyotaRigaPriorita.getSize()%>"><% 
  YPianoCaricoToyotaRigaPriorita.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <% 
  WebCheckBox YPianoCaricoToyotaRigaPrelevabile =  
     new com.thera.thermfw.web.WebCheckBox("YPianoCaricoToyotaRiga", "Prelevabile"); 
  YPianoCaricoToyotaRigaPrelevabile.setParent(YPianoCaricoToyotaRigaForm); 
%>
<input id="<%=YPianoCaricoToyotaRigaPrelevabile.getId()%>" name="<%=YPianoCaricoToyotaRigaPrelevabile.getName()%>" type="checkbox" value="Y"><%
  YPianoCaricoToyotaRigaPrelevabile.write(out); 
%>

                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "StatoPrelievo", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="StatoPrelievo"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebComboBox YPianoCaricoToyotaRigaStatoPrelievo =  
     new com.thera.thermfw.web.WebComboBox("YPianoCaricoToyotaRiga", "StatoPrelievo", null); 
  YPianoCaricoToyotaRigaStatoPrelievo.setParent(YPianoCaricoToyotaRigaForm); 
%>
<select id="<%=YPianoCaricoToyotaRigaStatoPrelievo.getId()%>" name="<%=YPianoCaricoToyotaRigaStatoPrelievo.getName()%>"><% 
  YPianoCaricoToyotaRigaStatoPrelievo.write(out); 
%> 
</select>
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyotaRiga", "StatoRiga", null); 
   label.setParent(YPianoCaricoToyotaRigaForm); 
%><label class="<%=label.getClassType()%>" for="StatoRiga"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebComboBox YPianoCaricoToyotaRigaStatoRiga =  
     new com.thera.thermfw.web.WebComboBox("YPianoCaricoToyotaRiga", "StatoRiga", null); 
  YPianoCaricoToyotaRigaStatoRiga.setParent(YPianoCaricoToyotaRigaForm); 
%>
<select id="<%=YPianoCaricoToyotaRigaStatoRiga.getId()%>" name="<%=YPianoCaricoToyotaRigaStatoRiga.getName()%>"><% 
  YPianoCaricoToyotaRigaStatoRiga.write(out); 
%> 
</select>
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <% 
   request.setAttribute("parentForm", YPianoCaricoToyotaRigaForm); 
   String CDForDatiComuniEstesi$it$thera$thip$cs$DatiComuniEstesi$jsp = "DatiComuniEstesi"; 
%>
<jsp:include page="/it/thera/thip/cs/DatiComuniEstesi.jsp" flush="true"> 
<jsp:param name="CDName" value="<%=CDForDatiComuniEstesi$it$thera$thip$cs$DatiComuniEstesi$jsp%>"/> 
</jsp:include> 
<!--<span class="subform" id="DatiComuniEstesi"></span>-->
                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                </table>
              <% mytabbed.endTab(); %> 
</div>
            </div><% mytabbed.endTabbed();%> 

     </td>
   </tr>
</table><!--</span>-->
          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YPianoCaricoToyotaRigaForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YPianoCaricoToyotaRigaForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YPianoCaricoToyotaRigaForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YPianoCaricoToyotaRigaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YPianoCaricoToyotaRigaForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YPianoCaricoToyotaRigaBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YPianoCaricoToyotaRigaBODC.getErrorList().getErrors()); 
           if(YPianoCaricoToyotaRigaBODC.getConflict() != null) 
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
     if(YPianoCaricoToyotaRigaBODC != null && !YPianoCaricoToyotaRigaBODC.close(false)) 
        errors.addAll(0, YPianoCaricoToyotaRigaBODC.getErrorList().getErrors()); 
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
     String errorPage = YPianoCaricoToyotaRigaForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YPianoCaricoToyotaRigaBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YPianoCaricoToyotaRigaForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
