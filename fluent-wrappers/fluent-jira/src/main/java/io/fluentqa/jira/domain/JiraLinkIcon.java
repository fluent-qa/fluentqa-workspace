package io.fluentqa.jira.domain;

import java.io.Serializable;
import java.net.URL;

public class JiraLinkIcon implements Serializable {

	private static final long serialVersionUID = 1L;

	private URL url16x16;

	public JiraLinkIcon() {
	}

	public JiraLinkIcon(URL url16x16) {
		this.url16x16 = url16x16;
	}

	public URL getUrl16x16() {
		return url16x16;
	}

	public void setUrl16x16(URL url16x16) {
		this.url16x16 = url16x16;
	}
}
