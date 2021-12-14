package pkg;
import pkg.VehicleInfo;

public class CustomerProf {
    //define the attributes for the CustomerProf Object
    private String adminID, firstName, lastName, address, phone, status, use;
    private float income;
    private VehicleInfo vhInfo;


    //Constructor for the customer profiles
    public CustomerProf(String adminID, String firstname, String lastname, String address, String phonenumber,
                        float income, String status, String use, VehicleInfo vehicleInformation) {
        //set all the attributes
        this.adminID = adminID;
        this.firstName = firstname;
        this.lastName = lastname;
        this.address = address;
        this.phone = phonenumber;
        this.status = status;
        this.use = use;
        this.income = income;
        this.vhInfo = vehicleInformation;
    }

    //return adminid
    public String getadminID() {
        return adminID;
    }

    //return firstname
    public String getFirstName() {
        return firstName;
    }

    //return lastname
    public String getLastName() {
        return lastName;
    }

    //return address
    public String getAddress() {
        return address;
    }

    //return phone
    public String getPhone() {
        return phone;
    }

    //return income
    public float getIncome() {
        return income;
    }

    //return status
    public String getStatus() {
        return status;
    }

    //return use
    public String getUse() {
        return use;
    }

    //return vehicle info
    public VehicleInfo getVhInfo() {
        return vhInfo;
    }

    //update the first name with the method input
    public void updateFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    //update the last name with the method input
    public void updateLastName(String newLastName) {
        lastName = newLastName;
    }

    //update the address with the method input
    public void updateAddress(String newAddress) {
        address = newAddress;
    }

    //update the phone with the method input
    public void updatePhone(String newPhone) {
        phone = newPhone;
    }

    public void updateUse(String newUse) {
        use = newUse;
    }

    //update the income with the method input
    public void updateIncome(float newIncome) {
        income = newIncome;
    }

    //update the status with the method input
    public void updateStatus(String newStatus) {
        status = newStatus;
    }

    //update the vehicle info with the method input
    public void updateVehicleInfo(String model, String type, String year, String method) {
        vhInfo.updateModel(model);
        vhInfo.updateType(type);
        vhInfo.updateYear(year);
        vhInfo.updateMethod(method);
    }
}
