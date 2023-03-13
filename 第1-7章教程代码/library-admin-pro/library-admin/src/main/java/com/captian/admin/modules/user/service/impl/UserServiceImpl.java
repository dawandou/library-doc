package com.captian.admin.modules.user.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.captian.admin.modules.user.entity.User;
import com.captian.admin.modules.user.vo.UserVO;
import com.captian.admin.modules.user.bo.UserPage;
import com.captian.admin.modules.user.bo.UserInsert;
import com.captian.admin.modules.user.bo.UserUpdate;
import com.captian.admin.modules.user.mapper.UserMapper;
import com.captian.admin.modules.user.struct.UserStructMapper;
import com.captian.admin.modules.user.service.UserService;
import com.captian.enums.SexEnum;
import com.captian.enums.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import javax.annotation.Resource;

import com.captian.util.PageCovertUtil;

/**
 * @Author captian
 * @Desc 用户表(User)表服务实现类
 * @Date 2023-03-13 10:01:22
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
