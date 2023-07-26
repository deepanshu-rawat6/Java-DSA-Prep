package com.deepanshu.dsa_practice.practice;

import java.util.Scanner;
class Hospital
{
    doctor dr;
    medicalStore ms = new medicalStore(dr);
    receptionist Riddhi = new receptionist(dr,ms);

}

class doctor {
    public String[][] DoctorInfo;
    int[] fees;
    String[] pres;
    static String city = "Dehradun";

    public String[] prescription() {
        return new String[0];
    }

    ;
}


class Gynecologist extends doctor
{
//    super()DoctorInfo = new DoctorInfo[5][4];
    String[] pres = new String[10];
    int[] fees= {0,500,600,800};
    public Gynecologist()
    {
        String[][] DoctorInfo= {{"serial number", "1.", "2.","3."},
                {"Name","Dr. Sunita Jha", "Dr. Asha Jain", "Dr Mamta Mathur",},
                {"Degree","MBBS", "MBBS MD", "MBBS MS"},
                {"Experience(in years)", "10","5","8"},
                {"Timing","9AM-1PM","2PM-6PM","6PM-8PM"}};

        for(int i=0;i<10;i++)
            pres[i]= null;
    }
    public String[] prescription()
    {
        pres[0]="med1";
        pres[1]="med3";
        pres[2]="med5";
        return pres;
    }
}
class Neurologist extends doctor
{
    int[] fees= {0,500,600,800};

    String[] pres= new String[10];
    static String specialization= "Neurologist";
//    super.DoctorInfo = new DoctorInfo[5][4];
    public Neurologist()
    {
        String[][] DoctorInfo= {{"serial number", "1.", "2.","3."},
        {"Name","Dr. Sunita Jha", "Dr. Asha Jain", "Dr Mamta Mathur",},
        {"Degree","MBBS", "MBBS MD", "MBBS MS"},
        {"Experience(in years)", "10","5","8"},
        {"Timing","9AM-1PM","2PM-6PM","6PM-8PM"}};

        for(int i=0;i<10;i++)
            pres[i]= null;
    }
    public String[] prescription()
    {
        pres[0]="med1";
        pres[1]="med3";
        pres[2]="med5";
        return pres;
    }
}
class Physician extends doctor
{
    int[] fees= {0,500,600,800};
//    super.DoctorInfo = new DoctorInfo[5][4];
    String[] pres= new String[10];

    public Physician()
    {
        String[][] DoctorInfo = {{"serial number", "1.", "2.","3."},
        {"Name","Dr. Sunita Jha", "Dr. Asha Jain", "Dr Mamta Mathur",},
        {"Degree","MBBS", "MBBS MD", "MBBS MS"},
        {"Experience(in years)", "10","5","8"},
        {"Timing","9AM-1PM","2PM-6PM","6PM-8PM"}};

        for(int i=0;i<10;i++)
            pres[i]= null;
    }
    public String[] prescription()
    {
        pres[0]="med1";
        pres[1]="med3";
        pres[2]="med5";
        return pres;
    }
}
class medicalStore
{
    String medicine[]= new String[30];
    int price[]= new int[30];
    int cost;
    doctor dr;
    public medicalStore(doctor dr)
    {
        this.dr= dr;
        int[] price={200, 300, 55, 550, 600, 100, 650, 350, 120, 800,
                600, 600, 505, 580, 60, 1000, 60, 650, 150, 380,
                330, 450, 50, 300, 700, 99, 675, 500, 190, 670};
        String[] medicine = {"med1","med2","med3","med4","med5", "med6", "med7","med8","med9", "med10",
            "med11","med12","med13","med14","med15", "med16", "med17","med18","med19", "med20",
            "med21","med22","med23","med24","med25", "med26", "med27","med28","med29", "med30"};
        cost=0;
    }
    public int bill(String pres[])
    { int i=0, c=0;
        while(pres[i] != null)
        {
            for(int j=0; j<30; j++)
                if(pres[i].equals(medicine[j]))
            {
                c++;
                cost+= price[j];
                break;}
            if(c==0)
                System.out.println(pres[i]+"not available.");
        }
        return cost;
    }
}
class receptionist
{   doctor dr;
    medicalStore ms;
    Scanner sc= new Scanner(System.in);
    receptionist(doctor dr, medicalStore ms )
    {
        this.dr = dr;
        this.ms= ms;
    }
    public void askPatient()
    {    int yn=1;
        do{
            System.out.println("How can I help you?" );
            System.out.println("Enter \n 1. Apointment\n 2. Bill" );
            int what=sc.nextInt();
            switch (what) {
                case 1 -> {
                    System.out.println("Enter :\n 1. Gynecologist\n 2. Neurologist\n 3.Physician");
                    int n = sc.nextInt();
                    switch (n) {
                        case 1 -> dr = new Gynecologist();
                        case 2 -> dr = new Neurologist();
                        case 3 -> dr = new Physician();
                        default -> System.out.println("Not Available");
                    }
                    for (int i = 0; i < dr.DoctorInfo.length; i++) {
                        for (int j = 0; j < dr.DoctorInfo[0].length; j++) {
                            System.out.print(dr.DoctorInfo[j][i] + "\t");
                        }
                        System.out.println();
                    }
                    System.out.println("Enter \n 1. Appointment according to availibity at time\n2. Apointment according preference of doctor");
                    int nn = sc.nextInt();
                    switch (nn) {
                        case 1 -> {
                            System.out.println("Enter serial number of doctor chosen:");
                            int sno = sc.nextInt();
                            appointment(sno);
                        }
                        case 2 -> {
                            System.out.println("Enter ssutable time(e.g. 4:30):");
                            char time = sc.next().charAt(0);
                            appointment(time);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Enter serial number of doctor chosen:");
                    int drno = sc.nextInt();
                    totalbill(drno);
                }
                default -> System.out.println("Invalid Choice");
            }
            System.out.println("If you want anything else enter 1 else 2");
            yn=sc.nextInt();
        }while(yn==1);
    }

    void totalbill(int drno)
    {
        if(drno< dr.DoctorInfo[0].length)
        {
            int medbill= ms.bill(dr.prescription());
            int tbill= medbill + dr.fees[drno];
            System.out.println("Doctor fees :\t"+ dr.fees[drno]+"\nMedicine Cost :\t"+ medbill+"\nTotal Bill:\t"+ tbill);
        }
        else
            System.out.println("Invalid entry.");
    }
    void appointment(int slno)
    { if(slno< dr.DoctorInfo[0].length)
        System.out.println("Your appointment with " + dr.DoctorInfo[1][slno]+"is fixed");
    else
        System.out.println("Not Available.");
    }
    void appointment(char time)
    {
        int c=0;
        int l = dr.DoctorInfo[0].length;
        for(int i=1;i<l ; i++)
            if(time< dr.DoctorInfo[3][i].charAt(4) && time>= dr.DoctorInfo[3][i].charAt(0))
            {
                System.out.println("Your appointment with "+ dr.DoctorInfo[1][i]+"is fixed");
                c++;
            }
        if(c==0)
            System.out.println("No Doctor Available.");
    }
}

public class patient
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Hospital AIIMS = new Hospital();
        AIIMS.Riddhi.askPatient();
    }
}