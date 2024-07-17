package io.fluentqa.jira.domain;

import java.util.Objects;

public abstract class JiraNamedResource extends JiraIdResource implements JiraNamedBean {

  private String name;

  public JiraNamedResource() {}

  public JiraNamedResource(String id, String name) {
    super(id);
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(getId(), getName());
  }
}
