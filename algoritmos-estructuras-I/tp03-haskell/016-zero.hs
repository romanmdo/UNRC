zeros a 0 = True
zeros a n = zeros a (n -1) && ( a !!( n -1) == 0)

{-  Salidas de la terminal
    zeros [0,2,0] 3 = False 
    zeros [0,0,3] 2 = True
    zeros [0,0,0,0] 4 = True
-}