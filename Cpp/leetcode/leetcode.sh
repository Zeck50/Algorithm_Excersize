#!/bin/bash

# 入参设置
#$1 创建/删除项目
#$2 项目名称（非必填）默认名称为"Leetcode_当前系统时间戳"
#$3 项目路径（非必填）默认路径为"/home/zeck/Learning/CppProject/Leetcode"
ACTION=$1
INPUT_PRO=$2
INPUT_PATH=$3

#默认参数
PROJECT_NAME="myproject"
DEFAULT_PROJECT_NAME="leetcode_$PROJECT_NAME"
DEFAULT_PATH=$PWD
DEFAULT_GOOGLETEST_PATH="/Users/zeck/learning/GoogleTest/googletest"
#编译参数
CMAKE_PARAM="-DCMAKE_MAKE_PROGRAM=/usr/bin/make -DCMAKE_CXX_COMPILER=/usr/bin/g++ -DCMAKE_C_COMPILER=/usr/bin/gcc"

# 判断项目名称入参是否为空
if [ -z "$INPUT_PRO" ]; then
    PROJECT_NAME=$DEFAULT_PROJECT_NAME
    echo "[WARNING] Input project name is empty. Use default project name: $PROJECT_NAME"
else
    PROJECT_NAME=leetcode_$INPUT_PRO
    echo "[INFO] Input project name is $PROJECT_NAME"
fi

#设定CMake参数
CMAKE_BUILD_TYPE=Debug
CMAKE_CPP_STANDARDS=" -std=c++17"
CMAKE_MAIN_PROJECT_NAME=$PROJECT_NAME
CMAKE_TEST_PROJECT_NAME="test_"$CMAKE_MAIN_PROJECT_NAME


# 判断项目路径入参是否为空
if [ -z "$INPUT_PATH" ]; then
    PATH=$DEFAULT_PATH
    echo "[WARNING] Input path is empty. Use default path: $PATH"
else
    PATH=$INPUT_PATH
    echo "[INFO] Input path is: $PATH"
    # 使判断路径是否存在
    if [ -d "$INPUT_PATH" ]; then
        echo "[INFO] Input path $INPUT_PATH exists."
    else
        echo "[ERROR] Input path $INPUT_PATH does not exist!"
        exit 1
    fi
fi

echo "[INFO] Path is $PATH"
echo "[INFO] Project is $PROJECT_NAME"

if [ $ACTION = "create" ]; then
    echo "[INFO] create project start."

    /bin/mkdir -p $PATH/$PROJECT_NAME/main/src/include
    /usr/bin/touch $PATH/$PROJECT_NAME/main/src/$PROJECT_NAME.cpp
    /bin/mkdir -p $PATH/$PROJECT_NAME/main/lib
    /bin/mkdir -p $PATH/$PROJECT_NAME/main/bin
    /bin/mkdir -p $PATH/$PROJECT_NAME/main/build
    /usr/bin/touch $PATH/$PROJECT_NAME/main/build/CMakeLists.txt

    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/src/inlucde
    /usr/bin/touch $PATH/$PROJECT_NAME/unittest/src/test_$PROJECT_NAME.cpp
    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/lib
    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/bin
    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/build
    /usr/bin/touch $PATH/$PROJECT_NAME/unittest/build/CMakeLists.txt
    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/googletest

    #拉取googltest源码,速度太慢，拉取一份到本地然后拷贝
    #/usr/bin/git clone https://github.com/google/googletest.git $PATH/$PROJECT_NAME/unittest/googletest/
    /bin/cp -r $DEFAULT_GOOGLETEST_PATH/* $PATH/$PROJECT_NAME/unittest/googletest/

    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/googletest/googletest/include/gtest/gtest
    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/googletest/googletest/include/gtest/gtest/internal
    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/googletest/googletest/include/gtest/gtest/internal/custom
    /bin/cp $PATH/$PROJECT_NAME/unittest/googletest/googletest/include/gtest/* $PATH/$PROJECT_NAME/unittest/googletest/googletest/include/gtest/gtest/
    /bin/cp $PATH/$PROJECT_NAME/unittest/googletest/googletest/include/gtest/internal/* $PATH/$PROJECT_NAME/unittest/googletest/googletest/include/gtest/gtest/internal
     /bin/cp $PATH/$PROJECT_NAME/unittest/googletest/googletest/include/gtest/internal/custom/* $PATH/$PROJECT_NAME/unittest/googletest/googletest/include/gtest/gtest/internal/custom


    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/googletest/googlemock/include/gmock/gmock
    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/googletest/googlemock/include/gmock/gmock/internal
    /bin/mkdir -p $PATH/$PROJECT_NAME/unittest/googletest/googlemock/include/gmock/gmock/internal/custom
    /bin/cp $PATH/$PROJECT_NAME/unittest/googletest/googlemock/include/gmock/* $PATH/$PROJECT_NAME/unittest/googletest/googlemock/include/gmock/gmock/
    /bin/cp $PATH/$PROJECT_NAME/unittest/googletest/googlemock/include/gmock/internal/* $PATH/$PROJECT_NAME/unittest/googletest/googlemock/include/gmock/gmock/internal
    /bin/cp $PATH/$PROJECT_NAME/unittest/googletest/googlemock/include/gmock/internal/custom/* $PATH/$PROJECT_NAME/unittest/googletest/googlemock/include/gmock/gmock/internal/custom

    #生成main的cmakeList
    /bin/cat << EOF > $PATH/$PROJECT_NAME/main/build/CMakeLists.txt
    #win平台执行命令“cmake -G "MinGW Makefiles" .”进行cmake，之后执行命令“mingw32-make”进行make

    #设置项目名称
    #将函数入口,及涉及的所有cpp/c源代码写在参数中，触发cmake进行编译，生成exe可执行文件，一个exe对应一个add_executable 
    MESSAGE(STATUS "Project: "${PROJECT_NAME})

    # 声明cmake工程的名字,同时声明本项目是一个C/C++项目
    project(${PROJECT_NAME} LANGUAGES C CXX)

    # 声明cmake的最低版本
    cmake_minimum_required(VERSION 3.4)
    message(STATUS "Current Cmake Version > VERSION 3.4")

    # 设置CMake的build模式为DEBUG
    SET(CMAKE_BUILD_TYPE "${CMAKE_BUILD_TYPE}")
    MESSAGE("Build type: " ${CMAKE_BUILD_TYPE})

    # 添加c++17标准支持 【可选】
    set(CMAKE_CXX_FLAGS "${CMAKE_CPP_STANDARDS}")
    # 检查C++版本 【可选】
    include(CheckCXXCompilerFlag)
    CHECK_CXX_COMPILER_FLAG("${CMAKE_CPP_STANDARDS}" COMPILER_SUPPORTS_CXX17)
    CHECK_CXX_COMPILER_FLAG("-std=c++0x" COMPILER_SUPPORTS_CXX0X)
    if(COMPILER_SUPPORTS_CXX17)
       set(CMAKE_CXX_FLAGS "${CMAKE_CPP_STANDARDS}")
       add_definitions(-DCOMPILEDWITHC17)
       message(STATUS "Using flag -std=c++17.")
    elseif(COMPILER_SUPPORTS_CXX0X)
       set(CMAKE_CXX_FLAGS "-std=c++0x")
       add_definitions(-DCOMPILEDWITHC0X)
       message(STATUS "Using flag -std=c++0x.")
    else()
       message(FATAL_ERROR "Compiler check failed.")
    endif()

    enable_testing()
    
    # 指定生成的库的名称和源文件
    
    add_library(${PROJECT_NAME} STATIC
       /usr/bin/touch $PATH/$PROJECT_NAME/main/src/$PROJECT_NAME.cpp
    )
    #指定生成的库文件的目标路径
    set(LIBRARY_OUTPUT_PATH $PATH/$PROJECT_NAME/main/lib)
    
    #添加调试信息
    target_compile_options(${PROJECT_NAME} PRIVATE -g)
EOF

    #生成测试代码的CMakelists.txt
    /bin/cat << EOF > $PATH/$PROJECT_NAME/unittest/build/CMakeLists.txt
    #win平台执行命令“cmake -G "MinGW Makefiles" .”进行cmake，之后执行命令“mingw32-make”进行make

    #设置项目名称
    #将函数入口,及涉及的所有cpp/c源代码写在参数中，触发cmake进行编译，生成exe可执行文件，一个exe对应一个add_executable
    MESSAGE(STATUS "Project: "${CMAKE_TEST_PROJECT_NAME})

    # 声明cmake工程的名字,同时声明本项目是一个C/C++项目
    project(${CMAKE_TEST_PROJECT_NAME} LANGUAGES C CXX)

    # 声明cmake的最低版本
    cmake_minimum_required(VERSION 3.4)
    message(STATUS "Current Cmake Version > VERSION 3.4")

    # 设置CMake的build模式为DEBUG
    SET(CMAKE_BUILD_TYPE "Debug")
    MESSAGE("Build type: " ${CMAKE_BUILD_TYPE})

    # 添加c++17标准支持 【可选】
    set(CMAKE_CXX_FLAGS "${CMAKE_CPP_STANDARDS}")
    # 检查C++版本 【可选】
    include(CheckCXXCompilerFlag)
    CHECK_CXX_COMPILER_FLAG("${CMAKE_CPP_STANDARDS}" COMPILER_SUPPORTS_CXX17)
    CHECK_CXX_COMPILER_FLAG("-std=c++0x" COMPILER_SUPPORTS_CXX0X)
    if(COMPILER_SUPPORTS_CXX17)
       set(CMAKE_CXX_FLAGS "${CMAKE_CPP_STANDARDS}")
       add_definitions(-DCOMPILEDWITHC17)
       message(STATUS "Using flag -std=c++17.")
    elseif(COMPILER_SUPPORTS_CXX0X)
       set(CMAKE_CXX_FLAGS "-std=c++0x")
       add_definitions(-DCOMPILEDWITHC0X)
       message(STATUS "Using flag -std=c++0x.")
    else()
       message(FATAL_ERROR "Compiler check failed.")
    endif()

    enable_testing()

    # 指定生成的库的名称和源文件
    #set(LIBRARY_OUTPUT_PATH $PATH/$PROJECT_NAME/unittest/lib)
    set(EXECUTABLE_OUTPUT_PATH ${PATH}/${PROJECT_NAME}/unittest/bin)

    # 指定库代码包含的include头文件目录
    include_directories(${PATH}/${PROJECT_NAME}/unittest/googletest/googletest/include/gtest)
    include_directories(${PATH}/${PROJECT_NAME}/unittest/googletest/googlemock/include/gmock)
    include_directories(${PATH}/${PROJECT_NAME}/unittest/googletest/lib)
    include_directories(${PATH}/${PROJECT_NAME}/unittest/src/include)
    link_directories(${PATH}/${PROJECT_NAME}/unittest/googletest/lib ${PATH}/${PROJECT_NAME}/main/lib ${PATH}/${PROJECT_NAME}/unittest/lib)

    add_executable(${CMAKE_TEST_PROJECT_NAME}
       $PATH/$PROJECT_NAME/unittest/src/$CMAKE_TEST_PROJECT_NAME.cpp
    )
    find_library(gtest libgtest.a ${PATH}/${PROJECT_NAME}/unittest/googletest/lib)
    find_library(gtest_main libgtest_main.a ${PATH}/${PROJECT_NAME}/unittest/googletest/lib)
    find_library(gmock libgmock.a ${PATH}/${PROJECT_NAME}/unittest/googletest/lib)
    find_library(gmock_main libgmock_main.a ${PATH}/${PROJECT_NAME}/unittest/googletest/lib)
    
    #添加调试信息
    target_compile_options(${CMAKE_TEST_PROJECT_NAME} PRIVATE -g)

    #set(GTEST_INCLUDE_DIR ${PATH}/${PROJECT_NAME}/unittest/googletest/_deps/googletest-src/googletest/include/gtest)
    #set(GTEST_LIBRARY ${PATH}/${PROJECT_NAME}/unittest/googletest/lib)
    #set(GTEST_MAIN_LIBRARY ${PATH}/${PROJECT_NAME}/unittest/googletest/lib)

    #find_package(GTest REQUIRED)
    target_link_libraries(
      ${CMAKE_TEST_PROJECT_NAME}
      gtest
      gtest_main
      gmock
      gmock_main
      ${PATH}/${PROJECT_NAME}/main/lib/lib${PROJECT_NAME}.a
    )

    include(googletest)
    gtest_discover_tests(${CMAKE_TEST_PROJECT_NAME})
EOF

#生成代码
/bin/cat << EOF > $PATH/$PROJECT_NAME/main/src/$PROJECT_NAME.cpp
    #include<string>
    class Solution {
    public:
        int romanToInt(std::string s) {
            return 3;
        }
    };
EOF

#生成测试框架代码
    /bin/cat << EOF > $PATH/$PROJECT_NAME/unittest/src/$CMAKE_TEST_PROJECT_NAME.cpp
    #include "../googletest/googletest/include/gtest/gtest.h"
    #include "../googletest/googlemock/include/gmock/gmock.h"
    #include "../../main/src/$PROJECT_NAME.cpp"
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
      EXPECT_EQ(4, s->romanToInt("III"));
    }
EOF
    #编译

    /Applications/CMake.app/Contents/bin/cmake $CMAKE_PARAM -B $PATH/$PROJECT_NAME/main/build/ -S $PATH/$PROJECT_NAME/main/build/
    #使用-C参数强制递归寻找makefile
    /usr/bin/make -C $PATH/$PROJECT_NAME/main/build/

    /Applications/CMake.app/Contents/bin/cmake $CMAKE_PARAM -B $PATH/$PROJECT_NAME/unittest/googletest/ -S $PATH/$PROJECT_NAME/unittest/googletest/
    /usr/bin/make -C $PATH/$PROJECT_NAME/unittest/googletest/

    /Applications/CMake.app/Contents/bin/cmake $CMAKE_PARAM -B $PATH/$PROJECT_NAME/unittest/build/ -S $PATH/$PROJECT_NAME/unittest/build/
    /usr/bin/make -C $PATH/$PROJECT_NAME/unittest/build/
    
    echo "[INFO] create project end."
elif [ $ACTION = "remove" ]; then
    echo "[INFO] remove project start."
    /bin/rm -rf $PATH/$PROJECT_NAME
    echo "[INFO] remove project end."
fi

exit 0
