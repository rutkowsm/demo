package com.musicstore.demo.service;

import com.musicstore.demo.entity.Instrument;
import com.musicstore.demo.exceptionhandler.InstrumentNotFoundException;
import com.musicstore.demo.repository.InstrumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;


    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public List<Instrument> getInstruments(){
        return instrumentRepository.findAll();
    }

    public Instrument getInstrumentById(Long id){
        return(Instrument) instrumentRepository.getInstrumentById(id)
                .orElseThrow(InstrumentNotFoundException::new);
    }


    public Instrument saveInstrument(Instrument instrument){
        return instrumentRepository.save(instrument);

    }

    public Instrument makeInstrumentAvailableById(Long id){
        Instrument instrument = getInstrumentById(id);
        instrument.setAvailable(true);
        saveInstrument(instrument);
        return instrument;
    }

    public Instrument makeInstrumentNotAvailableById(Long id){
        Instrument instrument = getInstrumentById(id);
        instrument.setAvailable(false);
        saveInstrument(instrument);
        return instrument;
    }

    public Instrument editPriceById(Long id, int newPrice){
        Instrument instrument = getInstrumentById(id);
        instrument.setPrice(newPrice);
        saveInstrument(instrument);
        return instrument;
    }

    public void deleteInstrumentById(Long id){
        instrumentRepository.deleteById(id);
    }
}
