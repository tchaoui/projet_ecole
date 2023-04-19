package com.location.repository;

import com.location.model.Note;
import com.location.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteReposirory  extends JpaRepository<Note, Long> {

    @Override
    Optional<Note> findById(Long id);


    Optional<Note> findByNoteUuid(String noteUuid) ;
}
