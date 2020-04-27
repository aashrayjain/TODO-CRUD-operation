package com.in128minutes.rest.webservice.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
        "$2a$10$L0aohsJNnxaYlIJnNdlqAe.ZZGkUbaGWQf/uTP06wjguPdj8XEOtC", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
            "$2a$10$wmoBj.cWTQ1TJ8xNuw6R4ujXeqduecrntr7ZvZi0v0uFHRCje6yPS", "ROLE_USER_2"));
  }
//  $2a$10$kN93s.DTm/1b9uI0sPpaDelaaUazmQbjIqn4SrL1dYR57NmxpWov6

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


