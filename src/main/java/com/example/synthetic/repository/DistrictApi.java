package com.example.synthetic.repository;

import com.example.synthetic.DistrictService;
import com.example.synthetic.entity.District;
import com.example.synthetic.entity.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/district")
@RestController
public class DistrictApi {
    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<District>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return ResponseEntity.ok(districtService.findAll(page,limit));
    }
}
