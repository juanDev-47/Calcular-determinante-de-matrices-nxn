/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    /*
    01. Elabore programa de computador que permita al usuario procesar una matriz cuadrada de orden n. (El
    usuario debe entrar el valor de n, el cual debe estar entre 3 y 8) La matriz la debe construir generando
    números aleatorios entre 1 y 9. El proceso consiste en calcular el valor del determinante asociado a la matriz
    construida usando el método de los menores o cofactores (Algoritmo recursivo). Su programa debe mostrar la
    matriz construida y el valor del determinante.

    Juan Pablo Arenas Velez C.C: 1037633965
    */
package cuarto_examen;

import javax.swing.JOptionPane;

/**
 *
 * @author JUAN
 */
public class clasePrincipal {
    public static int n=0;
    public static double matrix[][];
    
    
    public static double[][] generarMatriz(int n){
        double[][] m = new double[n][n];
        
        
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m.length; j++) {
                m[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
        
        return m;
    } 
    
    // calculo de la submatrix eliminando fila y columna actual
    private static double[][]subM(int i,int j, double[][]m){
        double[][] temp = new double[m.length-1][m.length-1];
        
        int c1 = 0;
        int c2 = 0;
        
        
        for (int k = 0; k < m.length; k++) {
            if (k != i) {
                c2 = 0;
               for (int l = 0; l < m.length; l++) {
                   if (l != j) {
                       temp[c1][c2] = m[k][l];
                       
                       c2++;
                   }
                }
               c1++;
            }            
        }
        
        return temp;
    }    
    
    public static double calcularDeterminante(int m, double[][] mat){
        double det = 0;
        
        if(mat.length == 2){
            det = mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];
            
            return det;
        }else{
            det = 0;
            
            for (int i = 0; i < mat.length; i++) {
                double[][]temp = subM(m,i,mat);
                
                det = det+Math.pow(-1, m+i) * mat[m][i] * calcularDeterminante(m,temp);
            }
        }
        
        
        
        return det;
    }
    

    

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean salir = false;
        
        
        
        try{
                
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ingrese solo datos númericos");
        }
        
        
        int opcion; //Guardaremos la opcion del usuario

        
      
           do{
               try{
           opcion =  Integer.parseInt(JOptionPane.showInputDialog("            Escribe la opcion  \n\n"
                                                                + "1. Generar matriz de tamaño n x n\n Y calcular su determinante. \n\n"
                                                                + "2. Salir\n"
                                                                 ));
            

        switch(opcion){
               case 1:
               try{
                   
                   n= Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el tamaño de la matriz"));
                   
                   if(n<3 || n>8){
                        JOptionPane.showMessageDialog(null,"El tamaño minimo es 3 y el maximo es 8");            
                    }      
                   
                   matrix = generarMatriz(n);
                   
                   for (int i = 0; i < n; i++) {
                       for (int j = 0; j <= n; j++) {
                           if (j == n) {
                               System.out.println("");
                           }else{
                               System.out.print("|" + matrix[i][j] + "| ");                               
                           }
                           
                       }
                   }
                   
                   System.out.println("La determinante de la matriz es: " + calcularDeterminante(0, matrix));
                   
                   
                   
                   }
                   catch(NumberFormatException w){
                       JOptionPane.showMessageDialog(null,"Ingrese datos numericos unicamente");
                   }
                   System.out.println("");
                   break;
                   
               case 2:
                   salir=true;
                   break;   
                   
                    
                default:
                   JOptionPane.showMessageDialog(null, "Solo ingrese la opcion 1 o 2");
           }
               }
               catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Presiono cancelar ó aceptar\n sin seleccionar opcion validad", "Presiono cancelar ó aceptar sin seleccionar opcion validad", JOptionPane.ERROR_MESSAGE);
      }     
   
       }while(!salir);
     
        
        
    }
    
    
    
}
