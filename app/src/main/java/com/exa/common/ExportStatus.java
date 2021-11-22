package com.exa.common;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ExportStatus implements BaseEnum<Integer> {
  EXPORT_STATUS_UNKNOWN(0, "未导出"),
  EXPORT_STATUS_RUNNING(1, "导出中"),
  EXPORT_STATUS_COMPLETED(2, "导出成功"),
  EXPORT_STATUS_FAILED(3, "导出失败"),
  ;

  ExportStatus(int code, String description) {
    this.code = code;
    this.description = description;
  }


  @EnumValue
  private int code;

  private String description;

  @JsonValue
  @Override
  public Integer getCode() {
    return code;
  }

  @Override
  public String toString() {
    return String.valueOf(code);
  }
}
