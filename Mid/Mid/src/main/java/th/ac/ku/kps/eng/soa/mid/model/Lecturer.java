package th.ac.ku.kps.eng.soa.mid.model;

import java.io.Serializable;

public class Lecturer implements Serializable{
private int id;
private String name;
private String email;
private Department department;

public Lecturer() {

}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public Department getDepartment() {
return department;
}
public void setDepartment(Department department) {
this.department = department;
}



}