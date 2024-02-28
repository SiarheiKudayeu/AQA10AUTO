package lesson3.disable;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DisableClass {
    @Ignore
    @Test
    public void a() {

    }

    @Test
    public void b() {

    }

    @Test(enabled = false)
    public void c() {

    }

    @Test
    public void d() {

    }

    @Test
    public void e() {

    }
}
