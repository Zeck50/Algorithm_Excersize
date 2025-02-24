#include<string>
using namespace std;

class Solution
{
public:
    int valueOfChar(char input)
    {
        switch (input)
        {
        case 'I':
        {
            return 1;
        }
        case 'V':
        {
            return 5;
        }
        case 'X':
        {
            return 10;
        }
        case 'L':
        {
            return 50;
        }
        case 'C':
        {
            return 100;
        }
        case 'D':
        {
            return 500;
        }
        case 'M':
        {
            return 1000;
        }
        }
        return 0;
    }

    int romanToInt(string s)
    {
        char *p = &s[0];
        int result = 0;
        while ((*p) != '\0')
        {
            if ((*p == 'V' || *p == 'X') && (p != &s[0]))
            {
                if (*(p - 1) == 'I')
                {
                    result += valueOfChar(*p) - valueOfChar(*(p - 1));
                    p++;
                    continue;
                }
            }
            if ((*p == 'L' || *p == 'C') && (p != &s[0]))
            {
                if (*(p - 1) == 'X')
                {
                    result += valueOfChar(*p) - valueOfChar(*(p - 1));
                    p++;
                    continue;
                }
            }
            if ((*p == 'D' || *p == 'M') && (p != &s[0]))
            {
                if (*(p - 1) == 'C')
                {
                    result += valueOfChar(*p) - valueOfChar(*(p - 1));
                    p++;
                    continue;
                }
            }
            int tempvalue = 0;
            while (valueOfChar(*(p + 1)) <= valueOfChar(*p))
            {
                tempvalue += valueOfChar(*p);
                p++;
                if (*(p + 1) == '\0')
                {
                    tempvalue += valueOfChar(*p);
                    break;
                }
            }
            result += tempvalue;

            int tempvalue2 = 0;
            while (valueOfChar(*(p + 1)) == valueOfChar(*p))
            {
                tempvalue2 += valueOfChar(*p);
                p++;
                if (*(p + 1) == '\0')
                {
                    tempvalue2 += valueOfChar(*p);
                    break;
                }
            }
            result += tempvalue2;
            p++;
        }
        return result;
    }
};