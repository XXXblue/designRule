import com.designRule.dao.SysuserMapper;
import com.designRule.pojo.Sysuser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2711:48
 * @Description:
 * @Modified By:
 */
public class test {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
        SysuserMapper sysuserMapper = applicationContext.getBean(SysuserMapper.class);
        Sysuser sysuser = sysuserMapper.selectByPrimaryKey(1);
        System.out.println(sysuser.getUsername());
    }
}
