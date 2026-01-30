package edu.aau;

public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() { return userRepository; }
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful. Role: " + user.getRole());
            return user;
        }
        return null;
    }

    @Override
    public boolean register(Passenger passenger) {
        if (userRepository.findByUsername(passenger.getUsername()) == null) {
            userRepository.save(passenger);
            return true;
        }
        return false;
    }
}
