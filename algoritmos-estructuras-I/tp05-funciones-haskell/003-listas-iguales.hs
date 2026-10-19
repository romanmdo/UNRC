listasIguales :: Eq a => [a] -> [a] -> Bool
listasIguales [] [] = True
listasIguales (x:xs) (y:ys) = 
    if x == y 
        then listasIguales xs ys 
        else False
        
        