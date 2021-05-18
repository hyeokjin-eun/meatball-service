package com.service.exhibitservice.util;

import java.util.Random;

public class MathUtil {

    /**
     * num 까지 숫자중 랜덤 숫자
     * @param num 0 ~ num 까지 뽑을 수
     * @return Random Number
     */
    public static int randomNumber(int num) {
        return new Random().nextInt(num);
    }
}
