package hrm.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hrm.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
