package com.juniorbocelli.xmobotscase.aerodrome.domain.usecases;

import java.util.List;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.repositories.AerodromeRepository;

public class CreateAerodromeFromUpload {
    final AerodromeRepository aerodromeRepository;

    public CreateAerodromeFromUpload(AerodromeRepository aerodromeRepository) {
        this.aerodromeRepository = aerodromeRepository;
    }

    public void call(List<Aerodrome> aerodromes) {
        for (Aerodrome aerodrome : aerodromes) {
            this.aerodromeRepository.createAerodrome(aerodrome);
        }
    }
}