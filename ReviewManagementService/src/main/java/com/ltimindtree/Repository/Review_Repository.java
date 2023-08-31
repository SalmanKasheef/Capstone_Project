package com.ltimindtree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.Model.Reviews;

@Repository
public interface Review_Repository  extends JpaRepository<Reviews,Long>{

}
