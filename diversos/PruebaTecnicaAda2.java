package com.mycompany.pruebatecnicaada2;

import java.util.Scanner;

public class PruebaTecnicaAda2 {

    public static void main(String[] args) {
        
        Scanner obj = new Scanner(System.in);
        double num1, num2, resultado = 0;
        String operacion;
        
        
        System.out.println("Ingrese el numero 1");
        num1 = Double.parseDouble(obj.nextLine());
        
        System.out.println("Ingrese la operacion");
        operacion = obj.nextLine();
        
        if(operacion != "sqrt"){
            System.out.println("Ingrese el numero 2");
            num2 = Double.parseDouble(obj.nextLine());
        } else{
            num2 = 0;
        }
        
        switch(operacion){
            case("+"):
                resultado = num1 + num2;
                break;
            case("-"):
                resultado = num1 - num2;
                break;
            case("*"):
                resultado = num1 * num2;
                break;
            case("/"):
                if (num2 < 0) {
                    System.out.println("no se puede realizar división entre 0, por ende se retorna 0");
                    resultado = 0;
                }else
                    resultado = num1/num2;
                break;
            case("sqrt"):
                if (num1 >= 0)
                    resultado = Math.sqrt(num1);
                else
                    System.out.println("no se pueden hacer operaciones con imaginarios");
                break;
        }
                
                    
        
        System.out.println("El resultado de su operacion es: "+resultado);
    }
}
