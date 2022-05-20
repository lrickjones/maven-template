package com.template.entity;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Jacksonized
public class Sample {
    private int id;
    private String name;
    private String description;
}
