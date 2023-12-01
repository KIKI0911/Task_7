package com.kiki.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(int id);

    @Select("SELECT * FROM users WHERE id = #{id} AND addressId = #{addressId}")
    Optional<User> findByIdAndAddressId(int id, int addressId);
}
