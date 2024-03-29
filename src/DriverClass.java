//Unit 5 Assignment 5
//Group Members: Jean Carlos Lin Lai, Wenteng Lin

import java.util.ArrayList;
//driver class
public class DriverClass {
    public static void main(String[] args) {
        Student s;
        s = new PhdStudent ("Zaydoun BenSellam",
                "zb5954" ,
                "Gary Richarson",
                "Fuzzy Topology" ,
                2599 );

        s.printInvoice();
        //***********
        int [] gradCrnsTaken = {7587,8997} ;
        s = new MsStudent ( "Emily Jones",
                "em1254",
                gradCrnsTaken,
                1997);
        s.printInvoice();

        //************
        int [] undergradCrnsTaken = {4587,2599};
        s = new UndergraduateStudent ("Jamila Jones" ,
                "ja5225" ,
                undergradCrnsTaken ,
                3.0,
                true);
        s.printInvoice();
    }
}

//-------------------------------
//Student class
abstract  class Student{
    private String name;
    private String id;
// setters and getters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public Student(String name, String id){
        this.name = name;
        this.id = id;
    }

    //switch to get course name and credit hour
    public String getCourseName(int crn){
        switch(crn){
            case 4587:
                return "MAT 236";
            case 4599:
                return "COP 220";
            case 8997:
                return "GOL 124";
            case 9696:
                return "COP 100";
            case 4580:
                return "MAT 136";
            case 2599:
                return "COP 260";
            case 1997:
                return "CAP 424";
            case 5696:
                return "KOL 110";
            case 7587:
                return "MAT 936";
            case 1599:
                return "COP 111";
            case 6997:
                return "GOL 109";
            case 2696:
                return "COP 101";
            case 5580:
                return "MAT 636";
            case 2099:
                return "COP 268";
            case 4997:
                return "CAP 427";
            case 3696:
                return "KOL 910";
        }
        return "Course not found";
    }
    public int getCreditHour(int crn){
        switch(crn){
            case 4587:
                return 4;
            case 4599:
                return 3;
            case 8997:
                return 1;
            case 9696:
                return 3;
            case 4580:
                return 1;
            case 2599:
                return 3;
            case 1997:
                return 1;
            case 5696:
                return 2;
            case 7587:
                return 5;
            case 1599:
                return 3;
            case 6997:
                return 1;
            case 2696:
                return 3;
            case 5580:
                return 2;
            case 2099:
                return 3;
            case 4997:
                return 1;
            case 3696:
                return 2;
        }
        return 0;
    }

    abstract public void printInvoice();
}
//---------------------------------------------

// Undergrad class
class UndergraduateStudent extends Student {
    private int[] undergradCrnsTaken;
    private double gpa;
    private boolean resident;

    public UndergraduateStudent(String name , String id , int [] undergradCrnsTaken , double gpa, boolean resident) {
        super(name, id);

        this.undergradCrnsTaken = undergradCrnsTaken;
        this.gpa = gpa;
        this.resident = resident;

    }

    // getter and setter
    public int[] getUndergradCrnsTaken() {
        return undergradCrnsTaken;
    }
    public void setUndergradCrnsTaken(int[] undergradCrnsTaken) {
        this.undergradCrnsTaken = undergradCrnsTaken;
    }
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public boolean getResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    // calculate payment
    public double calculateUndergradPay(){
        double creditHourFee = 120.25;
        double services = 35;
        double totalPayment = 0;
        gpa = getGpa();

        if(resident != true){
            creditHourFee= creditHourFee * 2;
        }else {
            creditHourFee = 120.25;
        }

        for(int crn: undergradCrnsTaken){
            int creditHour = getCreditHour(crn);
            totalPayment += creditHour * creditHourFee;
        }

        return totalPayment + services;
    }

    // calculate discount to give based on GPA
    private double calculateUnderGradDiscount(){
        double creditHourFee = 120.25;
        double services = 35;
        double totalPayment = 0;
        gpa = getGpa();

        totalPayment = calculateUndergradPay();

        if(gpa >= 3.5 && totalPayment >= 500){
            return ((totalPayment) * 0.25);
        }
        else{
            return totalPayment = 0;
        }

    }
// calculate discount based on residency
    public double checkResidentDiscount(){
        double creditHourPrice = 120.25;
        if (resident != true){
            return creditHourPrice * 2;
        }else {
            return creditHourPrice;
        }
    }

    // print invoice
    @Override
    public void printInvoice(){
        double service = 35.00;
        System.out.println("\nVALENCE COLLEGE");
        System.out.println("ORLANDO FL 10101");
        System.out.println("-------------------------\n");
        System.out.println("Fee Invoice Prepared for Student:");
        System.out.println(getId() + "-" + getName() + "\n");
        System.out.println("1 Credit Hour = $" + checkResidentDiscount());
        System.out.println("\nCRN\t\tCR_PREFIX\tCR_HOURS\t");
        for(int crn: undergradCrnsTaken){
            double courseTotal;

            if (resident != true){
                courseTotal = getCreditHour(crn) * (120.25 * 2);
            }else{
                courseTotal = getCreditHour(crn) * 120.25;
            }


            System.out.println(crn +"\t"+ getCourseName(crn)+"\t\t"+getCreditHour(crn)+ "\t\t\t$ "+ courseTotal);
        }
        System.out.println("\t\t\tHealth and id Fees  $ "  + service);
        System.out.println("-----------------------------------------");
        System.out.println("\t\t\t\tTotal Payment:  $ "+ calculateUndergradPay());
        System.out.println("\t\t\t\t\t\t\t   -$ "+ calculateUnderGradDiscount());
        System.out.println("-----------------------------------------");
        System.out.println("\t\t\t\tTotal Payments  $ " +(calculateUndergradPay() - calculateUnderGradDiscount()));
    }
}

//-------------------------------------
// Graduate student class
abstract class GraduateStudent extends Student{
    int crn;

    // getter and setter
    public void setCrn(int crn){
        this.crn= crn;
    }

    public int getCrn(){
        return crn;
    }

    public GraduateStudent (String name, String id, int crn){
        super(name, id);
        this.crn = crn;

    }
}

//-------------------------------
class PhdStudent extends GraduateStudent {

    private String advisor;

    private String researchSubject;

    // getter and setter

    public String getResearchSubject() {
        return researchSubject;
    }

    public void setResearchSubject(String researchSubject) {
        this.researchSubject = researchSubject;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public PhdStudent(String name, String id, String advisor, String researchSubject, int crn) {
        super(name, id, crn);
        this.advisor = advisor;
        this.researchSubject = researchSubject;
    }


    //check for whether they are doing research
    public double checkIfResearch() {
        researchSubject = researchSubject;
        double reserachCost = 700;
        if (researchSubject != null) {
            return reserachCost;
        } else {return 0;
        }
    }

// print invoice
    @Override
    public void printInvoice(){
        double services = 35;
        System.out.println("\nVALENCE COLLEGE");
        System.out.println("ORLANDO FL 10101");
        System.out.println("--------------------------------------\n");
        System.out.println("Fee Invoice Prepared for Student:");
        System.out.println(getId() + "-" + getName() + "\n");
        System.out.println("Research");
        System.out.println(researchSubject+"\t\t\t$ "+ checkIfResearch()+ "\n");
        System.out.println("\t\tHealth and ID\t$ " + services);
        System.out.println("--------------------------------------");
        System.out.println("\t\tTotal Payments\t$ "+ (checkIfResearch()+services));

    }
}
class MsStudent extends GraduateStudent {
    private int [] gradCrnsTaken;
    private int crn;

    //getter and setter
    public int[] getGradCrnsTaken() {
        return gradCrnsTaken;
    }

    public void setGradCrnsTaken(int[] gradCrnsTaken) {
        this.gradCrnsTaken = gradCrnsTaken;
    }

    public MsStudent (String name, String id , int [] gradCrnsTaken , int crn ){
        super(name, id, crn);
        this.gradCrnsTaken=gradCrnsTaken;
    }

    public double calculateGradPay(){
        double creditHourFee = 300;
        double services = 35;
        double totalPayment = 0;

        for(int crn: gradCrnsTaken){
            int creditHour = getCreditHour(crn);
            totalPayment += creditHour * creditHourFee;
        }

        return totalPayment + services;


    }
    //print invoice
    @Override
    public void printInvoice() {
        double services = 35;
        System.out.println("\nVALENCE COLLEGE");
        System.out.println("ORLANDO FL 10101");
        System.out.println("-------------------------\n");
        System.out.println("Fee Invoice Prepared for Student:");
        System.out.println(getId() + "-" + getName() + "\n");
        System.out.println("1 Credit Hour = $300.00");
        System.out.println("\nCRN\t\tCR_PREFIX\tCR_HOURS\t");
        for(int crn: gradCrnsTaken){
            double courseTotal = getCreditHour(crn) * 300;

            System.out.println(crn +"\t"+ getCourseName(crn)+"\t\t"+getCreditHour(crn)+ "\t\t\t$ "+ courseTotal);
        }
        System.out.println("\t\t\tHealth and id Fees  $ "  + services);
        System.out.println("--------------------------------------------");
        System.out.println("\t\t\t\tTotal Payments  $ " +(calculateGradPay()));


    }
}