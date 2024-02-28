package lesson3.group;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupClass {

    @Test(groups = {"smoke"})
    public void a(){

    }

    @Test(dependsOnGroups = {"smoke"})
    public void b(){

    }

    @Test()
    public void c(){

    }

    @Test(groups = {"regression"})
    public void d(){

    }

    @Test(groups = {"smoke", "regression"})
    public void e(){

    }
}
