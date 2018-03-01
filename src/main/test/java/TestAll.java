import com.wlj.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAll {
    @Autowired
    private StudentService studentService;

    @Test
    public void getAll() {
        System.out.println(studentService.getAll());
    }

    @Test
    public void getLearning() {
        System.out.println(studentService.getLearning());
    }

    @Test
    public void getWorking() {
        System.out.println(studentService.getWorking());
    }

    @Test
    public void getJava() {
        System.out.println(studentService.getJava());
    }

    @Test
    public void getWeb() {
        System.out.println(studentService.getWeb());
    }

    @Test
    public void getMobile() {
        System.out.println(studentService.getMobile());
    }

    @Test
    public void a() {
        Integer a = 10, b = 10, c = 180, d = 180;
        System.out.println(a == b);
        System.out.println(c == d);
    }
}
