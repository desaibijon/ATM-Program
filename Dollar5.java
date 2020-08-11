/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM;

/**
 *
 * @author kenny
 */
public class Dollar5 extends handleCash{
    private int cant = 0;
    @Override
    public void getCash(int value) {
        if(value <5){
            super.next.getCash(value);
        }else{
            int remaind = value%5;
            cant = value/5;
            System.out.printf("Saliendo %d billeres de 5\n", cant);
            if(remaind != 0){
                super.next.getCash(remaind);
            }
        }
    }
    
}
