module List (List, empty, isEmpty, length, get, add, remove) where

newtype List a = Lst [a] deriving (Show, Eq)

empty :: List a
empty = Lst []

isEmpty :: List a -> Bool
isEmpty (Lst []) = True
isEmpty _ = False

length :: List a -> Int
length (Lst xs) = length xs

get :: Int -> List a -> a
get i (Lst xs)
    | 0 > i || i >= length xs = error "Indice fuera de rango"
    | otherwise = xs !! i

add :: Int -> a -> List a -> List a
add i elem (Lst xs)
    | 0 > i || i >= length xs = error "Indice fuera de rango"
    | otherwise = Lst (left ++ (elem : right))

remove :: Int -> a -> List a -> (a, List a)
remove i (Lst xs)
    | 0 > i || i >= length xs = error "Indice fuera de rango"
    | otherwise = (xs !! i, Lst (left ++ tail right))
    where
        (left, right) = splitAt i xs