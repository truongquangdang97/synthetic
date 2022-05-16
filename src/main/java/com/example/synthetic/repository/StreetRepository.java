package com.example.synthetic.repository;

import com.example.synthetic.entity.Street;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends PagingAndSortingRepository<Street,Integer> {

    public Page<Street> findAll(Pageable pageable);

    @Query("SELECT s FROM Street s WHERE s.nameStreet LIKE %:name%")
    Page<Street> findByName(@Param("name") String name, Pageable pageable);
    //
    @Query("SELECT s,d.nameDistrict FROM Street as s  JOIN District as d on  s.district.id= d.id  where d.nameDistrict like %:nameDistrict%  and s.nameStreet like %:nameStreet% ")
    Page<Street> findByDistrict(@Param("nameDistrict") String nameDistrict,@Param("nameStreet") String nameStreet, Pageable pageable);
}
