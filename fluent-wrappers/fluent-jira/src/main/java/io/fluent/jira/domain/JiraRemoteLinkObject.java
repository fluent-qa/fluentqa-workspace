package io.fluent.jira.domain;

import java.io.Serializable;
import java.net.URL;

public class JiraRemoteLinkObject implements Serializable {

  private static final long serialVersionUID = 1L;

  private URL url;

  private String title;

  private JiraLinkIcon icon;

  public JiraRemoteLinkObject() {}

  public JiraRemoteLinkObject(URL url) {
    this.url = url;
  }

  public URL getUrl() {
    return url;
  }

  public void setUrl(URL url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public JiraLinkIcon getIcon() {
    return icon;
  }

  public void setIcon(JiraLinkIcon icon) {
    this.icon = icon;
  }
}
