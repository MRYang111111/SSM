package cn.yxd.mapper;

import cn.yxd.pojo.Customer;
import cn.yxd.pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {
    //根据QuaryVo查询出总数
    public Integer selectTotalCountByQueryVo(QueryVo vo);
    //根据quaryvo查询list集合
    public List<Customer> selectListByQueryVo(QueryVo vo);
    //根据客户id回显信息
    public  Customer selectCustomerById(Integer id);
    //根据客户修改信息
    public  void updateCustomerById(Customer customer);
    //根据id删除客户
    public  void  deleteCustomerById(Integer id);
}
