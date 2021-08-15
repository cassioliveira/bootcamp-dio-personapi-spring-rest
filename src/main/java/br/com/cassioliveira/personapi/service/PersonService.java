package br.com.cassioliveira.personapi.service;

import br.com.cassioliveira.personapi.dto.MessageResponseDTO;
import br.com.cassioliveira.personapi.entity.Person;
import br.com.cassioliveira.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    /* Inject the person Respository construtor make easy to implement the unit tests, as author said. Needs more research... */
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder().message("Created person with ID" + savedPerson.getId()).build();
    }

}
