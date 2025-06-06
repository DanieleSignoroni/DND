# CLASSRD
    INSERT INTO <SCH>CLASSRD (CLASS_NAME, RELATION_NAME, CORR_CLASS_NAME, OUTER_JOIN, ONLY_SELECT, XMLEXPORTABLE, GRID_DISPLAYABLE, DEF_SETTING_POS, USER_ID, CHECK_DISABLED) VALUES ('YGestioneUdsPickingProd', 'Azienda', 'AziendaEstesa', 'N', 'N', 'N', 'N', 12, <USER>, 'N');
    INSERT INTO <SCH>CLASSRD (CLASS_NAME, RELATION_NAME, CORR_CLASS_NAME, OUTER_JOIN, ONLY_SELECT, XMLEXPORTABLE, GRID_DISPLAYABLE, DEF_SETTING_POS, USER_ID, CHECK_DISABLED) VALUES ('YGestioneUdsPickingProd', 'TestataUds', 'TestataUds', 'N', 'N', 'N', 'Y', 13, <USER>, 'N');
    INSERT INTO <SCH>CLASSRD (CLASS_NAME, RELATION_NAME, CORR_CLASS_NAME, OUTER_JOIN, ONLY_SELECT, XMLEXPORTABLE, GRID_DISPLAYABLE, DEF_SETTING_POS, USER_ID, CHECK_DISABLED) VALUES ('YGestioneUdsPickingProd', 'TipoUds', 'TipoUds', 'Y', 'N', 'N', 'Y', 14, <USER>, 'N');
# CLASSRD_NLS
    INSERT INTO <SCH>CLASSRD_NLS (CLASS_NAME, RELATION_NAME, LANGUAGE, NLS_RELATION_NAME, NLS_COLUMN_TITLE, NLS_LABEL) VALUES ('YGestioneUdsPickingProd', 'Azienda', 'it', 'Azienda', 'Azienda', null);
    INSERT INTO <SCH>CLASSRD_NLS (CLASS_NAME, RELATION_NAME, LANGUAGE, NLS_RELATION_NAME, NLS_COLUMN_TITLE, NLS_LABEL) VALUES ('YGestioneUdsPickingProd', 'TestataUds', 'it', 'Testata UDS', 'Testata UDS', null);
    INSERT INTO <SCH>CLASSRD_NLS (CLASS_NAME, RELATION_NAME, LANGUAGE, NLS_RELATION_NAME, NLS_COLUMN_TITLE, NLS_LABEL) VALUES ('YGestioneUdsPickingProd', 'TipoUds', 'it', 'Tipo UDS', 'Tipo UDS', null);
# CLASSRD_ROW
    INSERT INTO <SCH>CLASSRD_ROW (CLASS_NAME, RELATION_NAME, SEQUENCE, ATTRIBUTE_NAME, CD_NAME, CORR_CLASS_NAME, CORR_ATTR_NAME, DEF_SEARCH) VALUES ('YGestioneUdsPickingProd', 'Azienda', 2, null, null, 'AziendaEstesa', 'Descrizione', 'Y');
    INSERT INTO <SCH>CLASSRD_ROW (CLASS_NAME, RELATION_NAME, SEQUENCE, ATTRIBUTE_NAME, CD_NAME, CORR_CLASS_NAME, CORR_ATTR_NAME, DEF_SEARCH) VALUES ('YGestioneUdsPickingProd', 'Azienda', 1, 'IdAzienda', null, 'AziendaEstesa', 'IdAzienda', 'N');
    INSERT INTO <SCH>CLASSRD_ROW (CLASS_NAME, RELATION_NAME, SEQUENCE, ATTRIBUTE_NAME, CD_NAME, CORR_CLASS_NAME, CORR_ATTR_NAME, DEF_SEARCH) VALUES ('YGestioneUdsPickingProd', 'TestataUds', 1, 'IdUds', null, 'TestataUds', 'Codice', 'N');
    INSERT INTO <SCH>CLASSRD_ROW (CLASS_NAME, RELATION_NAME, SEQUENCE, ATTRIBUTE_NAME, CD_NAME, CORR_CLASS_NAME, CORR_ATTR_NAME, DEF_SEARCH) VALUES ('YGestioneUdsPickingProd', 'TestataUds', 2, null, null, 'TestataUds', 'StatoAllestimento', 'Y');
    INSERT INTO <SCH>CLASSRD_ROW (CLASS_NAME, RELATION_NAME, SEQUENCE, ATTRIBUTE_NAME, CD_NAME, CORR_CLASS_NAME, CORR_ATTR_NAME, DEF_SEARCH) VALUES ('YGestioneUdsPickingProd', 'TipoUds', 1, 'IdTipoUds', null, 'TipoUds', 'Codice', 'N');
    INSERT INTO <SCH>CLASSRD_ROW (CLASS_NAME, RELATION_NAME, SEQUENCE, ATTRIBUTE_NAME, CD_NAME, CORR_CLASS_NAME, CORR_ATTR_NAME, DEF_SEARCH) VALUES ('YGestioneUdsPickingProd', 'TipoUds', 2, null, null, 'TipoUds', 'DescBr', 'Y');
