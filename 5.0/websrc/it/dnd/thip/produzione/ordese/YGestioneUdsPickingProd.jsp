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
  BODataCollector YGestioneUdsPickingProdBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YGestioneUdsPickingProdForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YGestioneUdsPickingProdForm", "YGestioneUdsPickingProd", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/dnd/thip/produzione/ordese/YGestioneUdsPickingProd.js"); 
  YGestioneUdsPickingProdForm.setServletEnvironment(se); 
  YGestioneUdsPickingProdForm.setJSTypeList(jsList); 
  YGestioneUdsPickingProdForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YGestioneUdsPickingProdForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YGestioneUdsPickingProdForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YGestioneUdsPickingProdForm.getMode(); 
  String key = YGestioneUdsPickingProdForm.getKey(); 
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
        YGestioneUdsPickingProdForm.outTraceInfo(getClass().getName()); 
        String collectorName = YGestioneUdsPickingProdForm.findBODataCollectorName(); 
                YGestioneUdsPickingProdBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YGestioneUdsPickingProdBODC instanceof WebDataCollector) 
            ((WebDataCollector)YGestioneUdsPickingProdBODC).setServletEnvironment(se); 
        YGestioneUdsPickingProdBODC.initialize("YGestioneUdsPickingProd", true, 0); 
        YGestioneUdsPickingProdForm.setBODataCollector(YGestioneUdsPickingProdBODC); 
        int rcBODC = YGestioneUdsPickingProdForm.initSecurityServices(); 
        mode = YGestioneUdsPickingProdForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YGestioneUdsPickingProdForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YGestioneUdsPickingProdBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YGestioneUdsPickingProdForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YGestioneUdsPickingProdForm); 
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
  myToolBarTB.setParent(YGestioneUdsPickingProdForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YGestioneUdsPickingProdForm.getBodyOnBeforeUnload()%>" onload="<%=YGestioneUdsPickingProdForm.getBodyOnLoad()%>" onunload="<%=YGestioneUdsPickingProdForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YGestioneUdsPickingProdForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YGestioneUdsPickingProdForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YGestioneUdsPickingProdBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YGestioneUdsPickingProdForm.getServlet()%>" method="post" name="YGestioneUdsPickingProdForm" style="height:100%"><%
  YGestioneUdsPickingProdForm.writeFormStartElements(out); 
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
  WebTextInput YGestioneUdsPickingProdIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("YGestioneUdsPickingProd", "IdAzienda"); 
  YGestioneUdsPickingProdIdAzienda.setParent(YGestioneUdsPickingProdForm); 
%>
<input class="<%=YGestioneUdsPickingProdIdAzienda.getClassType()%>" id="<%=YGestioneUdsPickingProdIdAzienda.getId()%>" maxlength="<%=YGestioneUdsPickingProdIdAzienda.getMaxLength()%>" name="<%=YGestioneUdsPickingProdIdAzienda.getName()%>" size="<%=YGestioneUdsPickingProdIdAzienda.getSize()%>" type="hidden"><% 
  YGestioneUdsPickingProdIdAzienda.write(out); 
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
  mytabbed.setParent(YGestioneUdsPickingProdForm); 
 mytabbed.addTab("tab1", "it.dnd.thip.produzione.ordese.resources.YGestioneUdsPickingProd", "tab1", "YGestioneUdsPickingProd", null, null, null, null); 
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
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YGestioneUdsPickingProd", "NumeroRitorno", null); 
   label.setParent(YGestioneUdsPickingProdForm); 
%><label class="<%=label.getClassType()%>" for="NumeroRitorno"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YGestioneUdsPickingProdNumeroRitorno =  
     new com.thera.thermfw.web.WebTextInput("YGestioneUdsPickingProd", "NumeroRitorno"); 
  YGestioneUdsPickingProdNumeroRitorno.setParent(YGestioneUdsPickingProdForm); 
%>
<input class="<%=YGestioneUdsPickingProdNumeroRitorno.getClassType()%>" id="<%=YGestioneUdsPickingProdNumeroRitorno.getId()%>" maxlength="<%=YGestioneUdsPickingProdNumeroRitorno.getMaxLength()%>" name="<%=YGestioneUdsPickingProdNumeroRitorno.getName()%>" size="<%=YGestioneUdsPickingProdNumeroRitorno.getSize()%>"><% 
  YGestioneUdsPickingProdNumeroRitorno.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YGestioneUdsPickingProd", "IdUds", null); 
   label.setParent(YGestioneUdsPickingProdForm); 
%><label class="<%=label.getClassType()%>" for="TestataUds"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YGestioneUdsPickingProdTestataUds =  
     new com.thera.thermfw.web.WebMultiSearchForm("YGestioneUdsPickingProd", "TestataUds", false, false, true, 1, null, null); 
  YGestioneUdsPickingProdTestataUds.setParent(YGestioneUdsPickingProdForm); 
  YGestioneUdsPickingProdTestataUds.write(out); 
%>
<!--<span class="multisearchform" id="TestataUds"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YGestioneUdsPickingProd", "IdCodiceLista", null); 
   label.setParent(YGestioneUdsPickingProdForm); 
%><label class="<%=label.getClassType()%>" for="IdCodiceLista"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YGestioneUdsPickingProdIdCodiceLista =  
     new com.thera.thermfw.web.WebTextInput("YGestioneUdsPickingProd", "IdCodiceLista"); 
  YGestioneUdsPickingProdIdCodiceLista.setParent(YGestioneUdsPickingProdForm); 
%>
<input class="<%=YGestioneUdsPickingProdIdCodiceLista.getClassType()%>" id="<%=YGestioneUdsPickingProdIdCodiceLista.getId()%>" maxlength="<%=YGestioneUdsPickingProdIdCodiceLista.getMaxLength()%>" name="<%=YGestioneUdsPickingProdIdCodiceLista.getName()%>" size="<%=YGestioneUdsPickingProdIdCodiceLista.getSize()%>"><% 
  YGestioneUdsPickingProdIdCodiceLista.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YGestioneUdsPickingProd", "IdCodiceRigaLista", null); 
   label.setParent(YGestioneUdsPickingProdForm); 
%><label class="<%=label.getClassType()%>" for="IdCodiceRigaLista"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YGestioneUdsPickingProdIdCodiceRigaLista =  
     new com.thera.thermfw.web.WebTextInput("YGestioneUdsPickingProd", "IdCodiceRigaLista"); 
  YGestioneUdsPickingProdIdCodiceRigaLista.setParent(YGestioneUdsPickingProdForm); 
%>
<input class="<%=YGestioneUdsPickingProdIdCodiceRigaLista.getClassType()%>" id="<%=YGestioneUdsPickingProdIdCodiceRigaLista.getId()%>" maxlength="<%=YGestioneUdsPickingProdIdCodiceRigaLista.getMaxLength()%>" name="<%=YGestioneUdsPickingProdIdCodiceRigaLista.getName()%>" size="<%=YGestioneUdsPickingProdIdCodiceRigaLista.getSize()%>"><% 
  YGestioneUdsPickingProdIdCodiceRigaLista.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YGestioneUdsPickingProd", "IdTipoUds", null); 
   label.setParent(YGestioneUdsPickingProdForm); 
%><label class="<%=label.getClassType()%>" for="TipoUds"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YGestioneUdsPickingProdTipoUds =  
     new com.thera.thermfw.web.WebMultiSearchForm("YGestioneUdsPickingProd", "TipoUds", false, false, true, 1, null, null); 
  YGestioneUdsPickingProdTipoUds.setParent(YGestioneUdsPickingProdForm); 
  YGestioneUdsPickingProdTipoUds.write(out); 
%>
<!--<span class="multisearchform" id="TipoUds"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YGestioneUdsPickingProd", "Quantita", null); 
   label.setParent(YGestioneUdsPickingProdForm); 
%><label class="<%=label.getClassType()%>" for="Quantita"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YGestioneUdsPickingProdQuantita =  
     new com.thera.thermfw.web.WebTextInput("YGestioneUdsPickingProd", "Quantita"); 
  YGestioneUdsPickingProdQuantita.setParent(YGestioneUdsPickingProdForm); 
%>
<input class="<%=YGestioneUdsPickingProdQuantita.getClassType()%>" id="<%=YGestioneUdsPickingProdQuantita.getId()%>" maxlength="<%=YGestioneUdsPickingProdQuantita.getMaxLength()%>" name="<%=YGestioneUdsPickingProdQuantita.getName()%>" size="<%=YGestioneUdsPickingProdQuantita.getSize()%>"><% 
  YGestioneUdsPickingProdQuantita.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YGestioneUdsPickingProd", "StatoUds", null); 
   label.setParent(YGestioneUdsPickingProdForm); 
%><label class="<%=label.getClassType()%>" for="StatoUds"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebComboBox YGestioneUdsPickingProdStatoUds =  
     new com.thera.thermfw.web.WebComboBox("YGestioneUdsPickingProd", "StatoUds", null); 
  YGestioneUdsPickingProdStatoUds.setParent(YGestioneUdsPickingProdForm); 
%>
<select id="<%=YGestioneUdsPickingProdStatoUds.getId()%>" name="<%=YGestioneUdsPickingProdStatoUds.getName()%>"><% 
  YGestioneUdsPickingProdStatoUds.write(out); 
%> 
</select>
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                    </td>
                    <td valign="top">
                      <% 
  WebCheckBox YGestioneUdsPickingProdTrasmessoLinea =  
     new com.thera.thermfw.web.WebCheckBox("YGestioneUdsPickingProd", "TrasmessoLinea"); 
  YGestioneUdsPickingProdTrasmessoLinea.setParent(YGestioneUdsPickingProdForm); 
%>
<input id="<%=YGestioneUdsPickingProdTrasmessoLinea.getId()%>" name="<%=YGestioneUdsPickingProdTrasmessoLinea.getName()%>" type="checkbox" value="Y"><%
  YGestioneUdsPickingProdTrasmessoLinea.write(out); 
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
  errorList.setParent(YGestioneUdsPickingProdForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YGestioneUdsPickingProdForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YGestioneUdsPickingProdForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YGestioneUdsPickingProdBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YGestioneUdsPickingProdForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YGestioneUdsPickingProdBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YGestioneUdsPickingProdBODC.getErrorList().getErrors()); 
           if(YGestioneUdsPickingProdBODC.getConflict() != null) 
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
     if(YGestioneUdsPickingProdBODC != null && !YGestioneUdsPickingProdBODC.close(false)) 
        errors.addAll(0, YGestioneUdsPickingProdBODC.getErrorList().getErrors()); 
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
     String errorPage = YGestioneUdsPickingProdForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YGestioneUdsPickingProdBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YGestioneUdsPickingProdForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
