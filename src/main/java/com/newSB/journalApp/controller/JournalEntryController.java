//package com.newSB.journalApp.controller;
//
//import com.newSB.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//
//public class JournalEntryController {
//
//    public Map<Long, JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(),myEntry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getjournalEntryById(@PathVariable Long myId){
//        return journalEntries.get(myId);
//    }
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deletejournalEntryById(@PathVariable Long myId){
//        return journalEntries.remove(myId);
//    }
//    @PutMapping("id/{myId}")
//    public JournalEntry updatejournalById(@PathVariable Long myId, @RequestBody JournalEntry myEntry){
//        return journalEntries.put(myId,myEntry);
//    }
//}
