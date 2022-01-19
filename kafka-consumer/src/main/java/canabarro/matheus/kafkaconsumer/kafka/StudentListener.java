package canabarro.matheus.kafkaconsumer.kafka;

import canabarro.matheus.kafkaconsumer.Student;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class StudentListener {
    private static final String TOPIC_NAME = "student";

    @KafkaListener(topics = TOPIC_NAME, groupId = "group_id")
    public void consume(ConsumerRecord<String, Student> payload) {
        System.out.println("Message: " + payload.value());
    }
}
