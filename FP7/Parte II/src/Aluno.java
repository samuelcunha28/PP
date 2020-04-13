import enums.UnidadeCurricular;

public class Aluno extends Pessoa {
    // variaveis de instancia de Aluno
    private int alunoId;
    private UnidadeCurricular[] disciplinas;

    // construtor default de aluno
    public Aluno() {
    }

    // construtor de aluno


    public Aluno(String nome, String date, String morada, int id, int NIF, int alunoId, UnidadeCurricular[] disciplinas) {
        super(nome, date, morada, id, NIF);
        this.alunoId = alunoId;
        this.disciplinas = disciplinas;
    }

    // TODOS OS GETTERS E SETTERS
    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public UnidadeCurricular[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(UnidadeCurricular[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    // metodo toString para imprimir
    public String toString() {
        String text = "Nome : " + super.getNome() + "\n"
                + "Data de nascimento : " + super.getDate() + "\n"
                + "Morada : " + super.getMorada() + "\n"
                + "Número de cartão de cidadão : " + super.getId() + "\n"
                + "Número de identificação fiscal : " + super.getNIF() + "\n"
                + "ID de aluno : " + alunoId + "\n"
                + "Unidades curriculares : " + disciplinas + "\n";
        return text;
    }
}
