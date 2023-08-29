package com.example.demo.controller;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BabyEntity;
import com.example.demo.service.BabyService;

@RestController
public class BabyController {
    @Autowired
	BabyService bs;
	@PostMapping("addbaby")
	public List<BabyEntity> add(@RequestBody List<BabyEntity> ss)
	{
		return bs.saveinfo(ss);
	}
	@GetMapping("showbaby")
	public List<BabyEntity> show()
	{
		return bs.showinfo();
	} 
	@GetMapping("show/{fathername}")
	public Optional<BabyEntity> showparent(@PathVariable int id)
    {
		return bs.getbyid(id);
	}
	@GetMapping("sort/{fname}")
	public List<BabyEntity> getsortinfo(@PathVariable String fname)
	{
		return bs.sortinfo(fname);
	}
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<BabyEntity> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return bs.getbypage(pageno, pagesize);
	}
}
