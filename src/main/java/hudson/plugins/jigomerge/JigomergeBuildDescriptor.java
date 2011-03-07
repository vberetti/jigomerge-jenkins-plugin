package hudson.plugins.jigomerge;

import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;

public class JigomergeBuildDescriptor extends BuildStepDescriptor<Builder> {

	public JigomergeBuildDescriptor() {
		super(JigomergeBuilder.class);
		load();
	}

	@Override
	public String getHelpFile() {
		return "/plugin/jigomerge/help.html";
	}

	@Override
	public String getDisplayName() {
		return Messages.Jigomerge_DisplayName();
	}

	@Override
    public boolean isApplicable(Class<? extends AbstractProject> projectClass) {
	    return true;
    }
	
}