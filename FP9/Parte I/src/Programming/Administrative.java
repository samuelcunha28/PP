package Programming;

import Enums.ContractType;
import Enums.LiteraryAbilities;

public class Administrative extends Person {
    // variaveis de instância de Administrative
    private String initials;
    private ContractType contractType;
    private LiteraryAbilities literaryAbility;
    private String beginContract;
    private String endContract = null;

    // construtor default de Administrative
    public Administrative() {
    }

    // construtor de Administrative
    public Administrative(String name, String date, String address, int citizenCard, int vatNumber, int baseSalary, String initials, ContractType contractType, LiteraryAbilities literaryAbility, String beginContract, String endContract) {
        super(name, date, address, citizenCard, vatNumber, baseSalary);
        this.initials = initials;
        this.contractType = contractType;
        this.literaryAbility = literaryAbility;
        this.beginContract = beginContract;
        this.endContract = endContract;
    }

    // GETTERS E SETTERS
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public LiteraryAbilities getLiteraryAbility() {
        return literaryAbility;
    }

    public void setLiteraryAbility(LiteraryAbilities literaryAbility) {
        this.literaryAbility = literaryAbility;
    }

    public String getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(String beginContract) {
        this.beginContract = beginContract;
    }

    public String getEndContract() {
        return endContract;
    }

    public void setEndContract(String endContract) {
        this.endContract = endContract;
    }

    @Override
    double calculateFinalSalary() {
        if (this.getLiteraryAbility() == LiteraryAbilities.GRADUATION) {
            return (getBaseSalary() + getBaseSalary() * 0.10);
        } else if (getLiteraryAbility() == LiteraryAbilities.MASTER) {
            return (getBaseSalary() + getBaseSalary() * 0.20);
        } else if (this.getLiteraryAbility() == LiteraryAbilities.DOCTORATE) {
            return (getBaseSalary() + getBaseSalary() * 0.30);
        }
        return getBaseSalary();
    }

    // metodo toString para imprimir
    public String toString() {
        System.out.print(super.toString());
        String text = "Sigla : " + initials + "\n"
                + "Tipo de contrato : " + contractType + "\n"
                + "Habilitações literárias : " + literaryAbility + "\n"
                + "Data da contratação : " + beginContract + "\n"
                + "Data de fim de contrato : " + endContract + "\n";
        return text;
    }

    public String printAdministrative() {
        return super.toString();
    }
}
