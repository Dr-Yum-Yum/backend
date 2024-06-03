package com.yumyum.backend.chat.util;

import com.yumyum.backend.chat.domain.RoomType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeConverter implements Converter<String, RoomType> {

    @Override
    public RoomType convert(final String description) {
        return RoomType.from(description);
    }
}
