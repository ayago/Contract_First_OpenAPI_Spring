package adrianyago.examples.springboot.contractfirstapi.sample.config.jackson;

import adrianyago.examples.springboot.contractfirstapi.sample.config.jackson.deserializers.RecordPetsRequestDeserializer;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.RecordPetsRequest;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomJacksonConfiguration{

    @Bean
    public com.fasterxml.jackson.databind.Module customDeserializerModule() {
        final SimpleModule module = new SimpleModule();
        module.addDeserializer(RecordPetsRequest.class, new RecordPetsRequestDeserializer());
        return module;
    }
}
