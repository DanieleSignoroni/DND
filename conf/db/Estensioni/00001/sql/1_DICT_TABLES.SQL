  # DICT_TABLES 
      INSERT INTO <SCH>DICT_TABLES (NAME, DESCRIPTION, TAB_SPACE_NAME, SCHEMA_NAME, SHORT_NAME) VALUES ('YREPARTI', 'Reparto', null, 'THIPPERS', 'YREPART');
  # DICT_COLUMNS 
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YREPARTI', 'ID_AZIENDA', 'ID_AZIENDA', 'IdAzienda', 'IdAzienda', 1, 1, '1', null, null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YREPARTI', 'ID_REPARTO', 'ID_REPARTO', 'IdReparto', 'Codice', 2, 2, '1', null, null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YREPARTI', 'SERVITO_LOGISTICA', 'SERVITO_LO', 'Booleano', 'Servito da Logistica', 3, 0, '2', 'N', null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YREPARTI', 'BLOCCO_MISSIONI_PRL_AGV', 'BLOCCO_MIS', 'Booleano', 'Blocco missioni prelievo AGV', 4, 0, '2', 'N', null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YREPARTI', 'BLOCCO_MISSIONI_RIPOS_AGV', 'BLOCCO_MI0', 'Booleano', 'Blocco missioni riposizionamento AGV', 5, 0, '2', 'N', null);
  # DICT_INDEXES 
      INSERT INTO <SCH>DICT_INDEXES (NAME, SHORT_NAME, DESCRIPTION, TAB_NAME, UNIQUENESS) VALUES ('YREPARTI_I01', 'YREPAR_I01', 'Primary Key', 'YREPARTI', 'Y');
  # DICT_INDEX_COLS 
      INSERT INTO <SCH>DICT_INDEX_COLS (TAB_NAME, INDEX_NAME, NAME, SEQUENCE, VERSE) VALUES ('YREPARTI', 'YREPARTI_I01', 'ID_AZIENDA', 1, 'A');
      INSERT INTO <SCH>DICT_INDEX_COLS (TAB_NAME, INDEX_NAME, NAME, SEQUENCE, VERSE) VALUES ('YREPARTI', 'YREPARTI_I01', 'ID_REPARTO', 2, 'A');
  # DICT_CONSTRAINTS 
  # DICT_CONSTR_COLS 

