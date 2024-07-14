    #win平台执行命令“cmake -G "MinGW Makefiles" .”进行cmake，之后执行命令“mingw32-make”进行make

    #设置项目名称
    #将函数入口,及涉及的所有cpp/c源代码写在参数中，触发cmake进行编译，生成exe可执行文件，一个exe对应一个add_executable 
    MESSAGE(STATUS "Project: "leetcode_13)

    # 声明cmake工程的名字,同时声明本项目是一个C/C++项目
    project(leetcode_13 LANGUAGES C CXX)

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
    
    add_library(leetcode_13 STATIC
       /usr/bin/touch /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/main/src/leetcode_13.cpp
    )
    #指定生成的库文件的目标路径
    set(LIBRARY_OUTPUT_PATH /Users/zeck/learning/CppPro/workdir/Algorithm_Excersize/Cpp/leetcode_13/main/lib)
    
    #添加调试信息
    target_compile_options(leetcode_13 PRIVATE -g)
