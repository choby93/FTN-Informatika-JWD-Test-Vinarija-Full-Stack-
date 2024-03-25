package project.Vinarija.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.Vinarija.model.Vino;

@Repository
public interface VinoRepository extends JpaRepository<Vino, Long> {

	@Query("SELECT v FROM Vino v WHERE" +
			"(:nazivVina IS NULL OR v.ime LIKE %:nazivVina%) AND " +
			"(:vinarijaId IS NULL OR v.vinarija.id = :vinarijaId)")
	Page<Vino> search(@Param("vinarijaId") Long vinarijaId,
					  @Param("nazivVina") String nazivVina, 
					  Pageable pageable);


}
