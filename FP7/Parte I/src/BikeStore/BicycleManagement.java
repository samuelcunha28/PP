package BikeStore;

public class BicycleManagement {
    private final int MAXBIKES = 20;
    private Bicycle[] bikelist = new Bicycle[MAXBIKES];
    private int count = 0;

    /**
     * @param bike
     */
    public void addbike(Bicycle bike) {
        if (count < MAXBIKES) {
            bikelist[count] = bike;
            count += 1;
        } else {
            System.out.println("MAX Bikes");
        }
    }

    public String imprimir() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.bikelist[i] instanceof MountainBike) {
                MountainBike mountainbike = (MountainBike) this.bikelist[i];
                resp += mountainbike.printMountain(); // imprime mountain bikes
            } else if (this.bikelist[i] instanceof RoadBike) {
                RoadBike roadBike = (RoadBike) this.bikelist[i];
                resp += roadBike.printRoad(); // imprime road bikes
            } else {
                resp += this.bikelist[i].toString(); // imprime default bicycle
            }
            resp += "\n";
        }
        return resp;
    }

    public String imprimirMountainBikes() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.bikelist[i] instanceof MountainBike) {
                MountainBike mountainbike = (MountainBike) this.bikelist[i];
                resp += mountainbike.printMountain(); // imprime mountain bikes
            }
        }
        return resp;
    }

    public String imprimirRoadBikes() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.bikelist[i] instanceof RoadBike) {
                RoadBike roadBike = (RoadBike) this.bikelist[i];
                resp += roadBike.printRoad(); // imprime road bikes
            }
        }
        return resp;
    }


    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += "Bike " + (i + 1) + " : " + "\n" + bikelist[i].toString() + "\n";
        }
        return text;
    }
}
