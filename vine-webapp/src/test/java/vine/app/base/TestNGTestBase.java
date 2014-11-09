package vine.app.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations={"classpath:/context/mock-spring-all.xml"})
public class TestNGTestBase extends AbstractTestNGSpringContextTests {
}
