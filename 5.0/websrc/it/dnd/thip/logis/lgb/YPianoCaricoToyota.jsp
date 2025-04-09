<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///K:/Thip/5.1.0/websrcsvil/dtd/xhtml1-transitional.dtd">
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
  BODataCollector YPianoCaricoToyotaBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YPianoCaricoToyotaForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YPianoCaricoToyotaForm", "YPianoCaricoToyota", null, "it.dnd.thip.logis.lgb.web.YPianoCaricoToyotaFormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/dnd/thip/logis/lgb/YPianoCaricoToyota.js"); 
  YPianoCaricoToyotaForm.setServletEnvironment(se); 
  YPianoCaricoToyotaForm.setJSTypeList(jsList); 
  YPianoCaricoToyotaForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YPianoCaricoToyotaForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YPianoCaricoToyotaForm.setWebFormModifierClass("it.dnd.thip.logis.lgb.web.YPianoCaricoToyotaFormModifier"); 
  YPianoCaricoToyotaForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YPianoCaricoToyotaForm.getMode(); 
  String key = YPianoCaricoToyotaForm.getKey(); 
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
        YPianoCaricoToyotaForm.outTraceInfo(getClass().getName()); 
        String collectorName = YPianoCaricoToyotaForm.findBODataCollectorName(); 
                YPianoCaricoToyotaBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YPianoCaricoToyotaBODC instanceof WebDataCollector) 
            ((WebDataCollector)YPianoCaricoToyotaBODC).setServletEnvironment(se); 
        YPianoCaricoToyotaBODC.initialize("YPianoCaricoToyota", true, 0); 
        YPianoCaricoToyotaForm.setBODataCollector(YPianoCaricoToyotaBODC); 
        int rcBODC = YPianoCaricoToyotaForm.initSecurityServices(); 
        mode = YPianoCaricoToyotaForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YPianoCaricoToyotaForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YPianoCaricoToyotaBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YPianoCaricoToyotaForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YPianoCaricoToyotaForm); 
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
  myToolBarTB.setParent(YPianoCaricoToyotaForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YPianoCaricoToyotaForm.getBodyOnBeforeUnload()%>" onload="<%=YPianoCaricoToyotaForm.getBodyOnLoad()%>" onunload="<%=YPianoCaricoToyotaForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YPianoCaricoToyotaForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YPianoCaricoToyotaForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YPianoCaricoToyotaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YPianoCaricoToyotaForm.getServlet()%>" method="post" name="YPianoCaricoToyotaForm" style="height:100%"><%
  YPianoCaricoToyotaForm.writeFormStartElements(out); 
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
  WebTextInput YPianoCaricoToyotaAnnoDocumento =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyota", "AnnoDocumento"); 
  YPianoCaricoToyotaAnnoDocumento.setParent(YPianoCaricoToyotaForm); 
%>
<input class="<%=YPianoCaricoToyotaAnnoDocumento.getClassType()%>" id="<%=YPianoCaricoToyotaAnnoDocumento.getId()%>" maxlength="<%=YPianoCaricoToyotaAnnoDocumento.getMaxLength()%>" name="<%=YPianoCaricoToyotaAnnoDocumento.getName()%>" size="<%=YPianoCaricoToyotaAnnoDocumento.getSize()%>" type="hidden"><% 
  YPianoCaricoToyotaAnnoDocumento.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YPianoCaricoToyotaNumeroDocumento =  
     new com.thera.thermfw.web.WebTextInput("YPianoCaricoToyota", "NumeroDocumento"); 
  YPianoCaricoToyotaNumeroDocumento.setParent(YPianoCaricoToyotaForm); 
%>
<input class="<%=YPianoCaricoToyotaNumeroDocumento.getClassType()%>" id="<%=YPianoCaricoToyotaNumeroDocumento.getId()%>" maxlength="<%=YPianoCaricoToyotaNumeroDocumento.getMaxLength()%>" name="<%=YPianoCaricoToyotaNumeroDocumento.getName()%>" size="<%=YPianoCaricoToyotaNumeroDocumento.getSize()%>" type="hidden"><% 
  YPianoCaricoToyotaNumeroDocumento.write(out); 
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
  mytabbed.setParent(YPianoCaricoToyotaForm); 
 mytabbed.addTab("tab1", "it.dnd.thip.logis.lgb.resources.YPianoCaricoToyota", "tab1", "YPianoCaricoToyota", null, null, null, null); 
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
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "IdCodiceUdc", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="Udc"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPianoCaricoToyotaUdc =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyota", "Udc", false, false, true, 1, null, null); 
  YPianoCaricoToyotaUdc.setParent(YPianoCaricoToyotaForm); 
  YPianoCaricoToyotaUdc.write(out); 
%>
<!--<span class="multisearchform" id="Udc"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "IdRigaAttivita", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="AttivitaEsecutiva"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPianoCaricoToyotaAttivitaEsecutiva =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyota", "AttivitaEsecutiva", false, false, true, 3, null, null); 
  YPianoCaricoToyotaAttivitaEsecutiva.setParent(YPianoCaricoToyotaForm); 
  YPianoCaricoToyotaAttivitaEsecutiva.write(out); 
%>
<!--<span class="multisearchform" id="AttivitaEsecutiva"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "IdReparto", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="Reparto"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPianoCaricoToyotaReparto =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyota", "Reparto", false, false, true, 1, null, null); 
  YPianoCaricoToyotaReparto.setParent(YPianoCaricoToyotaForm); 
  YPianoCaricoToyotaReparto.write(out); 
%>
<!--<span class="multisearchform" id="Reparto"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "IdCodiceUbicazioneStock", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="UbicazioneStock"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPianoCaricoToyotaUbicazioneStock =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyota", "UbicazioneStock", false, false, true, 2, null, null); 
  YPianoCaricoToyotaUbicazioneStock.setParent(YPianoCaricoToyotaForm); 
  YPianoCaricoToyotaUbicazioneStock.write(out); 
%>
<!--<span class="multisearchform" id="UbicazioneStock"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "IdCodUbicazionePrelievo", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="UbicazionePrelievo"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPianoCaricoToyotaUbicazionePrelievo =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyota", "UbicazionePrelievo", false, false, true, 2, null, null); 
  YPianoCaricoToyotaUbicazionePrelievo.setParent(YPianoCaricoToyotaForm); 
  YPianoCaricoToyotaUbicazionePrelievo.write(out); 
%>
<!--<span class="multisearchform" id="UbicazionePrelievo"></span>-->
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
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "StatoGestione", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="StatoGestione"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebComboBox YPianoCaricoToyotaStatoGestione =  
     new com.thera.thermfw.web.WebComboBox("YPianoCaricoToyota", "StatoGestione", null); 
  YPianoCaricoToyotaStatoGestione.setParent(YPianoCaricoToyotaForm); 
%>
<select id="<%=YPianoCaricoToyotaStatoGestione.getId()%>" name="<%=YPianoCaricoToyotaStatoGestione.getName()%>"><% 
  YPianoCaricoToyotaStatoGestione.write(out); 
%> 
</select>
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "StatoUdc", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="StatoUdc"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebComboBox YPianoCaricoToyotaStatoUdc =  
     new com.thera.thermfw.web.WebComboBox("YPianoCaricoToyota", "StatoUdc", null); 
  YPianoCaricoToyotaStatoUdc.setParent(YPianoCaricoToyotaForm); 
%>
<select id="<%=YPianoCaricoToyotaStatoUdc.getId()%>" name="<%=YPianoCaricoToyotaStatoUdc.getName()%>"><% 
  YPianoCaricoToyotaStatoUdc.write(out); 
%> 
</select>
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
  errorList.setParent(YPianoCaricoToyotaForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YPianoCaricoToyotaForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YPianoCaricoToyotaForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YPianoCaricoToyotaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YPianoCaricoToyotaForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YPianoCaricoToyotaBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YPianoCaricoToyotaBODC.getErrorList().getErrors()); 
           if(YPianoCaricoToyotaBODC.getConflict() != null) 
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
     if(YPianoCaricoToyotaBODC != null && !YPianoCaricoToyotaBODC.close(false)) 
        errors.addAll(0, YPianoCaricoToyotaBODC.getErrorList().getErrors()); 
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
     String errorPage = YPianoCaricoToyotaForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YPianoCaricoToyotaBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YPianoCaricoToyotaForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
