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
  BODataCollector PsnDatiToyotaBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm PsnDatiToyotaForm =  
     new com.thera.thermfw.web.WebForm(request, response, "PsnDatiToyotaForm", "PsnDatiToyota", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/dnd/thip/toyota/PsnDatiToyota.js"); 
  PsnDatiToyotaForm.setServletEnvironment(se); 
  PsnDatiToyotaForm.setJSTypeList(jsList); 
  PsnDatiToyotaForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  PsnDatiToyotaForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  PsnDatiToyotaForm.setWebFormModifierClass("it.dnd.thip.toyota.web.PsnDatiToyotaFormModifier"); 
  PsnDatiToyotaForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = PsnDatiToyotaForm.getMode(); 
  String key = PsnDatiToyotaForm.getKey(); 
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
        PsnDatiToyotaForm.outTraceInfo(getClass().getName()); 
        String collectorName = PsnDatiToyotaForm.findBODataCollectorName(); 
                PsnDatiToyotaBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (PsnDatiToyotaBODC instanceof WebDataCollector) 
            ((WebDataCollector)PsnDatiToyotaBODC).setServletEnvironment(se); 
        PsnDatiToyotaBODC.initialize("PsnDatiToyota", true, 0); 
        PsnDatiToyotaForm.setBODataCollector(PsnDatiToyotaBODC); 
        int rcBODC = PsnDatiToyotaForm.initSecurityServices(); 
        mode = PsnDatiToyotaForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           PsnDatiToyotaForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = PsnDatiToyotaBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              PsnDatiToyotaForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(PsnDatiToyotaForm); 
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
  myToolBarTB.setParent(PsnDatiToyotaForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=PsnDatiToyotaForm.getBodyOnBeforeUnload()%>" onload="<%=PsnDatiToyotaForm.getBodyOnLoad()%>" onunload="<%=PsnDatiToyotaForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   PsnDatiToyotaForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = PsnDatiToyotaForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", PsnDatiToyotaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=PsnDatiToyotaForm.getServlet()%>" method="post" name="PsnDatiToyotaForm" style="height:100%"><%
  PsnDatiToyotaForm.writeFormStartElements(out); 
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
  WebTextInput PsnDatiToyotaIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("PsnDatiToyota", "IdAzienda"); 
  PsnDatiToyotaIdAzienda.setParent(PsnDatiToyotaForm); 
%>
<input class="<%=PsnDatiToyotaIdAzienda.getClassType()%>" id="<%=PsnDatiToyotaIdAzienda.getId()%>" maxlength="<%=PsnDatiToyotaIdAzienda.getMaxLength()%>" name="<%=PsnDatiToyotaIdAzienda.getName()%>" size="<%=PsnDatiToyotaIdAzienda.getSize()%>" type="hidden"><% 
  PsnDatiToyotaIdAzienda.write(out); 
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
  mytabbed.setParent(PsnDatiToyotaForm); 
 mytabbed.addTab("tab1", "it.dnd.thip.toyota.resources.PsnDatiToyota", "tab1", "PsnDatiToyota", null, null, null, null); 
 mytabbed.addTab("tab2", "it.dnd.thip.toyota.resources.PsnDatiToyota", "tab2", "PsnDatiToyota", null, null, null, null); 
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
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "PsnDatiToyota", "ClientIdPanth01", null); 
   label.setParent(PsnDatiToyotaForm); 
%><label class="<%=label.getClassType()%>" for="ClientIdPanth01"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput PsnDatiToyotaClientIdPanth01 =  
     new com.thera.thermfw.web.WebTextArea("PsnDatiToyota", "ClientIdPanth01"); 
  PsnDatiToyotaClientIdPanth01.setParent(PsnDatiToyotaForm); 
%>
<textarea class="<%=PsnDatiToyotaClientIdPanth01.getClassType()%>" cols="60" id="<%=PsnDatiToyotaClientIdPanth01.getId()%>" maxlength="<%=PsnDatiToyotaClientIdPanth01.getMaxLength()%>" name="<%=PsnDatiToyotaClientIdPanth01.getName()%>" rows="5" size="<%=PsnDatiToyotaClientIdPanth01.getSize()%>"></textarea><% 
  PsnDatiToyotaClientIdPanth01.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "PsnDatiToyota", "ClientSecretPanth01", null); 
   label.setParent(PsnDatiToyotaForm); 
%><label class="<%=label.getClassType()%>" for="ClientSecretPanth01"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput PsnDatiToyotaClientSecretPanth01 =  
     new com.thera.thermfw.web.WebTextArea("PsnDatiToyota", "ClientSecretPanth01"); 
  PsnDatiToyotaClientSecretPanth01.setParent(PsnDatiToyotaForm); 
%>
<textarea class="<%=PsnDatiToyotaClientSecretPanth01.getClassType()%>" cols="60" id="<%=PsnDatiToyotaClientSecretPanth01.getId()%>" maxlength="<%=PsnDatiToyotaClientSecretPanth01.getMaxLength()%>" name="<%=PsnDatiToyotaClientSecretPanth01.getName()%>" rows="5" size="<%=PsnDatiToyotaClientSecretPanth01.getSize()%>"></textarea><% 
  PsnDatiToyotaClientSecretPanth01.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "PsnDatiToyota", "UrlPanth01", null); 
   label.setParent(PsnDatiToyotaForm); 
%><label class="<%=label.getClassType()%>" for="UrlPanth01"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput PsnDatiToyotaUrlPanth01 =  
     new com.thera.thermfw.web.WebTextArea("PsnDatiToyota", "UrlPanth01"); 
  PsnDatiToyotaUrlPanth01.setParent(PsnDatiToyotaForm); 
%>
<textarea class="<%=PsnDatiToyotaUrlPanth01.getClassType()%>" cols="60" id="<%=PsnDatiToyotaUrlPanth01.getId()%>" maxlength="<%=PsnDatiToyotaUrlPanth01.getMaxLength()%>" name="<%=PsnDatiToyotaUrlPanth01.getName()%>" rows="5" size="<%=PsnDatiToyotaUrlPanth01.getSize()%>"></textarea><% 
  PsnDatiToyotaUrlPanth01.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <% 
   request.setAttribute("parentForm", PsnDatiToyotaForm); 
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
              <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab2")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab2"); %>
                <table style="width: 100%;">
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "PsnDatiToyota", "ClientIdPanth02", null); 
   label.setParent(PsnDatiToyotaForm); 
%><label class="<%=label.getClassType()%>" for="ClientIdPanth02"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput PsnDatiToyotaClientIdPanth02 =  
     new com.thera.thermfw.web.WebTextArea("PsnDatiToyota", "ClientIdPanth02"); 
  PsnDatiToyotaClientIdPanth02.setParent(PsnDatiToyotaForm); 
%>
<textarea class="<%=PsnDatiToyotaClientIdPanth02.getClassType()%>" cols="60" id="<%=PsnDatiToyotaClientIdPanth02.getId()%>" maxlength="<%=PsnDatiToyotaClientIdPanth02.getMaxLength()%>" name="<%=PsnDatiToyotaClientIdPanth02.getName()%>" rows="5" size="<%=PsnDatiToyotaClientIdPanth02.getSize()%>"></textarea><% 
  PsnDatiToyotaClientIdPanth02.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "PsnDatiToyota", "ClientSecretPanth02", null); 
   label.setParent(PsnDatiToyotaForm); 
%><label class="<%=label.getClassType()%>" for="ClientSecretPanth02"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput PsnDatiToyotaClientSecretPanth02 =  
     new com.thera.thermfw.web.WebTextArea("PsnDatiToyota", "ClientSecretPanth02"); 
  PsnDatiToyotaClientSecretPanth02.setParent(PsnDatiToyotaForm); 
%>
<textarea class="<%=PsnDatiToyotaClientSecretPanth02.getClassType()%>" cols="60" id="<%=PsnDatiToyotaClientSecretPanth02.getId()%>" maxlength="<%=PsnDatiToyotaClientSecretPanth02.getMaxLength()%>" name="<%=PsnDatiToyotaClientSecretPanth02.getName()%>" rows="5" size="<%=PsnDatiToyotaClientSecretPanth02.getSize()%>"></textarea><% 
  PsnDatiToyotaClientSecretPanth02.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "PsnDatiToyota", "UrlPanth02", null); 
   label.setParent(PsnDatiToyotaForm); 
%><label class="<%=label.getClassType()%>" for="UrlPanth02"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput PsnDatiToyotaUrlPanth02 =  
     new com.thera.thermfw.web.WebTextArea("PsnDatiToyota", "UrlPanth02"); 
  PsnDatiToyotaUrlPanth02.setParent(PsnDatiToyotaForm); 
%>
<textarea class="<%=PsnDatiToyotaUrlPanth02.getClassType()%>" cols="60" id="<%=PsnDatiToyotaUrlPanth02.getId()%>" maxlength="<%=PsnDatiToyotaUrlPanth02.getMaxLength()%>" name="<%=PsnDatiToyotaUrlPanth02.getName()%>" rows="5" size="<%=PsnDatiToyotaUrlPanth02.getSize()%>"></textarea><% 
  PsnDatiToyotaUrlPanth02.write(out); 
%>

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
  errorList.setParent(PsnDatiToyotaForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  PsnDatiToyotaForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = PsnDatiToyotaForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", PsnDatiToyotaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              PsnDatiToyotaForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, PsnDatiToyotaBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, PsnDatiToyotaBODC.getErrorList().getErrors()); 
           if(PsnDatiToyotaBODC.getConflict() != null) 
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
     if(PsnDatiToyotaBODC != null && !PsnDatiToyotaBODC.close(false)) 
        errors.addAll(0, PsnDatiToyotaBODC.getErrorList().getErrors()); 
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
     String errorPage = PsnDatiToyotaForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", PsnDatiToyotaBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = PsnDatiToyotaForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
