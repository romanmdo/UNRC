trasponerGrilla :: Grilla -> Grilla
trasponerGrilla [] = []
trasponerGrilla ([]:_) = []
trasponerGrilla grilla = 
    let nuevaFila = map head grilla
        restoGrilla = map tail grilla
    in
    nuevaFila : (trasponerGrilla restoGrilla)
