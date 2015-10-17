import org.junit.Assert;
import org.junit.Test;

public class InPlaceStringShiftTest
{
    @Test
    public void GcdIsOneProperlyShifted()
    {
        char[] str = "abcdef".toCharArray();
        InPlaceStringShift.Shift(str, 5);

        Assert.assertEquals("bcdefa", new String(str));
    }

    @Test
    public void GcdIsTwoProperlyShifted()
    {
        char[] str = "abcdef".toCharArray();
        InPlaceStringShift.Shift(str, 4);

        Assert.assertEquals("cdefab", new String(str));
    }
}
