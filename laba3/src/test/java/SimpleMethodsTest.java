import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.muctor.SimpleMethods;

public class SimpleMethodsTest {
    private final double delta = 1E-4;
    private SimpleMethods simpleMethods;

    @Before
    public void initSimpleMethods()
    {
        simpleMethods = new SimpleMethods();
    }

    @Test
    public void testIsArrayEqual()
    {
        int[] array1 = {1, 2, 4};
        int[] array2 = {1, 4, 2};
        Assert.assertTrue(SimpleMethods.isArrayEqual(array1, array2));

    }
    @Test
    public void testAverage()
    {
        int[] array1 = {2, 2, 4};
        Assert.assertEquals(2.666666666, simpleMethods.average(array1), delta);
    }

}
