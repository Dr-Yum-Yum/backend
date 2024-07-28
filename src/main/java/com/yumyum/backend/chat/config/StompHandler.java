package com.yumyum.backend.chat.config;

import com.yumyum.backend.jwt.domain.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StompHandler implements ChannelInterceptor {

    private final AuthService authService; // 인증 서비스 예시

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        // 메시지가 CONNECT 타입일 경우 인증 처리
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            String authToken = accessor.getFirstNativeHeader("Authorization");
            if (!authService.isAuthenticated(authToken)) {
                throw new IllegalArgumentException("Invalid authentication token");
            }
        }

        // 메시지 내용 필터링 예시
        if (StompCommand.SEND.equals(accessor.getCommand())) {
            String payload = (String) message.getPayload();
            if (containsProhibitedWords(payload)) {
                throw new IllegalArgumentException("Prohibited words found in message");
            }
        }

        return message;
    }

    private boolean containsProhibitedWords(String payload) {
        // 예시 필터링 로직
        return payload.contains("badword");
    }
}