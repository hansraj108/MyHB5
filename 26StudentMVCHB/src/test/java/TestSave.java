import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hr.bean.Student;
import com.hr.config.SpringRootConfig;
import com.hr.dao.AbstractDAO;
import com.hr.dao.StudentDAO;
import com.hr.exception.StudentException;
import com.hr.service.StudentService;



public class TestSave extends AbstractDAO{

	
	public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        StudentService service = ctx.getBean(StudentService.class);
        Student s = new Student();
        s.setName("xxx");
        s.setDob("2009-10-10");
        s.setMobile(989898L);
        s.setCountry("NEW");
        
        try {
			service.save(s);
			service.update(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }  
}
