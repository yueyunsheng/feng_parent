package com.feng.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.feng.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{

    List<Recruit> findTop6ByStateOrderByCreatetime(String state);//where state=? orderBy Createtime


    List<Recruit> findTop6ByStateNotOrderByCreatetime(String state);
}
