public class SchoolManagement {
    // adicionar metodos para listar professores, alunos e funcionarios
    private final int MAXPESSOAS = 20;
    private Pessoa[] listapessoas = new Pessoa[MAXPESSOAS];
    private int count = 0;

    public void addPessoa(Pessoa pessoa) {
        if (count < MAXPESSOAS) {
            listapessoas[count] = pessoa;
            count += 1;
        } else {
            System.out.println("MAX Pessoas");
        }
    }

    public String imprimir() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listapessoas[i] instanceof Professor) {
                Professor professor = (Professor) this.listapessoas[i];
                resp += professor.printProfessor(); // imprime professores
            } else if (this.listapessoas[i] instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) this.listapessoas[i];
                resp += funcionario.printFuncionario(); // imprime funcionarios
            } else if (this.listapessoas[i] instanceof Aluno) {
                Aluno aluno = (Aluno) this.listapessoas[i];
                resp += aluno.printAluno(); // imprime alunos
            } else {
                resp += this.listapessoas[i].toString(); // imprime default (pessoa normal)
            }
            resp += "\n";
        }
        return resp;
    }

    // imprime professores
    public String imprimirProfessor() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listapessoas[i] instanceof Professor) {
                Professor professor = (Professor) this.listapessoas[i];
                resp += professor.printProfessor();
            }
        }
        return resp;
    }

    // imprime funcionarios
    public String imprimirFuncionario() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listapessoas[i] instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) this.listapessoas[i];
                resp += funcionario.printFuncionario();
            }
        }
        return resp;
    }

    // imprime alunos
    public String imprimirAluno() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listapessoas[i] instanceof Aluno) {
                Aluno aluno = (Aluno) this.listapessoas[i];
                resp += aluno.printAluno(); //
            }
        }
        return resp;
    }


    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += "Pessoa " + (i + 1) + " : " + "\n" + listapessoas[i].toString() + "\n";
        }
        return text;
    }
}