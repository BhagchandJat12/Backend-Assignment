package com.user.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
  
@Query("select u from User u where u.Email=?1 and u.Password=?2")    
public User findByEmailAndPassword(String Email,String Password);

@Query("select u from User u where u.Email= ?1 ")    
public User findByEmail(String Email);

//  @Modifying
//  @Query("insert into User u (u.Name,u.Email,u.Password,u.Dob,u.Number) values(?1,?2,?3,?4,?5")
//  public void Insert(String Name,String Email,String password,LocalDate dob, int number);
}
