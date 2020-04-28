package Programming;

import Enums.ContractType;
import Enums.LiteraryAbilities;
import Enums.ProgrammerType;

import java.time.LocalDate;
import java.util.Date;

public class ProgrammerDemo {

    public static void main(String[] args) {

        Administrative person1 = new Administrative("Samuel", "12-11-1998", "Aparecida", 123456, 54321, 1000, "SAM", ContractType.INTEGRAL, LiteraryAbilities.DOCTORATE, "25-11-2019", null);
        // Imprimir diretamente a pessoa 1
        System.out.println(person1);

        JavaProgrammer person2 = new JavaProgrammer("Jorge", "14-01-1998", "Penafiel", 123, 321, 1000, 1, 3, "Java Develop", ProgrammerType.JUNIOR);
        // Imprimir diretamente a pessoa 2
        System.out.println(person2);

        //ProjectManager person3 = new ProjectManager("Fatinha", "01-08-1998", "Penafiel", 657465, 652123, 1000, 2, new String[]{"ola", "tudo bem"}, new Date(2019));
        //System.out.println(person3);
    }
}
