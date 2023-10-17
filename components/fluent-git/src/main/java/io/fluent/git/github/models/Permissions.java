package io.fluent.git.github.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "admin",
    "maintain",
    "push",
    "triage",
    "pull"
})
public class Permissions {

    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("maintain")
    private Boolean maintain;
    @JsonProperty("push")
    private Boolean push;
    @JsonProperty("triage")
    private Boolean triage;
    @JsonProperty("pull")
    private Boolean pull;

    @JsonProperty("admin")
    public Boolean getAdmin() {
        return admin;
    }

    @JsonProperty("admin")
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @JsonProperty("maintain")
    public Boolean getMaintain() {
        return maintain;
    }

    @JsonProperty("maintain")
    public void setMaintain(Boolean maintain) {
        this.maintain = maintain;
    }

    @JsonProperty("push")
    public Boolean getPush() {
        return push;
    }

    @JsonProperty("push")
    public void setPush(Boolean push) {
        this.push = push;
    }

    @JsonProperty("triage")
    public Boolean getTriage() {
        return triage;
    }

    @JsonProperty("triage")
    public void setTriage(Boolean triage) {
        this.triage = triage;
    }

    @JsonProperty("pull")
    public Boolean getPull() {
        return pull;
    }

    @JsonProperty("pull")
    public void setPull(Boolean pull) {
        this.pull = pull;
    }

}
