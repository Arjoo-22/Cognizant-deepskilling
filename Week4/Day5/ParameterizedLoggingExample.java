import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String name = "Arjoo";
        int age = 20;
        double salary = 50000.50;

        logger.info("Employee Name: {}", name);
        logger.info("Employee Age: {}", age);
        logger.info("Employee Salary: {}", salary);

        logger.debug("Employee {} is {} years old.", name, age);

        logger.warn("Salary of {} is below expected range.", name);

        logger.error("Unable to process employee record for {}.", name);
    }
}