
package AI.Models;

import AI.AIZeroLogic;
import jx.zero.FirstLevelIrqHandler;

/**
 *
 * @author xuyi
 */
public class IRQHandler implements FirstLevelIrqHandler {
        
    private final int irq;

    public IRQHandler(int irq){
        this.irq = irq;
    }

    @Override
    public void interrupt() {
        for(FirstLevelIrqHandler handler:AIZeroLogic.handlers[irq]){
            if(handler != null)
                handler.interrupt();
        }
    }

    public static boolean OK(int irq){
        return AIZeroLogic.handlers[irq][1] == null;
    }
}
