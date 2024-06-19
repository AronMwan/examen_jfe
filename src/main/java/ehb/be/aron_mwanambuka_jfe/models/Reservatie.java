package ehb.be.aron_mwanambuka_jfe.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vakantiehuis vakantiehuis;

    @ManyToOne
    private Huurder huurder;

    private LocalDate startDatum;

    private int duur;


    public Reservatie() {
    }

    public Reservatie(Vakantiehuis vakantiehuis, Huurder huurder, LocalDate startDatum, int duur) {
        this.vakantiehuis = vakantiehuis;
        this.huurder = huurder;
        this.startDatum = startDatum;
        this.duur = duur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vakantiehuis getVakantiehuis() {
        return vakantiehuis;
    }

    public void setVakantiehuis(Vakantiehuis vakantiehuis) {
        this.vakantiehuis = vakantiehuis;
    }

    public Huurder getHuurder() {
        return huurder;
    }

    public void setHuurder(Huurder huurder) {
        this.huurder = huurder;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDate startDatum) {
        this.startDatum = startDatum;
    }

    public int getDuur() {
        return duur;
    }

    public void setDuur(int duur) {
        this.duur = duur;
    }
}
