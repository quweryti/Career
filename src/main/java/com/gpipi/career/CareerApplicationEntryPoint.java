/**
 * CareerApplicationEntryPoint
 * 	アプリケーションのエントリーポイントを担当します。
 * 
 * @since	2025/04/23
 * @version	1.0.0
 * @author	Kwon Yujin
 */

package com.gpipi.career;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CareerApplicationEntryPoint {
    public static void main(String[] args) {
        SpringApplication.run(CareerApplicationEntryPoint.class, args);
    }
}
