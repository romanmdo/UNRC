import Test.HUnit
import Data.List (sort)
import System.Exit (exitFailure, exitSuccess)
import SopaDeLetras

-- =====================================================
-- UTILIDADES DE TEST
-- =====================================================

-- Compara listas ignorando el orden
(~=?~) :: (Eq a, Ord a, Show a) => [a] -> [a] -> Assertion
esperado ~=?~ obtenido = sort esperado @=? sort obtenido

-- =====================================================
-- DATOS DE PRUEBA
-- =====================================================

gSimple :: Grilla
gSimple = construirGrilla ["HOLA", "CHAU", "CASA"]

gMini :: Grilla
gMini =
  [ [((0,0),'A'),((0,1),'B'),((0,2),'C')],
    [((1,0),'D'),((1,1),'E'),((1,2),'F')],
    [((2,0),'G'),((2,1),'H'),((2,2),'I')]
  ]

gSopa :: Grilla
gSopa =
  [ [((0,0),'C'),((0,1),'S'),((0,2),'I'),((0,3),'S')],
    [((1,0),'A'),((1,1),'R'),((1,2),'E'),((1,3),'A')],
    [((2,0),'M'),((2,1),'C'),((2,2),'X'),((2,3),'O')],
    [((3,0),'A'),((3,1),'M'),((3,2),'A'),((3,3),'M')]
  ]

g4x4 :: Grilla
g4x4 =
  [ [((0,0),'H'),((0,1),'O'),((0,2),'L'),((0,3),'A')],
    [((1,0),'Q'),((1,1),'U'),((1,2),'E'),((1,3),'M')],
    [((2,0),'C'),((2,1),'O'),((2,2),'M'),((2,3),'O')],
    [((3,0),'O'),((3,1),'T'),((3,2),'A'),((3,3),'R')]
  ]


-- =====================================================
-- SECCIÓN 1 — CONSTRUCCIÓN DE LA GRILLA
-- =====================================================

testConstruccion :: Test
testConstruccion = TestList
  [ "construirFilaGrilla" ~:
      [((1,0),'H'),((1,1),'O'),((1,2),'L'),((1,3),'A')] ~=? construirFilaGrilla 1 "HOLA",  
      
    "construirGrilla" ~:
        [ [((0,0),'H'),((0,1),'O'),((0,2),'L'),((0,3),'A')],
            [((1,0),'C'),((1,1),'H'),((1,2),'A'),((1,3),'U')],
            [((2,0),'C'),((2,1),'A'),((2,2),'S'),((2,3),'A')]
        ] ~=? construirGrilla ["HOLA","CHAU","CASA"],

    "construirFilaGrilla con fila 3" ~:
        [((3,0),'C'),((3,1),'A'),((3,2),'S'),((3,3),'A')] ~=? construirFilaGrilla 3 "CASA",

    "construirGrilla con una sola palabra" ~:
        [ [((0,0),'P'),((0,1),'E'),((0,2),'R'),((0,3),'A')] ] ~=? construirGrilla ["PERA"]
    
  ]

-- =====================================================
-- SECCIÓN 2 — TRANSFORMACIONES DE LA GRILLA
-- =====================================================

testTransformaciones :: Test
testTransformaciones = TestList
  [ "trasponerGrilla" ~:
      [ [((0,0),'C'),((1,0),'A'),((2,0),'M'),((3,0),'A')],
        [((0,1),'S'),((1,1),'R'),((2,1),'C'),((3,1),'M')],
        [((0,2),'I'),((1,2),'E'),((2,2),'X'),((3,2),'A')],
        [((0,3),'S'),((1,3),'A'),((2,3),'O'),((3,3),'M')]
      ] ~=? trasponerGrilla gSopa,
    
    "trasponerGrilla (gMini)" ~:
        [ [((0,0),'A'),((1,0),'D'),((2,0),'G')],
          [((0,1),'B'),((1,1),'E'),((2,1),'H')],
          [((0,2),'C'),((1,2),'F'),((2,2),'I')]
        ] ~=? trasponerGrilla gMini,

    "espejarGrilla" ~:
        [ [((0,3),'S'),((0,2),'I'),((0,1),'S'),((0,0),'C')],
          [((1,3),'A'),((1,2),'E'),((1,1),'R'),((1,0),'A')],
          [((2,3),'O'),((2,2),'X'),((2,1),'C'),((2,0),'M')],
          [((3,3),'M'),((3,2),'A'),((3,1),'M'),((3,0),'A')]
        ] ~=? espejarGrilla gSopa,

    "espejarGrilla (gMini)" ~:
        [ [((0,2),'C'),((0,1),'B'),((0,0),'A')],
        [((1,2),'F'),((1,1),'E'),((1,0),'D')],
        [((2,2),'I'),((2,1),'H'),((2,0),'G')]
        ] ~=? espejarGrilla gMini,

    "columnasGrilla" ~:
      [ [((0,0),'C'),((1,0),'A'),((2,0),'M'),((3,0),'A')],
        [((0,1),'S'),((1,1),'R'),((2,1),'C'),((3,1),'M')],
        [((0,2),'I'),((1,2),'E'),((2,2),'X'),((3,2),'A')],
        [((0,3),'S'),((1,3),'A'),((2,3),'O'),((3,3),'M')]
      ] ~=?~ columnasGrilla gSopa,
    
    "columnasGrilla (gMini)" ~:
        [ [((0,0),'A'),((1,0),'D'),((2,0),'G')],
          [((0,1),'B'),((1,1),'E'),((2,1),'H')],
          [((0,2),'C'),((1,2),'F'),((2,2),'I')]
        ] ~=?~ columnasGrilla gMini,

    "diagonalizarDesdeIzquierdaGrilla 3x3" ~:
        [ [((0,0),'A'),((1,1),'E'),((2,2),'I')],  -- principal
          [((1,0),'D'),((2,1),'H')],              -- debajo
          [((0,1),'B'),((1,2),'F')]               -- arriba
        ] ~=?~ diagonalizarDesdeIzquierdaGrilla gMini,

    "diagonalizarDesdeIzquierdaGrilla 4x4" ~:
        [ [((0,0),'H'),((1,1),'U'),((2,2),'M'),((3,3),'R')],  -- principal
          [((1,0),'Q'),((2,1),'O'),((3,2),'A')],              -- inferiores
          [((2,0),'C'),((3,1),'T')],
          [((0,1),'O'),((1,2),'E'),((2,3),'O')],              -- superiores
          [((0,2),'L'),((1,3),'M')]
        ] ~=?~ diagonalizarDesdeIzquierdaGrilla g4x4
  ]

-- =====================================================
-- SECCIÓN 3 — FUNCIONES AUXILIARES
-- =====================================================

testAuxiliares :: Test
testAuxiliares = TestList
  [ "eliminarRepetidos (sin importar orden)" ~:
      [1,2,3,4,5,8] ~=?~ eliminarRepetidos [1,2,3,4,5,1,8,3], 

    "eliminarRepetidos con strings (sin importar orden)" ~:
        ["H","O","L","A","M","U","N","D"] ~=?~ eliminarRepetidos ["H","O","L","A","H","O","M","U","N","D","O"],

    "subSegmentos" ~:
      [[],[1],[2],[3],[4],[1,2],[1,2,3],[1,2,3,4],[2,3],[2,3,4],[3,4]] ~=?~ subSegmentos [1,2,3,4],

    "subSegmentos con letras" ~:
        [[],['A'],['B'],['C'],['A','B'],['A','B','C'],['B','C']] ~=?~ subSegmentos ['A','B','C']

  ]

-- =====================================================
-- SECCIÓN 4 — BÚSQUEDA Y RESOLUCIÓN
-- =====================================================

testBusqueda :: Test
testBusqueda = TestList
  [ "buscarEnLinea (sin importar orden)" ~:
      [("MA",(1,0),(1,1)), ("MA",(1,2),(1,3))] ~=?~ buscarEnLinea "MA" [((1,0),'M'),((1,1),'A'),((1,2),'M'),((1,3),'A')],

    "buscarEnLinea (palabra solapada)" ~:
        [("ANA",(0,0),(0,2)), ("ANA",(0,2),(0,4))] 
            ~=?~ buscarEnLinea "ANA" [((0,0),'A'),((0,1),'N'),((0,2),'A'),((0,3),'N'),((0,4),'A')],

    "buscarEnLinea (sin coincidencias)" ~:
        [] ~=?~ buscarEnLinea "SOL" [((0,0),'S'),((0,1),'A'),((0,2),'L'),((0,3),'U'),((0,4),'D')],

    "buscarEnLinea (palabra incompleta al final)" ~:
        [] ~=?~ buscarEnLinea "CASA" [((0,0),'C'),((0,1),'A'),((0,2),'S')],

    "buscarEnLinea" ~:
        [("CASA",(1,0),(4,0))] ~=?~ buscarEnLinea "CASA" [((1,0),'C'),((2,0),'A'),((3,0),'S'),((4,0),'A')],

    "resolverSopaLetras (sin importar orden)" ~:
      [
        ("MAMA",(3,3),(3,0)),
        ("CAMA",(0,0),(3,0)),
        ("SI",(0,1),(0,2)),("SI",(0,3),(0,2)),
        ("SECA",(0,3),(3,0)),
        ("AMA",(3,0),(3,2)),("AMA",(1,0),(3,0)),("AMA",(3,2),(3,0)),("AMA",(3,0),(1,0)),
        ("ERA",(1,2),(1,0))
      ] ~=?~ resolverSopaLetras gSopa ["MAMA","CAMA","SI","SECA","AMA","ERA","HABLAREMOS"],

    "resolverSopaLetras 3x3 (sin importar orden)" ~:
        [ ("ABC",(0,0),(0,2))
        , ("CFI",(0,2),(2,2))
        , ("DH",(1,0),(2,1))
        , ("CEG",(0,2),(2,0))
        ] ~=?~ resolverSopaLetras gMini ["ABC","CFI","DH","XYZ","CEG"],
    
    "resolverSopaLetras g4x4 (sin importar orden)" ~:
    [ ("HOLA",(0,0),(0,3)),
      ("QUE",(1,0),(1,2)),
      ("RATO",(3,3),(3,0)),
      ("MO",(2,2),(2,3)),("MO",(2,2),(2,1)),("MO",(1,3),(2,3)),
      ("HUMR",(0,0),(3,3)),
      ("AMOR",(0,3),(3,3)),
      ("ROMA",(3,3),(0,3)),
      ("AOQ",(3,2),(1,0)),
      ("LUC",(0,2),(2,0)),
      ("OEA",(2,1),(0,3))

    ] ~=?~ resolverSopaLetras g4x4 ["HOLA","QUE","MO","RATO","HUMR", "AMOR", "ROMA", "AOQ", "LUC", "OEA", "CAMIONETA"]

  ]

-- =====================================================
-- EJECUCIÓN DE TODOS LOS TESTS
-- =====================================================

tests :: Test
tests = TestList
  [ TestLabel "Construcción" testConstruccion
  , TestLabel "Transformaciones" testTransformaciones
  , TestLabel "Auxiliares" testAuxiliares
  , TestLabel "Búsqueda" testBusqueda
  ]

main :: IO ()
main = do
  counts <- runTestTT tests
  putStrLn "--------------------------------------"
  if errors counts + failures counts == 0
    then do
      putStrLn "Todos los tests pasaron correctamente."
      exitSuccess
    else do
      putStrLn "Algunos tests fallaron. Revisá tu código."
      exitFailure