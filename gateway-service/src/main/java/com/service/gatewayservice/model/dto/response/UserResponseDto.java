package com.service.gatewayservice.model.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserResponseDto {
    private Long id;

    private String user;

    private String password;

    private String name;

    private String sex;

    private String birthday;

    private String phoneNumber;
}
