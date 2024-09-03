package com.ufape.price.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ufape.price.controllers.request.PolicyRequest;
import com.ufape.price.controllers.response.PolicyResponse;
import com.ufape.price.frontage.PriceFrontage;
import com.ufape.price.models.Policy;

@RestController
@RequestMapping("/price")
public class PolicyController {

    @Autowired
    private PriceFrontage priceFrontage;

    @GetMapping("/policy")
    List<PolicyResponse> listPolicy() {
        List<PolicyResponse> response = new ArrayList<PolicyResponse>();
        for(Policy c : priceFrontage.listPolicies())
            response.add(new PolicyResponse(c));
        return response;
    }

    @PostMapping("/policy")
    Policy savePolicy(@Validated @RequestBody PolicyRequest newObj) {
        return priceFrontage.savePolicy(newObj.convertModel());
    }

    @DeleteMapping("/policy/{id}")
    ResponseEntity<?> deletePolicy(@PathVariable long id) {
        priceFrontage.deletePolicy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/policy/{id}")
    Policy updatePolicy(@PathVariable long id, @Validated @RequestBody PolicyRequest newObj) {
        return priceFrontage.updatePolicy(id, newObj.convertModel());
    }

    
}
