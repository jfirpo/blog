package hu.furediblog.dao;

import hu.furediblog.dao.model.Authors;


public class AuthorRepository extends AbstractRepository<Authors> {
	
    @Override
    public Class<Authors> getManagedClass() {
        return Authors.class;
    }


		
		
}
