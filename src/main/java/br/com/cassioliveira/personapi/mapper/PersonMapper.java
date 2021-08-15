package br.com.cassioliveira.personapi.mapper;

import br.com.cassioliveira.personapi.dto.PersonDTO;
import br.com.cassioliveira.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    // This annotation is to inform mapstruct about convert PersonDTO's  birthDate String attribute and converto to format of respective Person entity attribute.
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

}
