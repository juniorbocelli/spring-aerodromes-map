package com.juniorbocelli.xmobotscase.aerodrome.domain.usecases;

import java.util.List;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.repositories.AerodromeRepository;

public class GetAerodromes {
    final AerodromeRepository aerodromeRepository;

    public GetAerodromes(AerodromeRepository aerodromeRepository) {
        this.aerodromeRepository = aerodromeRepository;
    }

    public List<Aerodrome> call() {
        return this.aerodromeRepository.getAerodromes();
    }
}
