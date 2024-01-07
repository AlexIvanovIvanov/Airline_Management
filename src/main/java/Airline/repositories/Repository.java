package Airline.repositories;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getRepositoryData();

    void add(T repositoryOject);

    boolean remove(T repositoryOject);

    //T findByName(String name);
}
