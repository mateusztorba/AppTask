package pl.moveapp.task.core.dao;

import org.springframework.stereotype.Repository;
import pl.moveapp.task.core.models.Tag;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mateusz on 2015-07-03.
 */
@Repository
public class TagDao extends AbstractDao {

    public Tag create(final Tag tag) {
        em.persist(tag);
        return tag;
    }

    public Optional<Tag> findByName(final String name) {
        final List<Tag> tagList = em.createQuery("SELECT t FROM Tag t where t.name = :name").setParameter("name", name).getResultList();
        if(tagList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(tagList.get(0));
        }

    }

}
