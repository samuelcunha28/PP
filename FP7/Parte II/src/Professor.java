import enums.TipoContrato;
import enums.UnidadeCurricular;

public class Professor extends Pessoa {
    // variaveis de instância de Professor
    private String sigla;
    private TipoContrato contrato;
    private UnidadeCurricular[] disciplinas;

    // construtor default de Professor
    public Professor() {
    }

    // construtor de Professor


    public Professor(String nome, String date, String morada, int id, int NIF, String sigla, TipoContrato contrato, UnidadeCurricular[] disciplinas) {
        super(nome, date, morada, id, NIF);
        this.sigla = sigla;
        this.contrato = contrato;
        this.disciplinas = disciplinas;
    }

    // TODOS GETTERS E SETTERS
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public TipoContrato getContrato() {
        return contrato;
    }

    public void setContrato(TipoContrato contrato) {
        this.contrato = contrato;
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
                + "Sigla : " + sigla + "\n"
                + "Tipo de contrato : " + contrato + "\n"
                + "Unidade curriculares : " + disciplinas + "\n";
        return text;
    }
}
