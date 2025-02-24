    #include "../googletest/googletest/include/gtest/gtest.h"
    #include "../googletest/googlemock/include/gmock/gmock.h"
    #include "../../main/src/leetcode_13_Array.cpp"
    // Demonstrate some basic assertions.
    class SolutionTest: public testing::Test{
      protected:
      SolutionTest(){
      }
      ~SolutionTest() override{
      }
      void SetUp() override{
      }
      void TearDown() override{
      }
    };

    TEST_F(SolutionTest, test_case1) {
      // Expect equality.
      Solution *s=new Solution();
      EXPECT_EQ(3, s->romanToInt("III"));
    }

    TEST_F(SolutionTest, test_case2) {
      // Expect equality.
      Solution *s=new Solution();
      EXPECT_EQ(4, s->romanToInt("IV"));
    }

    TEST_F(SolutionTest, test_case3) {
      // Expect equality.
      Solution *s=new Solution();
      EXPECT_EQ(9, s->romanToInt("IX"));
    }

    TEST_F(SolutionTest, test_case4) {
      // Expect equality.
      Solution *s=new Solution();
      EXPECT_EQ(58, s->romanToInt("LVIII"));
    }

    TEST_F(SolutionTest, test_case5) {
      // Expect equality.
      Solution *s=new Solution();
      EXPECT_EQ(1994, s->romanToInt("MCMXCIV"));
    }
