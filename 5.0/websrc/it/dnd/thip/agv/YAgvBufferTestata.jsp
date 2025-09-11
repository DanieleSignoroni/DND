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
  BODataCollector YAgvBufferTestataBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YAgvBufferTestataForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YAgvBufferTestataForm", "YAgvBufferTestata", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/dnd/thip/agv/YAgvBufferTestata.js"); 
  YAgvBufferTestataForm.setServletEnvironment(se); 
  YAgvBufferTestataForm.setJSTypeList(jsList); 
  YAgvBufferTestataForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YAgvBufferTestataForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YAgvBufferTestataForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YAgvBufferTestataForm.getMode(); 
  String key = YAgvBufferTestataForm.getKey(); 
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
        YAgvBufferTestataForm.outTraceInfo(getClass().getName()); 
        String collectorName = YAgvBufferTestataForm.findBODataCollectorName(); 
                YAgvBufferTestataBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YAgvBufferTestataBODC instanceof WebDataCollector) 
            ((WebDataCollector)YAgvBufferTestataBODC).setServletEnvironment(se); 
        YAgvBufferTestataBODC.initialize("YAgvBufferTestata", true, 0); 
        YAgvBufferTestataForm.setBODataCollector(YAgvBufferTestataBODC); 
        int rcBODC = YAgvBufferTestataForm.initSecurityServices(); 
        mode = YAgvBufferTestataForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YAgvBufferTestataForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YAgvBufferTestataBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YAgvBufferTestataForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YAgvBufferTestataForm); 
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
  myToolBarTB.setParent(YAgvBufferTestataForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YAgvBufferTestataForm.getBodyOnBeforeUnload()%>" onload="<%=YAgvBufferTestataForm.getBodyOnLoad()%>" onunload="<%=YAgvBufferTestataForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YAgvBufferTestataForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YAgvBufferTestataForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YAgvBufferTestataBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YAgvBufferTestataForm.getServlet()%>" method="post" name="YAgvBufferTestataForm" style="height:100%"><%
  YAgvBufferTestataForm.writeFormStartElements(out); 
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
  mytabbed.setParent(YAgvBufferTestataForm); 
 mytabbed.addTab("tab1", "it.dnd.thip.agv.resources.YAgvBufferTestata", "tab1", "YAgvBufferTestata", null, null, null, null); 
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
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YAgvBufferTestata", "IdBuffer", null); 
   label.setParent(YAgvBufferTestataForm); 
%><label class="<%=label.getClassType()%>" for="IdBuffer"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YAgvBufferTestataIdBuffer =  
     new com.thera.thermfw.web.WebTextInput("YAgvBufferTestata", "IdBuffer"); 
  YAgvBufferTestataIdBuffer.setParent(YAgvBufferTestataForm); 
%>
<input class="<%=YAgvBufferTestataIdBuffer.getClassType()%>" id="<%=YAgvBufferTestataIdBuffer.getId()%>" maxlength="<%=YAgvBufferTestataIdBuffer.getMaxLength()%>" name="<%=YAgvBufferTestataIdBuffer.getName()%>" size="<%=YAgvBufferTestataIdBuffer.getSize()%>"><% 
  YAgvBufferTestataIdBuffer.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YAgvBufferTestata", "IdReparto1", null); 
   label.setParent(YAgvBufferTestataForm); 
%><label class="<%=label.getClassType()%>" for="Reparto1"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YAgvBufferTestataReparto1 =  
     new com.thera.thermfw.web.WebMultiSearchForm("YAgvBufferTestata", "Reparto1", false, false, true, 1, null, null); 
  YAgvBufferTestataReparto1.setParent(YAgvBufferTestataForm); 
  YAgvBufferTestataReparto1.write(out); 
%>
<!--<span class="multisearchform" id="Reparto1"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YAgvBufferTestata", "IdReparto2", null); 
   label.setParent(YAgvBufferTestataForm); 
%><label class="<%=label.getClassType()%>" for="Reparto2"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YAgvBufferTestataReparto2 =  
     new com.thera.thermfw.web.WebMultiSearchForm("YAgvBufferTestata", "Reparto2", false, false, true, 1, null, null); 
  YAgvBufferTestataReparto2.setParent(YAgvBufferTestataForm); 
  YAgvBufferTestataReparto2.write(out); 
%>
<!--<span class="multisearchform" id="Reparto2"></span>-->
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
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YAgvBufferTestata", "StatoBuffer", null); 
   label.setParent(YAgvBufferTestataForm); 
%><label class="<%=label.getClassType()%>" for="StatoBuffer"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebComboBox YAgvBufferTestataStatoBuffer =  
     new com.thera.thermfw.web.WebComboBox("YAgvBufferTestata", "StatoBuffer", null); 
  YAgvBufferTestataStatoBuffer.setParent(YAgvBufferTestataForm); 
%>
<select id="<%=YAgvBufferTestataStatoBuffer.getId()%>" name="<%=YAgvBufferTestataStatoBuffer.getName()%>"><% 
  YAgvBufferTestataStatoBuffer.write(out); 
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
                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YAgvBufferTestata", null, "YAgvBufferRiga"); 
   label.setParent(YAgvBufferTestataForm); 
%><label class="<%=label.getClassType()%>" for="YAgvBufferRiga"><%label.write(out);%></label><%}%>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" valign="top">
                      <!--<span class="editgrid" id="YAgvBufferRiga">--><% 
  WebEditGrid YAgvBufferTestataYAgvBufferRiga =  
     new com.thera.thermfw.web.WebEditGrid("YAgvBufferTestata", "YAgvBufferRiga", 8, new String[]{"IdRigaBuffer", "IdBuffer", "IdAzienda", "IdAnnoPcToyota", "IdNumeroPcToyota", "Azienda.Descrizione"}, 3, null, null,false,"com.thera.thermfw.web.servlet.GridActionAdapterForIndependentRow"); 
 YAgvBufferTestataYAgvBufferRiga.setParent(YAgvBufferTestataForm); 
 YAgvBufferTestataYAgvBufferRiga.setNoControlRowKeys(false); 
 YAgvBufferTestataYAgvBufferRiga.addHideAsDefault("Azienda.Descrizione"); 
 YAgvBufferTestataYAgvBufferRiga.write(out); 
%>
<!--</span>-->
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
                      <% 
   request.setAttribute("parentForm", YAgvBufferTestataForm); 
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
  errorList.setParent(YAgvBufferTestataForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YAgvBufferTestataForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YAgvBufferTestataForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YAgvBufferTestataBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YAgvBufferTestataForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YAgvBufferTestataBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YAgvBufferTestataBODC.getErrorList().getErrors()); 
           if(YAgvBufferTestataBODC.getConflict() != null) 
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
     if(YAgvBufferTestataBODC != null && !YAgvBufferTestataBODC.close(false)) 
        errors.addAll(0, YAgvBufferTestataBODC.getErrorList().getErrors()); 
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
     String errorPage = YAgvBufferTestataForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YAgvBufferTestataBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YAgvBufferTestataForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
