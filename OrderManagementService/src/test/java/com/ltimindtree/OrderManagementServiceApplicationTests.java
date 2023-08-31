package com.ltimindtree;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ltimindtree.Model.Orders;
import com.ltimindtree.Repository.Orders_Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OrderManagementServiceApplicationTests {

	@Test
	void contextLoads() {
	}

//
//	@Autowired
//	Orders_Repository orders_repository;
//
//	@Test
//	@Order(1)
//	public void testCreate(){
//		Orders orders=new Orders();
//		orders.setOrder_id(1);
//		orders.setOrder_items("Jam ,Butter");
//		orders.setNo_of_items("2");
//		orders.setTotal_amount(212);
//		orders_repository.save(orders);
//		assertNotNull(orders_repository.findById(1l).get());
//	}
//
//	@Test
//	@Order(2)
//	public void testRealAll(){
//		List list=orders_repository.findAll();
//		assertThat(list).size().isGreaterThan(0);
//	}
//
//	@Test
//	@Order(3)
//	public void testRead(){
//		Orders orders=orders_repository.findById(1L).get();
//		assertEquals("Jam ,Butter",orders.getOrder_items());
//	}
//
//	@Test
//	@Order(4)
//	public void testUpdate(){
//		Orders orders=orders_repository.findById(1L).get();
//		orders.setTotal_amount(12000);
//		orders_repository.save(orders);
//		assertNotEquals(8000,orders_repository.findById(1L)
//				.get().getTotal_amount());
//	}
//
//	@Test
//	@Order(5)
//	public void testDelete(){
//		orders_repository.deleteById(1L);
//		assertThat(orders_repository.existsById(1L)).isFalse();
//	}
}
