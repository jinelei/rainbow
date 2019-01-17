package cn.jinelei.rainbow.blog.repository;

import cn.jinelei.rainbow.blog.model.CommentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhenlei
 */
@Repository
public interface CommentRepository extends CrudRepository<CommentModel, Integer> {
}