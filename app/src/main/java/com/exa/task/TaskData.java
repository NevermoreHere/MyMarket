package com.exa.task;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskData<T> {
    private String uuid;

    private String userId;

    private String orgId;

    private T data;
}
