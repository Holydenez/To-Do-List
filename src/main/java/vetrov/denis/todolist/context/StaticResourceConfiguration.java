package vetrov.denis.todolist.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import vetrov.denis.todolist.services.CategoryConverter;

/**
 * Created by Denis on 30.06.2016.
 */
@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    CategoryConverter categoryConverter;

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(categoryConverter);
    }
}