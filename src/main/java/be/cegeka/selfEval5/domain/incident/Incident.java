package be.cegeka.selfEval5.domain.incident;

import be.cegeka.selfEval5.domain.highway.Highway;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "INCIDENTS")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private IncidentType type;

    @Column(name = "DISTANCE")
    private BigDecimal distance;

    @ManyToOne
    @JoinColumn(name = "HIGHWAY_ID")
    private Highway highway;


    public Incident() {
    }

    public Incident(String name, IncidentType type, BigDecimal distance, Highway highway) {
        this.name = name;
        this.type = type;
        this.distance = distance;
        this.highway = highway;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IncidentType getType() {
        return type;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Incident incident = (Incident) o;

        return id == incident.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
