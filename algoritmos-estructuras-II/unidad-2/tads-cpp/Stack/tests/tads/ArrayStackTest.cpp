#include <gtest/gtest.h>
#include "ArrayStack.h"

// Test del Constructor: Genera un objeto que representa la secuencia vacía []
TEST(ArrayStackTest, TestConstructorCreatesEmptyStack) {
    Stack<int>* stack = new ArrayStack<int>(); 
    
    EXPECT_EQ("[]", stack->toString());
    EXPECT_TRUE(stack->repOK());
    EXPECT_TRUE(stack->isEmpty());
    EXPECT_EQ(0, stack->size());
    
    delete stack;
}

// Test de Push: Agrega elementos y verifica la secuencia abstracta
TEST(ArrayStackTest, TestPushElementsRepOK) {
    Stack<int>* stack = new ArrayStack<int>(); 
    
    stack->push(1);
    stack->push(2);
    
    EXPECT_EQ("[1, 2]", stack->toString());
    EXPECT_TRUE(stack->repOK());
    EXPECT_FALSE(stack->isEmpty());
    EXPECT_EQ(2, stack->size());
    
    delete stack;
}

// Test de Top: Devuelve el último elemento sin sacarlo
TEST(ArrayStackTest, TestTopReturnsLastElement) {
    Stack<int>* stack = new ArrayStack<int>(); 
    stack->push(10);
    stack->push(20);
    
    EXPECT_EQ(20, stack->top());
    EXPECT_EQ(2, stack->size()); // El tamaño no debe cambiar
    EXPECT_TRUE(stack->repOK());
    
    delete stack;
}

// Test de Pop: Remueve y devuelve el último elemento
TEST(ArrayStackTest, TestPopRemovesTopElement) {
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

// Test de Excepciones: Pop en pila vacía
TEST(ArrayStackTest, TestPopEmptyStackThrowsException) {
    Stack<int>* stack = new ArrayStack<int>();
    
    EXPECT_THROW(stack->pop(), std::invalid_argument);
    
    delete stack;
}