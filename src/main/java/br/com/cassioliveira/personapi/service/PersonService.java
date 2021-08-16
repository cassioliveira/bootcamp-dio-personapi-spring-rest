package br.com.cassioliveira.personapi.service;

import br.com.cassioliveira.personapi.dto.MessageResponseDTO;
import br.com.cassioliveira.personapi.dto.PersonDTO;
import br.com.cassioliveira.personapi.entity.Person;
import br.com.cassioliveira.personapi.exceptions.PersonNotFoundException;
import br.com.cassioliveira.personapi.mapper.PersonMapper;
import br.com.cassioliveira.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    private PersonRepository personRepository;

    /* Inject the person Respository construtor make easy to implement the unit tests, as instructor said. Needs more research... */
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person savedPerson = personRepository.save(personMapper.toModel(personDTO));
        return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
    }

    public List<PersonDTO> listAll() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
//        Optional<Person> optionalPerson = personRepository.findById(id);
//        if(optionalPerson.isEmpty()){
//            throw new PersonNotFoundException(id);
//         }
//        return personMapper.toDTO(optionalPerson.get());
// ----------> Can use this form or next line...
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }
}
