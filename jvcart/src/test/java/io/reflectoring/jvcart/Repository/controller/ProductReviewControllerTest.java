package io.reflectoring.jvcart.Repository.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.reflectoring.jvcart.Service.ProductService;

@WebMvcTest(controllers = ProductReviewController.class)
public class ProductReviewControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @InjectMocks
    private ProductReviewController productReviewController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productReviewController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    public void addReview_missingProductId_returns400() throws Exception {
        String payload = "{\"comment\":\"Nice!\",\"rating\":4.5}";

        mockMvc.perform(post("/api/product/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("productId must be provided"));
    }

    @Test
    public void addReview_productNotFound_returns404() throws Exception {
        String payload = "{\"productId\":9999,\"comment\":\"Nice!\",\"rating\":4.5}";

        doThrow(new RuntimeException("Product not found!")).when(productService).addReview(any());

        mockMvc.perform(post("/api/product/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product not found!"));
    }

    @Test
    public void addReview_success_returns201() throws Exception {
        String payload = "{\"productId\":1,\"comment\":\"Nice!\",\"rating\":4.5}";

        // productService.addReview does nothing (no exception)

        mockMvc.perform(post("/api/product/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andExpect(status().isCreated())
                .andExpect(content().string("Review added"));

        verify(productService).addReview(any());
    }
}
