package com.unicorn.mytime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.unicorn.mytime.dao.EmployeeDao;
import com.unicorn.mytime.dao.EmployeeDaoImpl;
import com.unicorn.mytime.model.Employee;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{


	@Autowired private EmployeeDao dao;

	  
    @SuppressWarnings("deprecation")
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException
    {
        System.out.println("Getting access details from employee dao !!" + username);
         
        // Ideally it should be fetched from database and populated instance of
        // #org.springframework.security.core.userdetails.User should be returned from this method
        
        // Get Employee and Role details from the EMPL_ROLE DAO
        Employee empl = dao.getEmployee(username);
	    if (empl == null)
	      throw new UsernameNotFoundException("User not found");
	    System.out.println("Employee found !!" + empl.getFirstName());
        
        // Populate authorities from this
       /* List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
        UserDetails user = new User(username, "password", true, true, true, true, authorities);
        return user;
    	*/
	    return buildUserFromEmployee(empl);
    
    }
    
    private User buildUserFromEmployee(Employee empl) {

        String username = empl.getFirstName() + " " + empl.getSurname();
        String password = empl.getPassword();
        boolean enabled = !empl.isLockedBool();
        boolean accountNonExpired = (empl.getEndDate() == null);
        boolean credentialsNonExpired = !empl.isLockedBool();
        boolean accountNonLocked = !empl.isLockedBool();

        /*Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (SecurityRoleEntity role : userEntity.getRoles()) {
          authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
        }
*/
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        User user = new User(username, password, enabled,
          accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        return user;
      }
	
}
