#include<stdint.h>
#include<stdio.h>

int isCharRepeated(const char* leftInput,const char* rightInput)
    {
        while(leftInput<rightInput)
        {
            if(*leftInput==*rightInput)
            {
                return 0;
            }
            leftInput++;
        }
        return -1;
    }

int lengthOfLongestSubstring(char* s) {
    char* left=&s[0];
    char* right=&s[0];
    uint64_t resultLength=0;
    uint64_t stringLength=0;

    while(*right!='\0')
    {
        int isRepeated=isCharRepeated(left,right);
        while((isRepeated==0)&&left<right)
        {
            left++;
            stringLength--;
            if(isCharRepeated(left,right)!=0)
            {
                break;
            }
        }
        right++;
        stringLength++;
        resultLength=resultLength>stringLength?resultLength:stringLength;
    }
    return resultLength;
}

int main()
{
    char* test1="abcabcbb";
    int result1=lengthOfLongestSubstring(test1);
    printf("lengthOfLongestSubstring: %s,is %d\n",test1,result1);
    printf("\n");

    char* test2="bbbbb";
    int result2=lengthOfLongestSubstring(test2);
    printf("lengthOfLongestSubstring: %s,is %d\n",test2,result2);
    printf("\n");

    char* test3="pwwkew";
    int result3=lengthOfLongestSubstring(test3);
    printf("lengthOfLongestSubstring: %s,is %d\n",test3,result3);
    printf("\n");
}