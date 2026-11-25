package com.example.MultithreadingUsingExecutorService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ImageProcessingService {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    public void processImage(List<String> imagePaths)
    {
        for(String path:imagePaths)
        {
            executorService.submit(()->compressImage(path));
        }
    }
    private void compressImage(String path)
    {
        try {
            System.out.println("Processing "+path+" with Thread"+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Processing is completed" + path);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
