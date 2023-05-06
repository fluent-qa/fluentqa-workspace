package io.fluentqa.postman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fluentqa.postman.ValueUtils;


import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostmanBody {

    @JsonProperty("mode")
    private String mode = ResponseBodyMode.EMPTY.getMode();

    @JsonProperty("file")
    private PostmanFileBody file;

    @JsonProperty("urlencoded")
    private List<PostmanUrlEncodedBody> urlEncodes = new ArrayList<>();

    @JsonProperty("raw")
    private PostmanRawBody raw;

    @JsonProperty("formdata")
    private List<PostmanFormDataBody> formDataList = new ArrayList<>();


    public PostmanBody() {
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public PostmanFileBody getFile() {
        return file;
    }

    public void setFile(PostmanFileBody file) {
        this.file = file;
    }

    public List<PostmanUrlEncodedBody> getUrlEncodes() {
        return urlEncodes;
    }

    public void setUrlEncodes(List<PostmanUrlEncodedBody> urlEncodes) {
        this.urlEncodes = urlEncodes;
    }

    public PostmanRawBody getRaw() {
        return raw;
    }

    public void setRaw(PostmanRawBody raw) {
        this.raw = raw;
        this.raw.setValue(ValueUtils.value(raw.getValue()));
    }

    public List<PostmanFormDataBody> getFormDataList() {
        return formDataList;
    }

    public void setFormDataList(List<PostmanFormDataBody> formDataList) {
        this.formDataList = formDataList;
    }
}
