package ehb.be.aron_mwanambuka_jfe.controller;

import ehb.be.aron_mwanambuka_jfe.dao.HuurderDAO;
import ehb.be.aron_mwanambuka_jfe.dao.ReservatieDAO;
import ehb.be.aron_mwanambuka_jfe.dao.VakantiehuisDAO;
import ehb.be.aron_mwanambuka_jfe.models.Huurder;
import ehb.be.aron_mwanambuka_jfe.models.Reservatie;
import ehb.be.aron_mwanambuka_jfe.models.Vakantiehuis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private VakantiehuisDAO vakantiehuisDAO;

    @Autowired
    private ReservatieDAO reservatieDAO;

    @Autowired
    private HuurderDAO huurderDAO;


    @GetMapping("/api/locations")
    public Iterable<Vakantiehuis> getLocations() {
        return vakantiehuisDAO.findAll();
    }

    @GetMapping("/api/locations/{postcode}")
    public Iterable<Vakantiehuis> getLocationsByPostcode(@PathVariable int postcode) {
        return vakantiehuisDAO.findByPostcode(postcode);
    }

    @DeleteMapping("/api/locations/{id}")
    public void deleteLocation(@PathVariable long id) {
        vakantiehuisDAO.deleteById(id);
    }

    @PostMapping("/api/customers")
    public void addCustomer(@RequestParam String voornaam, @RequestParam String achternaam,
                            @RequestParam String email, @RequestParam String telefoonnummer) {
        Huurder huurder = new Huurder();
        huurder.setVoornaam(voornaam);
        huurder.setAchternaam(achternaam);
        huurder.setEmail(email);
        huurder.setTelefoon(telefoonnummer);
        huurderDAO.save(huurder);
    }

    @GetMapping("/api/reservations")
    public Iterable<Vakantiehuis> getAvailableLocations() {
        return vakantiehuisDAO.momenteelBeschikbaar(LocalDate.now());
    }

    @PostMapping("/api/reservations")
    public void addReservation(@RequestParam Long vakantiehuisId, @RequestParam Long huurderId,
                               @RequestParam LocalDate startDatum, @RequestParam int duur) {
        Vakantiehuis vakantiehuis = vakantiehuisDAO.findById(vakantiehuisId).orElseThrow();
        Huurder huurder = huurderDAO.findById(huurderId).orElseThrow();

        Reservatie reservatie = new Reservatie();
        reservatie.setVakantiehuis(vakantiehuis);
        reservatie.setHuurder(huurder);
        reservatie.setStartDatum(startDatum);
        reservatie.setDuur(duur);
        reservatieDAO.save(reservatie);
    }


}
