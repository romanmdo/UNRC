miIf :: Bool -> a -> a -> a
miIf True x y = x
miIf False x y = y

inf :: Int
inf = inf + 1

square :: Int -> Int
square x = x * x

{-
    a) Evaluación Aplicativa: 
        miIf (2 <= 4) (3+3) (1/0)
        = miIf (2 <= 4) (3+3) 
        = Error: no se puede evaluar (1/0)

    b) Evaluación Aplicativa: 
        miIf (inf == inf) (2*2) (square 9)
        = Error: no termina (inf == inf)

    a) Evaluación Normal:
        miIf (2 <= 4) (3+3) (1/0)
        = miIf True (3+3) 
        = miIf True 6
        = 6

    b) Evaluación Normal:
        miIf (inf == inf) (2*2) (square 9)
        = Error: no termina (inf == inf)
-}