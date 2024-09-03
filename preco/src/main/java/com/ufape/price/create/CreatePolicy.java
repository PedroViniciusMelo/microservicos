package com.ufape.price.create;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufape.price.create.exception.DuplicatedRegisterException;
import com.ufape.price.create.interfaces.InterfaceCreatePolicy;
import com.ufape.price.models.Policy;
import com.ufape.price.repositories.RepositoryPolicy;
@Service
public class CreatePolicy implements InterfaceCreatePolicy {

    @Autowired
    private RepositoryPolicy repositoryPolicy;

    @Override
    public Policy savePolicy(Policy entity) {
        if(repositoryPolicy.findByNameContainingIgnoreCase(entity.getName())==null) {
            throw new DuplicatedRegisterException("A política ["+ entity.getName() + "] já se encontra cadastrada no sistema.");
        }
        return repositoryPolicy.save(entity);
    }

    @Override
    public Policy updatePolicy(Long id, Policy entity) {
        Policy policy = findPolicy(id).get();
        policy.setName(entity.getName());
        policy.setDescription(entity.getDescription());
        policy.setDiscount(entity.getDiscount());
        return repositoryPolicy.save(policy);
    }

    @Override
    public Optional<Policy> findPolicy(Long id) {
        return repositoryPolicy.findById(id);
    }

    @Override
    public void deletePolicy(Long id) {
        repositoryPolicy.deleteById(id);
    }

    @Override
    public void deletePolicy(Policy entity) {
        repositoryPolicy.delete(entity);
    }

    @Override
    public List<Policy> listPolicies() {
        return repositoryPolicy.findAll();
    }

}
