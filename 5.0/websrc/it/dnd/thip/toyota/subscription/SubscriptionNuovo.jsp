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
  BODataCollector SubscriptionBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm SubscriptionForm =  
     new com.thera.thermfw.web.WebForm(request, response, "SubscriptionForm", "Subscription", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/dnd/thip/toyota/subscription/SubscriptionNuovo.js"); 
  SubscriptionForm.setServletEnvironment(se); 
  SubscriptionForm.setJSTypeList(jsList); 
  SubscriptionForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  SubscriptionForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  SubscriptionForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = SubscriptionForm.getMode(); 
  String key = SubscriptionForm.getKey(); 
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
        SubscriptionForm.outTraceInfo(getClass().getName()); 
        String collectorName = SubscriptionForm.findBODataCollectorName(); 
                SubscriptionBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (SubscriptionBODC instanceof WebDataCollector) 
            ((WebDataCollector)SubscriptionBODC).setServletEnvironment(se); 
        SubscriptionBODC.initialize("Subscription", true, 0); 
        SubscriptionForm.setBODataCollector(SubscriptionBODC); 
        int rcBODC = SubscriptionForm.initSecurityServices(); 
        mode = SubscriptionForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           SubscriptionForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = SubscriptionBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              SubscriptionForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(SubscriptionForm); 
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
  myToolBarTB.setParent(SubscriptionForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
<body onbeforeunload="<%=SubscriptionForm.getBodyOnBeforeUnload()%>" onload="<%=SubscriptionForm.getBodyOnLoad()%>" onunload="<%=SubscriptionForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   SubscriptionForm.writeBodyStartElements(out); 
%> 

	<table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = SubscriptionForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", SubscriptionBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=SubscriptionForm.getServlet()%>" method="post" name="SubscriptionNuovoForm" style="height:100%"><%
  SubscriptionForm.writeFormStartElements(out); 
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
				<td>
					<table style="width: 100%;">
						<tr>
							<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "Subscription", "SourceType", null); 
   label.setParent(SubscriptionForm); 
%><label class="<%=label.getClassType()%>" for="SourceType"><%label.write(out);%></label><%}%></td>
							<td valign="top"><% 
  WebComboBox SubscriptionSourceType =  
     new com.thera.thermfw.web.WebComboBox("Subscription", "SourceType", null); 
  SubscriptionSourceType.setParent(SubscriptionForm); 
%>
<select id="<%=SubscriptionSourceType.getId()%>" name="<%=SubscriptionSourceType.getName()%>"><% 
  SubscriptionSourceType.write(out); 
%> 
</select>
							</td>
						</tr>
						<tr>
							<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "Subscription", "Endpoint", null); 
   label.setParent(SubscriptionForm); 
%><label class="<%=label.getClassType()%>" for="Endpoint"><%label.write(out);%></label><%}%></td>
							<td valign="top"><% 
  WebTextInput SubscriptionEndpoint =  
     new com.thera.thermfw.web.WebTextArea("Subscription", "Endpoint"); 
  SubscriptionEndpoint.setParent(SubscriptionForm); 
%>
<textarea class="<%=SubscriptionEndpoint.getClassType()%>" cols="60" id="<%=SubscriptionEndpoint.getId()%>" maxlength="<%=SubscriptionEndpoint.getMaxLength()%>" name="<%=SubscriptionEndpoint.getName()%>" rows="5" size="<%=SubscriptionEndpoint.getSize()%>"></textarea><% 
  SubscriptionEndpoint.write(out); 
%>
</td>
						</tr>
					</table>>
				</td>
			</tr>
			<tr>
				<td style="height: 0"><% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(SubscriptionForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>--></td>
			</tr>
		</table>
	<%
  SubscriptionForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = SubscriptionForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", SubscriptionBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


<%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              SubscriptionForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, SubscriptionBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, SubscriptionBODC.getErrorList().getErrors()); 
           if(SubscriptionBODC.getConflict() != null) 
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
     if(SubscriptionBODC != null && !SubscriptionBODC.close(false)) 
        errors.addAll(0, SubscriptionBODC.getErrorList().getErrors()); 
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
     String errorPage = SubscriptionForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", SubscriptionBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = SubscriptionForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
