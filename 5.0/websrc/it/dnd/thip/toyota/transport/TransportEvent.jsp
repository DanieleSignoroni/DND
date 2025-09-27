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
  BODataCollector TransportEventBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebFormForIndipendentRowForm TransportEventForm =  
     new com.thera.thermfw.web.WebFormForIndipendentRowForm(request, response, "TransportEventForm", "TransportEvent", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, false, null); 
  TransportEventForm.setServletEnvironment(se); 
  TransportEventForm.setJSTypeList(jsList); 
  TransportEventForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  TransportEventForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  TransportEventForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = TransportEventForm.getMode(); 
  String key = TransportEventForm.getKey(); 
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
        TransportEventForm.outTraceInfo(getClass().getName()); 
        String collectorName = TransportEventForm.findBODataCollectorName(); 
	     TransportEventBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (TransportEventBODC instanceof WebDataCollector) 
            ((WebDataCollector)TransportEventBODC).setServletEnvironment(se); 
        TransportEventBODC.initialize("TransportEvent", true, 0); 
        TransportEventForm.setBODataCollector(TransportEventBODC); 
        int rcBODC = TransportEventForm.initSecurityServices(); 
        mode = TransportEventForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           TransportEventForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = TransportEventBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              TransportEventForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(TransportEventForm); 
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
  myToolBarTB.setParent(TransportEventForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=TransportEventForm.getBodyOnBeforeUnload()%>" onload="<%=TransportEventForm.getBodyOnLoad()%>" onunload="<%=TransportEventForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   TransportEventForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = TransportEventForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", TransportEventBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=TransportEventForm.getServlet()%>" method="post" name="TransportEventForm" style="height:100%"><%
  TransportEventForm.writeFormStartElements(out); 
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
  WebTextInput TransportEventId =  
     new com.thera.thermfw.web.WebTextInput("TransportEvent", "Id"); 
  TransportEventId.setParent(TransportEventForm); 
%>
<input class="<%=TransportEventId.getClassType()%>" id="<%=TransportEventId.getId()%>" maxlength="<%=TransportEventId.getMaxLength()%>" name="<%=TransportEventId.getName()%>" size="<%=TransportEventId.getSize()%>" type="hidden"><% 
  TransportEventId.write(out); 
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
  mytabbed.setParent(TransportEventForm); 
 mytabbed.addTab("tab2", "it.dnd.thip.toyota.transport.resources.TransportEvent", "tab2", "TransportEvent", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
              <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab2")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab2"); %>
                <table style="width: 100%;">
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "TransportEvent", "Index", null); 
   label.setParent(TransportEventForm); 
%><label class="<%=label.getClassType()%>" for="Index"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput TransportEventIndex =  
     new com.thera.thermfw.web.WebTextInput("TransportEvent", "Index"); 
  TransportEventIndex.setParent(TransportEventForm); 
%>
<input class="<%=TransportEventIndex.getClassType()%>" id="<%=TransportEventIndex.getId()%>" maxlength="<%=TransportEventIndex.getMaxLength()%>" name="<%=TransportEventIndex.getName()%>" size="<%=TransportEventIndex.getSize()%>"><% 
  TransportEventIndex.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "TransportEvent", "EventType", null); 
   label.setParent(TransportEventForm); 
%><label class="<%=label.getClassType()%>" for="EventType"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput TransportEventEventType =  
     new com.thera.thermfw.web.WebTextInput("TransportEvent", "EventType"); 
  TransportEventEventType.setParent(TransportEventForm); 
%>
<input class="<%=TransportEventEventType.getClassType()%>" id="<%=TransportEventEventType.getId()%>" maxlength="<%=TransportEventEventType.getMaxLength()%>" name="<%=TransportEventEventType.getName()%>" size="<%=TransportEventEventType.getSize()%>"><% 
  TransportEventEventType.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "TransportEvent", "Data", null); 
   label.setParent(TransportEventForm); 
%><label class="<%=label.getClassType()%>" for="Data"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput TransportEventData =  
     new com.thera.thermfw.web.WebTextArea("TransportEvent", "Data"); 
  TransportEventData.setParent(TransportEventForm); 
%>
<textarea class="<%=TransportEventData.getClassType()%>" cols="60" id="<%=TransportEventData.getId()%>" maxlength="<%=TransportEventData.getMaxLength()%>" name="<%=TransportEventData.getName()%>" rows="5" size="<%=TransportEventData.getSize()%>"></textarea><% 
  TransportEventData.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <% 
   request.setAttribute("parentForm", TransportEventForm); 
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
  errorList.setParent(TransportEventForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  TransportEventForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = TransportEventForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", TransportEventBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              TransportEventForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, TransportEventBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, TransportEventBODC.getErrorList().getErrors()); 
           if(TransportEventBODC.getConflict() != null) 
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
     if(TransportEventBODC != null && !TransportEventBODC.close(false)) 
        errors.addAll(0, TransportEventBODC.getErrorList().getErrors()); 
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
     String errorPage = TransportEventForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", TransportEventBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = TransportEventForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
