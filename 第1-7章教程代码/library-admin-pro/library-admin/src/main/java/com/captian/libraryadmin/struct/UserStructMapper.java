package com.captian.libraryadmin.struct;

import org.mapstruct.*;
import com.captian.libraryadmin.entity.User;
import com.captian.libraryadmin.bo.UserInsert;
import com.captian.libraryadmin.bo.UserUpdate;
import com.captian.libraryadmin.vo.UserVO;

/**
 * 用户表(User)对象映射转换
 *
 * @author Captian
 * @since 2023-03-09
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserStructMapper {

    User updateToUser(UserUpdate update);

    User insertToUser(UserInsert insert);

    UserVO userToUserVO(User user);

}

