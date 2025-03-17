package io.fluent.jira.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class JiraTransition extends JiraNamedResource {

  private static final long serialVersionUID = 1L;

  private JiraIssueStatus to;

  public JiraTransition() {}

  public JiraTransition(String id, String name, JiraIssueStatus to) {
    super(id, name);
    this.to = to;
  }

  public JiraIssueStatus getTo() {
    return to;
  }

  public void setTo(JiraIssueStatus to) {
    this.to = to;
  }
}
