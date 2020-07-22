package hu.furediblog.dao.repository;

import hu.furediblog.dao.db.*;
import org.hibernate.Session;


public abstract class AbstractRepository {

    protected Session getSession() {
        return DatabaseSessionProvider.getInstance().getSessionObj();
    }

}