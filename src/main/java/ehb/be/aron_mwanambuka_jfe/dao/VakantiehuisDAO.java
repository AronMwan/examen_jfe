package ehb.be.aron_mwanambuka_jfe.dao;

import ehb.be.aron_mwanambuka_jfe.models.Vakantiehuis;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface VakantiehuisDAO extends CrudRepository<Vakantiehuis, Long> {

     List<Vakantiehuis> findByPostcode(int postcode);
     List<Vakantiehuis> momenteelBeschikbaar(LocalDate startdatum);

}
