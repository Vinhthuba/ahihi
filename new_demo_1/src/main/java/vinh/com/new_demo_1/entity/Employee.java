package vinh.com.new_demo_1.entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String last_name;
    @Column(name="email")
    private String email;

    public Employee()
    {

    }
    public Employee(int id, String firstName, String lastName, String email)
    {
        this.id=id;
        this.firstName=firstName;
        this.last_name = lastName;
        this.email  =email  ;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString()
    {
        return "Employee [id=" + id+", firstName"+firstName+", lastName"+last_name+", email"+email+"]";
    }

}
