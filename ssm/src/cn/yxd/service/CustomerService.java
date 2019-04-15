package cn.yxd.service;

import cn.yxd.pojo.Customer;
import cn.yxd.pojo.QueryVo;
import cn.yxd.util.Page;

public interface CustomerService {
    //分页查询
    public Page<Customer> selectPageBeanByQueryVo(QueryVo vo);
    //根据客户id查询
    public Customer selectCustomerById(Integer id);
    //根据客户更新客户'
    public  void updateCustomerById(Customer customer);
    //根据客户cust_id删除客户
    public  void deleteCustomerById(Integer id);
}
