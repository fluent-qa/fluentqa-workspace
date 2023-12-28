package io.fluentqa.jira.config;

import io.fluentqa.jira.domain.JiraIssue;
import io.fluentqa.jira.domain.JiraIssueType;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


public class TransitionConfig {

	private Set<String> sourceStatusIn = new LinkedHashSet<>();
	private Set<String> targetStatusIn = new LinkedHashSet<>();
	private String sourceStatusToSet;
	private String targetStatusToSet;
	private boolean copyResolutionToSource = false;
	private boolean copyFixVersionsToSource = false;
	private boolean onlyIfAssignedInTarget = false;
	private boolean assignToMyselfInSource = false;
	private boolean triggerIfIssueWasMovedBetweenProjects = false;
	private Context onlyIfStatusTransitionNewerIn = null;

	private Map<String, Map<String, String>> customFieldsToCopyFromTargetToSource = new LinkedHashMap<>();

	public TransitionConfig() {
	}

	public Set<String> getSourceStatusIn() {
		return sourceStatusIn;
	}

	public void setSourceStatusIn(Set<String> sourceStatusIn) {
		this.sourceStatusIn = sourceStatusIn;
	}

	public void setTargetStatusIn(Set<String> targetStatusIn) {
		this.targetStatusIn = targetStatusIn;
	}

	public String getSourceStatusToSet() {
		return sourceStatusToSet;
	}

	public void setSourceStatusToSet(String sourceStatusToSet) {
		this.sourceStatusToSet = sourceStatusToSet;
	}

	public String getTargetStatusToSet() {
		return targetStatusToSet;
	}

	public void setTargetStatusToSet(String targetStatusToSet) {
		this.targetStatusToSet = targetStatusToSet;
	}

	public boolean isCopyResolutionToSource() {
		return copyResolutionToSource;
	}

	public void setCopyResolutionToSource(boolean copyResolutionToSource) {
		this.copyResolutionToSource = copyResolutionToSource;
	}

	public boolean isCopyFixVersionsToSource() {
		return copyFixVersionsToSource;
	}

	public void setCopyFixVersionsToSource(boolean copyFixVersionsToSource) {
		this.copyFixVersionsToSource = copyFixVersionsToSource;
	}

	public void setOnlyIfAssignedInTarget(boolean onlyIfAssignedInTarget) {
		this.onlyIfAssignedInTarget = onlyIfAssignedInTarget;
	}

	public boolean isOnlyIfAssignedInTarget() {
		return onlyIfAssignedInTarget;
	}

	public void setAssignToMyselfInSource(boolean assignToMyselfInSource) {
		this.assignToMyselfInSource = assignToMyselfInSource;
	}

	public boolean isAssignToMyselfInSource() {
		return assignToMyselfInSource;
	}

	public Set<String> getTargetStatusIn() {
		return targetStatusIn;
	}

	public boolean isTriggerIfIssueWasMovedBetweenProjects() {
		return triggerIfIssueWasMovedBetweenProjects;
	}

	public void setTriggerIfIssueWasMovedBetweenProjects(boolean triggerIfIssueWasMovedBetweenProjects) {
		this.triggerIfIssueWasMovedBetweenProjects = triggerIfIssueWasMovedBetweenProjects;
	}

	public void setCustomFieldsToCopyFromTargetToSource(Map<String, Map<String, String>> customFieldsToCopyFromTargetToSource) {
		this.customFieldsToCopyFromTargetToSource = customFieldsToCopyFromTargetToSource;
	}

	public Map<String, Map<String, String>> getCustomFieldsToCopyFromTargetToSource() {
		return customFieldsToCopyFromTargetToSource;
	}

	public Map<String, String> getCustomFieldsToCopyFromTargetToSource(JiraIssue issue) {
		return getCustomFieldsToCopyFromTargetToSource(issue.getFields().getIssuetype());
	}

	private Map<String, String> getCustomFieldsToCopyFromTargetToSource(JiraIssueType issueType) {
		return getCustomFieldsToCopyFromTargetToSource().getOrDefault(issueType.getName(), Collections.emptyMap());
	}

	public Context getOnlyIfStatusTransitionNewerIn() {
		return onlyIfStatusTransitionNewerIn;
	}

	public void setOnlyIfStatusTransitionNewerIn(Context onlyIfStatusTransitionNewerIn) {
		this.onlyIfStatusTransitionNewerIn = onlyIfStatusTransitionNewerIn;
	}


}
