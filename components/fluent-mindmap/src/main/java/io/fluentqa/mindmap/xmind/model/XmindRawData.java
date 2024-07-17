package io.fluentqa.mindmap.xmind.model;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class XmindRawData {
  private String contentJson;
  private String contentXml;

  public boolean isZenVersion() {
    return StrUtil.isNotBlank(this.contentJson);
  }

  public String fetchContentJson() {
    if (StrUtil.isNotBlank(this.contentJson)) {
      return contentJson;
    }

    if (StrUtil.isNotBlank(this.contentXml)) {
      try {
        return JSONUtil.toJsonPrettyStr(
            new XmlMapper()
                .readValue(this.contentXml, JSONArray.class).stream()
                    .skip(1)
                    .collect(Collectors.toList()));
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    }

    return StrUtil.EMPTY;
  }
}
