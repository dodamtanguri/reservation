package kr.or.connect.reservation.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientUtils {
    public static String getRemoteIP(HttpServletRequest request, HttpServletResponse response) {
        String ip = request.getHeader("X-FORWARDED-FOR");

        // Proxy 환경일 경우
        if (ip == null)
            ip = request.getHeader("Proxy-Client-IP");

        // 웹 logic 서버일 경우
        if (ip == null)
            ip = request.getHeader("WL-Proxy-Client-IP");

        if (ip == null)
            ip = request.getHeader("HTTP_CLIENT_IP");

        if (ip == null)
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");

        if (ip == null)
            ip = request.getRemoteAddr();

        return ip;
    }
}