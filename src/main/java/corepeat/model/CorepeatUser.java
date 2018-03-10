package corepeat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COREPEAT_USER",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_ID"})})
public class CorepeatUser {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(name = "MAIL")
    @JsonProperty("userEmail")
    private String userEmail;

    @Column(name = "PASSWORD_HASH")
    @JsonProperty("passwordHash")
    private char[] passwordHash;

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

    @Column(name = "SURNAME")
    @JsonProperty("surname")
    private String surname;

    @Column(name = "BIRTHDATE")
    @JsonProperty("birthDate")
    private String birthDate;

    @Column(name = "CITY")
    @JsonProperty("city")
    private String city;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "USER_COREPEATS",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COREPEAT_ID")}
    )
    @JsonProperty("corepeats")
    Set<Corepeat> corepeats = new HashSet<>();

    @OneToMany(mappedBy = "mentor")
    @JsonProperty("mentoredCorepeats")
    Set<Corepeat> mentoredCorepeats = new HashSet<>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public char[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(char[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Corepeat> getCorepeats() {
        return corepeats;
    }

    public void setCorepeats(Set<Corepeat> corepeats) {
        this.corepeats = corepeats;
    }

    public Set<Corepeat> getMentoredCorepeats() {
        return mentoredCorepeats;
    }

    public void setMentoredCorepeats(Set<Corepeat> mentoredCorepeats) {
        this.mentoredCorepeats = mentoredCorepeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorepeatUser that = (CorepeatUser) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(userEmail, that.userEmail) &&
                Arrays.equals(passwordHash, that.passwordHash) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userEmail, name, surname, birthDate, city);
        result = 31 * result + Arrays.hashCode(passwordHash);
        return result;
    }
}
