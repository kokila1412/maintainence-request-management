//package com.springbootdockermavenjibplugin.utils;
//
//import com.springbootdockermavenjibplugin.models.Product;
//import com.springbootdockermavenjibplugin.repositories.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class InitializerRunner implements CommandLineRunner {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // save products to db
//        Product product1 = Product.builder()
//                .name("Chimp Paradox")
//                .description("Emotional WellBeing")
//                .price(17.099)
//                .category("Psychology")
//                .build();
//        productRepository.save(product1);
//
//        Product product2 = Product.builder()
//                .name("Healthy Habits")
//                .description("Physical Wellbeing")
//                .price(10.199)
//                .category("Motivational")
//                .build();
//        productRepository.save(product2);
//
//        Product product3 = Product.builder()
//                .name("Containersation")
//                .description("Deployments Made Easy")
//                .price(12.396)
//                .category("Technology")
//                .build();
//        productRepository.save(product3);
//    }
//}
