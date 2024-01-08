import com.xie.MainApplication;
import com.xie.config.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class SpringBootLearnTest {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void testRedis(){
        boolean flag = redisUtil.set("key1","222");
        System.out.println("----------------------------:" + flag);
        Object value = redisUtil.get("key1");
        System.out.println(value);
//        System.out.println(11);
    }
}
