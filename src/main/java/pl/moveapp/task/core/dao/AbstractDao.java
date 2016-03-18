package pl.moveapp.task.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Mateusz on 2015-07-03.
 */
public abstract class AbstractDao {

    @PersistenceContext
    protected EntityManager em;
}
