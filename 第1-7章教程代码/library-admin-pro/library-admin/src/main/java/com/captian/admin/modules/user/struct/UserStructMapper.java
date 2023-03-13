package com.captian.admin.modules.user.struct;

import org.mapstruct.*;
import com.captian.admin.modules.user.entity.User;
import com.captian.admin.modules.user.vo.UserVO;
import com.captian.admin.modules.user.bo.UserInsert;
import com.captian.admin.modules.user.bo.UserUpdate;

/**
 * 用户表(User)对象映射转换
 *
 * @author captian
 * @since 2023-03-13
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserStructMapper {

    User updateToUser(UserUpdate update);

    User insertToUser(UserInsert insert);

    UserVO userToUserVO(User user);

}

