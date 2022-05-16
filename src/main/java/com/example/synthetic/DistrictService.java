package com.example.synthetic;

import com.example.synthetic.entity.District;
import com.example.synthetic.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    public Page<District> findAll(int page,int limit){
        return districtRepository.findAll(PageRequest.of(page-1,limit));
    }
}
