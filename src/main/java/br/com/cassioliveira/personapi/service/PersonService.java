package br.com.cassioliveira.personapi.service;

import br.com.cassioliveira.personapi.dto.MessageResponseDTO;
import br.com.cassioliveira.personapi.dto.PersonDTO;
import br.com.cassioliveira.personapi.entity.Person;
import br.com.cassioliveira.personapi.mapper.PersonMapper;
import br.com.cassioliveira.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    private PersonRepository personRepository;

    /* Inject the person Respository construtor make easy to implement the unit tests, as author said. Needs more research... */
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);

        if(personToSave.getCpf().isEmpty()){
            throw new RuntimeException("O CPF deve ser informado.");
        }

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
    }

}
