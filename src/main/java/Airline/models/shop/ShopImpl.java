package Airline.models.shop;

import Airline.models.tool.Tool;
import Airline.models.vehicle.Vehicle;
import Airline.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop {
    //opisanie na dejstviqta v magazina

    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools();

        //tools.iterator().hasNext() puskame po tools edin itertor i dokato imame next ....

        while (worker.canWork() && !vehicle.reached() && !tools.iterator().hasNext()) {  //dokato imam sila, vehicle ne e gotovo i imam instrumenti
            Tool currentTool = tools.iterator().next();                                 //daj mi pyrviq instrument ot spisyka
            currentTool.decreasesPower();                                               //namalqva,e silata na instrumenta -10
            worker.working();                                                           //strength worker -10
            vehicle.making();                                                           //strengthReqired to make the vehicle -5
            if (currentTool.isUnfit()) {
                currentTool = tools.iterator().next();
            }
        }

    }


}
