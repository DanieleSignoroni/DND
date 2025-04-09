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
     new com.thera.thermfw.web.WebForm(request, response, "YPianoCaricoToyotaForm", "YPianoCaricoToyota", null, "it.dnd.thip.logis.lgb.web.YPianoCaricoToyotaEstrattoFormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/dnd/thip/logis/lgb/YPianoCaricoToyotaTesEstratto.js"); 
  YPianoCaricoToyotaForm.setServletEnvironment(se); 
  YPianoCaricoToyotaForm.setJSTypeList(jsList); 
  YPianoCaricoToyotaForm.setHeader("it.thera.thip.cs.Header.jsp"); 
  YPianoCaricoToyotaForm.setFooter(null); 
  YPianoCaricoToyotaForm.setWebFormModifierClass("it.dnd.thip.logis.lgb.web.YPianoCaricoToyotaEstrattoFormModifier"); 
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

		<table cellpadding="0" cellspacing="0" class="resTableEstratto" id="emptyborder" width="100%">
			<tr>
				<td><% 
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
				<td><% 
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
				<td colspan="2">
					<table style="width: 100%; margin-top: -4px">
						<tr>
							<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "IdRigaAttivita", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="AttivitaEsecutiva"><%label.write(out);%></label><%}%></td>
							<td valign="top"><% 
  WebMultiSearchForm YPianoCaricoToyotaAttivitaEsecutiva =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPianoCaricoToyota", "AttivitaEsecutiva", false, false, true, 3, null, null); 
  YPianoCaricoToyotaAttivitaEsecutiva.setParent(YPianoCaricoToyotaForm); 
  YPianoCaricoToyotaAttivitaEsecutiva.write(out); 
%>
<!--<span class="multisearchform" id="AttivitaEsecutiva"></span>--></td>
						</tr>
						<tr>
							<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "StatoGestione", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="StatoGestione"><%label.write(out);%></label><%}%></td>
							<td valign="top"><% 
  WebComboBox YPianoCaricoToyotaStatoGestione =  
     new com.thera.thermfw.web.WebComboBox("YPianoCaricoToyota", "StatoGestione", null); 
  YPianoCaricoToyotaStatoGestione.setParent(YPianoCaricoToyotaForm); 
%>
<select id="<%=YPianoCaricoToyotaStatoGestione.getId()%>" name="<%=YPianoCaricoToyotaStatoGestione.getName()%>"><% 
  YPianoCaricoToyotaStatoGestione.write(out); 
%> 
</select></td>
						</tr>
						<tr>
							<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPianoCaricoToyota", "StatoUdc", null); 
   label.setParent(YPianoCaricoToyotaForm); 
%><label class="<%=label.getClassType()%>" for="StatoUdc"><%label.write(out);%></label><%}%></td>
							<td valign="top"><% 
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
				</td>
			</tr>
			<tr>
				<td style="display: none;"><% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YPianoCaricoToyotaForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>--></td>
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
