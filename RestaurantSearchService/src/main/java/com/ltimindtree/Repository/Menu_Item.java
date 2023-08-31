package com.ltimindtree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.Model.Restaurant_MenuItem;

@Repository
public interface Menu_Item extends JpaRepository<Restaurant_MenuItem,Long> {

}
