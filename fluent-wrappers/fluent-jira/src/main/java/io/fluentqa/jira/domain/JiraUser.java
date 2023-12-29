package io.fluentqa.jira.domain;


public class JiraUser extends JiraNamedResource {

	private static final long serialVersionUID = 2L;

	private String displayName;

	public JiraUser() {
	}

	public JiraUser(String name, String key) {
		super(key, name);
	}

	public JiraUser(String name, String key, String displayName) {
		super(key, name);
		this.displayName = displayName;
	}

	public String getKey() {
		return getId();
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
