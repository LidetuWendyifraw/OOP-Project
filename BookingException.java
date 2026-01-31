// Custom exception for booking failures
class BookingException extends Exception {
    public BookingException(String message) {
        super(message);
    }
}

// Custom exception for invalid user data
class InvalidPassengerException extends RuntimeException {
    public InvalidPassengerException(String message) {
        super(message);
    }
}
