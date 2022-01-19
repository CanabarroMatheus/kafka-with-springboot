package canabarro.matheus.kafkaproducer.kafka;

import canabarro.matheus.kafkaproducer.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentProducer {
    private static final String TOPIC_NAME = "student";
    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    public void send(Student message) {
        kafkaTemplate.send(TOPIC_NAME, message);
    }
}
