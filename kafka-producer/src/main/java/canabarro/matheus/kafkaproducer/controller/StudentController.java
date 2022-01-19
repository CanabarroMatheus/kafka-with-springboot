package canabarro.matheus.kafkaproducer.controller;

import canabarro.matheus.kafkaproducer.Student;
import canabarro.matheus.kafkaproducer.kafka.StudentProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentProducer producer;

    @PostMapping
    public void sendMessage(@RequestBody Student student) {
        producer.send(student);
    }
}
