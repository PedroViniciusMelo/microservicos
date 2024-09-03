package com.ufape.price.create.interfaces;

import java.util.List;
import java.util.Optional;

import com.ufape.price.models.Policy;

public interface InterfaceCreatePolicy {
    Policy savePolicy(Policy entity);
    Policy updatePolicy(Long id, Policy entity);
    Optional<Policy> findPolicy(Long id);
    void deletePolicy(Long id);
    void deletePolicy(Policy entity);
    List<Policy> listPolicies();
}