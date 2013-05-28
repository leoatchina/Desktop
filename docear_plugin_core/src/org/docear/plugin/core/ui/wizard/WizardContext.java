package org.docear.plugin.core.ui.wizard;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.AbstractButton;

public abstract class WizardContext {
	private Map<Class<? extends Object>, Object> properties = new LinkedHashMap<Class<? extends Object>, Object>();
	private WizardTraverseLog traversalLog;

	/***********************************************************************************
	 * CONSTRUCTORS
	 **********************************************************************************/

	/***********************************************************************************
	 * METHODS
	 **********************************************************************************/

	public void set(Class<? extends Object> key, Object value) {
		properties.put(key, value);
	}
	
	public <T> T get(Class<T> key) {
		return (T) properties.get(key);
	}
	
	public WizardTraverseLog getTraversalLog() {
		if(traversalLog == null) {
			traversalLog = new WizardTraverseLog();
		}
		return traversalLog;
	}
	
	
	/***********************************************************************************
	 * REQUIRED METHODS FOR INTERFACES
	 **********************************************************************************/
	
	public abstract WizardPageDescriptor getCurrentDescriptor();
	
	public abstract WizardModel getModel();
	
	public abstract void setWizardTitle(String title);
	
	public abstract AbstractButton getNextButton();
	public abstract AbstractButton getBackButton();
	public abstract AbstractButton getSkipButton();
}
