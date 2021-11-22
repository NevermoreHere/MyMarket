package com.exa.request;

import com.exa.common.ExportStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CeshiReq {
    @JsonProperty("export_status")
    private ExportStatus exportStatus;
}
