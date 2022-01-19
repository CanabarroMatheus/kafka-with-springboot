package canabarro.matheus.kafkaconsumer.kafka;

import canabarro.matheus.kafkaconsumer.Student;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {
    @Bean
    ConsumerFactory<String, Student> consumerFactory(KafkaProperties kafkaProperties) {
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        Map<String, Class<?>> classMap = new HashMap<>();
        classMap.put("canabarro.matheus.kafkaconsumer.Student", Student.class);
        typeMapper.setIdClassMapping(classMap);

        typeMapper.addTrustedPackages("*");

        JsonDeserializer<Student> valueDeserializer = new JsonDeserializer<>(Student.class);
        valueDeserializer.setTypeMapper(typeMapper);
        valueDeserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(),
                new StringDeserializer(),
                valueDeserializer
        );
    }
}
