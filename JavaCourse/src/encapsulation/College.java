package encapsulation;


public class College {

    public static void main(String[] args) {
        
        Student student = new Student();
        
        // assigning values to variables
        
        student.setRoll(41);
        student.setName("Sarvesh Kumar Gond");
        student.setCourse("BCA");
        
        // printing values of variables
        
        System.out.println("roll: " + student.getRoll());
        System.out.println("name: " + student.getName());
        System.out.println("course: " + student.getCourse());
        
    }
    
}
