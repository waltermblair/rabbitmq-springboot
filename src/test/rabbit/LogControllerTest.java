package rabbit;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for LogController with mock server
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LogControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private HttpMessageConverter mappingJackson2HttpMessageConverter;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createLogSuccess() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("content", "employment achievement unlocked");
        String logJson = obj.toString();

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/logs")
                .contentType(contentType)
                .content(logJson))
                .andExpect(status().isOk());
    }

    @Test
    public void createLogFailure() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("bad request", "employment achievement unlocked");
        String logJson = obj.toString();

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/logs")
                .contentType(contentType)
                .content(logJson))
                .andExpect(status().isBadRequest());
    }

}