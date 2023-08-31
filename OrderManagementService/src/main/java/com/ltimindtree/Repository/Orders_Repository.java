package com.ltimindtree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.Model.Orders;

@Repository
public interface Orders_Repository extends JpaRepository<Orders,Long>{

}
