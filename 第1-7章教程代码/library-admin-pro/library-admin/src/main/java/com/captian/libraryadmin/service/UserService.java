package com.captian.libraryadmin.service;

import com.captian.libraryadmin.entity.User;
import com.captian.libraryadmin.bo.UserPage;
import com.captian.libraryadmin.vo.UserVO;
import com.captian.libraryadmin.bo.UserInsert;
import com.captian.libraryadmin.bo.UserUpdate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.captian.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author Captian
 * @Desc 用户表(User)表服务接口
 * @Date 2023-03-09 12:03:54
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询
     */
    IPage<UserVO> queryByPage(UserPage page);

    /**
     * 根据ID查详情
     */
    UserVO queryById(Long id);

    /**
     * 新增数据
     */
    boolean insert(UserInsert userInsert);

    /**
     * 修改数据
     */
    boolean update(UserUpdate userUpdate);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Long id);

}
