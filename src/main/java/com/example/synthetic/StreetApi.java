package com.example.synthetic;

import com.example.synthetic.entity.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/streets")
public class StreetApi {

    @Autowired
    StreetService streetService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Street>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return ResponseEntity.ok(streetService.findAll(page,limit));
    }

    @RequestMapping(method = RequestMethod.GET,path = "byname")
    public ResponseEntity<Page<Street>> findbyName(@RequestParam(defaultValue = "")String nameStreet, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return ResponseEntity.ok(streetService.findByName(nameStreet,page,limit));
    }

    @RequestMapping(method = RequestMethod.GET,path = "bydistrict")
    public ResponseEntity<Page<Street>> findByNameStreetAndDis(@RequestParam(defaultValue = "")String nameDistrict,@RequestParam(defaultValue = "")String nameStreet, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return ResponseEntity.ok( streetService.findByNameAndCate(nameDistrict,nameStreet,page,limit));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> save(@RequestBody Street obj){
        return ResponseEntity.ok(streetService.save(obj));
    }

}
