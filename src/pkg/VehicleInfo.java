package pkg;

public class VehicleInfo {
    //define the attributes of this class
    private String model, type, method, year;


    //define the constructor for VehicleInfo
    public VehicleInfo(String model, String type, String method, String year) {
        //set the attributes of the class
        this.model = model;
        this.type = type;
        this.method = method;
        this.year = year;
    }

    //retur model
    public String getModel() {
        return model;
    }

    //return type
    public String getType() {
        return type;
    }

    //return year
    public String getYear() {
        return year;
    }

    //return method
    public String getMethod() {
        return method;
    }

    //update the model with the method input
    public void updateModel(String newModel) {
        model = newModel;
    }

    //update the type with the method input
    public void updateType(String newType) {
        type = newType;
    }

    //update the year with the method input
    public void updateYear(String newYear) {
        year = newYear;
    }

    //update the method with the method input
    public void updateMethod(String newMethod) {
        method = newMethod;
    }
}
