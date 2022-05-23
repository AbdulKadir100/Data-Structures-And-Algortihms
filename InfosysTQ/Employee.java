package InfosysTQ;

class Employee1 {
    private int empID;
    private String empName;
    private double empSal;

    public Employee1(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", empSal=" + empSal +
                '}';
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }
}

class PermanentEmployee extends Employee1 {
    private double basicPay;
    private double hra;
    private float experince;

    public PermanentEmployee(int empID, String empName, double basicPay, double hra, float experince) {
        super(empID, empName);
        this.basicPay = basicPay;
        this.hra = hra;
        this.experince = experince;
    }

    public void calculateMonthlySalary() {
        double bsal = 0, hra, basicPay, varCompt = 0;
        hra = getHra();
        basicPay = getBasicPay();
        varCompt = getExperince();
        double percent = 0;
        if (varCompt < 3) {
            basicPay += 0;
        } else if (varCompt >= 3 && varCompt < 5) {
            percent = (basicPay * 5)/100;
            basicPay +=  percent;
        } else if (varCompt >= 5 && varCompt < 10) {
            basicPay += basicPay % 7;
        } else if (varCompt >= 12) {
            basicPay += basicPay % 10;
        }
        bsal = hra + basicPay + varCompt;
        System.out.println(bsal);

    }

    @Override
    public String toString() {
        return "PermanentEmployee{" +
                "basicPay=" + basicPay +
                ", hra=" + hra +
                ", experince=" + experince +
                '}';
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public float getExperince() {
        return experince;
    }

    public void setExperince(float experince) {
        this.experince = experince;
    }
}

class ContractEmployee extends Employee1 {

    private double wage;
    private float workedhour;

    public ContractEmployee(int empID, String empName, double wage, float workedhour) {
        super(empID, empName);
        this.wage = wage;
        this.workedhour = workedhour;
    }

    public void calculateSalary() {

    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "wage=" + wage +
                ", workedhour=" + workedhour +
                '}';
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public float getWorkedhour() {
        return workedhour;
    }

    public void setWorkedhour(float workedhour) {
        this.workedhour = workedhour;
    }
}

class Employee {
    public static void main(String[] args) {
        PermanentEmployee permanentEmployee = new PermanentEmployee(711211, "Rafael", 1850, 115, 3.5f);
        permanentEmployee.calculateMonthlySalary();
        System.out.println("Hi " + permanentEmployee.getEmpName() + ", your salary is $" + Math.round(permanentEmployee.getEmpSal() * 100) / 100.0);


    }
}