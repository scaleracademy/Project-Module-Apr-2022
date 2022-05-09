package com.scaler.simpleserver.repo;

import com.scaler.simpleserver.models.Notes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Integer> {
}
