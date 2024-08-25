# C/C++ 数据结构与算法

## 格式化输出打印
### C
```c
#include<stdio.h>

int num = 10;
printf("整数值为：%d\n", num);

float fNum = 3.14;
printf("浮点数值为：%.2f\n", fNum); //保留两位小数

char ch = 'A';
printf("字符为：%c\n", ch);

char str[] = "Hello, World!";
printf("字符串为：%s\n", str);

int *ptr = &num;
printf("指针地址为：%p\n", (void *)ptr);
```
### C++

## 数据结构

### 字符串
#### 1、声明&定义&初始化  
#### 2、字符串读取  
#### 3、字符串处理  
##### 3.1、判空
##### 3.2、取大小
##### 3.3、搜索
##### 3.4、比较
##### 3.5、拼接
##### 3.6、截取
##### 3.7、修改
##### 3.8、数值转换
##### 3.9、拷贝
#### 4、字符串输出
---

### 数组/多维数组
#### 1、声明&定义&初始化 
#### 2、数组处理
##### 2.1、数组遍历
#### 3、STL 固定大小数组 array
#### 3、STL 可变大小数组 array
---

### 队列
#### 1、定义&实现
#### 2、STL双端队列 deque
---
### 链表
#### 1、定义&实现
#### 2、STL双向链表 list
#### 3、STL单向链表 forward_list
---
### 栈
#### 1、定义&实现
#### 2、STL栈 Stack

---
### 树
#### 1、定义&实现
---
### 图
#### 1、定义&实现
---
### 哈希/map
#### 1、定义&实现


## 算法
### 排序
#### 1、冒泡排序
#### 2、冒泡排序
#### 3、插入排序
#### 4、选择排序
#### 5、归并排序
#### 6、希尔排序
#### 7、快速排序
#### 8、堆排序
---
### 查找
#### 1、线性查找
#### 2、二分查找
#### 3、哈希表查找
#### 4、二叉搜索树查找
#### 5、平衡二叉搜索树查找
#### 6、插值查找
#### 7、STL容器查找算法
---
### 进制转换
|V:src\H:dest|二进制|八进制|十进制|十六进制|
|:----:|:----:|:----:|:----:|:----:|
|二进制|NA|取三合一|乘权累加|取四合一|
|八进制|取一分三|NA|乘权累加|N转M|
|十进制|除二取余|除八取余|NA|除十六取余
|十六进制|取一分四|N转M|乘权累加|NA|

#### 1、取N合一
#### 2、取一分N
#### 3、乘权累加
#### 4、N转M
先将N转换为十进制，再将该十进制数转换为目标进制数


参考文献:  
[1] c++最全进制转化（含算法和函数分析），<https://blog.csdn.net/qq_43621422/article/details/100586558?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-100586558-blog-134900652.235^v43^pc_blog_bottom_relevance_base9&spm=1001.2101.3001.4242.1&utm_relevant_index=3>


---
### 位运算  
#### 1、提取整数第n位  
#### 2、交换变量的值  
#### 3、判断奇偶性  
#### 4、清零/置位/切换特定位  
#### 5、判断数值正负  
#### 6、计算绝对值  
#### 7、计算汉明重量  
#### 8、计算汉明距离  
#### 9、判断2的幂次方  
#### 10、计算最高/最低有效位  
#### 11、计算平均值  
#### 12、计算模数  
#### 13、判断符号是否相等  
#### 14、计算最大值/最小值  

参考文献：
[1] C++位运算的19种高级技巧(建议收藏！)，<https://blog.csdn.net/sinat_28305511/article/details/131316049>


---
### 枚举
#### 1、遍历
参考数据结构各自章节的遍历方式，此处不赘述。
#### 2、排列(有序)
参考文献：  
[1] 【C++】无重复数字全排列(三种方法)和有重复数字全排列, <https://blog.csdn.net/m0_62881487/article/details/134172104>
#### 3、组合（无序）
---
### 滑窗算法
#### 1、算法模板
```C++
 //1、初始化指针left，right
int left=0;
int right =0;
//2、右指针停止移动条件
while(rightStopCondition(right,...))
{
    doSomethingA();
     //3、开始移动左指针条件
    while(startLeftCondition(left,...))
    {
         doSomethingB();
         //4、移动左指针,收缩滑窗
        left++;  
    }
    //5、移动右指针，扩张滑窗
    right++;
}
return result;
```

#### 2、例题
**例1(leetcode209)** 给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其总和大于等于 target 的长度最小的 子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。  

示例 1：
输入：target = 7, nums = [2,3,1,2,4,3]  
输出：2  
解释：子数组 [4,3] 是该条件下的长度最小的子数组。  

示例 2：  
输入：target = 4, nums = [1,4,4]  
输出：1  

示例 3：  
输入：target = 11, nums = [1,1,1,1,1,1,1,1]  
输出：0  

**解答**：
```C++
#include<vector>
#include<math>
using namespace std;

class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) 
        int sum=0;
        int len=INT_MAX
        //1、初始化指针left，right
        int left=0;
        int right =0;
        //2、右指针停止移动条件
        while(right<nums.size())
        {
            sum+=nums[right];
             //3、开始移动左指针条件
            while(sum>=target)
            {
                len=min(len,right-left+1);
                 //4、移动左指针,收缩滑窗
                sum-=nums[left++];   
            }
             //5、移动右指针，扩张滑窗
            ++right;
        }
        return len==INT_MAX?0:len;
    }
};
```
**例2(leetcode209)**  给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。

示例 1:  
输入: s = "abcabcbb"  
输出: 3   
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。  

示例 2:  
输入: s = "bbbbb"  
输出: 1  
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。  

示例 3:  
输入: s = "pwwkew"  
输出: 3  
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。  
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：  
0 <= s.length <= 5 * 104  
s 由英文字母、数字、符号和空格组成  
```c
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
```

参考文献：  
[1]【算法】运用滑动窗口方法解决算法题（C++）,<https://blog.csdn.net/Dreaming_TI/article/details/135191477>
### 双指针
---

### 前缀和
### 迭代
### 递归
### 分治
#### 归并
#### 二分
### 搜索
#### 深搜
#### 广搜
### 贪心


