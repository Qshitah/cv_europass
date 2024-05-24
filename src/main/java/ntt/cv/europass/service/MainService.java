package ntt.cv.europass.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class MainService<T,ID> {

    @Autowired
    protected final JpaRepository<T, ID> repository;

    public MainService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Transactional
    public T save(T entity) {
        if(entity == null){
            return null;
        }
        return repository.save(entity);
    }

    @Transactional
    public List<T> saveMultiple(List<T> entities) {
        return repository.saveAll(entities);
    }
}
