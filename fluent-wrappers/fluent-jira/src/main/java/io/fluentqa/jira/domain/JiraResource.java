package io.fluentqa.jira.domain;

import java.io.Serializable;

public abstract class JiraResource implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String JIRA_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

	private String self;

	protected JiraResource() {
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getSelf() {
		return self;
	}

}
