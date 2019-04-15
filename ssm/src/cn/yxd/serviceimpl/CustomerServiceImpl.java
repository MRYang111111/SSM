package cn.yxd.serviceimpl;

import cn.yxd.mapper.CustomerMapper;
import cn.yxd.pojo.Customer;
import cn.yxd.pojo.QueryVo;
import cn.yxd.service.CustomerService;
import cn.yxd.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    /*
    根据条件查询分页对象
   private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;


     */
    @Override
    public Page<Customer> selectPageBeanByQueryVo(QueryVo vo) {
        Page<Customer> page=new Page<Customer>();
        //判断queryvo是否为空
        if(vo!=null){
            //设置查询条件从哪里开始查
            page.setPage(vo.getPage());
            vo.setStart((vo.getPage()-1)*vo.getRow());
            page.setSize(10);
            vo.setRow(10);
           //判断客户的名称是否为空
            if (vo.getCustName()!=null&&"".equals(vo.getCustName().trim())){
                vo.setCustName(vo.getCustName());
            }
            if (vo.getCustSource()!=null&&!vo.getCustSource().trim().equals("")){
                vo.setCustSource(vo.getCustSource());
            }
            if (vo.getCustIndustry()!=null&&!vo.getCustIndustry().equals("")){
                vo.setCustIndustry(vo.getCustIndustry());
            }
            if (vo.getCustLevel()!=null&&!vo.getCustLevel().trim().equals("")){
                vo.setCustLevel(vo.getCustLevel());
            }
            //查询出总记录数
//            page.setTotal(customerMapper.selectTotalCountByQueryVo(vo));
            Integer integer = customerMapper.selectTotalCountByQueryVo(vo);
            page.setTotal(integer);
            //查询出分页记录
            List<Customer> list = customerMapper.selectListByQueryVo(vo);
            System.out.println("customerList有："+list);
            page.setRows(list);

        }

        return page;
    }

    @Override
    public Customer selectCustomerById(Integer id) {
        return customerMapper.selectCustomerById(id);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        customerMapper.updateCustomerById(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerMapper.deleteCustomerById(id);
    }
}
