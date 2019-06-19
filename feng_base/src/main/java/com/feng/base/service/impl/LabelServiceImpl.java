package com.feng.base.service.impl;

import com.feng.base.dao.LabelDao;
import com.feng.base.pojo.Label;
import com.feng.base.service.LabelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelServiceImpl implements LabelService {

    @Resource
    private LabelDao labelDao;

    @Resource
    private IdWorker idWorker;
   

    @Override
    public List<Label> findLabelList() {
        return labelDao.findAll();
    }

    @Override
    public Label findLabelById(String id) {
        return labelDao.findById(id).get();
    }

    @Override
    public void addLabel(Label label) {
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    @Override
    public void updateLabel(Label label) {
        labelDao.save(label);
    }


    @Override
    public void deleteLabelById(String id) {
        labelDao.deleteById(id);
    }

    @Override
    public List<Label> findSearch(Label label) {
        Specification specification = creatSpecification(label);
        return labelDao.findAll(specification);
    }

    @Override
    public Page<Label> pageQuery(Label label, int page, int size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (label.getLabelName() != null &&
                        !"".equals(label.getLabelName())) {
                    predicates.add(criteriaBuilder.like(root.get("labelName").as(String.class),
                            "%" + (String) label.getLabelName() + "%"));
                }
                if(label.getState()!=null &&
                        !"".equals(label.getState())){
                    predicates.add(criteriaBuilder.equal(
                            root.get("state").as(String.class), (String)label.getState()) );
                }
                Predicate predicate[] = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(predicate));
            }
        }, pageable);
    }


    private Specification<Label> creatSpecification(Label label) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (label.getLabelName() != null &&
                        !"".equals(label.getLabelName())) {
                    predicates.add(criteriaBuilder.like(root.get("labelName").as(String.class),
                            "%" + (String) label.getLabelName() + "%"));
                }
                if(label.getState()!=null &&
                        !"".equals(label.getState())){
                    predicates.add(criteriaBuilder.equal(
                            root.get("state").as(String.class), (String)label.getState()) );
                }
                Predicate predicate[] = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(predicate));
            }
        };

    }

}
