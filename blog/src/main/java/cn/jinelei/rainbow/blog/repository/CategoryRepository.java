package cn.jinelei.rainbow.blog.repository;

import cn.jinelei.rainbow.blog.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhenlei
 */
@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel, Integer> {
}
