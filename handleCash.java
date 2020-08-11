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
public abstract class handleCash {
    
    protected handleCash next;
    
    public void setNext(handleCash next){
        this.next = next;
    }
    
    public abstract void getCash(int value);
    
}
