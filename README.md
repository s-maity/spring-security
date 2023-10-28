##Spring Security + Spring boot 3

	- Basic authentication
	- Session based authentication
	- Token based authentication (JWT token)
	- Oauth2
	
	

### Basic authentication
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

### JWT token based auth
In basic auth, we need to send the username and password in every request. 
In token based auth, we need to send the username and password first time and on successful authentication the service will provide a token (JWT).
We need to pass the token as Bearer token. JWT token contains - Header, Payload, signing key.

We need to have an end point [POST] /authenticate which will accept username and password and return jwt token.
We need to add some dependencies of jjwt in order to work with JWT token. 
To validate the token, we define a filter  `AuthFilter extends OncePerRequestFilter` which will validate the token and set the Security context with user.
To register the filter with Spring Security ,the filter needs to be added in the Security filter chain configuration.


### Oauth2  based auth
Oauth2 can be implemented with Github, Google, FB or with own authorization server.
First, we will implement Oauth2 using Github. 
Add `spring-boot-starter-oauth2-client` dependency. It will add spring security and oauth2 related dependencies. 
Configure Client-id and client-secret in Github Developers settings. 
Add the client-id and secret in application.yaml. 
Update the Security filter chain to use Oauth2 