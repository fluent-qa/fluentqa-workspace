package io.fluentqa.jira.domain;

import java.util.List;


public class JiraProject extends JiraIdResource implements JiraNamedBean {

	private static final long serialVersionUID = 1L;

	private String key;
	private String name;
	private String description;
	private List<JiraIssueType> issueTypes;

	public JiraProject() {
	}

	public JiraProject(String id, String key) {
		super(id);
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIssueTypes(List<JiraIssueType> issueTypes) {
		this.issueTypes = issueTypes;
	}

	public List<JiraIssueType> getIssueTypes() {
		return issueTypes;
	}

}
