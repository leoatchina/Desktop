package org.freeplane.plugin.workspace;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.freeplane.core.resources.ResourceController;
import org.osgi.service.url.AbstractURLStreamHandlerService;

public class WorkspaceUrlHandler extends AbstractURLStreamHandlerService {

	public URLConnection openConnection(URL url) throws IOException {
		//String workspaceBaseURI = ResourceController.getResourceController().getProperty(WorkspacePreferences.WORKSPACE_LOCATION);
		URL ret = new URL("file", null, WorkspaceUtils.getWorkspaceBaseURI().toURL().getPath() + url.getPath());
		try {
			ret = ret.toURI().normalize().toURL();
		}
		catch (URISyntaxException e) {
			throw new IOException(e.getMessage());
		}
		return ret.openConnection();
	}
}