package com.musicstore.demo.service;

import com.musicstore.demo.entity.Instrument;
import com.musicstore.demo.exceptionhandler.InstrumentNotFoundException;
import com.musicstore.demo.repository.InstrumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class InstrumentService {

    private List<Instrument> instruments;

    private final InstrumentRepository instrumentRepository;


//    Tutaj może się okazać, że trzeba skrócić do samego repo
    public InstrumentService(List<Instrument> instruments, InstrumentRepository instrumentRepository) {
        this.instruments = instruments;
        this.instrumentRepository = instrumentRepository;
    }

    public List<Instrument> getInstruments(){
        return instrumentRepository.findAll();
    }

    public Instrument getInstrumentById(Long id){
        return(Instrument) instrumentRepository.getInstrumentById(id)
                .orElseThrow(InstrumentNotFoundException::new);
    }

    public Instrument addInstrument(Instrument instrument){
        this.instruments.add(instrument);
        return instrument;
    }

    public Instrument saveInstrument(Instrument instrument){
        instrumentRepository.save(instrument);
        return instrument;
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

    public Instrument deleteInstrumentById(Long id, Instrument instrument){
        instrumentRepository.deleteById(id);
        return instrument;
    }
}
