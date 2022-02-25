package com.wk.service.impl;

import com.wk.dao.AdminMapper;
import com.wk.entity.Admin;
import com.wk.entity.AdminExample;
import com.wk.service.AdminService;
import com.wk.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: com.wk.service.impl.AdminServiceImpl
 * @description: TODO
 * @author: 酷盖i
 * @create: 2022-02-22 12:52
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin login(String name, String pwd) {

        AdminExample example=new AdminExample();

        example.createCriteria().andANameEqualTo(name);

        List<Admin> adminList=adminMapper.selectByExample(example);
        if(adminList.size()>0){
            Admin admin=adminList.get(0);
            String pwd_Md5= MD5Util.getMD5(pwd);
            if(pwd_Md5.equals(admin.getaPass())){
                return admin;
            }
        }

        return null;
    }
}
