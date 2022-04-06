/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.timer;

/**
 *
 * @author Willy
 */
public class RandomTimerRange {
    
    protected final int min;
    protected final int max;
    
    public RandomTimerRange(final int minSeconds, final int maxSeconds){
        this.min = minSeconds;
        this.max = maxSeconds;
    }
    
}
