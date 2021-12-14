package pkg;
import pkg.CustomerProf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class CustomerProfDB {
    //define attributes for customer profile database
    public int numCustomer = 0, curCustomerIndex = 0;
    private String fileName;
    public CustomerProf[] customerList = new CustomerProf[0];

    //constructor for the customer profile database
    CustomerProfDB(String str) {
        //intiailize the database from the provided file path string
        initializeDatabase(str);
        //set the attribute filename
        fileName = str;
    }

    //adds a customer profile to the array
    public void insertNewProfile(CustomerProf newCustomer) {
        //extends the array adding 1 to length
        addOneToArray();
        //sets the last element of the array as the new customer profile
        customerList[customerList.length-1] = newCustomer;
    }

    //deletes a profile from the array if the adminID and lastname match
    public boolean deleteProfile(String adminID, String lastname) {
        //loops through every customer profile in the array
        for(int i = 0; i < customerList.length; i++) {
            //System.out.println(i + " " + customerList[i].getadminID() + " " + customerList[i].getLastName());
            if(customerList[i].getadminID().equals(adminID) && customerList[i].getLastName().equals(lastname)) {
                //if the profile is found all the other elements will be moved down
                for(int k = i; k < customerList.length-1; k++) {
                    customerList[k] = customerList[k+1];
                }
                //delete the last slot from the array, decreasing its length by 1
                removeOneFromArray();
                return true;
            }
        }
        //if the profile doesn't exist return false
        return false;
    }

    //finds the profile specified by the adminid and lastname
    public CustomerProf findProfile(String adminID, String lastname) {
        //loops through all the customers in the array
        for(int i = 0; i < customerList.length; i++) {
            if(customerList[i].getadminID().equals(adminID) && customerList[i].getLastName().equals(lastname)) {
                //return the customer if it was found
                return customerList[i];
            }
        }
        return null;
    }

    //returns the first profile in the array
    public CustomerProf findFirstProfile() {
        //System.out.println("| " + customerList.length);
        if(customerList.length == 0) {
            return null;
        }
        curCustomerIndex = 0;
        return customerList[0];
    }

    //returns the next profile based on the customer index
    public CustomerProf findNextProfile() {
        curCustomerIndex++;
        if(curCustomerIndex >= customerList.length) {
            return null;
        }
        return customerList[curCustomerIndex];
    }

    //writes all the customer profiles to the database
    public void writeAllCustomerProf() {
        //define a file f with file path based on file name
        File f = new File(fileName);
        try {
            //create object print writer for writing to the file
            PrintWriter printWriter = new PrintWriter(fileName);
            //prints the header for the file
            printWriter.write("adminID, firstName, lastName, address, phoneNumber, income, status, use, model, year, type, method\n");
            //for each customer in the customer array
            for(int i = 0; i < customerList.length; i++) {
                //puts all the customer prof attributes in a single line seperated by commas in csv format
                printWriter.write(customerList[i].getadminID() + ",");
                printWriter.write(customerList[i].getFirstName() + ",");
                printWriter.write(customerList[i].getLastName() + ",");
                printWriter.write(customerList[i].getAddress() + ",");
                printWriter.write(customerList[i].getPhone() + ",");
                printWriter.write(customerList[i].getIncome() + ",");
                printWriter.write(customerList[i].getStatus() + ",");
                printWriter.write(customerList[i].getUse() + ",");
                printWriter.write(customerList[i].getVhInfo().getModel() + ",");
                printWriter.write(customerList[i].getVhInfo().getYear() + ",");
                printWriter.write(customerList[i].getVhInfo().getType() + ",");
                printWriter.write(customerList[i].getVhInfo().getMethod() + "\n");
            }
            //closes the file and saves it
            printWriter.close();
        } catch (Exception e) {
            //if there was an error print.
            System.out.println("Error Writing To Database");
        }
    }

    //private method to increase array size by one
    private void addOneToArray() {
        //makes new array with one more length
        CustomerProf[] newlist = new CustomerProf[customerList.length+1];
        for(int i = 0; i < customerList.length; i++) {
            newlist[i] = customerList[i];
        }
        numCustomer++;
        customerList = newlist;

    }

    //private array to decrease array size by one
    private void removeOneFromArray() {
        //decreases array size by one.
        CustomerProf[] newlist = new CustomerProf[customerList.length-1];
        for(int i = 0; i < customerList.length-1; i++) {
            newlist[i] = customerList[i];
        }
        numCustomer--;
        customerList = newlist;

    }

    //method to initialize the database from the filepath
    public void initializeDatabase(String file) {
        //creates the file with the path of string 'file'
        File f = new File(file);
        try {
            //attempts to create a new file, if it is false, then the file already exists
            if(f.createNewFile()) {

            } else {
                //creates new scanner object with file input, for reading the file
                Scanner sc = new Scanner(f);
                //reads the first line of the file
                String line = sc.nextLine();
                //while the file has a next line
                while(sc.hasNextLine()) {
                    //reads the line
                    line = sc.nextLine();
                    //splits the line by the commas
                    String[] split = line.split(",");
                    //if the length is less than 12 then it is missing an element and thus something went wrong
                    if(split.length != 12) {
                        System.out.println("Bad CSV file");
                        return;
                    }
                    //adds 1 to array length
                    addOneToArray();
                    //create a new customer profile and adds it to the array based on file input
                    customerList[customerList.length-1] = new CustomerProf(split[0],
                            split[1],
                            split[2],
                            split[3],
                            split[4],
                            Float.parseFloat(split[5]),
                            split[6],
                            split[7],
                            new VehicleInfo(split[8], split[10].toLowerCase(), split[11].toLowerCase(), split[9]));

                }
                //System.out.println(customerList.length);
                //closes the scanner for reading
                sc.close();
            }
            //catch and errors or exceptions
        } catch(Exception e) {
            System.out.println("Bad File Path or Database Structure");
        }
    }
}
