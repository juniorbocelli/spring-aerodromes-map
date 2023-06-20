package com.juniorbocelli.xmobotscase.aerodrome.data.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeRequestModel;
import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeResponseModel;
import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.usecases.CreateAerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.usecases.GetAerodromes;

@RestController
public class AerodromeController {
    final CreateAerodrome createAerodrome;
    final GetAerodromes getAerodromes;

    AerodromeController(CreateAerodrome createAerodrome, GetAerodromes getAerodromes) {
        this.getAerodromes = getAerodromes;
        this.createAerodrome = createAerodrome;
    }

    @PostMapping(path = "aerodrome", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AerodromeResponseModel> create(@RequestBody AerodromeRequestModel aerodromeRequestModel) {
        try {
            this.createAerodrome.call(AerodromeRequestModel.toAerodrome(aerodromeRequestModel));

            return new ResponseEntity<AerodromeResponseModel>(
                    new AerodromeResponseModel(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "aerodrome")
    public ResponseEntity<List<AerodromeResponseModel>> getAerodromes() {
        try {
            List<Aerodrome> aerodromes = this.getAerodromes.call();

            return new ResponseEntity<List<AerodromeResponseModel>>(
                    AerodromeResponseModel.toAerodromeResponseModelList(aerodromes), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
