<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///W:\PthDev\Projects\Panthera\DND\WebContent\dtd/xhtml1-transitional.dtd">
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
  BODataCollector TransportBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm TransportForm =  
     new com.thera.thermfw.web.WebForm(request, response, "TransportForm", "Transport", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/dnd/thip/toyota/transport/Transport.js"); 
  TransportForm.setServletEnvironment(se); 
  TransportForm.setJSTypeList(jsList); 
  TransportForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  TransportForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  TransportForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = TransportForm.getMode(); 
  String key = TransportForm.getKey(); 
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
        TransportForm.outTraceInfo(getClass().getName()); 
        String collectorName = TransportForm.findBODataCollectorName(); 
                TransportBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (TransportBODC instanceof WebDataCollector) 
            ((WebDataCollector)TransportBODC).setServletEnvironment(se); 
        TransportBODC.initialize("Transport", true, 0); 
        TransportForm.setBODataCollector(TransportBODC); 
        int rcBODC = TransportForm.initSecurityServices(); 
        mode = TransportForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           TransportForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = TransportBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              TransportForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(TransportForm); 
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
  myToolBarTB.setParent(TransportForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=TransportForm.getBodyOnBeforeUnload()%>" onload="<%=TransportForm.getBodyOnLoad()%>" onunload="<%=TransportForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   TransportForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = TransportForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", TransportBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=TransportForm.getServlet()%>" method="post" name="TransportForm" style="height:100%"><%
  TransportForm.writeFormStartElements(out); 
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
          <td height="100%">
            <!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(TransportForm); 
 mytabbed.addTab("tab1", "it.dnd.thip.toyota.transport.resources.Transport", "tab1", "Transport", null, null, null, null); 
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
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "Transport", "Id", null); 
   label.setParent(TransportForm); 
%><label class="<%=label.getClassType()%>" for="Id"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput TransportId =  
     new com.thera.thermfw.web.WebTextArea("Transport", "Id"); 
  TransportId.setParent(TransportForm); 
%>
<textarea class="<%=TransportId.getClassType()%>" cols="60" id="<%=TransportId.getId()%>" maxlength="<%=TransportId.getMaxLength()%>" name="<%=TransportId.getName()%>" rows="5" size="<%=TransportId.getSize()%>"></textarea><% 
  TransportId.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "Transport", "Data", null); 
   label.setParent(TransportForm); 
%><label class="<%=label.getClassType()%>" for="Data"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput TransportData =  
     new com.thera.thermfw.web.WebTextArea("Transport", "Data"); 
  TransportData.setParent(TransportForm); 
%>
<textarea class="<%=TransportData.getClassType()%>" cols="60" id="<%=TransportData.getId()%>" maxlength="<%=TransportData.getMaxLength()%>" name="<%=TransportData.getName()%>" rows="5" size="<%=TransportData.getSize()%>"></textarea><% 
  TransportData.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "Transport", "TransportState", null); 
   label.setParent(TransportForm); 
%><label class="<%=label.getClassType()%>" for="TransportState"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebComboBox TransportTransportState =  
     new com.thera.thermfw.web.WebComboBox("Transport", "TransportState", null); 
  TransportTransportState.setParent(TransportForm); 
%>
<select id="<%=TransportTransportState.getId()%>" name="<%=TransportTransportState.getName()%>"><% 
  TransportTransportState.write(out); 
%> 
</select>
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <% 
   request.setAttribute("parentForm", TransportForm); 
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
  errorList.setParent(TransportForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  TransportForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = TransportForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", TransportBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              TransportForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, TransportBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, TransportBODC.getErrorList().getErrors()); 
           if(TransportBODC.getConflict() != null) 
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
     if(TransportBODC != null && !TransportBODC.close(false)) 
        errors.addAll(0, TransportBODC.getErrorList().getErrors()); 
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
     String errorPage = TransportForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", TransportBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = TransportForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
