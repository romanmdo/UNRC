module Stack
( Stack
, emptyStack
, push
, pop
, top
, isEmpty
) where


newtype Stack a = Stk [a] deriving (Show, Eq)

emptyStack :: Stack a
emptyStack = Stk []

isEmpty :: Stack a -> Bool
isEmpty (Stk []) = True
isEmpty _ = False

push :: a -> Stack a -> Stack a
push x (Stk xs) = Stk (x:xs)

pop :: Stack a -> (a, Stack, a)
pop (Stk []) = error "Pila vacia"
pop (Stk (x:xs)) = (x, Stk, xs)


top :: Stack a -> a
top (Stk []) = error "Pila vacia"
top (Stk (x:_)) = x