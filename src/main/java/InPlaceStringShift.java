public class InPlaceStringShift
{
    private static int GCD(int a, int b)
    {
        while (a != b)
        {
            if (a > b)
            {
                a = a - b;
            }
            else
            {
                b = b - a;
            }
        }
        return a;
    }

    public static char Swap(char[] str, int position, char character)
    {
        char tmp = str[position];
        // str = str.substring(0, position) + character + str.substring(position + 1);
        str[position] = character;
        return tmp;
    }

    public static void Shift(char[] str, int shift)
    {
        int position = 0;
        char ch = str[position];

        int rotationCycleCount = GCD(str.length, shift);
        int rotationsPerCycle = str.length / rotationCycleCount;

        for (int cycle = 0; cycle < rotationCycleCount; ++cycle)
        {
            for (int rotation = 0; rotation < rotationsPerCycle; ++rotation)
            {
                position = (position + shift) % str.length;
                ch = Swap(str, position, ch);
            }
            position++;
            ch = str[position];
        }
    }
}
