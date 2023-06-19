package com.juniorbocelli.xmobotscase.aerodrome.domain.usecases;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.repositories.AerodromeRepository;

public class CreateAerodrome {
    final AerodromeRepository aerodromeRepository;

    public CreateAerodrome(AerodromeRepository aerodromeRepository) {
        this.aerodromeRepository = aerodromeRepository;
    }

    public void call(Aerodrome aerodrome) {
        this.aerodromeRepository.createAerodrome(aerodrome);
    }
}
