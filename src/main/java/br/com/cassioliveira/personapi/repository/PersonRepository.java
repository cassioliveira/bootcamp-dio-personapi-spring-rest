package br.com.cassioliveira.personapi.repository;

import br.com.cassioliveira.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
