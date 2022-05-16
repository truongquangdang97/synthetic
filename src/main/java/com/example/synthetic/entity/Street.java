package com.example.synthetic.entity;

import com.example.synthetic.entity.Enum.StreetStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameStreet;
    private String information;
    @CreatedDate
    private LocalDateTime createAt;

    @Basic
    private int status;
    @Transient
    private StreetStatus streetStatus;

    @PostLoad // khi load
    void fillTransient() {
        this.streetStatus = streetStatus.of(status); // chuyển dữ liệu dạng số ở trong database về kiểu enum
    }
    @PrePersist // trước khi lưu
    void fillPersistent() {// đưa giá trị vào trường status
        this.status = this.streetStatus.getValue();
    }




    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;


}
