package lab11;


public interface Subject {
    void addObserver(Observer observer);       // [cite: 469]
    void removeObserver(Observer observer);    // [cite: 469]
    void notifyObservers(String message);      // [cite: 470]
}