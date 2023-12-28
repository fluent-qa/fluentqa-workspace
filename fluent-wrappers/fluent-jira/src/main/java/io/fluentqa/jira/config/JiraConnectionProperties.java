package io.fluentqa.jira.config;


import java.io.File;

public class JiraConnectionProperties {

	private String url;
	private String sshJumpHost;
	private String username;
	private String password;
	private BasicAuthentication basicAuth;
	private File sslTrustStore;
	private char[] sslTrustStorePassword;



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setSshJumpHost(String sshJumpHost) {
		this.sshJumpHost = sshJumpHost;
	}

	public String getSshJumpHost() {
		return sshJumpHost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BasicAuthentication getBasicAuth() {
		return basicAuth;
	}

	public void setBasicAuth(BasicAuthentication basicAuth) {
		this.basicAuth = basicAuth;
	}


	public void setSslTrustStorePassword(char[] sslTrustStorePassword) {
		this.sslTrustStorePassword = sslTrustStorePassword;
	}

	public char[] getSslTrustStorePassword() {
		return sslTrustStorePassword;
	}
}
