package com.juniorbocelli.xmobotscase.aerodrome.data.datasources;

import java.util.List;

import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeModel;

public interface AerodromeDatasourcesLocal {
    public void createAerodrome(AerodromeModel aerodromeModel);

    public void deleteAerodrome(Long id);

    public AerodromeModel getAerodrome(Long id);

    public List<AerodromeModel> getAerodromes();
}
