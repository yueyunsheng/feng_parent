package com.feng.qa.dao;

import com.feng.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    @Query(value = "SELECT * FROM tb_problem ,tb_pl where id=problemid AND labelid=? ORDER BY replytime DESC",nativeQuery = true)
    Page<Problem> findNewProblemList(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem ,tb_pl where id=problemid AND labelid=? ORDER BY reply DESC",nativeQuery = true)
    Page<Problem> findHotProblemList(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem ,tb_pl where id=problemid AND reply='0' AND labelid=? ORDER BY createtime DESC",nativeQuery = true)
    Page<Problem> findWaitReplyList(String labelid, Pageable pageable);

}
