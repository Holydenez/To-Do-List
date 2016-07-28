package vetrov.denis.todolist.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetrov.denis.todolist.models.CurrentUser;
import vetrov.denis.todolist.models.entities.Category;
import vetrov.denis.todolist.models.entities.Task;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public class CategoryRepository {
    @Autowired
    EntityManager entityManager;

    public Category getCategory(Long id) {
        return entityManager.find(Category.class, id);
    }

}
