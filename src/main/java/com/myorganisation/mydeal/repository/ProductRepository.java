package com.myorganisation.mydeal.repository;

import com.myorganisation.mydeal.enums.Category;
import com.myorganisation.mydeal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Derived Query Methods
    List<Product> findByNameContainingAndCategory(String name, Category category);
    List<Product> findByName(String name);
    List<Product> findByNameOrCategory(String name, Category category);

    //JPQL -> Java Persistence Query Language
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> myJPQLCustomMethod(@Param("name") String name);

    //Native query / SQL Query
    @Query(value = "SELECT * FROM product WHERE category = :category", nativeQuery = true)
    List<Product> myNativeCustomMethod(@Param("category") Category category);

}
