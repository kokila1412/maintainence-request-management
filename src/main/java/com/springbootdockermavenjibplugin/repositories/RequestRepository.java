package com.springbootdockermavenjibplugin.repositories;

import com.springbootdockermavenjibplugin.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
