module Queue(Queue, emptyQ, enqueue, dequeue, first, isEmpty) where

data Queue a = Q [a] [a] deriving (Show, Eq)

emptyQ :: Queue a
emptyQ = Q [] []

enqueue :: a -> Queue a -> Queue a
enqueue x (Q a1 a) = Q (x : a1) a2

dequeue :: Queue a -> Queue a
dequeue (Q [] []) = error "Cola vacia"
dequeue (Q inbox (y:ys)) = (y, Q inbox ys)
dequeue (Q inbox []) = dequeue (Q [] (reverse inbox))

first :: Queue a -> a
first (Q [] []) = error "Cola vacia"
first (Q _ (y:_)) = y
first (Q inbox []) = head (reverse inbox)