package com.location.mapper;


import com.location.dto.NoteDto;
import com.location.model.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteDto noteTonoteDTO(Note note);

    Note noteDtoToNote(NoteDto noteDto);
}
