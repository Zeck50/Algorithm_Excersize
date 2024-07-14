    #include "../googletest/googletest/include/gtest/gtest.h"
    #include "../googletest/googlemock/include/gmock/gmock.h"
    #include "../../main/src/leetcode_13.cpp"
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
