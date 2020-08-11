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
public class Dollar10 extends handleCash{
    private int cant = 0;
    @Override
    public void getCash(int value) {
        if(value <10){
            super.next.getCash(value);
        }else{
            int remaind = value%10;
            cant = value/10;
            System.out.printf("Saliendo %d billeres de 10\n", cant);
            if(remaind != 0){
                super.next.getCash(remaind);
            }
        }
    }
    
}
