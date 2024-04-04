package com.JonanthaW.ImageRegistration.Controller;

import com.JonanthaW.ImageRegistration.Entities.Image;
import com.JonanthaW.ImageRegistration.Service.ImageService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    private final ImageService imageService;

    @GetMapping("/{id}")
    public void downloadImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
        byte[] image = imageService.getImage(id).getData();
        if (image != null) {

            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            response.getOutputStream().write(image);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @PostMapping("/{send}")
    public void uploadImage(@RequestParam("file")MultipartFile file) throws IOException {
        imageService.saveImage(file);
    }
}
