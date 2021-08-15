package br.com.cassioliveira.personapi.controller;

import br.com.cassioliveira.personapi.dto.MessageResponseDTO;
import br.com.cassioliveira.personapi.dto.PersonDTO;
import br.com.cassioliveira.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /* The @Requestbody annotation notify this method that a person object comes from client. */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }
}
