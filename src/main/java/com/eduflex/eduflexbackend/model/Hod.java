package com.eduflex.eduflexbackend.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class Hod {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int hodId;
    private String hodName;
    private String hodUserName;
    private String hodPassword;
    private String hodCity;

    @Lob
    @Column(columnDefinition = "CLOB")
    private String hodAvatar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Hod hod = (Hod) o;
        return Objects.equals(hodId, hod.hodId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}