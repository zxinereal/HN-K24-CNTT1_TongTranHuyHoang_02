package org.example.bookingservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${app.kafka.topic.booking-created:booking-created}")
    private String bookingCreatedTopic;
    public void sendBookingCreatedEvent(String customerEmail) {
        try {
            kafkaTemplate.send(bookingCreatedTopic, customerEmail);
            log.info("sự kiện booking-created đã được gửi cho khách hàng: {}", customerEmail);
        } catch (Exception e) {
            log.error("sự kiện booking-created không được gửi cho khách hàng: {}", customerEmail, e);
            throw e;
        }
    }
}
