package cn.yxd.controller;

import cn.yxd.pojo.BaseDict;
import cn.yxd.pojo.Customer;
import cn.yxd.pojo.QueryVo;
import cn.yxd.service.BaseDictService;
import cn.yxd.service.CustomerService;
import cn.yxd.util.Page;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BaseDictController {
    /**
     *
     * 客户管理页面
     */
    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/list")
    public  String list(QueryVo vo,Model model){
        List<BaseDict> fromType =  baseDictService.queryBaseDictByDictTypeCode("002");
        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode("001");
        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode("006");
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);
         //调用service
        Page<Customer> page = customerService.selectPageBeanByQueryVo(vo);
        model.addAttribute("page",page);
        //数据的回显
        model.addAttribute("custName",vo.getCustName());
        model.addAttribute("custSource",vo.getCustSource());
        model.addAttribute("custIndustry",vo.getCustIndustry());
        model.addAttribute("custLevel",vo.getCustLevel());

        return "customer";
    }
//    url:"<%=basePath%>/edit.action",

    /**
     * 根据客户的id查询，转换成json
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit.action")
    @ResponseBody
    public  Customer edit(Integer id){
        Customer customer = customerService.selectCustomerById(id);
    return  customer;
    }
    @RequestMapping(value = "/update.action")
    @ResponseBody
    public String updateCustomerById(Customer customer){
        customerService.updateCustomerById(customer);
        return "OK";
    }
    @RequestMapping(value = "/delete.action")
    @ResponseBody
    public  String delete(Integer id){
        customerService.deleteCustomerById(id);
        return "OK";
    }
}
