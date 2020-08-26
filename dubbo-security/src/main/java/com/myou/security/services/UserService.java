package com.myou.security.services;

import com.myou.security.entities.QRoleEntity;
import com.myou.security.entities.QUserEntity;
import com.myou.security.entities.RoleEntity;
import com.myou.security.entities.UserEntity;
import com.myou.security.exceptions.DataUpdatePrimaryIsEmptyException;
import com.myou.security.jwt.JwtOperationManual;
import com.myou.security.models.dto.UserDTO;
import com.myou.security.models.vo.UserVO;
import com.myou.security.persistence.Constants;
import com.myou.security.repositorys.UserRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 * @Author myou
 * @Date 2020/8/14  10:46 上午
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private UserDetailsService userDetailsService;


    public UserEntity create(UserVO userVO) {
        UserEntity userEntity = new UserEntity();
        Constants.copy(userVO, userEntity);
        QRoleEntity roleEntity = QRoleEntity.roleEntity;
        List<RoleEntity> roleEntities = jpaQueryFactory.selectFrom(roleEntity).where(roleEntity.roleId.in(userVO.getRateIds())).fetch();
        userEntity.setRoleEntities(new HashSet<>(roleEntities));
        return userRepository.save(userEntity);
    }

    public UserEntity update(UserVO userVO) {
        if (null == userVO.getUserId()) {
            throw new DataUpdatePrimaryIsEmptyException("primary is empty,can not get instance");
        }
        return create(userVO);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        Optional<UserEntity> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            UserEntity userEntity = optional.get();
            userEntity.getRoleEntities().clear();
            userRepository.deleteById(id);
        }
    }

    public List<UserEntity> findByEx(UserVO userVO) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QUserEntity userEntity = QUserEntity.userEntity;
        if (null != userVO.getUserId()) {
            booleanBuilder.and(userEntity.userId.eq(userVO.getUserId()));
        }
        if (null != userVO.getUserName()) {
            booleanBuilder.and(userEntity.userName.like(String.format("%%%s%%", userVO.getUserName())));
        }
        if (null != userVO.getUserGender()) {
            booleanBuilder.and(userEntity.userGender.eq(userVO.getUserGender()));
        }
        if (null != userVO.getUserNotEnable()) {
            booleanBuilder.and(userEntity.userNotEnable.eq(userVO.getUserNotEnable()));
        }
        if (null != userVO.getUserMobile()) {
            booleanBuilder.and(userEntity.userMobile.like(String.format("%%%s%%", userVO.getUserMobile())));
        }
        return jpaQueryFactory.selectFrom(userEntity).offset(userVO.pageNumber()).limit(userVO.getPageIndex()).where(booleanBuilder).fetch();
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    public UserEntity findByName(String acc) {
        QUserEntity userEntity = QUserEntity.userEntity;
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(userEntity.userName.eq(acc));
        return userRepository.findOne(builder).orElseGet(null);
    }
}
