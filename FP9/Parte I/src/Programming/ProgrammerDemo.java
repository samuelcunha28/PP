package Programming;

import Enums.ContractType;
import Enums.LiteraryAbilities;
import Enums.ProgrammerType;

import java.util.Calendar;
import java.util.Date;

public class ProgrammerDemo {

    public static void main(String[] args) {

        Administrative person1 = new Administrative("Samuel", "12-11-1998", "Aparecida", 123456, 54321, 1000, "SAM", ContractType.INTEGRAL, LiteraryAbilities.DOCTORATE, "25-11-2019", null);
        // Imprimir diretamente a pessoa 1
        //System.out.println(person1);

        JavaProgrammer person2 = new JavaProgrammer("Jorge", "14-01-1998", "Penafiel", 123, 321, 1000, 1, 3, "Java Develop", ProgrammerType.JUNIOR);
        // Imprimir diretamente a pessoa 2
        //System.out.println(person2);

        ProjectManager person3 = new ProjectManager("Fatinha", "01-08-1998", "Penafiel", 657465, 652123, 1000, 2, new String[]{"Java Develop", "Scrum"}, new Date(2019, Calendar.APRIL,6));
        // Imprimir diretamente a pessoa 3
        //System.out.println(person3);

        // adicionar pessoas ao array
        ProgrammingManagement list = new ProgrammingManagement();
        list.addPerson2(person1);
        list.addPerson2(person2);
        list.addPerson2(person3);

        // remover objetos do array
        // list.removeObject(0); // vai remover person1 porque está na posicao 0 do array

        // Listar as pessoas todas atraves de ProgrammingManagement através do método toString
        // System.out.println(list.toString());

        // Imprimir todas as pessoas através de metodo especifico em ProgrammingManagement
        System.out.println(list.imprimir());

        // Imprimir somente administrativos
        // System.out.println(list.imprimirAdministrative());

        // Imprimir somente programadores java
        // System.out.println(list.imprimirJavaProgrammer());

        // Imprimir somente gestor de projecto
        // System.out.println(list.imprimirProjectManager());
    }
}
