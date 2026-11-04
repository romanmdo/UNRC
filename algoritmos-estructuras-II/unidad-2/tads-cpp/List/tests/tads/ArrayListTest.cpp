#include <gtest/gtest.h>
#include "../../src/tads/ArrayList.h"

class ArrayListTest : public ::testing::Test {
protected:
    ArrayList<int>* list;

    void SetUp() override {
        list = new ArrayList<int>();
    }

    void TearDown() override {
        delete list;
    }
};

TEST_F(ArrayListTest, TestConstructorCreatesEmptyList) {
    EXPECT_TRUE(list->repOK());
    EXPECT_EQ("[]", list->toString());
}

TEST_F(ArrayListTest, TestAddFinalAndGet) {
    list->addFinal(10);
    list->addFinal(20);
    
    EXPECT_EQ(10, list->getInicio());
    EXPECT_EQ(20, list->getFinal());
    EXPECT_EQ(20, list->getIndice(1));
    EXPECT_EQ("[10, 20]", list->toString());
}

TEST_F(ArrayListTest, TestAddInicioShiftsElements) {
    list->addFinal(20);
    list->addInicio(10);
    
    EXPECT_EQ(10, list->getInicio());
    EXPECT_EQ(20, list->getIndice(1));
    EXPECT_EQ("[10, 20]", list->toString());
}

TEST_F(ArrayListTest, TestRemoveFinal) {
    list->addFinal(10);
    list->addFinal(20);
    
    int removed = list->removeFinal();
    EXPECT_EQ(20, removed);
    EXPECT_EQ("[10]", list->toString());
}

TEST_F(ArrayListTest, TestRemoveInicioShiftsElements) {
    list->addFinal(10);
    list->addFinal(20);
    list->addFinal(30);
    
    int removed = list->removeInicio();
    EXPECT_EQ(10, removed);
    EXPECT_EQ(20, list->getInicio());
    EXPECT_EQ("[20, 30]", list->toString());
}

TEST_F(ArrayListTest, TestContainsAndIndexOf) {
    list->addFinal(5);
    list->addFinal(15);
    
    EXPECT_TRUE(list->contains(15));
    EXPECT_FALSE(list->contains(99));
    
    EXPECT_EQ(1, list->indexOf(15));
    EXPECT_EQ(-1, list->indexOf(99));
}

TEST_F(ArrayListTest, TestDynamicResizing) {
    // Forzamos el redimensionamiento superando la capacidad inicial de 8
    for (int i = 0; i < 10; i++) {
        list->addFinal(i);
    }
    
    EXPECT_TRUE(list->repOK());
    EXPECT_EQ(0, list->getInicio());
    EXPECT_EQ(9, list->getFinal());
}