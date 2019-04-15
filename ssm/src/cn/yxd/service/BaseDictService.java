package cn.yxd.service;

import cn.yxd.pojo.BaseDict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BaseDictService {
    //注入mapper
    public List<BaseDict> queryBaseDictByDictTypeCode(String code);





}
