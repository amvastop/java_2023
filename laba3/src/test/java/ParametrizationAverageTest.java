import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.muctor.SimpleMethods;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametrizationAverageTest {
    int[] array;
    private final double delta = 1E-4;
    private static SimpleMethods simpleMethods;
    double average;

    @BeforeClass
    public static void initSimpleMethods()
    {
        simpleMethods = new SimpleMethods();
    }

    public ParametrizationAverageTest(double average, int[] array)
    {
        this.average = average;
        this.array=array;

    }
    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        int[] array1 = {2, 2, 5};
        int[] array2 = {12, 4 , 6, 8};
        int[] array3 = {2, 2};
        int[] array4 = {1, 2, 3};
        int[] array5 = {8, 8, 8, 8};
        return Arrays.asList(new Object[][]{
                {3, array1},
                {7.5, array2},
                {3, array3},
                {2, array4},
                {8, array5}
        });
    }

    @Test
    public void testAverage()
    {
        Assert.assertEquals(average, simpleMethods.average(array), delta);
    }



}
