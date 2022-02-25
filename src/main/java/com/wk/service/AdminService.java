package com.wk.service;

import com.wk.entity.Admin;

/**
 * @className: com.wk.service.AdminService
 * @description: 完成登陆的判断
 * @author: 酷盖i
 * @create: 2022-02-22 12:51
 */
public interface AdminService {
    Admin login(String name, String pwd);

}
