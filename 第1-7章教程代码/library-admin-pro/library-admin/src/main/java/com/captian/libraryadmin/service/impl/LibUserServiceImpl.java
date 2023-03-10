package com.captian.libraryadmin.service.impl;

import com.captian.libraryadmin.entity.LibUser;
import com.captian.libraryadmin.vo.LibUserVO;
import com.captian.libraryadmin.bo.LibUserPage;
import com.captian.libraryadmin.bo.LibUserInsert;
import com.captian.libraryadmin.bo.LibUserUpdate;
import com.captian.libraryadmin.mapper.LibUserMapper;
import com.captian.libraryadmin.struct.LibUserStructMapper;
import com.captian.libraryadmin.service.LibUserService;
import com.captian.util.PageCovertUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;

/**
 * @Author Captian
 * @Desc 用户表(LibUser)表服务实现类
 * @Date 2023-03-09 12:03:54
 */

@Service("libUserService")
public class LibUserServiceImpl extends ServiceImpl<LibUserMapper, LibUser> implements LibUserService {

    @Resource
    private LibUserStructMapper libUserStructMapper;
    @Resource
    private LibUserMapper libUserMapper;


    @Override
    public IPage<LibUserVO> queryByPage(LibUserPage page) {
        // 查询条件
        QueryWrapper<LibUser> queryWrapper = new QueryWrapper<>();
        // 查询分页数据
        IPage<LibUser> LibUserPage = new Page<LibUser>(page.getSize(), page.getCurrent());
        IPage<LibUser> pageData = baseMapper.selectPage(LibUserPage, queryWrapper);
        //转换成vo
        IPage<LibUserVO> records = PageCovertUtil.pageVoCovert(pageData, LibUserVO.class);
        return records;
    }


    @Override
    public LibUserVO queryById(Long id) {
        LibUser libUser = baseMapper.selectById(id);
        return libUserStructMapper.libUserToLibUserVO(libUser);
    }

    @Override
    public boolean insert(LibUserInsert libUserInsert) {
        LibUser libUser = libUserStructMapper.insertToLibUser(libUserInsert);
        save(libUser);
        return true;
    }


    @Override
    public boolean update(LibUserUpdate libUserUpdate) {
        LibUser libUser = libUserStructMapper.updateToLibUser(libUserUpdate);
        updateById(libUser);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        return removeById(id);
    }

}
