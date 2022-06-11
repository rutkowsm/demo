package com.musicstore.demo.controller;

import com.musicstore.demo.entity.Instrument;
import com.musicstore.demo.service.InstrumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicstore")
@Api("/api/tasks")
public class InstrumentController {

    private InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping("/getinstruments")
    @ApiOperation(value = "Find all", notes = "Retrieving all instruments from the offer")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Instrument[].class)
    })
    public ResponseEntity<List<Instrument>> getInstruments(){
        return ResponseEntity.ok(this.instrumentService.getInstruments());
    }

    @GetMapping("/findinstrument/{id}")
    public ResponseEntity<Instrument> getInstrumentsById(@PathVariable Long id){
        return ResponseEntity.ok(this.instrumentService.getInstrumentById(id));
    }

    @PostMapping("/addinstrument")
    public ResponseEntity<Instrument> saveInstrument(@RequestBody Instrument instrument){
        return ResponseEntity.ok(instrumentService.saveInstrument(instrument));
    }

    @PostMapping("/editprice/{id}/{newPrice}")
    public ResponseEntity<Instrument> editPriceById(@PathVariable Long id, @PathVariable int newPrice){
        return ResponseEntity.ok(instrumentService.editPriceById(id, newPrice));
    }

    @PostMapping("/setavailable/{id}")
    public ResponseEntity<Instrument> makeInstrumentAvailableById(@PathVariable Long id){
        return ResponseEntity.ok(instrumentService.makeInstrumentAvailableById(id));
    }

    @PostMapping("/setunavailable/{id}")
    public ResponseEntity<Instrument> makeInstrumentNotAvailableById(@PathVariable Long id){
        return ResponseEntity.ok(instrumentService.makeInstrumentNotAvailableById(id));
    }

    @DeleteMapping("/deleteinstrument/{id}")
    public ResponseEntity<Void> deleteInstrumentById(@PathVariable Long id){
        instrumentService.deleteInstrumentById(id);
        return ResponseEntity.ok().build();
    }

}
