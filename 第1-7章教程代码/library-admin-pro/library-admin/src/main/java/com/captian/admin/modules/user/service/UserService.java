package com.captian.admin.modules.user.service;

import com.captian.admin.modules.user.entity.User;
import com.captian.admin.modules.user.vo.UserVO;
import com.captian.admin.modules.user.bo.UserPage;
import com.captian.admin.modules.user.bo.UserInsert;
import com.captian.admin.modules.user.bo.UserUpdate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author captian
 * @Desc 用户表(User)表服务接口
 * @Date 2023-03-13 10:01:22
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
