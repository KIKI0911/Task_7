package integrationtest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.kiki.user.UserApplication;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

@SpringBootTest(classes = UserApplication.class)
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRestApiIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DataSet(value = "datasets/users.yml")
    @Transactional
    void ユーザーが全件取得できること() throws Exception {

        String response = mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        JSONAssert.assertEquals("[" +
                "  {" +
                "  \"id\" :1," +
                "  \"name\": \"鈴木\"," +
                "  \"email\": \"suzuki@raise-tech.co.jp\"," +
                "  \"addressId\" :5," +
                "  \"age\" :19" +
                "  }," +
                "  {" +
                "  \"id\" :2," +
                "  \"name\": \"中村\"," +
                "  \"email\": \"nakamura@raise-tech.co.jp\"," +
                "  \"addressId\" :7," +
                "  \"age\" :55" +
                "  }," +
                "  {" +
                "  \"id\" :3," +
                "  \"name\": \"田中\"," +
                "  \"email\": \"tanaka@raise-tech.co.jp\"," +
                "  \"addressId\" :9," +
                "  \"age\" :35" +
                "  }," +
                "  {" +
                "  \"id\" :4," +
                "  \"name\": \"小林\"," +
                "  \"email\": \"kobayashi@raise-tech.co.jp\"," +
                "  \"addressId\" :2," +
                "  \"age\" :7" +
                "  }" +
                "]", response, JSONCompareMode.STRICT);
    }
}
