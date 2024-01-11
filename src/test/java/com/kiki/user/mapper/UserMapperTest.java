package com.kiki.user.mapper;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.kiki.user.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    @DataSet(value = "datasets/users.yml")
    @Transactional
    void すべてのユーザが取得できること () {
        List<User> users = userMapper.findAll();
        assertThat(users)
                .hasSize(4)
                .contains(
                        new User(1,"鈴木", "suzuki@raise-tech.co.jp", 5, 19),
                        new User(2,"中村", "nakamura@raise-tech.co.jp", 7, 55),
                        new User(3,"田中", "tanaka@raise-tech.co.jp", 9, 35),
                        new User(4,"小林", "kobayashi@raise-tech.co.jp", 2, 7));

    }
}
