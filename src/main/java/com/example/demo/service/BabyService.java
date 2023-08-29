package com.example.demo.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.BabyEntity;
import com.example.demo.repository.BabyRepo;

@Service
public class BabyService {

	@Autowired
    BabyRepo br;
	
	public List<BabyEntity> saveinfo(List<BabyEntity> ss)
	{
		return (List<BabyEntity>)br.saveAll(ss);
	}
	public List<BabyEntity> showinfo()
	{
		return br.findAll();
	}
	public BabyEntity changeinfo(BabyEntity ss)
	{
		return br.saveAndFlush(ss);
	}
	public void delete(BabyEntity ss)
	{
		br.delete(ss);
	}
	public Optional<BabyEntity> getbyid(int id)
	{
		return br.findById(id);
	}
	public List<BabyEntity> sortinfo(String s)
	{
		return br.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	public List<BabyEntity> getbypage(int pgno,int pgsize)
	{
		Page<BabyEntity> p=br.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
}
