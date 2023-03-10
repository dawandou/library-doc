package com.captian.libraryadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.captian.libraryadmin.entity.User;


/**
 * @Author Captian
 * @Desc 用户表(User)表服务实现类
 * @Date 2023-03-09 12:03:55
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}

