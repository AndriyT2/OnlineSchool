package os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.osHibernate.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByEmail(String email);
}
