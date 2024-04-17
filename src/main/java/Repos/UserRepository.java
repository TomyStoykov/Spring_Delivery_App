package Repos;
import Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User findByName(String name);


    @Query("SELECT u FROM User u WHERE u.email = ?1 and u.phoneNumber = ?2")
    User findByEmailAndPhoneNumber(String email, String phoneNumber);

    @Query(value = "SELECT * FROM users WHERE address LIKE %?1%", nativeQuery = true)
    List<User> findByAddressContaining(String address);

}
