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
  BODataCollector YGenPianCaricoToyotaBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YGenPianCaricoToyotaForm =  
     new com.thera.thermfw.web.WebFormForBatchForm(request, response, "YGenPianCaricoToyotaForm", "YGenPianCaricoToyota", "Arial,10", "com.thera.thermfw.batch.web.BatchFormActionAdapter", false, false, false, true, true, true, null, 0, false, null); 
  YGenPianCaricoToyotaForm.setServletEnvironment(se); 
  YGenPianCaricoToyotaForm.setJSTypeList(jsList); 
  YGenPianCaricoToyotaForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YGenPianCaricoToyotaForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  ((WebFormForBatchForm)  YGenPianCaricoToyotaForm).setGenerateThReportId(true); 
  ((WebFormForBatchForm)  YGenPianCaricoToyotaForm).setGenerateSSDEnabled(true); 
  YGenPianCaricoToyotaForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YGenPianCaricoToyotaForm.getMode(); 
  String key = YGenPianCaricoToyotaForm.getKey(); 
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
        YGenPianCaricoToyotaForm.outTraceInfo(getClass().getName()); 
        String collectorName = YGenPianCaricoToyotaForm.findBODataCollectorName(); 
				 YGenPianCaricoToyotaBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YGenPianCaricoToyotaBODC instanceof WebDataCollector) 
            ((WebDataCollector)YGenPianCaricoToyotaBODC).setServletEnvironment(se); 
        YGenPianCaricoToyotaBODC.initialize("YGenPianCaricoToyota", true, 0); 
        int rcBODC; 
        if (YGenPianCaricoToyotaBODC.getBo() instanceof BatchRunnable) 
          rcBODC = YGenPianCaricoToyotaBODC.initSecurityServices("RUN", mode, true, false, true); 
        else 
          rcBODC = YGenPianCaricoToyotaBODC.initSecurityServices(mode, true, true, true); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YGenPianCaricoToyotaForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YGenPianCaricoToyotaBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YGenPianCaricoToyotaForm.setBODataCollector(YGenPianCaricoToyotaBODC); 
              YGenPianCaricoToyotaForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 

<% 
  WebLink link_0 =  
   new com.thera.thermfw.web.WebLink(); 
 link_0.setHttpServletRequest(request); 
 link_0.setHRefAttribute("thermweb/css/thermGrid.css"); 
 link_0.setRelAttribute("STYLESHEET"); 
 link_0.setTypeAttribute("text/css"); 
  link_0.write(out); 
%>
<!--<link href="thermweb/css/thermGrid.css" rel="STYLESHEET" type="text/css">-->
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(YGenPianCaricoToyotaForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/com/thera/thermfw/batch/BatchRunnableMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
<body bottommargin="0" leftmargin="0" onbeforeunload="<%=YGenPianCaricoToyotaForm.getBodyOnBeforeUnload()%>" onload="<%=YGenPianCaricoToyotaForm.getBodyOnLoad()%>" onunload="<%=YGenPianCaricoToyotaForm.getBodyOnUnload()%>" rightmargin="0" topmargin="0"><%
   YGenPianCaricoToyotaForm.writeBodyStartElements(out); 
%> 

	<table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YGenPianCaricoToyotaForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YGenPianCaricoToyotaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YGenPianCaricoToyotaForm.getServlet()%>" method="post" name="YGenPianCaricoToyotaForm" style="height:100%"><%
  YGenPianCaricoToyotaForm.writeFormStartElements(out); 
%>

		<table cellpadding="2" cellspacing="2" width="100%">
			<tr>
				<td style="height: 0"><% myToolBarTB.writeChildren(out); %> 
</td>
			</tr>
			<tr>
				<td>
					<table border="0" cellpadding="0" cellspacing="15">
					</table>
				</td>
			</tr>
			<tr>
				<td style="height: 0"><% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YGenPianCaricoToyotaForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>--></td>
			</tr>
		</table>
	<%
  YGenPianCaricoToyotaForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YGenPianCaricoToyotaForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YGenPianCaricoToyotaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


<%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YGenPianCaricoToyotaForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YGenPianCaricoToyotaBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YGenPianCaricoToyotaBODC.getErrorList().getErrors()); 
           if(YGenPianCaricoToyotaBODC.getConflict() != null) 
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
     if(YGenPianCaricoToyotaBODC != null && !YGenPianCaricoToyotaBODC.close(false)) 
        errors.addAll(0, YGenPianCaricoToyotaBODC.getErrorList().getErrors()); 
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
     String errorPage = YGenPianCaricoToyotaForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YGenPianCaricoToyotaBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YGenPianCaricoToyotaForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
