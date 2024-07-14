    #win平台执行命令“cmake -G "MinGW Makefiles" .”进行cmake，之后执行命令“mingw32-make”进行make

    #设置项目名称
    #将函数入口,及涉及的所有cpp/c源代码写在参数中，触发cmake进行编译，生成exe可执行文件，一个exe对应一个add_executable
    MESSAGE(STATUS "Project: "test_leetcode_13)

    # 声明cmake工程的名字,同时声明本项目是一个C/C++项目
    project(test_leetcode_13 LANGUAGES C CXX)

    # 声明cmake的最低版本
    cmake_minimum_required(VERSION 3.4)
    message(STATUS "Current Cmake Version > VERSION 3.4")

    # 设置CMake的build模式为DEBUG
    SET(CMAKE_BUILD_TYPE "Debug")
    MESSAGE("Build type: " Debug)

    # 添加c++17标准支持 【可选】
    set(CMAKE_CXX_FLAGS " -std=c++17")
    # 检查C++版本 【可选】
    include(CheckCXXCompilerFlag)
    CHECK_CXX_COMPILER_FLAG(" -std=c++17" COMPILER_SUPPORTS_CXX17)
    CHECK_CXX_COMPILER_FLAG("-std=c++0x" COMPILER_SUPPORTS_CXX0X)
    if(COMPILER_SUPPORTS_CXX17)
       set(CMAKE_CXX_FLAGS " -std=c++17")
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
    #set(LIBRARY_OUTPUT_PATH /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/lib)
    set(EXECUTABLE_OUTPUT_PATH /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/bin)

    # 指定库代码包含的include头文件目录
    include_directories(/Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/googletest/include/gtest)
    include_directories(/Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/googlemock/include/gmock)
    include_directories(/Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/lib)
    include_directories(/Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/src/include)
    link_directories(/Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/lib /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/main/lib /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/lib)

    add_executable(test_leetcode_13
       /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/src/test_leetcode_13.cpp
    )
    find_library(gtest libgtest.a /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/lib)
    find_library(gtest_main libgtest_main.a /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/lib)
    find_library(gmock libgmock.a /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/lib)
    find_library(gmock_main libgmock_main.a /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/lib)
    
    #添加调试信息
    target_compile_options(test_leetcode_13 PRIVATE -g)

    #set(GTEST_INCLUDE_DIR /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/_deps/googletest-src/googletest/include/gtest)
    #set(GTEST_LIBRARY /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/lib)
    #set(GTEST_MAIN_LIBRARY /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/unittest/googletest/lib)

    #find_package(GTest REQUIRED)
    target_link_libraries(
      test_leetcode_13
      gtest
      gtest_main
      gmock
      gmock_main
      /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/main/lib/libleetcode_13.a
    )

    include(googletest)
    gtest_discover_tests(test_leetcode_13)
