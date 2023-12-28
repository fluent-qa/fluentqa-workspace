package io.fluentqa.jira.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JiraLoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public JiraLoginRequest() {
	}

	public JiraLoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("username", username)
			.append("password", password)
			.toString();
	}
}
