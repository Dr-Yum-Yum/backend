package com.yumyum.backend.chat.util;

import com.yumyum.backend.chat.domain.MessageType;
import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

@Component
public class MessageTypeAttributeConverter implements AttributeConverter<MessageType, String> {
    @Override
    public String convertToDatabaseColumn(final MessageType messageType) {
        return messageType.getDescription();
    }

    @Override
    public MessageType convertToEntityAttribute(final String description) {
        return MessageType.from(description);
    }

}
