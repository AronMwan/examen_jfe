package ehb.be.aron_mwanambuka_jfe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vakantiehuis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String straatnaam;
    private int huisnummer;
    private int postcode;
    private int oppervlakte;
    private boolean beschikbaar;

    public Vakantiehuis() {
    }

    public Vakantiehuis(String straatnaam, int huisnummer, int postcode, int oppervlakte, boolean beschikbaar) {
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.oppervlakte = oppervlakte;
        this.beschikbaar = beschikbaar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getOppervlakte() {
        return oppervlakte;
    }

    public void setOppervlakte(int oppervlakte) {
        this.oppervlakte = oppervlakte;
    }

    public boolean isBeschikbaar() {
        return beschikbaar;
    }

    public void setBeschikbaar(boolean beschikbaar) {
        this.beschikbaar = beschikbaar;
    }
}
