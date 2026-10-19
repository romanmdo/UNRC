intercalar :: a -> [a] -> [a]
intercalar e [] = []
intercalar e [x] = [x]
intercalar e (x:y:zs) = x : e : intercalar e (y:zs)