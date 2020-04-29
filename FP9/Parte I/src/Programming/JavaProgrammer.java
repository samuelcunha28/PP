package Programming;

import Enums.LiteraryAbilities;
import Enums.ProgrammerType;

public class JavaProgrammer extends Person {
    // variaveis de instancia de JavaProgrammer
    private int code;
    private int programmingYears;
    private String projectName;
    private ProgrammerType programmerType;

    // construtor default de JavaProgrammer
    public JavaProgrammer() {
    }

    // construtor de JavaProgrammer
    public JavaProgrammer(String name, String date, String address, int citizenCard, int vatNumber, int baseSalary, int code, int programmingYears, String projectName, ProgrammerType programmerType) {
        super(name, date, address, citizenCard, vatNumber, baseSalary);
        this.code = code;
        this.programmingYears = programmingYears;
        this.projectName = projectName;
        this.programmerType = programmerType;
    }

    // GETTERS E SETTERS
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getProgrammingYears() {
        return programmingYears;
    }

    public void setProgrammingYears(int programmingYears) {
        this.programmingYears = programmingYears;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ProgrammerType getProgrammerType() {
        return programmerType;
    }

    public void setProgrammerType(ProgrammerType programmerType) {
        this.programmerType = programmerType;
    }

    public double getBaseSalary() {
        if (this.programmerType == ProgrammerType.JUNIOR) {
            return (super.getBaseSalary() + super.getBaseSalary() * 0.10 + super.getBaseSalary() * 0.05 * this.programmingYears);
        } else if (this.programmerType == ProgrammerType.SENIOR) {
            return (super.getBaseSalary() + super.getBaseSalary() * 0.20 + super.getBaseSalary() * 0.05 * this.programmingYears);
        }
        return super.getBaseSalary();
    }

    // metodo toString para imprimir
    public String toString() {
        System.out.print(super.toString());
        String text = "Código de funcionário: " + code + "\n"
                + "Número de anos de programação Java : " + programmingYears + "\n"
                + "Nome do projeto que se encontra a desenvolver : " + projectName + "\n"
                + "Tipo de programador : " + programmerType + "\n";
        return text;
    }

    public String printJavaProgrammer() {
        return super.toString();
    }
}
