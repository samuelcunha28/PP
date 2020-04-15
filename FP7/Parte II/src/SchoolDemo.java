import enums.TipoContrato;
import enums.UnidadeCurricular;

public class SchoolDemo {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("Samuel", "12-11-1998", "Aparecida", 124356787, 97745251);
        // Imprimir diretamente a pessoa 1
        // System.out.println(pessoa1);

        Professor pessoa2 = new Professor("Bruno", "23-11-1986", "Felgueiras", 12345678, 87654321, "BMO", TipoContrato.INTEGRAL, UnidadeCurricular.values());
        // Imprimir diretamente a pessoa 2
        // System.out.println(pessoa2);

        Funcionario pessoa3 = new Funcionario("Antonio", "01-06-1958", "Aparecida", 124356787, 97745251, 235645,TipoContrato.PARCIAL);
        // Imprimir diretamente a pessoa 3
        // System.out.println(pessoa3);

        Aluno pessoa4 = new Aluno("Sofia", "19-03-2000", "Aparecida", 124356787, 97745251, 656363, UnidadeCurricular.values());
        // Imprimir diretamente a pessoa 4
        // System.out.println(pessoa4);

        // adicionar pessoas ao array
        SchoolManagement list = new SchoolManagement();
        list.addPessoa(pessoa1);
        list.addPessoa(pessoa2);
        list.addPessoa(pessoa3);
        list.addPessoa(pessoa4);

        // Listar as pessoas todas atraves de SchoolManagement através do método toString
        //System.out.println(list.toString());

        // Imprimir todas as pessoas através de metodo especifico em SchoolManagement
        // System.out.println(list.imprimir());

        // Imprimir somente professores
        //System.out.println(list.imprimirProfessor());

        // Imprimir somente funcionarios
        //System.out.println(list.imprimirFuncionario());

        // Imprimir somente alunos
        //System.out.println(list.imprimirAluno());
    }
}
