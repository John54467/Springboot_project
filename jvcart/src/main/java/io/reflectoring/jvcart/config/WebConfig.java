package io.reflectoring.jvcart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // Map .jfif extension to image/jpeg so static resource responses have correct Content-Type
        configurer.mediaType("jfif", MediaType.IMAGE_JPEG);
        configurer.mediaType("jpg", MediaType.IMAGE_JPEG);
        configurer.mediaType("jpeg", MediaType.IMAGE_JPEG);
        configurer.mediaType("png", MediaType.IMAGE_PNG);
        configurer.mediaType("gif", MediaType.IMAGE_GIF);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Explicitly map /Product/** to the uploads/Product directory on disk.
        // This ensures requests like /Product/1.jfif are resolved to <project-root>/uploads/Product/1.jfif
        registry.addResourceHandler("/Product/**")
                .addResourceLocations("file:./uploads/Product/")
                .setCachePeriod(3600)
                .resourceChain(true);

        // Optionally, map other static folders if needed
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:./uploads/")
                .setCachePeriod(3600)
                .resourceChain(true);
    }
}