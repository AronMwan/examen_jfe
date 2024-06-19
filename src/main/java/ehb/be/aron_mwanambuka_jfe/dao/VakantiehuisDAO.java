package ehb.be.aron_mwanambuka_jfe.dao;

import ehb.be.aron_mwanambuka_jfe.models.Vakantiehuis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VakantiehuisDAO extends CrudRepository<Vakantiehuis, Long> {

     List<Vakantiehuis> findByPostcode(int postcode);
     @Query("SELECT v FROM Vakantiehuis v WHERE v.beschikbaar > :beschikbaar")
     List<Vakantiehuis> momenteelBeschikbaar(@Param("beschikbaar") boolean beschikbaar);
}
