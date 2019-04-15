package cn.yxd.mapper;

import cn.yxd.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {
    //根据id查询dict_type_code
    List<BaseDict> queryBaseDictByDictTypeCode(String code);
}
