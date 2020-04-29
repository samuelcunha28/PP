package Programming;

public class ProgrammingManagement {
    private final int MAXPERSONS = 20;
    private Person[] listperson = new Person[MAXPERSONS];
    private int count = 0;

    // metodo para adicionar pessoas
    public void addPerson(Person person) {
        if (count < MAXPERSONS) {
            listperson[count] = person;
            count += 1;
        } else {
            System.out.println("MAX Persons");
        }
    }

    // metodo para adicionar pessoas de forma + correta ( so deixa adicionar se citizen card for diferente)
    public void addPerson2(Person person) {
        boolean duplicated = false;
        Person[] temp = new Person[this.listperson.length + 1];

        for (int i = 0; i < this.count; i++) {
            if (person.getCitizenCard() == this.listperson[i].getCitizenCard()) {
                duplicated = true;
            }
        }
        if (this.count >= 0 && find(person) == null && duplicated == false) {
            this.listperson[this.count] = person;
            this.count++;
        }
    }

    // metodo para encontrar pessoas
    public Person find(Person person) {
        Person resp = null;
        for (int i = 0; i < this.count; i++) {
            if (person.equals(this.listperson[i].getCitizenCard())) {
                resp = this.listperson[i];
            }
        }
        return resp;
    }

    // metodo para remover um objeto (pessoa)
    public Person removeObject(int position) {
        if (position < listperson.length && position != -1) {
            if (listperson[position] == null) {
                System.out.println("Objeto não existe");
                return null;
            } else {
                Object delete = listperson[position];
                listperson[position] = null;
                for (int i = position; i < (count - 1); i++) {
                    listperson[i] = listperson[i + 1];
                }
                count -= 1;
                listperson[count] = null;
                return (Person) delete;
            }
        } else {
            System.out.println("Posição Inexistente");
            return null;
        }
    }

    public String imprimir() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listperson[i] instanceof Administrative) {
                Administrative administrative = (Administrative) this.listperson[i];
                resp += administrative.printAdministrative(); // imprime administrativos
            } else if (this.listperson[i] instanceof JavaProgrammer) {
                JavaProgrammer javaProgrammer = (JavaProgrammer) this.listperson[i];
                resp += javaProgrammer.printJavaProgrammer(); // imprime java programmers
            } else if (this.listperson[i] instanceof ProjectManager) {
                ProjectManager projectManager = (ProjectManager) this.listperson[i];
                resp += projectManager.printProjectManager(); // imprime project managers
            } else {
                resp += this.listperson[i].toString(); // imprime default (person normal)
            }
            resp += "\n";
        }
        return resp;
    }

    // imprime administrative
    public String imprimirAdministrative() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listperson[i] instanceof Administrative) {
                Administrative administrative = (Administrative) this.listperson[i];
                resp += administrative.printAdministrative();
            }
        }
        return resp;
    }

    // imprime java programmer
    public String imprimirJavaProgrammer() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listperson[i] instanceof JavaProgrammer) {
                JavaProgrammer javaProgrammer = (JavaProgrammer) this.listperson[i];
                resp += javaProgrammer.printJavaProgrammer();
            }
        }
        return resp;
    }

    // imprime project manager
    public String imprimirProjectManager() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listperson[i] instanceof ProjectManager) {
                ProjectManager projectManager = (ProjectManager) this.listperson[i];
                resp += projectManager.printProjectManager();
            }
        }
        return resp;
    }

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += "Pessoa " + (i + 1) + " : " + "\n" + listperson[i].toString() + "\n";
        }
        return text;
    }
}
