package com.captian.admin.controller;

import com.captian.admin.modules.user.vo.UserVO;
import com.captian.admin.modules.user.bo.UserPage;
import com.captian.admin.modules.user.bo.UserInsert;
import com.captian.admin.modules.user.bo.UserUpdate;
import com.captian.admin.modules.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.captian.util.Result;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;


/**
 * @Author captian
 * @Desc 用户表(User)表控制层
 * @Date 2023-03-13 10:01:21
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 分页查询列表
     *
     * @return 数据
     */
    @PostMapping("/list")
    public Result<IPage<UserVO>> queryByPage(@Valid @RequestBody UserPage page) {
        return Result.success(userService.queryByPage(page));
    }

    /**
     * 根据ID获取数据
     *
     * @return 单个用户表数据
     */
    @PostMapping("/queryById/{id}")
    public Result<UserVO> queryById(@PathVariable("id") Long id) {
        return Result.success(userService.queryById(id));
    }


    /**
     * 添加用户表
     *
     * @return 新增用户表数据
     */
    @PostMapping("/insert")
    public Result insert(@Valid @RequestBody UserInsert param) {
        userService.insert(param);
        return Result.success();
    }


    /**
     * 编辑用户表
     *
     * @return 编辑用户表数据
     */
    @PutMapping("/update")
    public Result update(@Valid @RequestBody UserUpdate param) {
        if (Objects.isNull(param.getId())) {
            return Result.error("ID不能为空");
        }
        userService.update(param);
        return Result.success();
    }

    /**
     * 删除用户表
     *
     * @return 删除用户表数据
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return Result.success();
    }
}
