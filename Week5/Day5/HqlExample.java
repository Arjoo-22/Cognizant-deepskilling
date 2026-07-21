

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HqlExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        // HQL Query
        String hql = "FROM Employee";

        List<Employee> employees = session.createQuery(hql, Employee.class).getResultList();

        for (Employee e : employees) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
        }

        session.close();
        factory.close();
    }
}