package com.exa.common;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseEnumDeserializer extends JsonDeserializer<BaseEnum> {

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public BaseEnum deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);
        String currentName = jp.currentName();
        Object currentValue = jp.getCurrentValue();
        Class findPropertyType = null;
        if (currentValue instanceof Collection) {

            JsonStreamContext parsingContext = jp.getParsingContext();

            JsonStreamContext parent = parsingContext.getParent();
            Object currentValue3 = parent.getCurrentValue();
            String currentName3 = parent.getCurrentName();
            try {
                Field listField = currentValue3.getClass().getDeclaredField(currentName3);
                ParameterizedType listGenericType = (ParameterizedType) listField.getGenericType();
                Type listActualTypeArguments = listGenericType.getActualTypeArguments()[0];
                findPropertyType = (Class) listActualTypeArguments;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (currentName.split("   ").length > 0) {
                currentName = currentName.toLowerCase();
                Matcher matcher = linePattern.matcher(currentName);
                StringBuffer sb = new StringBuffer();
                while (matcher.find()) {
                    matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
                }
                matcher.appendTail(sb);
                currentName = sb.toString();
            }
            findPropertyType = BeanUtils.findPropertyType(currentName, currentValue.getClass());
        }
        if (findPropertyType == null) {
            return null;
        }
        String asText = null;
        if (node.getNodeType() == JsonNodeType.STRING) {
            asText = node.asText();
        } else {
            asText = node.asText();
        }
        BaseEnum valueOf = null;
        if (!StrUtil.isEmpty(asText)) {
            valueOf = (BaseEnum) BaseEnum.getBaseEnum(findPropertyType, asText);
        }
        return valueOf;
    }


}
