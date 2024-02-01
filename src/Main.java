import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        while(again) {
            System.out.println("Do you want to register for Trip? if yes press 'y' otherwise press any other key");
            String regInput = sc.next();
            if (!(regInput.equals("y") || regInput.equals("Y"))) {
                System.out.println("Bye");
                return;
            }
            String path = "C:/Users/12678/Desktop/learning/CreateWriteFolderFile/src/database/";
            System.out.println("Enter Your Name: ");
            String name = sc.next();
            path = path + name;
            //Instantiate the File class
            File f1 = new File(path);
            //Creating a folder using mkdir() method
            boolean bool = f1.mkdir();
            if (bool) {
                System.out.println("Folder is created successfully");
                try {
                    String fileName = name + Math.random() * 100;
                    File myObj = new File(path + "/" + fileName + ".json");
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                    System.out.println("Enter your preferred vacation destination:");
                    String destination = sc.next();
                    System.out.println("Enter your email: ");
                    String email = sc.next();
                    System.out.println("Enter your phone no: ");
                    String phone = sc.next();
                    System.out.println("Enter you address: ");
                    String address = sc.next();
                    try {
                        FileWriter myWriter = new FileWriter(new File(path, fileName + ".json"));
                        myWriter.write("Name: "+name + "\n" + "Destination: " + destination + "\n" + "Email: "+ email + "\n" + "Phone: "+ phone + "\n" + "Address: "+ address);
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error Found!");
            }
            System.out.println("Do you want to book again? Press 'y' if yes other press any other key: ");
            String ansagain = sc.next();
            if(!ansagain.equals("y")){
                again = false;
            }
        }

    }
}