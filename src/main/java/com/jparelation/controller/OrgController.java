package com.jparelation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jparelation.entity.dto.UpdateOrg;
import com.jparelation.entity.org.Organization;
import com.jparelation.service.OrgService;

@RestController
@RequestMapping("/org")
public class OrgController {
	
	@Autowired
	OrgService orgService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insertData(@RequestBody Organization org){
		try {
		 orgService.insertOrg(org);
		 return new ResponseEntity<String>("Inserted SuccessFully",HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<Optional<Organization>> getData(@RequestParam int id){
		Optional<Organization> org=orgService.getOrgById(id);
		return new ResponseEntity<Optional<Organization>>(org,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateData(@RequestBody UpdateOrg updateOrg,@RequestParam int id) {
		try {
		orgService.updateOrg(updateOrg, id);
		return new ResponseEntity<String>("Update Succesfully",HttpStatus.ACCEPTED);
		}catch(Exception e) {
		return new ResponseEntity<String>("Update Failed",HttpStatus.BAD_REQUEST);	
		}
	}

}
