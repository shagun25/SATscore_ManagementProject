package stdapp;

public class Student {
    private String name;
    private String city;
    private String country;
    private int pincode;
    private double SATscore;
    private String passed;

    public Student(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public double getSATscore() {
        return SATscore;
    }

    public void setSATscore(double SATscore) {
        this.SATscore = SATscore;
    }

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pincode +
                ", SATscore=" + SATscore +
                ", passed='" + passed + '\'' +
                '}';
    }
}
