package com.nt.controle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssa-web-api")
public class SSAWebOperationRestController {
    @GetMapping("//find/{ssn}")
	public ResponseEntity<?>getStateBySSN(@PathVariable Integer ssn)
	{
		
		if(String.valueOf(ssn).length()!=9)
		return new ResponseEntity<String>("invalid ssn",HttpStatus.BAD_REQUEST);
		int statecode=ssn%100;
		String stateName=null;
		if(statecode==0)
			stateName="Washington DC";
		else if(statecode==02)
			stateName="Ohio";
		else if(statecode == 03)
			stateName="Calfornia";
		else if(statecode == 04)
			stateName="florida";
		else 
			stateName="invalid ssn";
		return new ResponseEntity<String>(stateName,HttpStatus.OK);
		
	}
}
