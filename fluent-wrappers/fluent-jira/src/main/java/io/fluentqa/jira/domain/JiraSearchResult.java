package io.fluentqa.jira.domain;

import java.io.Serializable;
import java.util.List;

public class JiraSearchResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private long startAt;
	private long maxResults;
	private long total;

	private List<JiraIssue> issues;

	public long getStartAt() {
		return startAt;
	}

	public void setStartAt(long startAt) {
		this.startAt = startAt;
	}

	public long getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(long maxResults) {
		this.maxResults = maxResults;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<JiraIssue> getIssues() {
		return issues;
	}

	public void setIssues(List<JiraIssue> issues) {
		this.issues = issues;
	}
}
