package rpks_astakhova_anastasiia;

import org.springframework.data.mongodb.repository.MongoRepository;
import rpks_astakhova_anastasiia.TestDocument;

public interface TestDocumentRepository extends MongoRepository<TestDocument, String> {
    TestDocument findByTestField(String testField);
}
