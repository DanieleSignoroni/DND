<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///K:/Thip/5.1.0/websrcsvil/dtd/xhtml1-transitional.dtd">
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
  BODataCollector YAgvBufferRigaBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebFormForIndipendentRowForm YAgvBufferRigaForm =  
     new com.thera.thermfw.web.WebFormForIndipendentRowForm(request, response, "YAgvBufferRigaForm", "YAgvBufferRiga", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, false, null); 
  YAgvBufferRigaForm.setServletEnvironment(se); 
  YAgvBufferRigaForm.setJSTypeList(jsList); 
  YAgvBufferRigaForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YAgvBufferRigaForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YAgvBufferRigaForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YAgvBufferRigaForm.getMode(); 
  String key = YAgvBufferRigaForm.getKey(); 
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
        YAgvBufferRigaForm.outTraceInfo(getClass().getName()); 
        String collectorName = YAgvBufferRigaForm.findBODataCollectorName(); 
	     YAgvBufferRigaBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YAgvBufferRigaBODC instanceof WebDataCollector) 
            ((WebDataCollector)YAgvBufferRigaBODC).setServletEnvironment(se); 
        YAgvBufferRigaBODC.initialize("YAgvBufferRiga", true, 0); 
        YAgvBufferRigaForm.setBODataCollector(YAgvBufferRigaBODC); 
        int rcBODC = YAgvBufferRigaForm.initSecurityServices(); 
        mode = YAgvBufferRigaForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YAgvBufferRigaForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YAgvBufferRigaBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YAgvBufferRigaForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YAgvBufferRigaForm); 
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
  myToolBarTB.setParent(YAgvBufferRigaForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
<body onbeforeunload="<%=YAgvBufferRigaForm.getBodyOnBeforeUnload()%>" onload="<%=YAgvBufferRigaForm.getBodyOnLoad()%>" onunload="<%=YAgvBufferRigaForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YAgvBufferRigaForm.writeBodyStartElements(out); 
%> 

	<table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YAgvBufferRigaForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YAgvBufferRigaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YAgvBufferRigaForm.getServlet()%>" method="post" name="YAgvBufferRigaForm" style="height:100%"><%
  YAgvBufferRigaForm.writeFormStartElements(out); 
%>

		<table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
			<tr>
				<td style="height: 0"><% menuBar.writeElements(out); %> 
</td>
			</tr>
			<tr>
				<td style="height: 0"><% myToolBarTB.writeChildren(out); %> 
</td>
			</tr>
			<tr>
				<td><% 
  WebTextInput YAgvBufferRigaIdBuffer =  
     new com.thera.thermfw.web.WebTextInput("YAgvBufferRiga", "IdBuffer"); 
  YAgvBufferRigaIdBuffer.setParent(YAgvBufferRigaForm); 
%>
<input class="<%=YAgvBufferRigaIdBuffer.getClassType()%>" id="<%=YAgvBufferRigaIdBuffer.getId()%>" maxlength="<%=YAgvBufferRigaIdBuffer.getMaxLength()%>" name="<%=YAgvBufferRigaIdBuffer.getName()%>" size="<%=YAgvBufferRigaIdBuffer.getSize()%>" type="hidden"><% 
  YAgvBufferRigaIdBuffer.write(out); 
%>
</td>
			</tr>
			<tr>
				<td height="100%"><!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YAgvBufferRigaForm); 
 mytabbed.addTab("tab2", "it.dnd.thip.agv.resources.YAgvBufferRiga", "tab2", "YAgvBufferRiga", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;"> <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab2")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab2"); %>
							<table style="width: 100%;">
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YAgvBufferRiga", "IdRigaBuffer", null); 
   label.setParent(YAgvBufferRigaForm); 
%><label class="<%=label.getClassType()%>" for="IdRigaBuffer"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebTextInput YAgvBufferRigaIdRigaBuffer =  
     new com.thera.thermfw.web.WebTextInput("YAgvBufferRiga", "IdRigaBuffer"); 
  YAgvBufferRigaIdRigaBuffer.setParent(YAgvBufferRigaForm); 
%>
<input class="<%=YAgvBufferRigaIdRigaBuffer.getClassType()%>" id="<%=YAgvBufferRigaIdRigaBuffer.getId()%>" maxlength="<%=YAgvBufferRigaIdRigaBuffer.getMaxLength()%>" name="<%=YAgvBufferRigaIdRigaBuffer.getName()%>" size="<%=YAgvBufferRigaIdRigaBuffer.getSize()%>"><% 
  YAgvBufferRigaIdRigaBuffer.write(out); 
%>
</td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YAgvBufferRiga", "IdNumeroPcToyota", null); 
   label.setParent(YAgvBufferRigaForm); 
%><label class="<%=label.getClassType()%>" for="PianoCaricoToyota"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebMultiSearchForm YAgvBufferRigaPianoCaricoToyota =  
     new com.thera.thermfw.web.WebMultiSearchForm("YAgvBufferRiga", "PianoCaricoToyota", false, false, true, 3, null, null); 
  YAgvBufferRigaPianoCaricoToyota.setParent(YAgvBufferRigaForm); 
  YAgvBufferRigaPianoCaricoToyota.write(out); 
%>
<!--<span class="multisearchform" id="PianoCaricoToyota"></span>--></td>
								</tr>
								<tr>
									<td valign="top"><% 
   request.setAttribute("parentForm", YAgvBufferRigaForm); 
   String CDForDatiComuniEstesi$it$thera$thip$cs$DatiComuniEstesi$jsp = "DatiComuniEstesi"; 
%>
<jsp:include page="/it/thera/thip/cs/DatiComuniEstesi.jsp" flush="true"> 
<jsp:param name="CDName" value="<%=CDForDatiComuniEstesi$it$thera$thip$cs$DatiComuniEstesi$jsp%>"/> 
</jsp:include> 
<!--<span class="subform" id="DatiComuniEstesi"></span>--></td>
									<td valign="top"></td>
								</tr>
							</table>
					<% mytabbed.endTab(); %> 
</div>
				</div><% mytabbed.endTabbed();%> 

     </td>
   </tr>
</table><!--</span>--></td>
			</tr>
			<tr>
				<td style="height: 0"><% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YAgvBufferRigaForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>--></td>
			</tr>
		</table>
	<%
  YAgvBufferRigaForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YAgvBufferRigaForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YAgvBufferRigaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


<%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YAgvBufferRigaForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YAgvBufferRigaBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YAgvBufferRigaBODC.getErrorList().getErrors()); 
           if(YAgvBufferRigaBODC.getConflict() != null) 
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
     if(YAgvBufferRigaBODC != null && !YAgvBufferRigaBODC.close(false)) 
        errors.addAll(0, YAgvBufferRigaBODC.getErrorList().getErrors()); 
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
     String errorPage = YAgvBufferRigaForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YAgvBufferRigaBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YAgvBufferRigaForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
