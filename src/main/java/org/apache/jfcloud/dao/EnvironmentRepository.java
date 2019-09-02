package org.apache.jfcloud.dao;

import org.apache.jfcloud.entity.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fxj
 * @date 2019/8/4 0004
 */
public interface EnvironmentRepository extends JpaRepository<Environment,Long> {

    /**
     * 分页查询
     * @param spec
     * @param pageable
     * @return
     */
    Page<Environment> findAll(Specification<Environment> spec, Pageable pageable);
}
