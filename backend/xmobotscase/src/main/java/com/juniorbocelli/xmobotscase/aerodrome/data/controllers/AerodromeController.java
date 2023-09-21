package com.juniorbocelli.xmobotscase.aerodrome.data.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeJsonRequestModel;
import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeRequestModel;
import com.juniorbocelli.xmobotscase.aerodrome.data.models.AerodromeResponseModel;
import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.usecases.CreateAerodrome;
import com.juniorbocelli.xmobotscase.aerodrome.domain.usecases.CreateAerodromeFromUpload;
import com.juniorbocelli.xmobotscase.aerodrome.domain.usecases.GetAerodromes;
import com.juniorbocelli.xmobotscase.user.data.models.UserResponseModel;

import netscape.javascript.JSException;

@RestController
public class AerodromeController {
    final CreateAerodrome createAerodrome;
    final GetAerodromes getAerodromes;
    final CreateAerodromeFromUpload createAerodromeFromUpload;

    AerodromeController(CreateAerodrome createAerodrome, GetAerodromes getAerodromes,
            CreateAerodromeFromUpload createAerodromeFromUpload) {
        this.getAerodromes = getAerodromes;
        this.createAerodrome = createAerodrome;
        this.createAerodromeFromUpload = createAerodromeFromUpload;
    }

    @PostMapping(path = "api/aerodrome", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AerodromeResponseModel> create(@RequestBody AerodromeRequestModel aerodromeRequestModel) {
        this.createAerodrome.call(AerodromeRequestModel.toAerodrome(aerodromeRequestModel));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "api/aerodrome")
    public ResponseEntity<List<AerodromeResponseModel>> getAerodromes() {

        List<Aerodrome> aerodromes = this.getAerodromes.call();

        return new ResponseEntity<List<AerodromeResponseModel>>(
                AerodromeResponseModel.toAerodromeResponseModelList(aerodromes),
                HttpStatus.OK);
    }

    @PostMapping(path = "api/aerodrome/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<AerodromeResponseModel>> uploadJsonFile(
            @ModelAttribute AerodromeJsonRequestModel aerodromeJsonRequestModel) throws IOException, JSException {
        try {
            List<Aerodrome> aerodromes = AerodromeJsonRequestModel.toAerodromeList(aerodromeJsonRequestModel);
            this.createAerodromeFromUpload.call(aerodromes);

            return new ResponseEntity<List<AerodromeResponseModel>>(
                    AerodromeResponseModel.toAerodromeResponseModelList(aerodromes),
                    HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
