##Spring Security

	- Basic authentication
	- Session based authentication
	- Token based authentication (JWT token)
	- Oauth2
	
	

### Basic authentication - Spring boot
As soon as we add `spring-boot-starter-security` dependency in our pom.xml,
all the end point will be secured by default and they will be protected by spring security. 

We need to configure Spring Security ...

spring:
  security:
    user:
      name: sudipta
      password: maity

Next, for testing we can define user in SecurityConfiguration,
UserDetailsService bean with InMemoryUserDetailsManager. 


Our ultimate goal is to fetch user from db and validate. 
To do that, We need to create CustomUserDetailsService which implements UserDetailsService. 
We need to override loadUserByUsername() method to fetch the user by username from database and map the user
to CustomUserDetails. CustomUserDetails is a class that implements UserDetails.
In SecurityConfig, we define rules in securityFilterChain() method. 
In controller, we define access using @PreAuthorize annotation.
