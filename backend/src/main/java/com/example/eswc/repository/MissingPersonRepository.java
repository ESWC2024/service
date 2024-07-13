package com.example.eswc.repository;

import com.example.eswc.model.MissingPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissingPersonRepository extends JpaRepository<MissingPerson, Long> {

    List<MissingPerson> findByNameAndGenderAndLastSeenLocation(String name, String gender, String lastSeenLocation);

    List<MissingPerson> findByNameAndGender(String name, String gender);

    List<MissingPerson> findByNameAndLastSeenLocation(String name, String lastSeenLocation);

    List<MissingPerson> findByGenderAndLastSeenLocation(String gender, String lastSeenLocation);

    List<MissingPerson> findByName(String name);

    List<MissingPerson> findByGender(String gender);

    List<MissingPerson> findByLastSeenLocation(String lastSeenLocation);

}
