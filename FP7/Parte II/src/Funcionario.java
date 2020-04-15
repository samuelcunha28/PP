import enums.TipoContrato;

public class Funcionario extends Pessoa {
    // variaveis de instancia de Funcionario
    private int funcId;
    private TipoContrato contrato;

    // construtor default de Funcionario
    public Funcionario() {
    }

    // construtor de funcionario


    public Funcionario(String nome, String date, String morada, int id, int NIF, int funcId, TipoContrato contrato) {
        super(nome, date, morada, id, NIF);
        this.funcId = funcId;
        this.contrato = contrato;
    }

    // TODOS OS GETTERS E SETTERS
    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public TipoContrato getContrato() {
        return contrato;
    }

    public void setContrato(TipoContrato contrato) {
        this.contrato = contrato;
    }

    // metodo toString para imprimir
    public String toString() {
        String text = "Nome : " + super.getNome() + "\n"
                + "Data de nascimento : " + super.getDate() + "\n"
                + "Morada : " + super.getMorada() + "\n"
                + "Número de cartão de cidadão : " + super.getId() + "\n"
                + "Número de identificação fiscal : " + super.getNIF() + "\n"
                + "ID de funcionário : " + funcId + "\n"
                + "Tipo de contrato : " + contrato + "\n";
        return text;
    }

    /**
     * Método especifico para imprimir só funcionarios
     *
     * @return Bikes
     */
    public String printFuncionario() {
        return "ID: " + super.getId() + " Nome: " + super.getNome() + " Data: " + super.getDate() + " Morada: " + super.getMorada();
    }
}
