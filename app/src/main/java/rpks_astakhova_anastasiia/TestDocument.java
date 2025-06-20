package rpks_astakhova_anastasiia;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "your_collection_name")
public class TestDocument {
    @Id
    private String id;
    private String testField;
    private String testValueField;
}
