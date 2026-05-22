package com.notfound.feed_back_server.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestDTO {

    @NotBlank(message = "Phải nhập vào thông tin")
    @Size(max = 255, message = "Thông tin không được vượt quá 255 ký tự")
    private String information;

    @NotBlank(message = "Phải nhập vào nội dung")
    @Size(max = 1000, message = "Nội dung không được vượt quá 1000 ký tự")
    private String content;

}
