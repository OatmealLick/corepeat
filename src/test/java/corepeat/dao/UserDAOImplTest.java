package corepeat.dao;

import corepeat.model.CorepeatUser;
import corepeat.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dispatcher-servlet.xml")
public class UserDAOImplTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    @Test
    @Rollback(false)
    public void addUser() {
        CorepeatUser corepeatUser = new CorepeatUser();
        corepeatUser.setName("Bratumiła");
        corepeatUser.setSurname("Mścigniew");
        corepeatUser.setBirthDate("02-02-1960");
        corepeatUser.setCity("Kraków");
        corepeatUser.setPasswordHash("lUkA5Z5miERDzi".toCharArray());
        corepeatUser.setUserEmail("b.msci@pocta.pl");

        sessionFactory.getCurrentSession().persist(corepeatUser);

    }
}