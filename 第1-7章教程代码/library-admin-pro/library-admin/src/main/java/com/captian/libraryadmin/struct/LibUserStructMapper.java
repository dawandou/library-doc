package com.captian.libraryadmin.struct;

import org.mapstruct.*;
import com.captian.libraryadmin.entity.LibUser;
import com.captian.libraryadmin.bo.LibUserInsert;
import com.captian.libraryadmin.bo.LibUserUpdate;
import com.captian.libraryadmin.vo.LibUserVO;

/**
 * 用户表(LibUser)对象映射转换
 *
 * @author Captian
 * @since 2023-03-09
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LibUserStructMapper {

    LibUser updateToLibUser(LibUserUpdate update);

    LibUser insertToLibUser(LibUserInsert insert);

    LibUserVO libUserToLibUserVO(LibUser libUser);

}

