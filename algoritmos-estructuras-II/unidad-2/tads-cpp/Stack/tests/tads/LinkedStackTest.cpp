#include <gtest/gtest.h>
#include "LinkedStack.h"

// Reutilizamos la misma lógica de los tests anteriores, 
// solo debemos reemplazar la construcción de los objetos[cite: 2].

TEST(LinkedStackTest, TestConstructorCreatesEmptyStack) {
    Stack<int>* stack = new LinkedStack<int>(); 
    
    EXPECT_EQ("[]", stack->toString());
    EXPECT_TRUE(stack->repOK());
    EXPECT_TRUE(stack->isEmpty());
    EXPECT_EQ(0, stack->size());
    
    delete stack;
}

TEST(LinkedStackTest, TestPushElementsRepOK) {
    Stack<int>* stack = new LinkedStack<int>(); 
    
    stack->push(1);
    stack->push(2);
    
    EXPECT_EQ("[1, 2]", stack->toString());
    EXPECT_TRUE(stack->repOK());
    EXPECT_FALSE(stack->isEmpty());
    EXPECT_EQ(2, stack->size());
    
    delete stack;
}

TEST(LinkedStackTest, TestTopReturnsLastElement) {
    Stack<int>* stack = new LinkedStack<int>(); 
    stack->push(10);
    stack->push(20);
    
    EXPECT_EQ(20, stack->top());
    EXPECT_EQ(2, stack->size());
    EXPECT_TRUE(stack->repOK());
    
    delete stack;
}

TEST(LinkedStackTest, TestPopRemovesTopElement) {
    Stack<int>* stack = new LinkedStack<int>();
    stack->push(10);
    stack->push(20);
    
    int poppedItem = stack->pop();
    
    EXPECT_EQ(20, poppedItem);
    EXPECT_EQ(1, stack->size());
    EXPECT_EQ("[10]", stack->toString());
    EXPECT_TRUE(stack->repOK());
    
    delete stack;
}

TEST(LinkedStackTest, TestPopEmptyStackThrowsException) {
    Stack<int>* stack = new LinkedStack<int>();
    
    EXPECT_THROW(stack->pop(), std::invalid_argument);
    
    delete stack;
}