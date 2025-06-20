package rpks_astakhova_anastasiia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TestDocumentRepository repository;

    @GetMapping("/read-kafka")
    public String readKafka(
            @RequestParam String bootstrapServers,
            @RequestParam String topic) {

        String kafkaMessage = KafkaTestConsumer.getFirstMessage(bootstrapServers, topic);
        if (kafkaMessage == null) {
            throw new RuntimeException("Kafka topic is empty");
        }

        TestDocument doc = repository.findByTestField(kafkaMessage);
        if (doc == null) {
            throw new RuntimeException("No document with test_field = " + kafkaMessage);
        }

        return doc.getTestValueField();
    }
}
