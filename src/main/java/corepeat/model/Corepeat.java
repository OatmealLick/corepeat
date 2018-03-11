package corepeat.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "corepeatId")
@Table(name = "COREPEAT",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"COREPEAT_ID"})})
public class Corepeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COREPEAT_ID")
    private Integer corepeatId;

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

    @Column(name = "CITY")
    @JsonProperty("city")
    private String city;

    @Column(name = "COORDINATES")
    @JsonProperty("coordinates")
    private String coordinates;

    @Column(name = "DESCRIPTION")
    @JsonProperty("description")
    private String description;

    @Column(name = "MAX_PARTICIPANTS")
    @JsonProperty("maxParticipants")
    private Integer maxParticipants;

    @Column(name = "MAX_MENTORS")
    @JsonProperty("maxMentors")
    private Integer maxMentors;

    @Column(name = "CURRENT_PARTICIPANTS")
    @JsonProperty("currentParticipants")
    private Integer currentParticipants;

    @Column(name = "CURRENT_MENTORS")
    @JsonProperty("currentMentors")
    private Integer currentMentors;

    @Column(name = "DATE")
    @JsonProperty("date")
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "corepeats")
    private Set<CorepeatUser> participants = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "MENTOR_ID")
    @JsonProperty("mentor")
    @JsonBackReference
    private CorepeatUser mentor;

    public Integer getCorepeatId() {
        return corepeatId;
    }

    public void setCorepeatId(Integer corepeatId) {
        this.corepeatId = corepeatId;
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

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Integer getMaxMentors() {
        return maxMentors;
    }

    public void setMaxMentors(Integer maxMentors) {
        this.maxMentors = maxMentors;
    }

    public Integer getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(Integer currentParticipants) {
        this.currentParticipants = currentParticipants;
    }

    public Integer getCurrentMentors() {
        return currentMentors;
    }

    public void setCurrentMentors(Integer currentMentors) {
        this.currentMentors = currentMentors;
    }

    public Set<CorepeatUser> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<CorepeatUser> participants) {
        this.participants = participants;
    }

    public CorepeatUser getMentor() {
        return mentor;
    }

    public void setMentor(CorepeatUser mentor) {
        this.mentor = mentor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
