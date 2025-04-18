package edu.mikita.apigateway.rest;

import edu.mikita.apigateway.client.PersonClient;
import edu.mikita.apigateway.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/persons")
public class ApiGatewayPersonRestControllerV1 {

    private final PersonClient personClient;

    @GetMapping("/{uid}")
    public ResponseEntity<PersonDto> getPersonByUid(@PathVariable("uid") String uid) {
        PersonDto personDto = personClient.getPersonByUid(uid);
        return ResponseEntity.ok(personDto);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPersons() {
        List<PersonDto> personDtos = personClient.getPersons();
        return ResponseEntity.ok(personDtos);
    }
}
