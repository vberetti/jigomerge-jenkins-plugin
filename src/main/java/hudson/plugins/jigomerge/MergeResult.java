package hudson.plugins.jigomerge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MergeResult {

	private boolean status;
	private List<String> conflictingRevisions;
	private Map<String, String> conflictingLogs;
	private Map<String, List<String>> conflictingFiles;
	private Map<String, List<String>> conflictingDiffs;

	public MergeResult() {
		conflictingRevisions = new ArrayList<String>();
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<String> getConflictingRevisions() {
		return conflictingRevisions;
	}

	public Map<String, String> getConflictingLogs() {
		return conflictingLogs;
	}

	public Map<String, List<String>> getConflictingFiles() {
		return conflictingFiles;
	}

	public Map<String, List<String>> getConflictingDiffs() {
		return conflictingDiffs;
	}
}
