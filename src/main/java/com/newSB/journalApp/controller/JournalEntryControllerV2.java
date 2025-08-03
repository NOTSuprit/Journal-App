package com.newSB.journalApp.controller;

import com.newSB.journalApp.entity.JournalEntry;
import com.newSB.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")

public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
       return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);

        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getjournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId).orElse(null);

    }
    @DeleteMapping("id/{myId}")
    public boolean deletejournalEntryById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return true;
    }
    @PutMapping("/id/{id}")
    public JournalEntry updatejournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle()!= null && !newEntry.getTitle().equals("")?newEntry.getTitle(): old.getTitle());
            old.setContent(newEntry.getContent()!=  null && !newEntry.equals("")?newEntry.getContent():old.getContent());
        }
        journalEntryService.saveEntry(old);

        return old;
    }
}
