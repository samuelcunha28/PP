package Programming;

import java.util.Arrays;
import java.util.Date;

public class ProjectManager extends Person {
    // variaveis de instancia de ProjectManager
    private int code;
    private String projects[];
    private Date contractDate;

    // construtor default de ProjectManager
    public ProjectManager() {
    }

    // construtor de ProjectManager
    public ProjectManager(String name, String date, String address, int citizenCard, int vatNumber, int baseSalary, int code, String[] projects, Date contractDate) {
        super(name, date, address, citizenCard, vatNumber, baseSalary);
        this.code = code;
        this.projects = projects;
        this.contractDate = contractDate;
    }

    // GETTERS E SETTERS
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String[] getProject() {
        return projects;
    }

    public void setProject(String[] project) {
        this.projects = project;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Override
    @Deprecated
    public double getBaseSalary() {
        return (super.getBaseSalary() + super.getBaseSalary() * 0.15 + this.getContractDate().getYear() * 0.015 + super.getBaseSalary() * 0.01 * this.projects.length);
    }

    // metodo toString para imprimir
    public String toString() {
        System.out.print(super.toString());
        String text = "Código de funcionário: " + code + "\n"
                + "Conjunto de projetos que gere : " + Arrays.toString(projects) + "\n"
                + "Data da contratação : " + contractDate + "\n";
        return text;
    }

    public String printProjectManager() {
        return super.toString();
    }
}
