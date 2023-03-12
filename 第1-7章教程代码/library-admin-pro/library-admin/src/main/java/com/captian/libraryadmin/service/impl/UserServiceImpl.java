package com.captian.libraryadmin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.captian.enums.SexEnum;
import com.captian.enums.StatusEnum;
import com.captian.libraryadmin.entity.User;
import com.captian.libraryadmin.vo.UserVO;
import com.captian.libraryadmin.bo.UserPage;
import com.captian.libraryadmin.bo.UserInsert;
import com.captian.libraryadmin.bo.UserUpdate;
import com.captian.libraryadmin.mapper.UserMapper;
import com.captian.libraryadmin.struct.UserStructMapper;
import com.captian.libraryadmin.service.UserService;
import com.captian.util.PageCovertUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

/**
 * @Author Captian
 * @Desc 用户表(User)表服务实现类
 * @Date 2023-03-09 12:03:54
 */

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserStructMapper userStructMapper;
    @Resource
    private UserMapper userMapper;


    @Override
    public IPage<UserVO> queryByPage(UserPage page) {
        // 查询条件
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if (page.getDeptId() != null) {
            queryWrapper.eq(User::getDeptId, page.getDeptId());
        }
        if (StrUtil.isNotEmpty(page.getUsername())) {
            queryWrapper.eq(User::getUsername, page.getUsername());
        }
        if (page.getStatus() != null) {
            queryWrapper.eq(User::getStatus, page.getStatus());
        }
        // 查询分页数据
        IPage<User> UserPage = new Page<User>(page.getSize(), page.getCurrent());
        IPage<User> pageData = baseMapper.selectPage(UserPage, queryWrapper);
        //转换成vo
        IPage<UserVO> records = PageCovertUtil.pageVoCovert(pageData, UserVO.class);
        if (CollUtil.isNotEmpty(records.getRecords())) {
            records.getRecords().forEach(vo -> {
                vo.setSexName(SexEnum.getValue(vo.getSex()));
                vo.setStatusName(StatusEnum.getValue(vo.getStatus()));
            });
        }
        return records;
    }


    @Override
    public UserVO queryById(Long id) {
        User user = baseMapper.selectById(id);
        return userStructMapper.userToUserVO(user);
    }

    @Override
    public boolean insert(UserInsert userInsert) {
        User user = userStructMapper.insertToUser(userInsert);
        save(user);
        return true;
    }


    @Override
    public boolean update(UserUpdate userUpdate) {
        User user = userStructMapper.updateToUser(userUpdate);
        updateById(user);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        return removeById(id);
    }

}
