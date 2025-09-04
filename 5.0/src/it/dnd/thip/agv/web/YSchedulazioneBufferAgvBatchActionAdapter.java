package it.dnd.thip.agv.web;

import java.io.IOException;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.batch.web.BatchFormActionAdapter;
import com.thera.thermfw.web.ServletEnvironment;

public class YSchedulazioneBufferAgvBatchActionAdapter extends BatchFormActionAdapter {
	
	private static final long serialVersionUID = 1L;

	public YSchedulazioneBufferAgvBatchActionAdapter()
	{
	}

	protected void otherActions(ClassADCollection	cadc, ServletEnvironment se) throws ServletException, IOException
	{
		String action = getStringParameter(se.getRequest(), ACTION).toUpperCase();
		if (action.equals(SAVE))
			saveBatch(se, true, false);
		else
			super.otherActions(cadc, se);
	}

}
