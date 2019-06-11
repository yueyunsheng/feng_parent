package com.feng.base.service.impl;

import com.feng.base.dao.LabelDao;
import com.feng.base.pojo.Label;
import com.feng.base.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
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
}
