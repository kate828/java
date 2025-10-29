package ua.repository;

@FunctionalInterface
public interface IdentityExtractor<T> {
    String extractId(T obj);
}
