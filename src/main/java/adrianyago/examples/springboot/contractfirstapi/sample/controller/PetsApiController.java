package adrianyago.examples.springboot.contractfirstapi.sample.controller;

import adrianyago.examples.springboot.contractfirstapi.sample.openapi.api.PetsApi;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.RecordPetsRequest;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.RecordResponse;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.UpdatePetDetailsRequest;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.UpdateResponse;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.UpdateResponse.PetTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class PetsApiController implements PetsApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetsApiController.class);

    @Override
    public Mono<ResponseEntity<RecordResponse>> recordPets(
        Mono<RecordPetsRequest> recordPetsRequest,
        ServerWebExchange exchange
    ){
        return recordPetsRequest
            .map(subType -> {
                LOGGER.info("Parsed sub type of pets is {}", subType.getClass().getSimpleName());
                return ResponseEntity.ok((RecordResponse) subType);
            });
    }

    @Override
    public Mono<ResponseEntity<UpdateResponse>> updatePetDetails(
        Mono<UpdatePetDetailsRequest> updatePetDetailsRequest,
        ServerWebExchange exchange
    ){
        return updatePetDetailsRequest
            .map(subType -> ResponseEntity.ok(
                new UpdateResponse().petType(PetTypeEnum.valueOf(subType.getPetType().name()))));
    }
}
