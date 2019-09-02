package org.apache.jfcloud.dao;

import org.apache.jfcloud.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fxj
 * @date 2019/8/4 0004
 */
public interface ProjectRepository extends JpaRepository<Project,Long> {

    /**
     * 分页查询
     * @param spec
     * @param pageable
     * @return
     */
    Page<Project> findAll(Specification<Project> spec, Pageable pageable);
}
