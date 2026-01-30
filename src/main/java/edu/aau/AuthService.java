package edu.aau;

public interface AuthService {
    User login(String username, String password);
    boolean register(Passenger passenger);

}
