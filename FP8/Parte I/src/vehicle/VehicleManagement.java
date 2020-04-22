package vehicle;

import java.util.Arrays;
import java.util.Objects;

public class VehicleManagement {
    private final int MAXVEHICLES = 20;
    private Vehicle[] listvehicles = new Vehicle[MAXVEHICLES];
    private int count = 0;

    // metodo para adicionar veiculos
    public void addVehicle(Vehicle vehicle) {
        if (count < MAXVEHICLES) {
            listvehicles[count] = vehicle;
            count += 1;
        } else {
            System.out.println("MAX Vehicles");
        }
    }

    // metodo para adicionar veiculos de forma + correta ( so deixa adicionar se vin for diferente)
    public void addVehicle2(Vehicle vehicle) {
        boolean duplicated = false;
        Vehicle[] temp = new Vehicle[this.listvehicles.length + 1];

        for (int i = 0; i < this.count; i++) {
            if (vehicle.getVin() == this.listvehicles[i].getVin()) {
                duplicated = true;
            }
        }
        if (this.count >= 0 && find(vehicle) == null && duplicated == false) {
            this.listvehicles[this.count] = vehicle;
            this.count++;
        }
    }

    public Vehicle find(Vehicle vehicle) {
        Vehicle resp = null;
        for (int i = 0; i < this.count; i++) {
            if (vehicle.equals(this.listvehicles[i].getVin())) {
                resp = this.listvehicles[i];
            }
        }
        return resp;
    }


    public Vehicle removeObject(int position) {
        if (position < listvehicles.length && position != -1) {
            if (listvehicles[position] == null) {
                System.out.println("Objeto não existe");
                return null;
            } else {
                Object delete = listvehicles[position];
                listvehicles[position] = null;
                for (int i = position; i < (count - 1); i++) {
                    listvehicles[i] = listvehicles[i + 1];
                }
                count -= 1;
                listvehicles[count] = null;
                return (Vehicle) delete;
            }
        } else {
            System.out.println("Posição Inexistente");
            return null;
        }
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleManagement that = (VehicleManagement) o;
        return MAXVEHICLES == that.MAXVEHICLES &&
                count == that.count &&
                Arrays.equals(listvehicles, that.listvehicles);
    }
     */


    public String imprimir() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listvehicles[i] instanceof Car) {
                Car car = (Car) this.listvehicles[i];
                resp += car.printCar(); // imprime carros
            } else if (this.listvehicles[i] instanceof Bike) {
                Bike bike = (Bike) this.listvehicles[i];
                resp += bike.printBike(); // imprime motas
            } else if (this.listvehicles[i] instanceof Truck) {
                Truck truck = (Truck) this.listvehicles[i];
                resp += truck.printTruck(); // imprime camioes
            } else {
                resp += this.listvehicles[i].toString(); // imprime default (veiculo normal)
            }
            resp += "\n";
        }
        return resp;
    }

    // imprime carros
    public String imprimirCar() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listvehicles[i] instanceof Car) {
                Car car = (Car) this.listvehicles[i];
                resp += car.printCar();
            }
        }
        return resp;
    }

    // imprime motas
    public String imprimirBike() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listvehicles[i] instanceof Bike) {
                Bike bike = (Bike) this.listvehicles[i];
                resp += bike.printBike();
            }
        }
        return resp;
    }

    // imprime camioes
    public String imprimirTruck() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listvehicles[i] instanceof Truck) {
                Truck truck = (Truck) this.listvehicles[i];
                resp += truck.printTruck();
            }
        }
        return resp;
    }

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += "Veiculo " + (i + 1) + " : " + "\n" + listvehicles[i].toString() + "\n";
        }
        return text;
    }
}
