package be.cegeka.selfEval5.domain.highway;

import javax.persistence.*;

@Entity
@Table(name = "HIGHWAYS")
public class Highway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LENGTH")
    private int length;

    public Highway() {
    }

    public Highway(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Highway highway = (Highway) o;

        return id == highway.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
