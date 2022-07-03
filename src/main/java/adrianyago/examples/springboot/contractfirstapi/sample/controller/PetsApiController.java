package adrianyago.examples.springboot.contractfirstapi.sample.controller;

import adrianyago.examples.springboot.contractfirstapi.sample.openapi.api.PetsApi;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.RecordPetsRequest;
import adrianyago.examples.springboot.contractfirstapi.sample.openapi.models.UpdatePetDetailsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class PetsApiController implements PetsApi {

    @Override
    public Mono<ResponseEntity<RecordPetsRequest>> recordPets(
        Mono<RecordPetsRequest> recordPetsRequest,
        ServerWebExchange exchange
    ){
        return recordPetsRequest
            .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Void>> updatePetDetails(
        Mono<UpdatePetDetailsRequest> updatePetDetailsRequest,
        ServerWebExchange exchange
    ){
        return PetsApi.super.updatePetDetails(updatePetDetailsRequest, exchange);
    }
}
