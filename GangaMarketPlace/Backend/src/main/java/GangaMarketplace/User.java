package GangaMarketplace;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.core.style.ToStringCreator;
@Entity
@Table(name ="users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name ="name")
    @NotFound(action = NotFoundAction.IGNORE)
    private String name;
    @Column(name ="address")
    @NotFound(action = NotFoundAction.IGNORE)
    private String address;
    @Column(name ="telephone_number")
    @NotFound(action = NotFoundAction.IGNORE)
    private String tNumber;
    @Column(name ="username")
    @NotFound(action = NotFoundAction.IGNORE)
    private String userName;
    @Column(name ="password")
    @NotFound(action = NotFoundAction.IGNORE)
    private String password;
    @Column(name ="email")
    @NotFound(action = NotFoundAction.IGNORE)
    private String email;
    public User(){

    }
    public User(int id,String name, String address, String tnumber)
    {
        this.id=id;
        this.name=name;
        this.address=address;
        this.tNumber=tnumber;
    }

    public Integer getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String gettNumber(){
        return tNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }
    public boolean isNew() {
        return this.id == null;
    }
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("new", this.isNew())
                .append("name", this.getName())
                .append("address", this.address)
                .append("telephone", this.tNumber)
                .toString();
    }
}