pertenece :: Eq a => a -> [a] -> Bool
pertenece _ [] = False
pertenece z (x:xs) = 
    if z == x
        then True
        else pertenece z xs
