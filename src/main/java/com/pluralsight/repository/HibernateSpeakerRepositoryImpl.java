package com.pluralsight.repository;

import com.pluralsight.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository("speakerRepository")
@Profile("dev")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Value("#{ T(java.lang.Math).random() * 100}")
    private double seedNum;
    @Autowired
    private Calendar cal;
    public List<Speaker> findAll() {
        List<Speaker> speakers = new ArrayList<Speaker>();

        Speaker speaker = new Speaker();

        speaker.setFirstName("Brian");
        speaker.setLastName("Guerra");
        speaker.setSeedNum(seedNum);

        System.out.println("cal: "+ cal.getTime());

        speakers.add(speaker);

        return speakers;
    }

}
