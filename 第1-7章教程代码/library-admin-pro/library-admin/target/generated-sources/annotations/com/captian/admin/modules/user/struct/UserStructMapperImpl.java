package com.captian.admin.modules.user.struct;

import com.captian.admin.modules.user.bo.UserInsert;
import com.captian.admin.modules.user.bo.UserUpdate;
import com.captian.admin.modules.user.entity.User;
import com.captian.admin.modules.user.vo.UserVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T10:04:05+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9.1 (JetBrains s.r.o.)"
)
@Component
public class UserStructMapperImpl implements UserStructMapper {

    @Override
    public User updateToUser(UserUpdate update) {
        if ( update == null ) {
            return null;
        }

        User user = new User();

        user.setId( update.getId() );
        user.setDeptId( update.getDeptId() );
        user.setRealName( update.getRealName() );
        user.setUsername( update.getUsername() );
        user.setPassword( update.getPassword() );
        user.setEmail( update.getEmail() );
        user.setPhone( update.getPhone() );
        user.setSex( update.getSex() );
        user.setAvatar( update.getAvatar() );
        user.setStatus( update.getStatus() );
        user.setLoginDate( update.getLoginDate() );
        user.setCreateTime( update.getCreateTime() );
        user.setUpdateTime( update.getUpdateTime() );
        user.setLastPasswordResetTime( update.getLastPasswordResetTime() );
        user.setRemark( update.getRemark() );

        return user;
    }

    @Override
    public User insertToUser(UserInsert insert) {
        if ( insert == null ) {
            return null;
        }

        User user = new User();

        user.setId( insert.getId() );
        user.setDeptId( insert.getDeptId() );
        user.setRealName( insert.getRealName() );
        user.setUsername( insert.getUsername() );
        user.setPassword( insert.getPassword() );
        user.setEmail( insert.getEmail() );
        user.setPhone( insert.getPhone() );
        user.setSex( insert.getSex() );
        user.setAvatar( insert.getAvatar() );
        user.setStatus( insert.getStatus() );
        user.setLoginDate( insert.getLoginDate() );
        user.setCreateTime( insert.getCreateTime() );
        user.setUpdateTime( insert.getUpdateTime() );
        user.setLastPasswordResetTime( insert.getLastPasswordResetTime() );
        user.setRemark( insert.getRemark() );

        return user;
    }

    @Override
    public UserVO userToUserVO(User user) {
        if ( user == null ) {
            return null;
        }

        UserVO userVO = new UserVO();

        userVO.setId( user.getId() );
        userVO.setDeptId( user.getDeptId() );
        userVO.setRealName( user.getRealName() );
        userVO.setUsername( user.getUsername() );
        userVO.setPassword( user.getPassword() );
        userVO.setEmail( user.getEmail() );
        userVO.setPhone( user.getPhone() );
        userVO.setSex( user.getSex() );
        userVO.setAvatar( user.getAvatar() );
        userVO.setStatus( user.getStatus() );
        userVO.setLoginDate( user.getLoginDate() );
        userVO.setCreateTime( user.getCreateTime() );
        userVO.setUpdateTime( user.getUpdateTime() );
        userVO.setLastPasswordResetTime( user.getLastPasswordResetTime() );
        userVO.setRemark( user.getRemark() );

        return userVO;
    }
}
