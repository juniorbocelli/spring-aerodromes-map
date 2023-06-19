package com.juniorbocelli.xmobotscase.aerodrome.data.datasources;

import java.util.List;
import java.util.Optional;

import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeModel;

public class AerodromeDatasourcesLocalImpl implements AerodromeDatasourcesLocal {
    final JpaAerodromeRepository jpaAerodromeRepository;

    public AerodromeDatasourcesLocalImpl(JpaAerodromeRepository jpaAerodromeRepository) {
        this.jpaAerodromeRepository = jpaAerodromeRepository;
    }

    public void createAerodrome(AerodromeModel aerodromeModel) {
        this.jpaAerodromeRepository.save(aerodromeModel);
    }

    public void deleteAerodrome(Long id) {
        this.jpaAerodromeRepository.deleteById(id);
    }

    public AerodromeModel getAerodrome(Long id) {
        Optional<AerodromeModel> op = jpaAerodromeRepository.findById(id);

        return op.get();
    }

    public List<AerodromeModel> getAerodromes() {
        return this.jpaAerodromeRepository.findAll();
    };
};