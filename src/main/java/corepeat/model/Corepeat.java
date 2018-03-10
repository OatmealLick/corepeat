package corepeat.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "USER",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "COREPEAT_ID" }) })
public class Corepeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer corepeatId;


    private String name;
    private String city;
    private String coordinates;
    private String description;
    private Integer maxParticipants;
    private Integer maxMentors;
    private Integer currentParticipants;
    private Integer currentMentors;

    @ManyToMany(mappedBy = "user")
    private Set<CorepeatUser> participants = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private CorepeatUser mentor;

    @Column(name = "COREPEAT_ID")
    public Integer getCorepeatId() {
        return corepeatId;
    }

    public void setCorepeatId(Integer corepeatId) {
        this.corepeatId = corepeatId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "COORDINATES")
    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "MAX_PARTICIPANTS")
    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Column(name = "MAX_MENTORS")
    public Integer getMaxMentors() {
        return maxMentors;
    }

    public void setMaxMentors(Integer maxMentors) {
        this.maxMentors = maxMentors;
    }

    @Column(name = "CURRENT_PARTICIPANTS")
    public Integer getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(Integer currentParticipants) {
        this.currentParticipants = currentParticipants;
    }

    @Column(name = "CURRENT_MENTORS")
    public Integer getCurrentMentors() {
        return currentMentors;
    }

    public void setCurrentMentors(Integer currentMentors) {
        this.currentMentors = currentMentors;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "corepeat")
    public Set<CorepeatUser> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<CorepeatUser> participants) {
        this.participants = participants;
    }

    @Column(name = "MENTOR")
    public CorepeatUser getMentor() {
        return mentor;
    }

    public void setMentor(CorepeatUser mentor) {
        this.mentor = mentor;
    }
}
