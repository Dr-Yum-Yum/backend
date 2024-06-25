package com.yumyum.backend.chat.util;

import com.yumyum.backend.chat.domain.RoomType;
import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeAttributeConverter implements AttributeConverter<RoomType, String> {
    @Override
    public String convertToDatabaseColumn(final RoomType roomType) {
        return roomType.getDescription();
    }

    @Override
    public RoomType convertToEntityAttribute(final String description) {
        return RoomType.from(description);
    }
}
