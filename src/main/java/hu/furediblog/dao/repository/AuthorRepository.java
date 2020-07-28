package hu.furediblog.dao.repository;

import org.springframework.stereotype.Component;

import hu.furediblog.dao.model.Authors;



public class AuthorRepository extends AbstractRepository<Authors> {

	
    @Override
    public Class<Authors> getManagedClass() {
        return Authors.class;
    }	
}
