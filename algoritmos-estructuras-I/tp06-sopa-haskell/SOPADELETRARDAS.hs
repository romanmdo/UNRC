module SopaDeLetras where

-- =========================================
-- Tipos de Datos empleados para modelar el problema
-- =========================================

type Posicion = (Int, Int)
type Letra = Char
type Casilla = (Posicion, Letra)
type Grilla = [[Casilla]] -- Grilla[filas][columnas]

-- =========================================
-- Construcción y visualización
-- =========================================

{-
 - Construye una fila de la Grilla
 - Parámetros: -  n: Número de la fila a construir
 -  xs: String que representa la fila
 -
 - Retorna: Listado de casillas que forman la fila
 -
 - Ejemplo: construirFilaGrilla 1 "HOLA" = [((1,0),'H'),((1,1),'O'),((1,2),'L'),((1,3),'A')]
 -}
construirFilaGrilla :: Int -> String -> [Casilla]
construirFilaGrilla n fila = [ ((n, j), letra) | (j, letra) <- zip [0..] fila]


{-
 - Construye una grilla con coordenadas
 - Parámetros:
 -  filas: String que representan las filas a usar en la grilla
 -
 - Retorna: Representación de las filas en formato Grilla
 -
 - Ejemplo: construirGrilla ["HOLA", "CHAU", "CASA"]
 -  Construye: 
    [
      [((0,0),'H'),((0,1),'O'),((0,2),'L'),((0,3),'A')],
      [((1,0),'C'),((1,1),'H'),((1,2),'A'),((1,3),'U')],
      [((2,0),'C'),((2,1),'A'),((2,2),'S'),((2,3),'A')]
    ]
-}

construirGrilla :: [String] -> Grilla
construirGrilla filas = [ construirFilaGrilla n fila | (n, fila) <- zip [0..] filas ]

-- Dibuja una fila con bordes
filaConBordes :: String -> [Casilla] -> String
filaConBordes borde fila =
  borde ++ "\n" ++
  concatMap (\(_, letra) -> "| " ++ [letra] ++ " ") fila ++ "|" 


-- Muestra la grilla con líneas y bordes
mostrarGrilla :: Grilla -> IO ()
mostrarGrilla grilla = do
  putStrLn "Grilla:"
  let nCols = length (head grilla)
      borde = "+" ++ concat (replicate nCols "---+")  -- línea superior/inferior
  mapM_ (putStrLn . filaConBordes borde) grilla
  putStrLn borde


-- =========================================
-- Transformaciones de grilla
-- =========================================

{-
 - Calcula la Traspuesta de la grilla conservando las posiciones originales (es decir intercambia filas ↔ columnas)
 - Parámetros:
 -  grila: Grilla a la que se le calcula la traspuesta
 -
 - Retorna: Grilla traspuesta
 -
 - Ejemplo: 
 -  g = [
      [((0,0),'H'),((0,1),'O'),((0,2),'L'),((0,3),'A')],
      [((1,0),'C'),((1,1),'H'),((1,2),'A'),((1,3),'U')]
    ]

    trasponerGrilla g = [
      [((0,0),'H'),((1,0),'C')],
      [((0,1),'O'),((1,1),'H')],
      [((0,2),'L'),((1,2),'A')],
      [((0,3),'A'),((1,3),'U')]
    ]

    trasponerGrilla g = [[((0,0),'H'),((1,0),'C')], [((0,1),'O'),((1,1),'H')], [((0,2),'L'),((1,2),'A')], [((0,3),'A'),((1,3),'U')]]

    Pseudocodigo: Si el 2do elemento de la tupla, es igual a algun elemento de otra tupla de las otras listas, entonces meter 
    esa x cantidad de tuplas en una lista.
-}

trasponerGrilla :: Grilla -> Grilla
trasponerGrilla [] = []
trasponerGrilla ([]:_) = []
trasponerGrilla grilla = 
    let nuevaFila = map head grilla
        restoGrilla = map tail grilla
    in
    nuevaFila : (trasponerGrilla restoGrilla)


{-
 - Calcula el espejo de la grilla conservando las posiciones originales
 - Parámetros:
 -  grila: Grilla a la que se le calcula el espejo
 -
 - Retorna: Grilla espejo
 -
 - Ejemplo: 
 -  g = [
      [((0,0),'H'),((0,1),'O'),((0,2),'L'),((0,3),'A')],
      [((1,0),'C'),((1,1),'H'),((1,2),'A'),((1,3),'U')]
    ]

    espejarGrilla g = [
      [((0,3),'A'),((0,2),'L'),((0,1),'O'),((0,0),'H')],
      [((1,3),'U'),((1,2),'A'),((1,1),'H'),((1,0),'C')]
    ]
-}

espejarGrilla :: Grilla -> Grilla
espejarGrilla [] = []
espejarGrilla grilla = 
    let 
      reverseCabeza = reverse (head grilla)
      reverseCola =  tail grilla
    in 
      reverseCabeza : espejarGrilla reverseCola

{-
 - Calcula las diagonales izquierdas->derecha de una Grilla
 - Debe conservar las posiciones originales de las Casillas y omitir las diagonales de longitud 1.
 - NOTA: El orden en el que se calculan es indistinto.
 -
 - Parámetros:
 -  grilla: Grilla a diagonalizar
 -
 - Retorna: lista de diagonales
 -
 - Ejemplo:
 - g =
    +---+---+---+---+
    | H | O | L | A |
    +---+---+---+---+
    | Q | U | E | M |
    +---+---+---+---+
    | C | O | M | O |
    +---+---+---+---+
    | O | T | A | R |
    +---+---+---+---+

    diagonalizarDesdeIzquierdaGrilla g = [
      [((0,0),'H'),((1,1),'U'),((2,2),'M'),((3,3),'R')],    // 
      [((1,0),'Q'),((2,1),'O'),((3,2),'A')],                //Inferiores a diag principal
      [((2,0),'C'),((3,1),'T')],
      [((0,1),'O'),((1,2),'E'),((2,3),'O')],                //Superiores a diag principal
      [((0,2),'L'),((1,3),'M')]
    ]
-}

diagonalizarDesdeIzquierdaGrilla :: Grilla -> [[Casilla]]
diagonalizarDesdeIzquierdaGrilla grilla = filter (\f -> length f > 1) diagonales
  where 
    -- "Aplanamos" la lista, entonces en vez de ser 
    -- : [ [((0,0),'N'), ((0,1),'O')], [((1,0),'Q'), ((1,1),'U')] ] (Tipo: [[Casilla]])
    -- Nos queda como
    -- : [ ((0,0),'N'), ((0,1),'O'), ((1,0),'Q'), ((1,1),'U') ] (Tipo: [Casilla])
    listaPlana = concat grilla

    -- En esta funcion auxiliar, necesitamos obtener la clave de la diagonal
    -- La clave es lo que decide si la diagonal es inferior/superior o es la diagonal principal
    -- Suponiendo que tenemos (n,m), para obtener la clave deberemos hacer n - m, esto nos va a dar 
    -- la clave.
    claveDiagonal :: Casilla -> Int
    claveDiagonal ((fila, col), _) = fila - col

    -- Variable auxiliar para almacenar todas las claves diagonales
    todasLasClaves = map claveDiagonal listaPlana

    -- Variable local para almacenar SOLO las claves unicas
    -- Uitulizadon 'eliminarRepetidos' definida con anterioridad, 
    -- eliminamos las claves repetidas
    clavesUnicas = eliminarRepetidos todasLasClaves

    diagonales = [ [cas | cas <- listaPlana, claveDiagonal cas == k] | k <- clavesUnicas ]

    
-- =========================================
-- Funciones auxiliares Subsegmentos
-- =========================================

{-
 - Elimina los elementos repetidos de una lista
 - Parámetros:
 -  xs: Lista a usar
 -
 - Retorna: lista sin los elementos repetidos
 - 
 - Ejemplo:
 -  eliminarRepetidos [1,2,3,4,5,1,8,3] = [1,2,3,4,5,8]
-}

eliminarRepetidos :: Eq a => [a] ->[a]
eliminarRepetidos [] = []
eliminarRepetidos [x] = [x]
eliminarRepetidos (x:xs) = 
  if elem x xs 
    then eliminarRepetidos xs 
    else x : eliminarRepetidos xs


{-
 - Calcula todos los subsegmentos de una lista
 - NOTA: El orden en el que se calculan es indistinto.
 - Parámetros:
 -  xs: Lista a usar
 -
 - Retorna: lista de subsegmentos (sin repetidos)
 - 
 - Ejemplo:
 -  subSegmentos [1,2,3,4] = [[],[1],[1,2],[1,2,3],[1,2,3,4],[2],[2,3],[2,3,4],[3],[3,4],[4]]
-}

subSegmentos :: Eq a => [a] -> [[a]]
subSegmentos xs =  eliminarRepetidos [take tamaño (drop comienzo xs) | comienzo <- [0..length xs], tamaño <- [0..length xs - comienzo]]

-- =========================================
-- Calcular Líneas de Grillas
-- =========================================

{-
 - Calcula la lista de filas de una Grilla (conserva las posiciones originales de las casillas)
 - Parámetros:
 -  grilla: Grilla a obtener sus filas
 -
 - Retorna: listado de filas - por definición usada de Grilla es igual al input.
-}

filasGrilla :: Grilla -> [[Casilla]]
filasGrilla grilla = grilla


{-
 - Calcula la lista de columnas de una Grilla (conserva las posiciones originales de las casillas)
 - Parámetros:
 -  grilla: Grilla a obtener sus columnas
 -
 - Retorna: listado de columnas
 -
 - Ejemplo:
 -  g = [
      [((0,0),'C'),((0,1),'S'),((0,2),'I'),((0,3),'S')],
      [((1,0),'A'),((1,1),'R'),((1,2),'E'),((1,3),'A')],
      [((2,0),'M'),((2,1),'C'),((2,2),'X'),((2,3),'O')],
      [((3,0),'A'),((3,1),'M'),((3,2),'A'),((3,3),'M')]
    ]
    
    columnasGrilla g = [
      [((0,0),'C'),((1,0),'A'),((2,0),'M'),((3,0),'A')],
      [((0,1),'S'),((1,1),'R'),((2,1),'C'),((3,1),'M')],
      [((0,2),'I'),((1,2),'E'),((2,2),'X'),((3,2),'A')],
      [((0,3),'S'),((1,3),'A'),((2,3),'O'),((3,3),'M')]
    ]
-}

columnasGrilla :: Grilla -> [[Casilla]]
columnasGrilla grilla = trasponerGrilla grilla


{-
 - Calcula la lista de diagonales de izq->der y der->izq de una Grilla (conserva las posiciones originales de las casillas)
 - Parámetros:
 -  grilla: Grilla a obtener sus diagonales
 -
 - Retorna: listado de diagonales
 -
 - Ejemplo: ver ejemplo de diagonalizarDesdeIzquierdaGrilla()

 - Ejemplo de antes: 
 - g = 
 - g =
    +---+---+---+---+
    | H | O | L | A |
    +---+---+---+---+
    | Q | U | E | M |
    +---+---+---+---+
    | C | O | M | O |
    +---+---+---+---+
    | O | T | A | R |
    +---+---+---+---+

    diagonalizarDesdeIzquierdaGrilla g = [
      [((0,0),'H'),((1,1),'U'),((2,2),'M'),((3,3),'R')],    // 
      [((1,0),'Q'),((2,1),'O'),((3,2),'A')],                //Inferiores a diag principal
      [((2,0),'C'),((3,1),'T')],
      [((0,1),'O'),((1,2),'E'),((2,3),'O')],                //Superiores a diag principal
      [((0,2),'L'),((1,3),'M')]
    ]

-}

diagonalesGrilla :: Grilla -> [[Casilla]]
diagonalesGrilla grilla = diagIzq ++ diagDer
  where diagIzq = diagonalizarDesdeIzquierdaGrilla grilla
        diagDer = diagonalizarDesdeDerechaGrilla grilla 


diagonalizarDesdeDerechaGrilla :: Grilla -> [[Casilla]]
diagonalizarDesdeDerechaGrilla grilla = filter (\f -> length f > 1) diagonales
  where 
    -- Simplemente, utilizamos el mismo algoritmo que el diagonales izquierda pero
    -- cambiamos algo...

    listaPlana = concat grilla

    -- Lo que cambiamos fue el patron para detectar la clave diagonal
    -- en diagonalizarDesdeIzquierdaGrilla hacianos fila - columna,
    -- aca hacemos fila + columna para detectar la clave
    -- teniendo en cuenta (n, m) = n + m
    claveDiagonal :: Casilla -> Int
    claveDiagonal ((fila, col), _) = fila + col

    todasLasClaves = map claveDiagonal listaPlana
    clavesUnicas = eliminarRepetidos todasLasClaves

    diagonales = [ [cas | cas <- listaPlana, claveDiagonal cas == k] | k <- clavesUnicas ]


{-
 - Calcula la lista de todas las lineas de una Grilla.
 - Es decir, une el listado de filas, columnas, diagonales izq->der y diagonales der->izq, junto a las reversas de todas ellas.
-}
todasLasLineas :: Grilla -> [[Casilla]]
todasLasLineas g = lineas ++ lineasReversas
  where lineas = (filasGrilla g) ++ (columnasGrilla g) ++ (diagonalesGrilla g)
        lineasReversas = map (reverse) (lineas)


-- =========================================
-- Búsqueda de palabras
-- =========================================

-- Tipo de Dato que representa el resultado final (Palabra, Posición casilla de inicio, Posición casilla de fin)
type Resultado = (String, Posicion, Posicion)


{-
 - Calcula todas las ocurrencias de una palabra en una linea (es indistinto si es linea horizontal, vertical o diagonal)
 - Parámetros:
 -  palabra: String que representa la palabra a buscar
 -  linea: lista de casillas con sus posiciones iniciales que representan la línea
 -
 - Retorna: lista de Resultados. Un resultado incluye: la palabra, posición de la primera letra y posición de la última letra (según las originales)
 -          En caso que no se encuentre la palabra retornar lista vacía.
 -          Si existe más de una ocurrencia, el orden en el que se listan es indistinto.
 - 
 - Ejemplo:
 -  buscarEnLinea "MA" [((1,0),'M'),((1,1),'A'),((1,2),'M'),((1,3),'A')] = [
      ("MA",(1,0),(1,1)),    //Primera ocurrencia
      ("MA",(1,2),(1,3))     //Segunda ocurrencia
    ]
-}

buscarEnLinea :: String -> [Casilla] -> [Resultado]
buscarEnLinea palabra [] = []
buscarEnLinea "" _ = []
buscarEnLinea palabra linea = 
  if palabra == (map getLetra (take n linea))
    then
      let
        posInicio = getPos (head (take n linea)) 
        posFinal = getPos (last (take n linea))
        miResultado = (palabra, posInicio, posFinal)
      in
        miResultado : buscarEnLinea palabra (tail linea)
    else 
      buscarEnLinea palabra (tail linea)
  where
    n = length palabra

getLetra :: Casilla -> Char
getLetra ((_, _), letra) = letra

getPos :: Casilla -> (Int, Int)
getPos (pos,_) = pos

-- Busca una palabra en todas las líneas (filas, columnas, diagonales, reversas de todas) de la grilla
buscarPalabra :: Grilla -> String -> [Resultado]
buscarPalabra grilla palabra = concatMap (buscarEnLinea palabra) (todasLasLineas grilla)


{-
 - Resuelve una sopa de letras
 - Parámetros:
 -  grilla: Grilla que representa a la sopa de letras a resolver
 -  palabras: Listado de palabras a buscar en la sopa de letras
 - 
 - Retorna: Lista de todas las ocurrencias de las palabras buscadas, es decir: indica posición de inicio y fin de cada palabra.
 - Si existe más de una ocurrencia debe ser calculada también, no deben calcularse resultados repetidos.
 - Si no existe una ocurrencia de la palabra, se debe omitir del resultado.
 - El orden de los resultados finales es indistinto.
 -
 - Ejemplo:
 - g =  +---+---+---+---+
        | C | S | I | S |
        +---+---+---+---+
        | A | R | E | A |
        +---+---+---+---+
        | M | C | X | O |
        +---+---+---+---+
        | A | M | A | M |
        +---+---+---+---+
  La misma grilla con posiciones:
   g = [
        [((0,0),'C'),((0,1),'S'),((0,2),'I'),((0,3),'S')],
        [((1,0),'A'),((1,1),'R'),((1,2),'E'),((1,3),'A')],
        [((2,0),'M'),((2,1),'C'),((2,2),'X'),((2,3),'O')],
        [((3,0),'A'),((3,1),'M'),((3,2),'A'),((3,3),'M')]
      ]

   Dadas las palabras: ["MAMA","CAMA","SI","SECA","AMA","ERA"]

   Se espera:
   resolverSopaLetras g ["MAMA","CAMA","SI","SECA","AMA","ERA", "HABLAREMOS"] = [
      ("MAMA",(3,3),(3,0)),
      ("CAMA",(0,0),(3,0)),
      ("SI",(0,1),(0,2)),("SI",(0,3),(0,2)),
      ("SECA",(0,3),(3,0)),
      ("AMA",(3,0),(3,2)),("AMA",(1,0),(3,0)),("AMA",(3,2),(3,0)),("AMA",(3,0),(1,0)),
      ("ERA",(1,2),(1,0))
    ]
    Notar que "HABLAREMOS" no está en el resultado ya que no está en la sopa de letras.
-}
resolverSopaLetras :: Grilla -> [String] -> [Resultado]
resolverSopaLetras _ [] = []
resolverSopaLetras grilla palabras =
          let 
              palabra = head palabras
              restoPalabra = tail palabras 
          in 
              buscarPalabra grilla palabra ++ resolverSopaLetras grilla restoPalabra