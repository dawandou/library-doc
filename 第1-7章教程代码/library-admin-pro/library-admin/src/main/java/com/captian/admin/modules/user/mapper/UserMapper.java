package com.captian.admin.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.captian.admin.modules.user.entity.User;


/**
 * @Author captian
 * @Desc 用户表(User)表服务实现类
 * @Date 2023-03-13 10:01:22
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}

