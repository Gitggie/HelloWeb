import com.wlj.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.ValidationEvent;
import java.util.*;

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
        /*Integer a = 10, b = 10, c = 180, d = 180;
        System.out.println(a == b);
        System.out.println(c == d);*/

        String l = "123,123,123,456.123424,345";
        String[] ll = l.split(",|\\.");


        for (int i = 0; i < ll.length; i++) {
            System.out.println(ll[i]);

        }
    }

    @Test
    public void b() {
        List<String> v = new ArrayList();
        v.add("one");
        v.add("two");
        for (String s : v) {
            System.out.println(s);
        }
    }

    @Test
    public void c() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "Value");
        map.put("key2", "Value2");
        System.out.println(map);

        Map<String, List> map2 = new HashMap<>();
        map2.put("s", Collections.singletonList("1"));
        map2.put("d", Collections.singletonList("2"));
        map2.put("f", Collections.singletonList("3"));
        map2.put("g", Collections.singletonList("4"));
        map2.put("h", Collections.singletonList("5"));
        System.out.println(map2);

        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        System.out.println(list);

        String[] a = new String[6];
        System.out.println(a.length);
        a[0] = "w";
        a[1] = "w";
        a[2] = "w";
        a[3] = "w";
        a[4] = "w";
        a[5] = "w";
        a();//这句话什么意思？
        for (String s : a) {
            System.out.println(s);
        }

    }

    @Test
    public void d() {
        // int k = 1 / 0;
        for (int i = 1, s = 0; i <= 100; i++) {
            s += i;
            System.out.println(i + "\t" + s);
        }
    }

}
