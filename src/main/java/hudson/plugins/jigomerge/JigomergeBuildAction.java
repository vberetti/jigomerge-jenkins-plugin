package hudson.plugins.jigomerge;

import hudson.XmlFile;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.util.XStream2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.thoughtworks.xstream.XStream;

public class JigomergeBuildAction implements Action {

    private static final XStream XSTREAM = new XStream2();
	private static final Logger logger = Logger.getLogger(JigomergeBuildAction.class.getName());
	
	public final AbstractBuild<?,?> owner;
	
	public JigomergeBuildAction(AbstractBuild<?,?> owner, MergeResult mergeResult, BuildListener listener){
		this.owner = owner;
		
		 // persist the data
        try {
            getResultFile().write(mergeResult);
        } catch (IOException e) {
            e.printStackTrace(listener.fatalError("Failed to save the Jigomerge result"));
        }
	}
    
    private XmlFile getResultFile() {
        return new XmlFile(XSTREAM,new File(owner.getRootDir(), "jigomergeResult.xml"));
    }
	
	public String getDisplayName() {
		return Messages.Jigomerge_BuildActionName();
	}

	public String getIconFileName() {
		return "installer.gif";
	}

	public String getUrlName() {
		return "jigomerge";
	}
	
	private MergeResult load() {
		MergeResult result;
        try {
        	result = (MergeResult)getResultFile().read();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to load "+getResultFile(),e);
            result = new MergeResult();   // return a dummy
        }
        return result;
    }

	public MergeResult getMergeResult(){
		return load();
	}
	
}
