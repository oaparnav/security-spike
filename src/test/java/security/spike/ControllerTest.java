package security.spike;

import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTest {
    @Test public void testSomeLibraryMethod() {
        SampleController controller = new SampleController();
        assertEquals("Hello, world", controller.endpoint());
    }
}
