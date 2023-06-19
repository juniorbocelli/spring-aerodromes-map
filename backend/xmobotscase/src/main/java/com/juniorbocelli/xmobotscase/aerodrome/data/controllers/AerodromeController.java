package com.juniorbocelli.xmobotscase.aerodrome.data.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeRequestModel;
import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeResponseModel;
import com.juniorbocelli.xmobotscase.aerodrome.domain.usecases.CreateAerodrome;

@RestController
public class AerodromeController {
    final CreateAerodrome createAerodrome;

    AerodromeController(CreateAerodrome createAerodrome) {
        this.createAerodrome = createAerodrome;
    }

    @PostMapping(path = "aerodrome", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AerodromeResponseModel> create(@RequestBody AerodromeRequestModel aerodromeRequestModel) {
        try {
            this.createAerodrome.call(AerodromeRequestModel.toAerodrome(aerodromeRequestModel));

            return new ResponseEntity<AerodromeResponseModel>(
                    new AerodromeResponseModel(HttpStatus.OK.value(), HttpStatus.OK.name()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
