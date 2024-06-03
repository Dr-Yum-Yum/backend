package com.yumyum.backend.chat.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.yumyum.backend.chat.exception.ChatException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.yumyum.backend.chat.exception.ChatExceptionCode.CHAT_ROOM_TYPE_NOT_FOUND;

@RequiredArgsConstructor
public enum RoomType {
    NOMAL("일반"),
    ANONYMOUS("익명"),
    ;

    private static final Map<String, RoomType> roomTypeMap = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(RoomType::getDescription, Function.identity())));

    @Getter
    @JsonValue
    private final String description;

    @JsonCreator
    public static RoomType from(final String description) {
        if (roomTypeMap.containsKey(description)) {
            return roomTypeMap.get(description);
        }

        throw new ChatException(CHAT_ROOM_TYPE_NOT_FOUND, description);
    }
}
