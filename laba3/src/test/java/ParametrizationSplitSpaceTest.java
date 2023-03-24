import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.muctor.SimpleMethods;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametrizationSplitSpaceTest {
    String[] ans;
    String str;

    public ParametrizationSplitSpaceTest( String[] ans, String str)
    {
        this.ans = ans;
        this.str=str;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        String[] ans1 = {"123", "123" };
        String[] ans2 = {"123", "11"};

        return Arrays.asList(new Object[][]{
                {ans1, "123 123"},
                {ans2, "123 123"}
        });
    }

    @Test
    public void testSplitSpase()
    {
        Assert.assertArrayEquals(ans, SimpleMethods.splitSpace(str));
    }
}
