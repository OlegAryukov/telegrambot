package ru.aryukov.telegrambot.api;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aryukov.telegrambot.dto.CityDTO;
import ru.aryukov.telegrambot.service.CityService;

@RestController
@RequestMapping(path = "/bot")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(path = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDTO>> getAllCityes() {
        List<CityDTO> cities = cityService.getAllCity();
        return new ResponseEntity(cities, HttpStatus.OK);
    }

    @PostMapping(path = "/city/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDTO> addCity(@Valid @RequestBody CityDTO cityDTO) {
        cityService.addCity(cityDTO);
        return new ResponseEntity<>(cityService.findByName(cityDTO.getName()), HttpStatus.OK);
    }
}
