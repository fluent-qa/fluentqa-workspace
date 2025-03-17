package io.fluent.mindmap.api;

import io.fluent.builtin.JavaProjectFileUtils;

public enum MindmapTypeEnum {
  FREEMIND("mm"), // FREEMIND file
  XMIND("xmind") // XMIND file
;

  MindmapTypeEnum(String fileSuffix) {
    this.fileSuffix = fileSuffix;
  }

  private String fileSuffix;

  public String getFileSuffix() {
    return fileSuffix;
  }

  public MindmapTypeEnum parse(String fileName) {
    String suffix = JavaProjectFileUtils.getSuffix(fileName);
    for (MindmapTypeEnum value : values()) {
      if (value.getFileSuffix().equalsIgnoreCase(suffix)) {
        return value;
      }
    }
    return XMIND;
  }
}
