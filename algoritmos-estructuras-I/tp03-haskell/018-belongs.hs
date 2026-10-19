{- Ejercicio 18: 
    Lo que hace la funcion belongs, del ejercicio 18, es agarrar dos parametros, un numero (n) y una lista de enteros
    entonces, la funcion lo que hace es ver si el parametro/numero (n) pertenece a la lista. Si el parametro pertenece
    devuelve true, si no, devuelve false. 

    Llamadas a la funcion: 
        - belongs 4 [2, 1, 3, 5, 4] = True
        - belongs 4 [2, 1, 3, 5] = False
-}

belongs :: Integer -> [Integer] -> Bool
belongs e [] = False
belongs e ( a : as ) = belongs e as || ( a == e )