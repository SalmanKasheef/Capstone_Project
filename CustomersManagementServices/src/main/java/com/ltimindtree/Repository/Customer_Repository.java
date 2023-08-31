package com.ltimindtree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.Model.Customer;

@Repository
public interface Customer_Repository extends JpaRepository<Customer,Long> {

}
