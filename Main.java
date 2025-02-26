import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("******STUDENT GRADE TRACKER******");
        System.out.println("ENTER THE NUMBER OF STUDENTS");
        int numStudents=sc.nextInt();
        int[] grades=new int[numStudents];
        int count=0;

        int choice;
        do{
            System.out.println("\n Menu:");
            System.out.println("1. Add a grade");
            System.out.println("2. View grade");
            System.out.println("3. Calculate average grade");
            System.out.println("4. Find highest grade");
            System.out.println("5. Find lowest grade");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(count<numStudents) {
                        System.out.println("Enter the grade(0-100):");
                        int grade = sc.nextInt();
                        if (grade >= 0 && grade <= 100) {
                            grades[count] = grade;
                            count++;
                            System.out.println("Grade added successfully.");
                        } else {
                            System.out.println("Invalid grade! Please enter a value between 0 and 100.");

                        }
                    }
                    else{
                        System.out.println("Cannot add more grades Maximum number of students reached");
                    }
                    break;
                case 2:
                   if(count>0){
                       System.out.println("Grades:");
                       for(int i=0;i<count;i++){
                           System.out.println(grades[i]+" ");
                       }
                       System.out.println();
                   }
                   else{
                       System.out.println("No grades entered yet");
                   }
                   break;
                case 3:
                    if(count>0){
                        double average=calculateAverage(grades,count);
                        System.out.printf("Average Grade: %.2f%n",average);

                    }
                    else{
                        System.out.println("No grades available to calculate average.");

                    }
                    break;
                case 4:
                 if(count>0){
                     int highest=findHighest(grades,count);
                     System.out.println("Highest Grade: "+highest);
                 }
                 else{
                     System.out.println("No grades available to find the highest grade");

                 }
                 break;
                case 5:
                    if(count>0){
                        int lowest=findLowest(grades,count);
                        System.out.println("Lowest Grade: "+lowest);
                    }
                    else{
                        System.out.println("No grades available to find the lowest grade");

                    }
                    break;
                case 6:
                    System.out.println("Exiting the program........");
                    break;
                default:
                    System.out.println("Invalid choice! please try again.");

            }
        } while(choice!=6);
        sc.close();
    }
    private static int findHighest(int[] grades,int count){
        int highest=grades[0];
        for(int i=1;i<count;i++){
            if(grades[i]>highest){
                highest=grades[i];
            }
        }
        return highest;
    }
private static int findLowest(int[] grades,int count){
    int lowest=grades[0];
    for(int i=1;i<count;i++){
        if(grades[i]<lowest){
            lowest=grades[i];
        }
    }
    return lowest;
}
public static double calculateAverage(int[] grades,int count){
        int sum=0;
        for(int i=0;i<count;i++){
            sum+=grades[i];
        }
        return (double) sum/count;
}
}