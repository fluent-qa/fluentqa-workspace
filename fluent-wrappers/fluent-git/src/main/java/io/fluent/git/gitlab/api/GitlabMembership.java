package io.fluent.git.gitlab.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GitlabMembership implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("source_type")
  private String sourceType;

  @JsonProperty("source_name")
  private String sourceName;
}
