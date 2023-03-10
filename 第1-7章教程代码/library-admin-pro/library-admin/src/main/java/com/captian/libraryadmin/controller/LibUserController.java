package com.captian.libraryadmin.controller;

import com.captian.libraryadmin.entity.LibUser;
import com.captian.libraryadmin.vo.LibUserVO;
import com.captian.libraryadmin.bo.LibUserPage;
import com.captian.libraryadmin.bo.LibUserInsert;
import com.captian.libraryadmin.bo.LibUserUpdate;
import com.captian.libraryadmin.service.LibUserService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.captian.util.Result;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;


/**
 * @Author Captian
 * @Desc 用户表(LibUser)表控制层
 * @Date 2023-03-09 12:03:54
 */

@RestController
@RequestMapping("libUser")
public class LibUserController {

    @Resource
    private LibUserService libUserService;


    /**
     * 分页查询列表
     *
     * @return 数据
     */
    @PostMapping("/list")
    public Result<IPage<LibUserVO>> queryByPage(@Valid @RequestBody LibUserPage page) {
        return Result.success(libUserService.queryByPage(page));
    }

    /**
     * 根据ID获取数据
     *
     * @return 单个用户表数据
     */
    @PostMapping("/queryById/{id}")
    public Result<LibUserVO> queryById(@PathVariable("id") Long id) {
        return Result.success(libUserService.queryById(id));
    }


    /**
     * 添加用户表
     *
     * @return 新增用户表数据
     */
    @PostMapping("/insert")
    public Result insert(@Valid @RequestBody LibUserInsert param) {
        libUserService.insert(param);
        return Result.success();
    }


    /**
     * 编辑用户表
     *
     * @return 编辑用户表数据
     */
    @PutMapping("/update")
    public Result update(@Valid @RequestBody LibUserUpdate param) {
        if (Objects.isNull(param.getId())) {
            return Result.error("ID不能为空");
        }
        libUserService.update(param);
        return Result.success();
    }

    /**
     * 删除用户表
     *
     * @return 删除用户表数据
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id") Long id) {
        libUserService.deleteById(id);
        return Result.success();
    }
}
