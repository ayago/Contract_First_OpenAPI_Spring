package adrianyago.examples.springboot.contractfirstapi.sample.config.jackson.deserializers;

import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.Cat;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.Dog;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.PersonPet;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class PersonPetDeserializer extends StdDeserializer<PersonPet>{

    public PersonPetDeserializer() {
        this(null);
    }

    public PersonPetDeserializer(Class<?> vc){
        super(vc);
    }

    @Override
    public PersonPet deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException{
        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        final ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();

        if (node.has("bark") && node.has("breed")) {
            return mapper.treeToValue(node, Dog.class);
        } else if (node.has("age") && node.has("hunts")) {
            return mapper.treeToValue(node, Cat.class);
        } else {
            throw new UnsupportedOperationException(
                "Not supported class type for RecordPetsRequest implementation");
        }
    }
}
