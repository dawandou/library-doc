package com.captian.libraryadmin.service;

import com.captian.libraryadmin.entity.LibUser;
import com.captian.libraryadmin.bo.LibUserPage;
import com.captian.libraryadmin.vo.LibUserVO;
import com.captian.libraryadmin.bo.LibUserInsert;
import com.captian.libraryadmin.bo.LibUserUpdate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.captian.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author Captian
 * @Desc 用户表(LibUser)表服务接口
 * @Date 2023-03-09 12:03:54
 */
public interface LibUserService extends IService<LibUser> {

    /**
     * 分页查询
     */
    IPage<LibUserVO> queryByPage(LibUserPage page);

    /**
     * 根据ID查详情
     */
    LibUserVO queryById(Long id);

    /**
     * 新增数据
     */
    boolean insert(LibUserInsert libUserInsert);

    /**
     * 修改数据
     */
    boolean update(LibUserUpdate libUserUpdate);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Long id);

}
