package its.nds.repositories;

import its.nds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select count(u) from User u")
    int countUserRecords();

    @Query("select u from User u where u.name = :name")
    List<User> findUserByName(@Param("name") String name);

    @Query("select u from User u where u.surname = :surname")
    List<User> findUserBySurname(@Param("surname") String surname);

    @Query("select u from User u where u.phone = :phone")
    User findUserByPhone(@Param("phone") String phone);

    @Query("select u from User u where u.email = :email")
    User findUserByEmail(@Param("email") String email);
}
