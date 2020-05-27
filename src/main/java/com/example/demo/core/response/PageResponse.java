package com.example.demo.core.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageResponse<T> extends ListResponse<T>{
    private long total;
}
