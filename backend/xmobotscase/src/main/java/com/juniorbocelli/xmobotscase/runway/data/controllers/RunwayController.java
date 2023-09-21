package com.juniorbocelli.xmobotscase.runway.data.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juniorbocelli.xmobotscase.runway.data.models.RunwayRequestModel;
import com.juniorbocelli.xmobotscase.runway.data.models.RunwayResponseModel;
import com.juniorbocelli.xmobotscase.runway.domain.usecases.CreateRunway;

@RestController
public class RunwayController {
    final CreateRunway createRunway;

    RunwayController(CreateRunway createRunway) {
        this.createRunway = createRunway;
    }

    @PostMapping(path = "api/runway", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RunwayResponseModel> create(@RequestBody RunwayRequestModel runwayRequestModel) {
        try {
            this.createRunway.call(RunwayRequestModel.toRunway(runwayRequestModel));

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
