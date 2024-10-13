package com.utp.edu._ta_categoria.repository;


import com.utp.edu._ta_categoria.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
}
