primerosDos :: [a] -> [a]
primerosDos [] = []
primerosDos [x] = [x]
primerosDos (x:y:_) = [x,y]