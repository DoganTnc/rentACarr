package kodlama.io.rentACar.Access.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//dao olarakda kullanabilirsin Repository i

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);
}
