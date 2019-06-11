package com.feng.base.dao;

import com.feng.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 标签数据访问接口
 */
public interface LabelDao extends
        JpaRepository<Label,String>,JpaSpecificationExecutor<Label> {


}
