<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///K:/Thip/5.1.0/websrcsvil/dtd/xhtml1-transitional.dtd">
<html>
<!-- WIZGEN Therm 2.0.0 as Batch form - multiBrowserGen = true -->
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
  BODataCollector YSchedulazioneBufferAgvBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YSchedulazioneBufferAgvForm =  
     new com.thera.thermfw.web.WebFormForBatchForm(request, response, "YSchedulazioneBufferAgvForm", "YSchedulazioneBufferAgv", "Arial,10", "it.dnd.thip.agv.web.YSchedulazioneBufferAgvBatchActionAdapter", false, false, true, true, true, true, "it.dnd.thip.agv.web.YSchedulazioneBufferAgvBatchDC", 1, false, null); 
  YSchedulazioneBufferAgvForm.setServletEnvironment(se); 
  YSchedulazioneBufferAgvForm.setJSTypeList(jsList); 
  YSchedulazioneBufferAgvForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YSchedulazioneBufferAgvForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  ((WebFormForBatchForm)  YSchedulazioneBufferAgvForm).setGenerateThReportId(true); 
  ((WebFormForBatchForm)  YSchedulazioneBufferAgvForm).setGenerateSSDEnabled(true); 
  YSchedulazioneBufferAgvForm.setWebFormModifierClass("it.dnd.thip.agv.web.YSchedulazioneBufferAgvModifier"); 
  YSchedulazioneBufferAgvForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YSchedulazioneBufferAgvForm.getMode(); 
  String key = YSchedulazioneBufferAgvForm.getKey(); 
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
        YSchedulazioneBufferAgvForm.outTraceInfo(getClass().getName()); 
        String collectorName = YSchedulazioneBufferAgvForm.findBODataCollectorName(); 
				 YSchedulazioneBufferAgvBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YSchedulazioneBufferAgvBODC instanceof WebDataCollector) 
            ((WebDataCollector)YSchedulazioneBufferAgvBODC).setServletEnvironment(se); 
        YSchedulazioneBufferAgvBODC.initialize("YSchedulazioneBufferAgv", true, 1); 
        int rcBODC; 
        if (YSchedulazioneBufferAgvBODC.getBo() instanceof BatchRunnable) 
          rcBODC = YSchedulazioneBufferAgvBODC.initSecurityServices("RUN", mode, true, false, true); 
        else 
          rcBODC = YSchedulazioneBufferAgvBODC.initSecurityServices(mode, true, true, true); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YSchedulazioneBufferAgvForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YSchedulazioneBufferAgvBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YSchedulazioneBufferAgvForm.setBODataCollector(YSchedulazioneBufferAgvBODC); 
              YSchedulazioneBufferAgvForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<title>Schedulazione Service Batch</title><% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YSchedulazioneBufferAgvForm); 
   request.setAttribute("menuBar", menuBar); 
%> 
<jsp:include page="/it/thera/thip/produzione/ordese/BatchRunnableMenuSchedulaSrv.jsp" flush="true"> 
<jsp:param name="partRequest" value="menuBar"/> 
</jsp:include> 
<% 
  menuBar.write(out); 
  menuBar.writeChildren(out); 
%> 
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(YSchedulazioneBufferAgvForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/produzione/ordese/BatchRunnableMenuSchedulaSrv.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
<body bottommargin="0" leftmargin="0" onbeforeunload="<%=YSchedulazioneBufferAgvForm.getBodyOnBeforeUnload()%>" onload="<%=YSchedulazioneBufferAgvForm.getBodyOnLoad()%>" onunload="<%=YSchedulazioneBufferAgvForm.getBodyOnUnload()%>" rightmargin="0" topmargin="0"><%
   YSchedulazioneBufferAgvForm.writeBodyStartElements(out); 
%> 

<table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YSchedulazioneBufferAgvForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YSchedulazioneBufferAgvBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YSchedulazioneBufferAgvForm.getServlet()%>" method="post" name="YSchedulazioneBufferAgv" style="height:100%"><%
  YSchedulazioneBufferAgvForm.writeFormStartElements(out); 
%>

<table cellpadding="0" cellspacing="0" height="67%" width="100%"><!-- Fix 39405 modeficato il height da 100% a 67%-->
		<tr valign="top"><td style="height:0"><% menuBar.writeElements(out); %> 
</td></tr>
		<tr valign="top"><td style="height:0"><% myToolBarTB.writeChildren(out); %> 
</td></tr>
	<tr><td>
			<table border="0" cellpadding="2" cellspacing="0" style="margin: 7 7 7 7;" width="98%">
		<!--Fix 12836   inizio -->
		<tr>
				 <td height="30" width="20%"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YSchedulazioneBufferAgv", "IdAzienda", null); 
   label.setParent(YSchedulazioneBufferAgvForm); 
%><label class="<%=label.getClassType()%>" for="IdAzienda"><%label.write(out);%></label><%}%></td>
				 <td height="30" width="80%"><% 
  WebTextInput YSchedulazioneBufferAgvIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("YSchedulazioneBufferAgv", "IdAzienda"); 
  YSchedulazioneBufferAgvIdAzienda.setParent(YSchedulazioneBufferAgvForm); 
%>
<input class="<%=YSchedulazioneBufferAgvIdAzienda.getClassType()%>" id="<%=YSchedulazioneBufferAgvIdAzienda.getId()%>" maxlength="<%=YSchedulazioneBufferAgvIdAzienda.getMaxLength()%>" name="<%=YSchedulazioneBufferAgvIdAzienda.getName()%>" size="<%=YSchedulazioneBufferAgvIdAzienda.getSize()%>"><% 
  YSchedulazioneBufferAgvIdAzienda.write(out); 
%>
</td>
		</tr>	
		<tr>
				 <td height="30" width="20%"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YSchedulazioneBufferAgv", "ScheduledJobId", null); 
   label.setParent(YSchedulazioneBufferAgvForm); 
%><label class="<%=label.getClassType()%>" for="ScheduledJobId"><%label.write(out);%></label><%}%></td>
				 <td height="30" width="80%"><% 
  WebTextInput YSchedulazioneBufferAgvScheduledJobId =  
     new com.thera.thermfw.web.WebTextInput("YSchedulazioneBufferAgv", "ScheduledJobId"); 
  YSchedulazioneBufferAgvScheduledJobId.setParent(YSchedulazioneBufferAgvForm); 
%>
<input class="<%=YSchedulazioneBufferAgvScheduledJobId.getClassType()%>" id="<%=YSchedulazioneBufferAgvScheduledJobId.getId()%>" maxlength="<%=YSchedulazioneBufferAgvScheduledJobId.getMaxLength()%>" name="<%=YSchedulazioneBufferAgvScheduledJobId.getName()%>" size="<%=YSchedulazioneBufferAgvScheduledJobId.getSize()%>"><% 
  YSchedulazioneBufferAgvScheduledJobId.write(out); 
%>
</td>
		</tr>	
		<!--Fix 12836   fine -->
		<tr>
				 <td height="30" width="20%"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YSchedulazioneBufferAgv", "OreInitiale", null); 
   label.setParent(YSchedulazioneBufferAgvForm); 
%><label class="<%=label.getClassType()%>" for="OreInitiale"><%label.write(out);%></label><%}%></td>
				 <td height="30" width="80%"><% 
  WebTextInput YSchedulazioneBufferAgvOreInitiale =  
     new com.thera.thermfw.web.WebTextInput("YSchedulazioneBufferAgv", "OreInitiale"); 
  YSchedulazioneBufferAgvOreInitiale.setParent(YSchedulazioneBufferAgvForm); 
%>
<input class="<%=YSchedulazioneBufferAgvOreInitiale.getClassType()%>" id="<%=YSchedulazioneBufferAgvOreInitiale.getId()%>" maxlength="<%=YSchedulazioneBufferAgvOreInitiale.getMaxLength()%>" name="<%=YSchedulazioneBufferAgvOreInitiale.getName()%>" size="<%=YSchedulazioneBufferAgvOreInitiale.getSize()%>"><% 
  YSchedulazioneBufferAgvOreInitiale.write(out); 
%>
</td>
				</tr>
		<tr>
				 <td height="30" width="20%"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YSchedulazioneBufferAgv", "ExpirationTime", null); 
   label.setParent(YSchedulazioneBufferAgvForm); 
%><label class="<%=label.getClassType()%>" for="ExpirationTime"><%label.write(out);%></label><%}%></td>
				 <td height="30" width="80%"><% 
  WebTextInput YSchedulazioneBufferAgvExpirationTime =  
     new com.thera.thermfw.web.WebTextInput("YSchedulazioneBufferAgv", "ExpirationTime"); 
  YSchedulazioneBufferAgvExpirationTime.setParent(YSchedulazioneBufferAgvForm); 
%>
<input class="<%=YSchedulazioneBufferAgvExpirationTime.getClassType()%>" id="<%=YSchedulazioneBufferAgvExpirationTime.getId()%>" maxlength="<%=YSchedulazioneBufferAgvExpirationTime.getMaxLength()%>" name="<%=YSchedulazioneBufferAgvExpirationTime.getName()%>" size="<%=YSchedulazioneBufferAgvExpirationTime.getSize()%>"><% 
  YSchedulazioneBufferAgvExpirationTime.write(out); 
%>
</td>
				</tr>
		<tr>
				 <td height="30" width="20%"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YSchedulazioneBufferAgv", "SleepTime", null); 
   label.setParent(YSchedulazioneBufferAgvForm); 
%><label class="<%=label.getClassType()%>" for="SleepTime"><%label.write(out);%></label><%}%></td>
				 <td height="30" width="80%"><% 
  WebTextInput YSchedulazioneBufferAgvSleepTime =  
     new com.thera.thermfw.web.WebTextInput("YSchedulazioneBufferAgv", "SleepTime"); 
  YSchedulazioneBufferAgvSleepTime.setParent(YSchedulazioneBufferAgvForm); 
%>
<input class="<%=YSchedulazioneBufferAgvSleepTime.getClassType()%>" id="<%=YSchedulazioneBufferAgvSleepTime.getId()%>" maxlength="<%=YSchedulazioneBufferAgvSleepTime.getMaxLength()%>" name="<%=YSchedulazioneBufferAgvSleepTime.getName()%>" size="<%=YSchedulazioneBufferAgvSleepTime.getSize()%>"><% 
  YSchedulazioneBufferAgvSleepTime.write(out); 
%>

			 <label class="thLabel" id="SleepTimeLabel" name="SleepTimeLabel">
 <% { WebLabelSimple label = new com.thera.thermfw.web.WebLabelSimple("it.thera.thip.produzione.ordese.resources.SchedulazioneServiceBatch", "SleepTime", null, null, null, null); 
 label.setParent(YSchedulazioneBufferAgvForm); 
label.write(out); }%> 
</label></td>
				</tr>
		<tr>
				 <td height="30" width="20%"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YSchedulazioneBufferAgv", "Stato", null); 
   label.setParent(YSchedulazioneBufferAgvForm); 
%><label class="<%=label.getClassType()%>" for="Stato"><%label.write(out);%></label><%}%></td>
				 <td height="30" width="80%"><% 
  WebComboBox YSchedulazioneBufferAgvStato =  
     new com.thera.thermfw.web.WebComboBox("YSchedulazioneBufferAgv", "Stato", null); 
  YSchedulazioneBufferAgvStato.setParent(YSchedulazioneBufferAgvForm); 
%>
<select id="<%=YSchedulazioneBufferAgvStato.getId()%>" name="<%=YSchedulazioneBufferAgvStato.getName()%>"><% 
  YSchedulazioneBufferAgvStato.write(out); 
%> 
</select></td>
				</tr>
				
			</table>	
		</td></tr>
		<tr valign="bottom"><td style="height:0"><% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YSchedulazioneBufferAgvForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>--></td></tr>
</table>
<%
  YSchedulazioneBufferAgvForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YSchedulazioneBufferAgvForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YSchedulazioneBufferAgvBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


<%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YSchedulazioneBufferAgvForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YSchedulazioneBufferAgvBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YSchedulazioneBufferAgvBODC.getErrorList().getErrors()); 
           if(YSchedulazioneBufferAgvBODC.getConflict() != null) 
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
     if(YSchedulazioneBufferAgvBODC != null && !YSchedulazioneBufferAgvBODC.close(false)) 
        errors.addAll(0, YSchedulazioneBufferAgvBODC.getErrorList().getErrors()); 
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
     String errorPage = YSchedulazioneBufferAgvForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YSchedulazioneBufferAgvBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YSchedulazioneBufferAgvForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
