
package com.intranet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @ManyToOne
    private ClassRoom classRoom;

    @ManyToOne
    private Section section;

    @ManyToOne
    private Parent parent;
}
