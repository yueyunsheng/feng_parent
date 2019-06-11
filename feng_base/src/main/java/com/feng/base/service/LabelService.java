package com.feng.base.service;


import com.feng.base.pojo.Label;

import java.util.List;

public interface LabelService {

    List<Label> findLabelList();

    Label findLabelById(String id);

    void addLabel(Label label);

    void updateLabel(Label label);

    void deleteLabelById(String id);


}
