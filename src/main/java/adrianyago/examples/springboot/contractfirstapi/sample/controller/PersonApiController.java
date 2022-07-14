package adrianyago.examples.springboot.contractfirstapi.sample.controller;

import adrianyago.examples.springboot.contractfirstapi.sample.openapi.api.PersonApi;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class PersonApiController implements PersonApi{

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonApiController.class);

    @Override
    public Mono<ResponseEntity<Person>> recordPersonProfile(Mono<Person> request, ServerWebExchange exchange){
        return request
            .map(person -> {
                LOGGER.info("Parsed sub type of pets is {}", person.getPet().getClass().getSimpleName());
                return ResponseEntity.ok(person);
            });
    }
}
