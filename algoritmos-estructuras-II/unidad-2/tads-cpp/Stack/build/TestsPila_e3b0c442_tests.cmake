add_test([=[StackTest.TestConstructorCreatesEmptyStackRepOK]=]  /home/romanmdo/Escritorio/UNRC/algoritmos-estructuras-II/unidad-2/tads-cpp/Stack/build/TestsPila [==[--gtest_filter=StackTest.TestConstructorCreatesEmptyStackRepOK]==] --gtest_also_run_disabled_tests)
set_tests_properties([=[StackTest.TestConstructorCreatesEmptyStackRepOK]=]
  PROPERTIES
    
    DEF_SOURCE_LINE [==[/home/romanmdo/Escritorio/UNRC/algoritmos-estructuras-II/unidad-2/tads-cpp/Stack/tests/tads/StackTest.cpp:6]==]
    WORKING_DIRECTORY [==[/home/romanmdo/Escritorio/UNRC/algoritmos-estructuras-II/unidad-2/tads-cpp/Stack/build]==]
    SKIP_REGULAR_EXPRESSION [==[\[  SKIPPED \]]==]
    
)
add_test([=[StackTest.TestPushTwoElementsRepOK]=]  /home/romanmdo/Escritorio/UNRC/algoritmos-estructuras-II/unidad-2/tads-cpp/Stack/build/TestsPila [==[--gtest_filter=StackTest.TestPushTwoElementsRepOK]==] --gtest_also_run_disabled_tests)
set_tests_properties([=[StackTest.TestPushTwoElementsRepOK]=]
  PROPERTIES
    
    DEF_SOURCE_LINE [==[/home/romanmdo/Escritorio/UNRC/algoritmos-estructuras-II/unidad-2/tads-cpp/Stack/tests/tads/StackTest.cpp:22]==]
    WORKING_DIRECTORY [==[/home/romanmdo/Escritorio/UNRC/algoritmos-estructuras-II/unidad-2/tads-cpp/Stack/build]==]
    SKIP_REGULAR_EXPRESSION [==[\[  SKIPPED \]]==]
    
)
add_test([=[StackTest.TestPopReturnsTopAndReducesSize]=]  /home/romanmdo/Escritorio/UNRC/algoritmos-estructuras-II/unidad-2/tads-cpp/Stack/build/TestsPila [==[--gtest_filter=StackTest.TestPopReturnsTopAndReducesSize]==] --gtest_also_run_disabled_tests)
set_tests_properties([=[StackTest.TestPopReturnsTopAndReducesSize]=]
  PROPERTIES
    
    DEF_SOURCE_LINE [==[/home/romanmdo/Escritorio/UNRC/algoritmos-estructuras-II/unidad-2/tads-cpp/Stack/tests/tads/StackTest.cpp:38]==]
    WORKING_DIRECTORY [==[/home/romanmdo/Escritorio/UNRC/algoritmos-estructuras-II/unidad-2/tads-cpp/Stack/build]==]
    SKIP_REGULAR_EXPRESSION [==[\[  SKIPPED \]]==]
    
)
set(TestsPila_TESTS [==[StackTest.TestConstructorCreatesEmptyStackRepOK]==] [==[StackTest.TestPushTwoElementsRepOK]==] [==[StackTest.TestPopReturnsTopAndReducesSize]==])
