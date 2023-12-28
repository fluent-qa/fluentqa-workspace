package io.fluentqa.jira.config;

import io.fluentqa.jira.domain.JiraProject;

import java.util.LinkedHashMap;
import java.util.Map;


public class JiraSyncConfig {

	private boolean autostart = true;
	private CacheConfig cache = new CacheConfig();
	private JiraConnectionProperties source;
	private JiraConnectionProperties target;
	private Map<String, JiraProjectSync> projects = new LinkedHashMap<>();

	private Map<String, String> priorityMapping = new LinkedHashMap<>();
	private Map<String, String> issueTypeMapping = new LinkedHashMap<>();
	private Map<String, String> resolutionMapping = new LinkedHashMap<>();
	private Map<String, String> fieldMapping = new LinkedHashMap<>();
	private DescriptionMappingConfig descriptionMapping = new DescriptionMappingConfig();
	private CommentMappingConfig commentMapping = new CommentMappingConfig();

	public JiraConnectionProperties getSource() {
		return source;
	}

	public void setSource(JiraConnectionProperties source) {
		this.source = source;
	}

	public JiraConnectionProperties getTarget() {
		return target;
	}

	public void setTarget(JiraConnectionProperties target) {
		this.target = target;
	}

	public void setProjects(Map<String, JiraProjectSync> projects) {
		this.projects = projects;
	}

	public Map<String, JiraProjectSync> getProjects() {
		return projects;
	}

	public void setPriorityMapping(Map<String, String> priorityMapping) {
		this.priorityMapping = priorityMapping;
	}

	public Map<String, String> getPriorityMapping() {
		return priorityMapping;
	}

	public Map<String, String> getIssueTypeMapping() {
		return issueTypeMapping;
	}

	public void setIssueTypeMapping(Map<String, String> issueTypeMapping) {
		this.issueTypeMapping = issueTypeMapping;
	}

	public void setResolutionMapping(Map<String, String> resolutionMapping) {
		this.resolutionMapping = resolutionMapping;
	}

	public Map<String, String> getResolutionMapping() {
		return resolutionMapping;
	}

	public void setAutostart(boolean autostart) {
		this.autostart = autostart;
	}

	public boolean isAutostart() {
		return autostart;
	}

	public CacheConfig getCache() {
		return cache;
	}

	public void setCache(CacheConfig cache) {
		this.cache = cache;
	}

	public void setFieldMapping(Map<String, String> fieldMapping) {
		this.fieldMapping = fieldMapping;
	}

	public Map<String, String> getFieldMapping() {
		return fieldMapping;
	}

	public DescriptionMappingConfig getDescriptionMapping() {
		return descriptionMapping;
	}

	public void setDescriptionMapping(DescriptionMappingConfig descriptionMapping) {
		this.descriptionMapping = descriptionMapping;
	}

	public CommentMappingConfig getCommentMapping() {
		return commentMapping;
	}

	public void setCommentMapping(CommentMappingConfig commentMapping) {
		this.commentMapping = commentMapping;
	}

	public JiraProjectSync getProjectConfigBySourceProject(JiraProject sourceProject) {
		return getProjects().values().stream()
			.filter(project -> project.getSourceProject().equals(sourceProject.getKey()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Found no project config for '" + sourceProject + "'"));
	}

	public JiraProjectSync getProjectConfigByTargetProject(JiraProject targetProject) {
		return getProjects().values().stream()
			.filter(project -> project.getTargetProject().equals(targetProject.getKey()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Found no project config for '" + targetProject + "'"));
	}
}