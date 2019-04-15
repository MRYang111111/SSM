package cn.yxd.serviceimpl;

import cn.yxd.mapper.BaseDictMapper;
import cn.yxd.pojo.BaseDict;
import cn.yxd.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BaseDictServiceImpl implements BaseDictService {
    /*/**

    根据id查询客户行业等，客户来源
     */
    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String code) {
        return baseDictMapper.queryBaseDictByDictTypeCode(code);
    }
}
