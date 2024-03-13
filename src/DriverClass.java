import java.util.ArrayList;
public class DriverClass {
    public static void main(String[] args) {


    }
}

//------------------------------
abstract  class Student{
    private String name;
    private String id;

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

    public void calculateUndergradPay(){
        int i=0;
        double total =0;
        int hour = 0;
        for(Integer crn: undergradCrnsTaken){
            hour += getCreditHour(crn);
        }
        total = hour * 120.25;
    }
    @Override
    public void printInvoice(){
        System.out.println("\nVALENCE COLLEGE");
        System.out.println("ORLANDO FL 10101");
        System.out.println("-------------------------\n");
        System.out.println("Fee Invoice Prepared for Student:");
        System.out.println(getId() + "-" + getName() + "\n");
        System.out.println("1 Credit Hour = $120.25");
        System.out.println("\nCRN\t\tCR_PREFIX\tCR_HOURS\t");
        for(int crn: undergradCrnsTaken){
            System.out.println(crn +"   "+ getCourseName(crn)+"     "+getCreditHour(crn));
        }
    }
}

//-------------------------------------
abstract class GraduateStudent extends Student{
    int crn;

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
    public PhdStudent(String name, String id, String advisor, String researchSubject ,int crn){
        super(name, id, crn);
        this.advisor = advisor;
        this.researchSubject= researchSubject;
    }

    @Override
    public void printInvoice(){
        System.out.println("\nVALENCE COLLEGE");
        System.out.println("ORLANDO FL 10101");
        System.out.println("-------------------------\n");
        System.out.println("Fee Invoice Prepared for Student:");
        System.out.println(getId() + "-" + getName() + "\n");
        System.out.println("Research");
        System.out.println(researchSubject+"             $700");

    }
}
class MsStudent extends GraduateStudent {
    private int [] gradCrnsTaken;
    private int crn;
    public MsStudent (String name, String id , int [] gradCrnsTaken , int crn ){
        super(name, id, crn);
        this.gradCrnsTaken=gradCrnsTaken;
    }
    @Override
    public void printInvoice() {
        System.out.println("\nVALENCE COLLEGE");
        System.out.println("ORLANDO FL 10101");
        System.out.println("-------------------------\n");
        System.out.println("Fee Invoice Prepared for Student:");
        System.out.println(getId() + "-" + getName() + "\n");
        System.out.println("1 Credit Hour = $300.00");
    }
}
