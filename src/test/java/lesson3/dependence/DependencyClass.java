package lesson3.dependence;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyClass {

    @Test
    public void a(){
        Assert.assertTrue(false);
    }

    @Test
    public void b(){

    }

    @Test(dependsOnMethods = {"a", "e"}, alwaysRun = true)
    public void c(){

    }

    @Test
    public void d(){

    }

    @Test
    public void e(){

    }
}
