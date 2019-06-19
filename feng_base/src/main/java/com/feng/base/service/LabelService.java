package com.feng.base.service;


import com.feng.base.pojo.Label;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LabelService {

    List<Label> findLabelList();

    Label findLabelById(String id);

    void addLabel(Label label);

    void updateLabel(Label label);

    void deleteLabelById(String id);


    List<Label> findSearch(Label label);

    /**
     * 分页条件查询
     * @param label
     * @param page
     * @param size
     * @return
     */
    Page<Label> pageQuery(Label label, int page, int size);
}
