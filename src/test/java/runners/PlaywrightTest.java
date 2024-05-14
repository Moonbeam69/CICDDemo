package runners;

import org.apiguardian.api.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.annotation.*;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@API(status = API.Status.STABLE)
@TestTemplate
@Testable
@ExtendWith(BstackRunner.class)
public @interface PlaywrightTest {
}
