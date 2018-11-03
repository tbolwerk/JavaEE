public class Person {

    private int person_id;
    private String lastname,firstname,gender;
    public Person(int person_id,String lastname,String firstname){
        this(person_id,lastname,firstname,null);
    }

    public Person(int person_id,String lastname,String firstname,String gender){
        this.person_id=person_id;
        this.lastname=lastname;
        this.firstname=firstname;
        this.gender=gender;
    }
    public int getPerson_id() {
        return person_id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getGender() {
        return gender;
    }

}
