package com.example.synthetic;

import com.example.synthetic.entity.Street;
import com.example.synthetic.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StreetService {
    @Autowired
    StreetRepository streetRepository;
    public Page<Street> findAll(int page,int limit){
        return streetRepository.findAll(PageRequest.of(page-1,limit));
    }
    public Page<Street> findByName(String name,int page,int limit){
        return streetRepository.findByName(name,PageRequest.of(page-1,limit));
    }
    public Page<Street> findByNameAndCate(String nameDistrict,String nameStreet,int page,int limit){
        return streetRepository.findByDistrict(nameDistrict,nameStreet,PageRequest.of(page-1,limit));
    }

    public Street save(Street obj){
         return streetRepository.save(obj);
    }
}
