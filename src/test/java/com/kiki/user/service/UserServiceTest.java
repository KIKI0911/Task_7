package com.kiki.user.service;

import com.kiki.user.entity.User;
import com.kiki.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserMapper userMapper;

    @Test
    public void 存在するユーザのIDを指定したときに正常にユーザーが返されること() {

        doReturn(Optional.of(new User(1, "nagasaka daiki", "nagasaska@raise-tech.co.jp", 8, 25))).when(userMapper).findById(1);

        User actual = userService.findUser(1);
        assertThat(actual).isEqualTo(new User(1, "nagasaka daiki", "nagasaska@raise-tech.co.jp", 8, 25));
        verify(userMapper).findById(1);

    }
}
