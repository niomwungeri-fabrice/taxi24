package com.taxi24.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.taxi24.models.Driver;

@RepositoryRestResource(collectionResourceRel = "drivers", path ="drivers")
public interface DriverRepo extends JpaRepository<Driver, UUID>{

}
