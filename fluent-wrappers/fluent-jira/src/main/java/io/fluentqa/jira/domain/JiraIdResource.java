package io.fluentqa.jira.domain;

public abstract class JiraIdResource extends JiraResource {

  private static final long serialVersionUID = 1L;

  private String id;

  protected JiraIdResource() {}

  protected JiraIdResource(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
