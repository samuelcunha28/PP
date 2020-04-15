package BikeStore;

import BikeStore.Bicycle;
import enums.BrakeType;
import enums.MaterialType;

public class RoadBike extends Bicycle {

    // variaveis de instancia
    private final int MAXOBS = 50;

    private String handlebelt​;
    private float framesize;
    private String[] observation = new String[MAXOBS];
    private int countobs = 0;

    // construtor default de RoadBike
    public RoadBike() {
    }

    // contrutor para RoadBike
    public RoadBike(int id, int numberOfGears, String mainColor, double wheelSize, BrakeType brakes, MaterialType material, double price, int guarantee, String handlebelt​, float framesize) {
        super(id, numberOfGears, mainColor, wheelSize, brakes, material, price, guarantee);
        this.handlebelt​ = handlebelt​;
        this.framesize = framesize;
    }

    // TODOS GETTERS AND SETTERS
    public String getHandlebelt​() {
        return handlebelt​;
    }

    public void setHandlebelt​(String handlebelt​) {
        this.handlebelt​ = handlebelt​;
    }

    public float getFramesize() {
        return framesize;
    }

    public void setFramesize(float framesize) {
        this.framesize = framesize;
    }

    public String[] getObservation() {
        return observation;
    }

    public void setObservation(String[] observation) {
        this.observation = observation;
    }

    /**
     * Adicionar observaçoes ao array
     *
     * @param obs
     */
    public void addobs(String obs) {
        if (countobs < MAXOBS) {
            observation[countobs] = obs;
            countobs++;
        } else {
            System.out.println("Limite atingido");
        }
    }

    /**
     * remover observaçoes
     *
     * @param pos
     */
    public void removeobs(int pos) {
        String[] tmp = new String[MAXOBS];
        int found = 0;

        for (int i = 0; i < countobs; i++) {
            if (pos == i) {
                found += 1;
                countobs -= 1;
                continue;
            }
            tmp[i] = observation[i];
        }
        if (found > 0) {
            observation = tmp;
        } else {
            System.out.println("Não foi encontrado.");
        }
    }

    /**
     * editar observaçoes
     *
     * @param position
     * @param obs
     */
    public void editObservations(int position, String obs) {
        int found = 0;

        for (int i = 0; i < countobs; i++) {
            if (position == i) {
                observation[i] = obs;
                found += 1;
                break;
            }
        }

        if (found > 0) {
            System.out.println("Foi alterado com sucesso.");
        } else {
            System.out.println("Não foi encontrado.");
        }
    }

    /**
     * print observaçoes
     *
     * @return
     */
    public String printobs() {
        String obs = "";
        for (int i = 0; i < countobs; i++) {
            obs += "Observação " + (i + 1) + " : " + observation[i] + "\n";
        }
        return obs;
    }

    /**
     * Print Bike
     */
    public void printBike() {
        System.out.println("-----------------////----------");
        System.out.print("ID : ");
        System.out.println(super.getId());
        System.out.print("Number of Gears: ");
        System.out.println(super.getNumberOfGears());
        System.out.print("Cor : ");
        System.out.println(super.getMainColor());
        System.out.print("Weel Size : ");
        System.out.println(super.getWheelSize());
        System.out.print("Brakes : ");
        System.out.println(super.getBrakes());
        System.out.print("Material : ");
        System.out.println(super.getMaterial());
        System.out.print("Price : ");
        System.out.println(super.getPrice());
        System.out.print("Guarantee : ");
        System.out.println(super.getGuarantee());
        System.out.print("Handlebelt : ");
        // System.out.println(handlebelt);
        System.out.print("Frame size : ");
        System.out.println(framesize);
        System.out.println("---------Observations : ");
        System.out.println(printobs());
    }

    public String printRoad() {
        return "ID: " + super.getId() + " Cor: " + super.getMainColor() + " Frame size: " + this.getFramesize();
    }
}
