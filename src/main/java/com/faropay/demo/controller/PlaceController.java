package com.faropay.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faropay.demo.entity.Place;
import com.faropay.demo.model.CommonResponse;
import com.faropay.demo.repository.PlaceRepository;

@RestController
@RequestMapping(path = "/api/places")
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<?> getPlaces() {
        List<Place> list = placeRepository.findAll();
        CommonResponse<?> resp = new CommonResponse<List<Place>>(HttpStatus.OK, list);

        return ResponseEntity.ok(resp);
    }
}
