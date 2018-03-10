package corepeat.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "COREPEAT",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"COREPEAT_ID"})})
public class Corepeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COREPEAT_ID")
    private Integer corepeatId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COORDINATES")
    private String coordinates;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MAX_PARTICIPANTS")
    private Integer maxParticipants;

    @Column(name = "MAX_MENTORS")
    private Integer maxMentors;

    @Column(name = "CURRENT_PARTICIPANTS")
    private Integer currentParticipants;

    @Column(name = "CURRENT_MENTORS")
    private Integer currentMentors;

    @ManyToMany(mappedBy = "corepeats")
    private Set<CorepeatUser> participants = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "MENTOR_ID")
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
}
