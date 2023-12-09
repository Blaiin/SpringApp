package its.nds.repositories;

import its.nds.model.Registration;
import its.nds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    @Query("select count(r) from Registration r")
    long countRegistrationRecords();

    @Query("select r from Registration r where r.user_email = :email")
    User findRegistrationByEmail(@Param("email") String email);

    @Query("select r from Registration r where r.user_id = :id")
    User findRegistrationById(@Param("id") Long id);

    @Query("select (count(r) > 0) from Registration r")
    boolean exists();


}
