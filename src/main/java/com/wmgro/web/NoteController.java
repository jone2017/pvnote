package com.wmgro.web;

import com.wmgro.domain.Note;
import com.wmgro.repos.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("note")
@Slf4j
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("")
    public String list(ModelMap model){
        List<Note> notes = noteRepository.findAll();
        model.put("notes",notes);
        log.info(notes.toString());
        return "index";
    }

    @GetMapping("/add")
    public String tosave(ModelMap model){
        model.put("af",1);
        return "index::note_add";
    }
    @GetMapping("/edit/{id}")
    public String toedit(ModelMap model,@PathVariable Integer id){
        Note note = noteRepository.getOne(id);
        model.put("note",note);
        log.info(note.toString());
        return "index::note_edit";
    }
    @PostMapping("/add")
    public String save(ModelMap model,Note note){
        if(note.getId()==null){
            note.setCreate_time(new Date());
            note.setUser_id(1);
        }else {
            note.setUpdate_time(new Date());
        }
        note = noteRepository.save(note);
        return "redirect:/note";
    }


    @GetMapping("/{id}")
    public String getOne(ModelMap model,@PathVariable Integer id){
        Note note = noteRepository.getOne(id);
        model.put("note",note);
        log.info(note.toString());
        return "index::right";
    }
}
