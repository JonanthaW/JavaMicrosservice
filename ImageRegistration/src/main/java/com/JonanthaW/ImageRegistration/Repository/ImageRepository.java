package com.JonanthaW.ImageRegistration.Repository;


import com.JonanthaW.ImageRegistration.Entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
