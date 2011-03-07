package hudson.plugins.jigomerge;

import hudson.model.Descriptor;
import hudson.tasks.Builder;

public class JigomergeDescriptor extends Descriptor<Builder> {

	public JigomergeDescriptor() {
		super(JigomergeBuilder.class);
		load();
	}

	@Override
	public String getHelpFile() {
		return "/plugin/jigomerge/help.html";
	}

	@Override
	public String getDisplayName() {
		return "getDisplayName";
	}

}