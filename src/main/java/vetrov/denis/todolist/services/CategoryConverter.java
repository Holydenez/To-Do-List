package vetrov.denis.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import vetrov.denis.todolist.models.entities.Category;
import vetrov.denis.todolist.repositories.CategoryRepository;

@Component
public final class CategoryConverter implements Converter<String, Category> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        return categoryRepository.getCategory(Long.valueOf(source));
    }
}