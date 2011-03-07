package hudson.plugins.jigomerge;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Project;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;

import java.io.IOException;
import java.io.Serializable;

import org.kohsuke.stapler.DataBoundConstructor;

public class JigomergePublisher extends Recorder implements Serializable {

    private static final long serialVersionUID = 1L;

    @DataBoundConstructor
    public JigomergePublisher() {
    }

    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.BUILD;
    }

    @Override
    public Action getProjectAction(AbstractProject<?,?> project) {
        return null;
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener)
            throws InterruptedException, IOException {
        listener.getLogger().println("Adding JigomergeBuildAction to current build ...");
        Action action = new JigomergeBuildAction(build);
        build.addAction(action);
        return true;
    }

    @Extension
    public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {

        public DescriptorImpl() {
            super(JigomergePublisher.class);
        }

        public String getDisplayName() {
            return "Jigomerge Conflict Resolver Report";
        }

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return Project.class.isAssignableFrom(jobType);
        }

        @Override
        public String getHelpFile() {
            return "/plugin/jigomerge/help.html";
        }

    }
}
