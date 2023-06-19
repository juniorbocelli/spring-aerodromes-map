package com.juniorbocelli.xmobotscase.aerodrome.data.repositories;

import java.util.List;

import com.juniorbocelli.xmobotscase.aerodrome.data.datasources.AerodromeDatasourcesLocal;
import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeModel;
import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.repositories.AerodromeRepository;

public class AerodromeRepositoryImpl implements AerodromeRepository {
    final AerodromeDatasourcesLocal aerodromeDatasourcesLocal;

    public AerodromeRepositoryImpl(AerodromeDatasourcesLocal aerodromeDatasourcesLocal) {
        this.aerodromeDatasourcesLocal = aerodromeDatasourcesLocal;
    }

    public void createAerodrome(Aerodrome aerodrome) {
        AerodromeModel aerodromeModel = new AerodromeModel();
        this.aerodromeDatasourcesLocal.createAerodrome(aerodromeModel.toAerodromeModel(aerodrome));
    }

    public void deleteAerodrome(Long id) {
        this.aerodromeDatasourcesLocal.deleteAerodrome(id);
    }

    public Aerodrome getAerodrome(Long id) {
        AerodromeModel aerodromeModel = new AerodromeModel();

        return aerodromeModel.toAerodrome(this.aerodromeDatasourcesLocal.getAerodrome(id));
    }

    public List<Aerodrome> getAerodromes() {
        AerodromeModel aerodromeModel = new AerodromeModel();

        return aerodromeModel.toAerodromeList(this.aerodromeDatasourcesLocal.getAerodromes());
    }
}