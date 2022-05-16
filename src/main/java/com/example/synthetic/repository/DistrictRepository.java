package com.example.synthetic.repository;

import com.example.synthetic.entity.District;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends PagingAndSortingRepository<District,Integer> {
}
