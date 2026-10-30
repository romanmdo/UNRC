#include <gtest/gtest.h>
#include "ArrayStack.h"
#include "LinkedStack.h"

// Test 1: Comprobar que el constructor crea un Stack vacio[cite: 6]
TEST(StackTest, TestConstructorCreatesEmptyStackRepOK) {
    // Para probar la lista enlazada, simplemente cambia ArrayStack por LinkedStack:
    // Stack<int>* stack = new LinkedStack<int>();[cite: 6]
    Stack<int>* stack = new ArrayStack<int>(); 
    
    std::string abstractSeq = stack->toString();
    
    EXPECT_EQ("[]", abstractSeq);
    EXPECT_TRUE(stack->repOK());
    EXPECT_TRUE(stack->isEmpty());
    EXPECT_EQ(0, stack->size());
    
    delete stack;
}

// Test 2: Comprobar el push de dos elementos[cite: 6]
TEST(StackTest, TestPushTwoElementsRepOK) {
    Stack<int>* stack = new ArrayStack<int>(); 
    
    stack->push(1);
    stack->push(2);
    
    std::string abstractSeq = stack->toString();
    
    EXPECT_EQ("[1, 2]", abstractSeq);
    EXPECT_TRUE(stack->repOK());
    EXPECT_EQ(2, stack->top());
    
    delete stack;
}

// Test 3: Comprobar el pop
TEST(StackTest, TestPopReturnsTopAndReducesSize) {
    Stack<int>* stack = new ArrayStack<int>();
    
    stack->push(10);
    stack->push(20);
    
    int poppedItem = stack->pop();
    
    EXPECT_EQ(20, poppedItem);
    EXPECT_EQ(1, stack->size());
    EXPECT_EQ("[10]", stack->toString());
    EXPECT_TRUE(stack->repOK());
    
    delete stack;
}