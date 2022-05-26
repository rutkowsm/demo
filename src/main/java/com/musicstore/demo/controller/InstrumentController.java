package com.musicstore.demo.controller;

import com.musicstore.demo.entity.Instrument;
import com.musicstore.demo.service.InstrumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicstore")
public class InstrumentController {

    private InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping("/getinstruments")
    public ResponseEntity<List<Instrument>> getInstruments(){
        return ResponseEntity.ok(this.instrumentService.getInstruments());
    }

    @GetMapping("findinstrument/{id}")
    public ResponseEntity<Instrument> getInstrumentsById(@PathVariable Long id){
        return ResponseEntity.ok(this.instrumentService.getInstrumentById(id));
    }

    @PostMapping("addinstrument")
    public ResponseEntity<Instrument> addInstrument(@RequestBody Instrument instrument){
        return ResponseEntity.ok(this.instrumentService.addInstrument(instrument));
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<Instrument> editInstrumentById(@PathVariable Long id, @RequestBody Instrument instrument){
        return ResponseEntity.ok(this.instrumentService.editInstrumentById(id, instrument));
    }

    @PostMapping("setavailable/{id}")
    public ResponseEntity<Instrument> makeInstrumentAvailableById(@PathVariable Long id){
        return ResponseEntity.ok(instrumentService.makeInstrumentAvailableById(id));
    }

    @PostMapping("setunavailable/{id}")
    public ResponseEntity<Instrument> makeInstrumentNotAvailableById(@PathVariable Long id){
        return ResponseEntity.ok(instrumentService.makeInstrumentNotAvailableById(id));
    }

    @DeleteMapping("deleteinstrument/{id}")
    public ResponseEntity<Instrument> deleteInstrumentById(Long id, @RequestBody Instrument instrument){
        return ResponseEntity.ok(this.instrumentService.deleteInstrumentById(id, instrument));
    }

}
