/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import p1.MatriculaCampamento;
import p1.MatriculaColegio;

/**
 *
 * @author reroes
 */
public class TipoMatricula {
    private double promedioMatriculas;
    private MatriculaCampamento campamento;
    private MatriculaColegio colegio;
    // private MatriculaEscuela escuela;
    // private MatriculaJardin jardin;
    // private MatriculaMaternal maternal;
    // private MatriculaMaternal maternal2;
    
    public void establecerMatriculaCampamento(MatriculaCampamento c){
        campamento = c;
    }
    
    public void establecerMatriculaColegio(MatriculaColegio c){
        colegio = c;
    }
    
    public MatriculaCampamento obtenerMatriculaCampamento(){
        return campamento;
    }
    
    public MatriculaColegio obtenerMatriculaColegio(){
        return colegio;
    }
    
    public void establecerPromedioTarifas(){
        promedioMatriculas = (obtenerMatriculaCampamento().obtenerTarifa() + 
                obtenerMatriculaColegio().obtenerTarifa())/2;
        
    }
    
    public double obtenerPromedioTarifas(){
        return promedioMatriculas;
    }
    
    
}
