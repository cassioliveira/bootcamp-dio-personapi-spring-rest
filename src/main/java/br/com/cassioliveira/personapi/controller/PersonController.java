package br.com.cassioliveira.personapi.controller;

import br.com.cassioliveira.personapi.dto.MessageResponseDTO;
import br.com.cassioliveira.personapi.entity.Person;
import br.com.cassioliveira.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {


    private PersonRepository personRepository;

    /* Inject the personRespository construtor make easy to implement the unit tests, as author said. Needs more research... */
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /* The @Requestbody annotation notify this method that a person object comes from client. */
    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder().message("Created person with ID" + savedPerson.getId()).build();
    }
}
