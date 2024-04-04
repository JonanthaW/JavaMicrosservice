package com.JonanthaW.ImageRegistration.Service;

import com.JonanthaW.ImageRegistration.Entities.Image;
import com.JonanthaW.ImageRegistration.Repository.ImageRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Data
public class ImageService {

    private final ImageRepository imageRepository;
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image getImage(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public void saveImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setData(file.getBytes());
        imageRepository.save(image);
    }
}
