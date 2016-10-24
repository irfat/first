import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 * This is a class to define the necessary attributes and methods to conceptualize a "Student"
 * The spepcific tasks are:
 * 1. Instiate 
 * 
 * @author IRFAT IRA
 * @version 24.10.2016
 */

public class Student{
	static Scanner input = new Scanner(System.in);  //Use for Scan data from user
    int id;
    String name,department,university;
    double cgpa;
    double gpa;
    String[] subjects;
    double[][] GPA;  // First index used for Year & 2nd in for Semester Ex : gpa[1][2] (first year 2nd semester) 
    double[][][] credits; //First index for year 2nd is for semester & 3rd is for Subject number
    double[][][] grades; //First index for year 2nd is for semester & 3rd is for Subject number
    
    
    

    /**
     * Define a constructor that initilize the default properties of the Student
     */
    public Student(){
        // initialise   variables with defult values
    	id = 0;
    	name = null;
    	department = null;
    	university = null;
    	GPA = new double[4][2];
    	subjects=new String[10];
    	credits = new double[4][2][5];
    	grades = new double[4][2][5];
        
    }
    /**
     * Define a method to print the students details.
     */
    
    public void studentDetailsById(int id){
        //write your code here
    	System.out.println("ID : "+id);
    	System.out.println("Name : "+name);
    	System.out.println("Depertment : "+department);
    	System.out.println("University : "+university);
	}
    
    /**
     * Define a method to update information of students by ID
     * Use as many arguments as required.
     */
    public void updateStudentById(int id){
        //Write your code here
    	this.id = id;
    	input.nextLine();
    	System.out.print("Enter name : ");
        name = input.nextLine();
    	System.out.print("Enter University name : ");
    	university = input.nextLine();
    	System.out.print("Enter Department name : ");
    	department = input.nextLine(); 
    	for(int i=0;i<8;i++)
    	{
    	    System.out.println("enter gpa of" +(i+1)+"semister:");
    	    gpa=gpa+input.nextDouble();
    	}
   
    }
    
    /**
     * Define a method to compute the CGPA from the Given term GPA for a particular student.
     * se as many arguments as required.
     */
    public double computeCGPAByID(int id)
    {
        double cgpa;
        cgpa=gpa/8.0;
        System.out.println(cgpa);
        return cgpa;
    }
    
    /**
     * Define a method to compute the GPA from the given Credits and Grades of all the subjects
     */
    public double computeGPAById(int id)
    {
        double result=0;
        double total=0;
        double gpa=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<8;j++)
            {
                for(int k=0;k<10;k++)
                {
                    System.out.print("enter credits and grades of"+ (i+1)+" year and"+(j+1)+" semister and"+(k+1)+"subjects:");
                    credits[i][j][k]=input.nextDouble();
                    total+=credits[i][j][k];

                    grades[i][j][k]=input.nextDouble();
                    result+=credits[i][j][k]*grades[i][j][k];
                }
                GPA[i][j]=result/total;
                System.out.println(GPA[i][j]);
            }
        }
        return 0.0;
    }
    
    /**
     * After performing required operations on each student, save the information to a file. Use File and PrintWriter Class. 
     * use as many arguments as required.
     * 
     */
   public void saveStudents()
    {
        try
        {
            File outputFile = new File ("out.txt");
            PrintWriter writer = new PrintWriter (outputFile);
            
            writer.println ("Name : " + name);
            writer.println ("ID : " + id);
            writer.println ("Deptartment : " + department);
            writer.println ("university : " + university);
            writer.println ("Current CGPA : " + cgpa);
            writer.println ("Current GPA : "+gpa);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.print (e);
        }
    }
    
    
    /**
     * The tasks to be carried out here:
     * 1. Create an Arrays of students using Student Class. Initlize them and perfom all the above defined operation to evualuate your code.
     * use as many arguments as required.
     */
    public static void main(String[] args){
    	int n,iD;
    	double cg;
    	
    	System.out.print("How many Students ? ");
    	n = input.nextInt();
    	Student[] student = new Student[n]; //Create n object of Student Class
    	for (int i = 0; i < n; i++) {
    		System.out.println("-----Update Student " + i+1 +" Information");
    		System.out.print("Enter ID no : ");
    		iD = input.nextInt();
    		student[i] = new Student(); //Memory allocation for nth stud
    	
				student[i].updateStudentById(iD);
				student[i].studentDetailsById(iD);
				student[i].computeCGPAByID(iD);
				cg = student[i].computeCGPAByID(iD);
			    System.out.println("CGPA:"+cg);
			    student[i].saveStudents();

    }
}
}