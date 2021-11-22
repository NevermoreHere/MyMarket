package com.exa.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = BaseEnumDeserializer.class)
@JsonSerialize(using = BaseEnumSerializer.class)
public interface BaseEnum<T> {

    T getCode();

    static <T extends BaseEnum> Object getBaseEnum(Class<T> targetType, String source) {
        for (T enumObject : targetType.getEnumConstants()) {
            if (source.equals(String.valueOf(enumObject.getCode()))) {
                return enumObject;
            }
        }
        return null;
    }
}


