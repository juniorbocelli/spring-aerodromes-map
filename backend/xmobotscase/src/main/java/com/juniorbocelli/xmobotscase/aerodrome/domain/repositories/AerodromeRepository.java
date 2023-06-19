package com.juniorbocelli.xmobotscase.aerodrome.domain.repositories;

import java.util.List;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;

public interface AerodromeRepository {
    public void createAerodrome(Aerodrome aerodrome);

    public void deleteAerodrome(Long id);

    public Aerodrome getAerodrome(Long id);

    public List<Aerodrome> getAerodromes();
}
