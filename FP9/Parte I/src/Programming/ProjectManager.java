package Programming;

import java.util.Arrays;

public class ProjectManager extends Person {
    // variaveis de instancia de ProjectManager
    private int code;
    private String projects[];
    private String contractDate;

    // construtor default de ProjectManager
    public ProjectManager() {
    }

    // construtor de ProjectManager
    public ProjectManager(String name, String date, String address, int citizenCard, int vatNumber, double baseSalary, int code, String[] projects, String contractDate) {
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

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    // metodo toString para imprimir
    public String toString() {
        String text = "Código de funcionário: " + code + "\n"
                + "Conjunto de projetos que gere : " + Arrays.toString(projects) + "\n"
                + "Data da contratação : " + contractDate + "\n";
        return text;
    }
}
