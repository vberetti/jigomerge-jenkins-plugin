package hudson.plugins.jigomerge;

import hudson.model.AbstractBuild;
import hudson.model.PermalinkProjectAction;

import java.util.List;

public class JigomergeBuildAction implements PermalinkProjectAction {

	public final AbstractBuild<?,?> owner;
	
	public JigomergeBuildAction(AbstractBuild<?,?> owner){
		this.owner = owner;
	}
	
	public String getDisplayName() {
		return Messages.Jigomerge_DisplayName();
	}

	public String getIconFileName() {
		return "installer.gif";
	}

	public String getUrlName() {
		return "jigomerge";
	}

	public List<Permalink> getPermalinks() {
		return null;
	}
	
}
