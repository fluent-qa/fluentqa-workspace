package io.fluent.git.gitlab.api;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GitlabMember implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String username;
}
