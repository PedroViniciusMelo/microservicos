package com.ufape.price.frontage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufape.price.create.interfaces.InterfaceCreatePolicy;
import com.ufape.price.create.interfaces.InterfaceCreatePrice;
import com.ufape.price.models.Policy;
import com.ufape.price.models.Price;

@Service
public class PriceFrontage {
    @Autowired
    private InterfaceCreatePolicy interfaceCreatePolicy;
    @Autowired
    private InterfaceCreatePrice interfaceCreatePrice;

    public Policy savePolicy(Policy entity) {
        return interfaceCreatePolicy.savePolicy(entity);
    }

    public Policy updatePolicy(Long id, Policy entity) {
        return interfaceCreatePolicy.updatePolicy(id, entity);
    }

    public Optional<Policy> findPolicy(Long id) {
        return interfaceCreatePolicy.findPolicy(id);
    }

    public void deletePolicy(Long id) {
        interfaceCreatePolicy.deletePolicy(id);
    }


    public void deletePolicy(Policy entity) {
        interfaceCreatePolicy.deletePolicy(entity);
    }

    public List<Policy> listPolicies() {
        return interfaceCreatePolicy.listPolicies();
    }

    public Price savePrice(Price entity) {
        return interfaceCreatePrice.savePrice(entity);
    }

    public Price updatePrice(Long id, Price entity){
        return interfaceCreatePrice.updatePrice(id, entity);
    }
    public Price findPrice(Long id){
        return interfaceCreatePrice.findPrice(id);
    }
    public void deletePrice(Long id){
        interfaceCreatePrice.deletePrice(id);
    }
    public void deletePrice(Price entity){
        interfaceCreatePrice.deletePrice(entity);
    }
    public List<Price> listPrices(){
        return interfaceCreatePrice.listPrices();
    }

}
