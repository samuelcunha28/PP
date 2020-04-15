package BikeStore;

import enums.BikeTools;
import enums.BrakeType;
import enums.MaterialType;
import enums.MountainBikeSuspension;

public class BikeDemo {

    public static void main(String[] args) {
        Bicycle bicycle1 = new Bicycle(1, 2,"blue", 2.0, BrakeType.CALIPERS, MaterialType.CARBON, 229.99, 5);
        // Imprimir diretamente a bicicleta 1
        // System.out.println(bicycle1);

        MountainBike bicycle2 = new MountainBike(2, 6, "black", 5.0, BrakeType.HYDRAULIC, MaterialType.CARBON, 359.99, 5, 1, MountainBikeSuspension.DOUBLE, BikeTools.PHONE_SUPPORT);
        // Imprimir diretamente a bicicleta 2
        //System.out.println(bicycle2);

        RoadBike bicycle3 = new RoadBike(3, 2,"white", 5.0, BrakeType.CALIPERS, MaterialType.CARBON, 299.99, 5, "Yes", 2);
        // Imprimir diretamente a bicicleta 3
        //System.out.println(bicycle3);

        // adicionar bicicletas ao array
        BicycleManagement list = new BicycleManagement();
        list.addbike(bicycle1);
        list.addbike(bicycle2);
        list.addbike(bicycle3);

        // Listar as bicicletas todas atraves de BicycleManagement através do método toString
        //System.out.println(list.toString());

        // Imprimir todas as bicicletas através de metodo especifico em BicycleManagement
        //System.out.println(list.imprimir());

        // Imprimir somente bicicletas de montanha
        //System.out.println(list.imprimirMountainBikes());

        // Imprimir somente bicicletas de corrida
        //System.out.println(list.imprimirRoadBikes());
    }
}
