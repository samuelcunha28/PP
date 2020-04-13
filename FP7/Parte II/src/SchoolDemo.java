import enums.TipoContrato;
import enums.UnidadeCurricular;

public class SchoolDemo {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("Samuel", "12-11-1998", "Aparecida", 124356787, 97745251);
        System.out.println(pessoa1);

        Professor pessoa2 = new Professor("Bruno", "23-11-1986", "Felgueiras", 12345678, 87654321, "BMO", TipoContrato.INTEGRAL, UnidadeCurricular.values());
        System.out.println(pessoa2);

        Funcionario pessoa3 = new Funcionario("Antonio", "01-06-1958", "Aparecida", 124356787, 97745251, 235645,TipoContrato.PARCIAL);
        System.out.println(pessoa3);

        Aluno pessoa4 = new Aluno("Sofia", "19-03-2000", "Aparecida", 124356787, 97745251, 656363, UnidadeCurricular.values());
        System.out.println(pessoa4);
    }
}
