#ifndef ARRAYLIST_H
#define ARRAYLIST_H

#include <stdexcept>
#include <sstream>
#include <string>

template <typename T>
class ArrayList {
private:
    T* array_;
    int size_;
    int capacity_;

    void resize(int newCapacity) {
        // TODO: Implementar lógica
    }

public:
    ArrayList() {
        capacity_ = 8;
        array_ = new T[capacity_];
        size_ = 0;
    }

    ~ArrayList() {
        delete[] array_;
    }

    T setInicio(T e) {
        T dato = array_[0];
        array_[0] = e;
        return dato;
    }

    T setIndice(int indice, T e) {
        if (indice >= size_ || indice < 0) {
            throw std::out_of_range("Error, indice no valido.");
        }
        T dato = array_[indice];
        array_[indice] = e;
        return dato;
    }

    T setFinal(T e) {
        T dato = array_[size_ - 1];
        array_[size_ - 1] = e;
        return dato;
    }

    T getInicio() const {
        return array_[0];
    }

    T getIndice(int indice) const {   
        if (indice >= size_ || indice < 0) {
            throw std::out_of_range("Error, indice no valido.");
        }
        return array_[indice];
    }

    T getFinal() const {
        return array_[size_ - 1];
    }

    void addInicio(T e) {
        if (size_ == capacity_) {
            throw std::out_of_range("Error, lista llena.");
        }
        for (int i = size_ - 1; i >= 0 ; i--) {
            array_[i + 1] = array_[i];
        }
        array_[0] = e;
        size_++;
    }

    void addIndice(int indice, T e) {   
        if (size_ == capacity_) {
            throw std::out_of_range("Error, lista llena.");
        }
        if (indice > size_ || indice < 0) {
            throw std::out_of_range("Error, indice no valido.");
        }
        for (int i = size_ - 1; i >= indice; i--) {
            array_[i + 1] = array_[i];
        }
        array_[indice] = e;
        size_++;
    }

    void addFinal(T e) {
        if (size_ == capacity_) {
            throw std::out_of_range("Error, lista llena.");
        }
        array_[size_] = e;
        size_++;
    }

    T removeInicio() {   
        if (size_ == 0) {
            throw std::out_of_range("Error, lista vacia.");
        }
        T dato = array_[0];
        for (int i = 0; i < size_ - 1; i++) {
            array_[i] = array_[i + 1];
        }
        size_--;
        return dato;
    }

    T removeIndice(int indice) {   
        if (size_ == 0) {
            throw std::out_of_range("Error, lista vacia.");
        }
        if (indice >= size_ || indice < 0) {
            throw std::out_of_range("Error, indice no valido.");
        }
        T dato = array_[indice];
        for (int i = indice; i < size_ - 1; i++) {
            array_[i] = array_[i + 1];
        }
        size_--;
        return dato;
    }

    T removeFinal() {   
        if (size_ == 0) {
            throw std::out_of_range("Error, lista vacia.");
        }
        T dato = array_[size_ - 1];
        size_--;
        return dato;
    }

    bool removeSearch(T e) {
        if (size_ == 0) {
            throw std::out_of_range("Error, lista vacia.");
        }
        for (int i = 0; i < size_; i++) {
            if (array_[i] == e) {
                removeIndice(i);
                return true;
            }
        }
        return false;
    }

    bool contains(T e) const {
        for (int i = 0; i < size_; i++) {
            if (array_[i] == e) {
                return true;
            }
        }
        return false;
    }

    int indexOf(T e) const {
        for (int i = 0; i < size_; i++) {
            if (array_[i] == e) {
                return i;
            }
        }
        return -1;
    }

    std::string toString() const {
        std::stringstream ss;
        ss << "[";
        for (int i = 0; i < size_; i++) {
            ss << array_[i];
            if (i < size_ - 1) {
                ss << ", ";
            }
        }
        ss << "]";
        return ss.str();
    }

    bool repOK() const {
        if (size_ < 0 || size_ > capacity_) {
            return false;
        }
        return true;
    }
};

#endif