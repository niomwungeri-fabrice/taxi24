package com.taxi24.dao;

import com.taxi24.models.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "riders", path ="riders")
public interface RiderRepo extends JpaRepository<Rider, UUID> {

}
