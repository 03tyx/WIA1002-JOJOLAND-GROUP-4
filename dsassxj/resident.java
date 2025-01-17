package dsassxj;

public class resident {
    public String name;
    public String age;
    public String gender;
    public String residentialArea;
    public String parents;
    public stand stand;

    public resident(String name, String age, String gender, String residentialArea, String parents) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.residentialArea = residentialArea;
        this.parents = parents;
    }

    public String getName() {
        return name;
    }
    
    public void setStand(stand stand) {
    	this.stand = stand;
    }
    
    public stand getStand() {
    	if (this.stand == null) {
    		return null;
    	}
    	return this.stand;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getResidentialArea() {
        return residentialArea;
    }

    public String getParents() {
        return parents;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Residential Area: " + residentialArea + "\n" +
                "Parents: " + parents + "\n";
    }
}
