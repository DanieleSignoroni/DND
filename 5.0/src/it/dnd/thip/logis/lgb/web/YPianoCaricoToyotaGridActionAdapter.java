package it.dnd.thip.logis.lgb.web;

import java.util.ArrayList;

import com.thera.thermfw.web.WebMenuAbstract;
import com.thera.thermfw.web.WebMenuBar;
import com.thera.thermfw.web.WebToolBar;

import it.thera.thip.base.documenti.web.DocumentoGridActionAdapter;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 08/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    08/04/2025  DSSOF3   Prima stesura
 */

public class YPianoCaricoToyotaGridActionAdapter extends DocumentoGridActionAdapter {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void modifyMenuBar(WebMenuBar menuBar) {
		super.modifyMenuBar(menuBar);
		ArrayList voce = new ArrayList();
		WebMenuAbstract wma = menuBar.getMenu("ListMenu");
		voce.add("New");
		wma.removeMenu(voce);
		voce.clear();
		voce.add("NewTemplate");
		wma.removeMenu(voce);
		wma = menuBar.getMenu("SelectedMenu");
		voce.clear();
		voce.add("Open");
		voce.clear();
		voce.add("Copy");
		wma.removeMenu(voce);
	}

	@Override
	public void modifyToolBar(WebToolBar toolBar) {
		super.modifyToolBar(toolBar);
		toolBar.removeButton("New");
		toolBar.removeButton("Copy");
	}

}
