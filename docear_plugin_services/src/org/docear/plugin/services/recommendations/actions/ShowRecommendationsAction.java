package org.docear.plugin.services.recommendations.actions;

import java.awt.event.ActionEvent;

import org.docear.plugin.services.ServiceController;
import org.docear.plugin.services.recommendations.RecommendationsController;
import org.freeplane.core.ui.AFreeplaneAction;
import org.freeplane.plugin.workspace.components.menu.CheckEnableOnPopup;

@CheckEnableOnPopup
public class ShowRecommendationsAction extends AFreeplaneAction {
	public final static String TYPE = "ShowRecommendationsAction";

	private static final long serialVersionUID = 1L;

	public ShowRecommendationsAction() {
		super(TYPE);
	}

	public void setEnabled() {
		if (ServiceController.getUser().isRecommendationsEnabled() && ServiceController.getUser().isValid()) {
			setEnabled(true);
		}
		else {
			setEnabled(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
//		ModeController modeController = Controller.getCurrentController().getModeController(DocearRecommendationsModeController.MODENAME);
//		Controller.getCurrentController().selectMode(modeController);
		RecommendationsController.refreshRecommendations();

	}

}
