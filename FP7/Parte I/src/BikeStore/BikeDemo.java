package BikeStore;

import enums.BikeTools;
import enums.BrakeType;
import enums.MaterialType;
import enums.MountainBikeSuspension;

public class BikeDemo {

    public static void main(String[] args) {
        Bicycle bicycle1 = new Bicycle(1, 2,"blue", 2.0, BrakeType.CALIPERS, MaterialType.CARBON, 229.99, 5);
        System.out.println(bicycle1);

        MountainBike bicycle2 = new MountainBike(2, 6, "black", 5.0, BrakeType.HYDRAULIC, MaterialType.CARBON, 359.99, 5, 1, MountainBikeSuspension.DOUBLE, BikeTools.PHONE_SUPPORT);
        System.out.println(bicycle2);

        BicycleManagement list = new BicycleManagement();
        list.addbike(bicycle1);
        list.addbike(bicycle2);

        // Listar as bicicletas todas atraves de BicycleManagement
        System.out.println(list.toString());
    }
}
